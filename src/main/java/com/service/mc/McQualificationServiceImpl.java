package com.service.mc;

import com.beans.McQualificationCertificate;
import com.beans.SysApprovalDetailed;
import com.beans.SysApprovalProcess;
import com.dao.mc.McQualificationMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
import com.util.FileUtils;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
许思明
2019/04/11
 */
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
        detailed.setApprovalName("资历证书");
        try {
            approvalDetailedMapper.add(detailed);
            McQualificationCertificate mc = new McQualificationCertificate();
            if (detailed.getState().equals( "通过")) {
                String state = "进行中";
                int processUserid = 0;
                List<McQualificationCertificate> list = mcQualificationMapper.querybyid(detailed.getApprovalId());
                mc=list.get(0);
                String users = mc.getProcess().getUsersid();
                String[] userArr = users.split(",");
                for (int i = 0; i < userArr.length; i++) {
                    if (userArr[i].equals(String.valueOf(mc.getProcessUserid()))) {
                        if (i != userArr.length - 1) {
                            processUserid = Integer.parseInt(userArr[i + 1]);
                        } else {
                            state = "已结束";
                        }
                    }
                }
                mc.setProcessUserid(processUserid);
                mc.setProcessState(state);
                mc.setId(detailed.getApprovalId());
            } else {
                mc.setProcessState(detailed.getState());
                mc.setId(detailed.getApprovalId());
            }
            return mcQualificationMapper.updateMcQualification(mc);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
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
    public Map<String ,Object> querybytypename(int deptid,String name, String type, int  pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(mcQualificationMapper.querycount(deptid,name,type));
            page.setCurrentPageNo(pageIndex);
            List<McQualificationCertificate> list=mcQualificationMapper.querybytypename(deptid,name,type,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
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
