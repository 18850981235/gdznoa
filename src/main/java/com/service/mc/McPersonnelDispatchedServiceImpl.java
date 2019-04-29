package com.service.mc;

import com.beans.McPersonnelDispatched;
import com.beans.SysApprovalDetailed;
import com.beans.SysApprovalProcess;
import com.dao.mc.McPersonnelDispatchedMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
import com.dao.sys.UserMapper;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
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
    @Resource
    private UserMapper userMapper;


    /**
     * 添加人员派遣申请
     * @param personnelDispatched 人员派遣实体类
     * @return 是否添加成功
     */
    @Override
    public int add(McPersonnelDispatched personnelDispatched) {
        int num = 0;
        try {
            SysApprovalProcess process = approvalProcessMapper.getProcessById(9);
            String[] arr = process.getUsersid().split(",");
            personnelDispatched.setProcessid(9);
            personnelDispatched.setProcessUserid(Integer.parseInt(arr[0]));
            personnelDispatched.setProcessState("进行中");
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
            McPersonnelDispatched update = new McPersonnelDispatched();
            int processUserid = 0;
            McPersonnelDispatched pd = mcPersonnelDispatchedMapper.getListById(detailed.getApprovalId());
            String state = "进行中";
            String users = pd.getProcess().getUsersid();
            String[] userArr = users.split(",");
            if (detailed.getState().equals("通过")) {
                pd.setProcessNode(pd.getProcessNode()+1);
                if(userArr.length<pd.getProcessNode()){
                    state="已结束";
                    pd.setProcessNode(0);
                }
            } else {
                pd.setProcessNode(pd.getProcessNode()-1);
            }

            if(pd.getProcessNode()==1){
                processUserid =Integer.parseInt(userArr[0]);
            }
            if(pd.getProcessNode()==2){
                processUserid = userMapper.DeptroleUser(pd.getDeptid()).get(0).getId();
            }
            if(pd.getProcessNode()==3){
                processUserid=pd.getUserid();
            }
            if(pd.getProcessNode()==4){
                processUserid =Integer.parseInt(userArr[3]);
            }

            update.setProcessNode(pd.getProcessNode());
            update.setProcessUserid(processUserid);
            update.setId(detailed.getApprovalId());
            update.setProcessState(state);
            return mcPersonnelDispatchedMapper.updateById(update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public Map<String, Object> getList(String projectName,String personnelCondition, int deptid, int userid, Date start, Date end, int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        List<McPersonnelDispatched> list=null;
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            if (projectName==null){
                page.setTotalCount(mcPersonnelDispatchedMapper.getCount(personnelCondition,deptid,userid,start,end));
                page.setCurrentPageNo(pageIndex);
                list=mcPersonnelDispatchedMapper.getList(personnelCondition,deptid,userid,start,end,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            }else{
                page.setTotalCount(mcPersonnelDispatchedMapper.getCountProject(projectName,personnelCondition,deptid,userid,start,end));
                page.setCurrentPageNo(pageIndex);
                list=mcPersonnelDispatchedMapper.getListProject(projectName,personnelCondition,deptid,userid,start,end,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());

            }
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