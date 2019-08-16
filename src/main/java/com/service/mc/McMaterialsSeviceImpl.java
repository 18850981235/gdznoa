package com.service.mc;

import com.beans.McMaterials;
import com.beans.SysApprovalDetailed;
import com.beans.SysApprovalProcess;
import com.dao.mc.McMaterialsMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
import com.util.FileUtils;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/4/10 17:17
 */
@Transactional
@Service("mcMaterialsSevice")
public class McMaterialsSeviceImpl implements McMaterialsSevice {

    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;
    @Resource
    private McMaterialsMapper mcMaterialsMapper;



    /**
     * 添加商务材料审批详情 修改人员派遣下一个审批人审批状态
     * @param detailed  审批详情实体类
     * @return 是否添加成功
     */
    @Override
    public int addProjectApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("商务材料申请");
        try {
            approvalDetailedMapper.add(detailed);
            McMaterials mr_update = new McMaterials();
            if (detailed.getState().equals("通过")) {
                String state = "审批中";
                int processUserid = 0;
                McMaterials fb=  mcMaterialsMapper.getListById(detailed.getApprovalId());
                String users = fb.getProcess().getUsersid();
                String[] userArr = users.split(",");
                for (int i = 0; i < userArr.length; i++) {
                    if (userArr[i].equals(String.valueOf(fb.getProcessUserid()))) {
                        if (i != userArr.length - 1) {
                            processUserid = Integer.parseInt(userArr[i + 1]);
                        } else {
                            state = "审批结束";
                        }
                    }
                }
                mr_update.setProcessUserid(processUserid);
                mr_update.setProcessState(state);
                mr_update.setId(detailed.getApprovalId());
            } else {
                mr_update.setProcessState(detailed.getState());
                mr_update.setId(detailed.getApprovalId());
            }
            return mcMaterialsMapper.updateById(mr_update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public int add(McMaterials mcMaterials, HttpServletRequest request) {
        int num = 0;
        try {
            SysApprovalProcess process = approvalProcessMapper.getProcessById(8);
            String accessory= FileUtils.uploadFile(request,"file");
            if (accessory!=null&&!accessory.equals("")){
                mcMaterials.setAccessory(accessory);
            }
            String[] arr = process.getUsersid().split(",");
            mcMaterials.setProcessid(8);
            mcMaterials.setProcessUserid(Integer.parseInt(arr[0]));
            mcMaterials.setProcessState("未审批");
            num = mcMaterialsMapper.add(mcMaterials);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    }


    @Override
    public int update(McMaterials materials) {
        return mcMaterialsMapper.updateById(materials);
    }

    @Override
    public int delete(int id) {
        return mcMaterialsMapper.delete(id);
    }

    @Override
    public Map<String, Object> getList(String projectName, int deptid, Date start, Date end, int usreid, int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(mcMaterialsMapper.getCount(projectName, deptid, start, end, usreid));
            page.setCurrentPageNo(pageIndex);
            List<McMaterials> list=mcMaterialsMapper.getList(projectName, deptid, start, end, usreid,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public McMaterials getListById(int id) {
        return mcMaterialsMapper.getListById(id);
    }

    @Override
    public Map<String, Object> getParticular1ById(int id) {
        Map<String, Object> map = new HashMap<>();
        try {
            McMaterials materials = mcMaterialsMapper.getListById(id);
            List<SysApprovalDetailed> list = approvalDetailedMapper.getListByapprovalId(id, "商务材料申请");
            map.put("materials",materials);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }


}