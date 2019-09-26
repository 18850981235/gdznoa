package com.service.mc;

import com.beans.McQualificationCertificate;
import com.beans.SysApprovalDetailed;
import com.beans.SysApprovalProcess;
import com.beans.SysUser;
import com.dao.mc.McQualificationMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
import com.util.FileUtils;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.util.setWatermark.setWatermark;

/*
许思明
2019/04/11
 */
@Transactional
@Service("mcQualificationService")
public class McQualificationServiceImpl implements McQualificationService {
    @Resource
    private McQualificationMapper mcQualificationMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper ;
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;

    @Override
    public int addProjectApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("资质证书");
        try {
            approvalDetailedMapper.add(detailed);
            McQualificationCertificate update = new McQualificationCertificate();
            int processUserid = 0;
            List<McQualificationCertificate> list = mcQualificationMapper.querybyid(detailed.getApprovalId());
            McQualificationCertificate pd = list.get(0);
            String state = "审批中";
            String users = pd.getProcess().getUsersid();
            String[] userArr = users.split(",");
            if (detailed.getState().equals("同意")) {
                pd.setProcessNode(pd.getProcessNode() + 1);
                if (userArr.length < pd.getProcessNode()) {
                    state = "审批结束";
                    pd.setProcessNode(0);
                }
            } else {
                pd.setProcessNode(pd.getProcessNode() - 1);
            }
            if (pd.getProcessNode() == 1) {
                processUserid = Integer.parseInt(userArr[0]);
            }
            if (pd.getProcessNode() == 2) {
//                processUserid = userMapper.DeptroleUser(pd.getDeptid()).get(0).getId();
                processUserid = Integer.parseInt(userArr[1]);
            }
            if (pd.getProcessNode() == 3) {
//                processUserid=pd.getUserid();
                processUserid = Integer.parseInt(userArr[2]);
            }
            if (pd.getProcessNode() == 4) {
                processUserid = Integer.parseInt(userArr[3]);
            }
            if (pd.getProcessNode() == 5) {
//                processUserid=pd.getUserid();
                processUserid = Integer.parseInt(userArr[4]);
            }
            if (pd.getProcessNode() == 6) {
                processUserid = Integer.parseInt(userArr[5]);
            }

            update.setProcessNode(pd.getProcessNode());
            update.setProcessUserid(processUserid);
            update.setId(detailed.getApprovalId());
            update.setProcessState(state);
            return mcQualificationMapper.updateMcQualification(update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }

    }
    @Override
    public List<McQualificationCertificate> queryAll() {
        return  mcQualificationMapper.queryAll();
    }

    @Override
    public void PDfOut(HttpServletResponse response,HttpServletRequest request, String showFileName,String WaterName) {
        String filePath="src/main/resources/static/upload" ;
        BufferedInputStream bis = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedOutputStream bos = null;
        SysUser user=(SysUser)request.getSession().getAttribute("user");
        try {
            File file = new File(filePath+"/"+showFileName);//:文件的声明

            String fileName = file.getName();
            is = new FileInputStream(file);  //:文件流的声明
            os = response.getOutputStream(); // 重点突出
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(os);
            // 对文件名进行编码处理中文问题
            fileName = java.net.URLEncoder.encode(showFileName, "UTF-8");// 处理中文文件名的问题
            fileName = new String(fileName.getBytes("UTF-8"), "GBK");// 处理中文文件名的问题
            response.reset(); // 重点突出
            response.setCharacterEncoding("UTF-8"); // 重点突出
            response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型 // 重点突出
            // inline在浏览器中直接显示，不提示用户下载
            // attachment弹出对话框，提示用户进行下载保存本地
            // 默认为inline方式
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName); // 重点突出
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            setWatermark(bos, is, format.format(cal.getTime())
                    + " 下载使用人：" + user.getName(), WaterName, 16);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        } finally {
            // 特别重要
            // 1. 进行关闭是为了释放资源
            // 2. 进行关闭会自动执行flush方法清空缓冲区内容
            try {
                if (null != bis) {
                    bis.close();
                    bis = null;
                }
                if (null != bos) {
                    bos.close();
                    bos = null;
                }
                if (null != is) {
                    is.close();
                    is = null;
                }
                if (null != os) {
                    os.close();
                    os = null;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex.getMessage());
            }
        }
    }
    //增加资质证书
    public int addQualificationCertificate(McQualificationCertificate mcQualificationCertificate, HttpServletRequest request) {
        int num = 0;
        try {
            SysApprovalProcess process = approvalProcessMapper.getProcessById(10);
            String accessory= FileUtils.uploadFile(request,"file");
            if (accessory!=null&&!accessory.equals("")){
                mcQualificationCertificate.setAccessory(accessory);
            }
            String[] arr = process.getUsersid().split(",");
            mcQualificationCertificate.setProcessid(10);
            mcQualificationCertificate.setProcessUserid(Integer.parseInt(arr[0]));
            mcQualificationCertificate.setProcessState("进行中");
            num = mcQualificationMapper.addMcQualification(mcQualificationCertificate);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    }
    //更改资质证书
    public int updateMcQualification(McQualificationCertificate mcQualificationCertificate) {
        return mcQualificationMapper.updateMcQualification(mcQualificationCertificate);
    }
    //根据ID查询
    public List<McQualificationCertificate> querybyid(int id) {
        return mcQualificationMapper.querybyid(id);
    }

    @Override
    public Map<String, Object> querydetailbyid(int id) {
      HashMap map=new HashMap();
      List<McQualificationCertificate> list =mcQualificationMapper.querybyid(id);
        List<SysApprovalDetailed>lists=approvalDetailedMapper.getListByapprovalId(id,"资质证书");
        map.put("List",list);
        map .put("Lists",lists);
        return map;

    };

    //根据条件查询
    public Map<String ,Object> querybytypename(String name, String type,String content ,String borrow,String state,String starttime,String endtime, int  pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(mcQualificationMapper.querycount( name, type,content,borrow,state,starttime,endtime));
            page.setCurrentPageNo(pageIndex);
            List<McQualificationCertificate> list=mcQualificationMapper.querybytypename(name, type,content,borrow,state,starttime,endtime,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }
    public int delete(int id) {
        return mcQualificationMapper.delete(id);
    }


}
