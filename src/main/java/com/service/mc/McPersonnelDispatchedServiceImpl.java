package com.service.mc;

import com.beans.McPersonnelDispatched;
import com.beans.SysApprovalDetailed;
import com.beans.SysApprovalProcess;
import com.dao.mc.McPersonnelDispatchedMapper;
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
 * @create 2019/4/8 11:29
 */
@Transactional
@Service("mcPersonnelDispatchedService")
public class McPersonnelDispatchedServiceImpl implements McPersonnelDispatchedService {

    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;
    @Resource
    private McPersonnelDispatchedMapper mcPersonnelDispatchedMapper;


    /**
     * 添加人员派遣申请
     * @param personnelDispatched 人员派遣实体类
     * @return 是否添加成功
     */
    @Override
    public int add(McPersonnelDispatched personnelDispatched, HttpServletRequest request) {
        int num = 0;
        try {
            SysApprovalProcess process = approvalProcessMapper.getProcessById(9);
            String accessory= FileUtils.uploadFile(request,"file");
            if (accessory!=null&&!accessory.equals("")){
                personnelDispatched.setAccessory(accessory);
            }
            String[] arr = process.getUsersid().split(",");
            personnelDispatched.setProcessid(9);
            personnelDispatched.setProcessUserid(Integer.parseInt(arr[0]));
            num = mcPersonnelDispatchedMapper.add(personnelDispatched);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    }

    /**
     * 修改人员派遣申请
     * @param personnelDispatched 人员派遣实体类
     * @return 是否修改成功
     */
    @Override
    public int update(McPersonnelDispatched personnelDispatched) {
        return mcPersonnelDispatchedMapper.updateById(personnelDispatched);
    }

    /**
     * 添加人员派遣审批详情 修改人员派遣下一个审批人审批状态
     * @param detailed  审批详情实体类
     * @return 是否添加成功
     */

    @Override
    public int addProjectApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("商务人员派遣");
        try {
            approvalDetailedMapper.add(detailed);
            McPersonnelDispatched pd_update = new McPersonnelDispatched();
            if (detailed.getState() == "通过") {
                String state = "进行中";
                int processUserid = 0;
                McPersonnelDispatched fb=  mcPersonnelDispatchedMapper.getListById(detailed.getApprovalId());
                String users = fb.getProcess().getUsersid();
                String[] userArr = users.split(",");
                for (int i = 0; i < userArr.length; i++) {
                    if (userArr[i].equals(String.valueOf(fb.getProcessUserid()))) {
                        if (i != userArr.length - 1) {
                            processUserid = Integer.parseInt(userArr[i + 1]);
                        } else {
                            state = "已结束";
                        }
                    }
                }
                pd_update.setProcessUserid(processUserid);
                pd_update.setProcessState(state);
                pd_update.setId(detailed.getApprovalId());
            } else {
                pd_update.setProcessState(detailed.getState());
                pd_update.setId(detailed.getApprovalId());
            }
            return mcPersonnelDispatchedMapper.updateById(pd_update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public Map<String, Object> getList(String name, int deptid, int userid, Date start, Date end, int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(mcPersonnelDispatchedMapper.getCount(name,deptid,userid,start,end));
            page.setCurrentPageNo(pageIndex);
            List<McPersonnelDispatched> list=mcPersonnelDispatchedMapper.getList(name,deptid,userid,start,end,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public McPersonnelDispatched getListById(int id) {
        return mcPersonnelDispatchedMapper.getListById(id);
    }

    @Override
    public Map<String, Object> getParticular1ById(int id) {
        Map<String, Object> map = new HashMap<>();
        try {
            McPersonnelDispatched personnelDispatched = mcPersonnelDispatchedMapper.getListById(id);
            List<SysApprovalDetailed> list = approvalDetailedMapper.getListByapprovalId(id, "商务人员派遣");
            map.put("personnelDispatched",personnelDispatched);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public int deleteById(int id) {
        return mcPersonnelDispatchedMapper.deleteById(id);
    }

}