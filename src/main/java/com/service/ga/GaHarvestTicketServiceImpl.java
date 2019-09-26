package com.service.ga;

import com.beans.GaHarvestTicket;
import com.beans.GaHarvestTicket;
import com.beans.SysApprovalDetailed;
import com.beans.SysApprovalProcess;
import com.dao.ga.GaHarvestTicketMapper;
import com.dao.ga.GaHarvestTicketMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/8/7 9:26
 */
@Service("gaHarvestTicketService")
public class GaHarvestTicketServiceImpl implements GaHarvestTicketService{

    @Resource
    private GaHarvestTicketMapper gaHarvestTicketMapper;
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;

    @Override
    public int add(GaHarvestTicket gaHarvestTicket) {
        int num = 0;
        try {
            if(gaHarvestTicket.getInorout().equals("开票")){
                SysApprovalProcess process = approvalProcessMapper.getProcessById(4);
                String[] arr = process.getUsersid().split(",");
                gaHarvestTicket.setProcessid(4);
                gaHarvestTicket.setProcessUserid(Integer.parseInt(arr[0]));
                gaHarvestTicket.setProcessState("未审批");
                num = gaHarvestTicketMapper.add(gaHarvestTicket);
            }else if(gaHarvestTicket.getInorout().equals("收票")){
                SysApprovalProcess process = approvalProcessMapper.getProcessById(3);
                String[] arr = process.getUsersid().split(",");
                gaHarvestTicket.setProcessid(3);
                gaHarvestTicket.setProcessUserid(Integer.parseInt(arr[0]));
                gaHarvestTicket.setProcessState("未审批");
                num = gaHarvestTicketMapper.add(gaHarvestTicket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int addApproval(SysApprovalDetailed detailed) {
        GaHarvestTicket pd = gaHarvestTicketMapper.getListById(detailed.getApprovalId());
        if(pd.getInorout().equals("开票")){
            detailed.setApprovalName("开票票申请");
        }else{
            detailed.setApprovalName("收票票申请");
        }
        try {
            approvalDetailedMapper.add(detailed);
            GaHarvestTicket update = new GaHarvestTicket();
            int processUserid = 0;
            String state = "审批中";
            String users = approvalProcessMapper.getProcessById(pd.getProcessid()).getUsersid();
            String[] userArr = users.split(",");
            if (detailed.getState().equals("同意")) {
                pd.setProcessNode(pd.getProcessNode()+1);
                if(userArr.length<pd.getProcessNode()){
                    state="审批结束";
                    pd.setProcessNode(0);
                }
            } else {
                pd.setProcessNode(pd.getProcessNode()-1);
            }
            if(pd.getInorout().equals("开票")){
                //开票流程扭转
                if(pd.getProcessNode()==1){
                    processUserid =Integer.parseInt(userArr[0]);
                }
                if(pd.getProcessNode()==2){
                    processUserid = Integer.parseInt(userArr[1]);
                }

            }else{
                //收票流程扭转
            }
            update.setProcessNode(pd.getProcessNode());
            update.setProcessUserid(processUserid);
            update.setId(detailed.getApprovalId());
            update.setProcessState(state);
            return gaHarvestTicketMapper.updateById(update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public int update(GaHarvestTicket gaHarvestTicket) {
        return gaHarvestTicketMapper.updateById(gaHarvestTicket);
    }

    @Override
    public Map<String, Object> getlist(int projectid, String type, int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setTotalCount(gaHarvestTicketMapper.getCount(projectid,type));
            page.setPageSize(10);
            page.setCurrentPageNo(pageIndex);
            List<GaHarvestTicket> list = gaHarvestTicketMapper.getList(projectid,type, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
            map.put("page", page);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public Map<String, Object> getById(int id) {
        Map<String, Object> map = new HashMap<>();
        try {
            GaHarvestTicket gaHarvestTicket = gaHarvestTicketMapper.getListById(id);
            String type;
            if(gaHarvestTicket.getInorout().equals("开票")){
                type="开票申请";
            }else{
                type="收票申请";
            }
            List<SysApprovalDetailed> list = approvalDetailedMapper.getListByapprovalId(id, type);
            map.put("gaHarvestTicket", gaHarvestTicket);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public BigDecimal sumCost(Integer contractid, String type) {
        return gaHarvestTicketMapper.sumCost(contractid,type);
    }

    @Override
    public Map<String, Object> getSumMoneyAndCompanyName(int id) {
        Map<String, Object> map = new HashMap<>();
        try {
            String companyName=gaHarvestTicketMapper.companyName(id);
            BigDecimal sumMoney=gaHarvestTicketMapper.sumMoney(id);
            map.put("companyName", companyName);
            map.put("sumMoney", sumMoney);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }
}