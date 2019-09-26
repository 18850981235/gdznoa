package com.service.ga;

import com.beans.*;
import com.dao.ga.GaHarvestTicketMapper;
import com.dao.ga.GaIncomeMapper;
import com.dao.ga.GaPaymentMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
import com.dao.sys.UserMapper;
import com.util.FileUtils;
import com.util.ListSortUtil;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author 李鹏熠
 * @create 2019/8/6 16:20
 */
@Service("gaPaymentService")
public class GaPaymentServiceImpl implements GaPaymentService {
    @Resource
    private GaPaymentMapper gaPaymentMapper;
    @Resource
    private GaIncomeMapper gaincomeMapper;
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private GaHarvestTicketMapper ticketMapper;



    @Override
    public int add(GaPayment gaPayment, HttpServletRequest request) {
        int num = 0;
        try {
            String accessory = FileUtils.uploadFile(request, "file");
            if (accessory != null && !accessory.equals("")) {
                gaPayment.setAccessory(accessory);
            }
            SysApprovalProcess process = approvalProcessMapper.getProcessById(16);
            String[] arr = process.getUsersid().split(",");
            gaPayment.setProcessid(16);
            gaPayment.setProcessUserid(Integer.parseInt(arr[0]));
            gaPayment.setProcessState("未审批");
            gaPayment.setCreatetime(new Date());
            gaPaymentMapper.add(gaPayment);
            num = gaPayment.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int addApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("付款申请");
        try {
            approvalDetailedMapper.add(detailed);
            GaPayment update = new GaPayment();
            int processUserid = 0;
            GaPayment pd = gaPaymentMapper.getListById(detailed.getApprovalId());
            String state = "审批中";
            String users = approvalProcessMapper.getProcessById(pd.getProcessid()).getUsersid();
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
                processUserid = userMapper.DeptroleUser(pd.getUser().getDeptid()).get(0).getId();
            }
            if (pd.getProcessNode() == 2) {
                processUserid = Integer.parseInt(userArr[1]);
            }
            if (pd.getProcessNode() == 3) {
                processUserid = Integer.parseInt(userArr[2]);
            }
            if (pd.getProcessNode() == 4) {
                processUserid = Integer.parseInt(userArr[3]);
            }
            if (pd.getProcessNode() == 5) {
                processUserid = Integer.parseInt(userArr[4]);
            }
            update.setProcessNode(pd.getProcessNode());
            update.setProcessUserid(processUserid);
            update.setId(detailed.getApprovalId());
            update.setProcessState(state);
            return gaPaymentMapper.updateById(update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public int update(GaPayment gaPayment) {
        return gaPaymentMapper.updateById(gaPayment);
    }

    @Override
    public Map<String, Object> getlist(int projectid, String matter, String type, int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setTotalCount(gaPaymentMapper.getCount(projectid, matter, type));
            page.setPageSize(10);
            page.setCurrentPageNo(pageIndex);
            List<GaPayment> list = gaPaymentMapper.getList(projectid, matter, type, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
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
            GaPayment gaPayment = gaPaymentMapper.getListById(id);
            List<SysApprovalDetailed> list = approvalDetailedMapper.getListByapprovalId(id, "付款申请");
            map.put("gaPayment", gaPayment);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public BigDecimal sumPaid(int projectid, String matter, int id) {
        if (matter.equals("采购付款")) {
            return gaPaymentMapper.sumPaid(projectid, matter, 0, id, 0);
        } else if (matter.equals("劳务费付款")) {
            return gaPaymentMapper.sumPaid(projectid, matter, 0, 0, id);
        } else {
            return gaPaymentMapper.sumPaid(projectid, matter, id, 0, 0);
        }
    }



    @Override
    public List<bankflow> getBankFlow(int projectid, String type) {


        if(type.equals("现金")){
            type=null;
        }
        List<bankflow> list2=gaPaymentMapper.bankFlow(projectid, type);
        List<bankflow> list=new ArrayList<>();
        for(bankflow bank:list2){
            bank.setOut("支出");
            list.add(bank);
        }
        List<bankflow> list1=ticketMapper.bankFlow(projectid, type);
        for(bankflow bank:list1){
            bank.setOut("收入");
            list.add(bank);
        }
        List<bankflow> list3=gaincomeMapper.bankFlow(projectid, type);
        for(bankflow bank:list3){

            list.add(bank);
        }
        ListSortUtil.sort(list2,"createtime","sout");
        return list2;



    }
}