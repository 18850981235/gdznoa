package com.service.ga;

import com.beans.GaIncome;
import com.beans.GaPayment;
import com.beans.SysApprovalDetailed;
import com.beans.SysApprovalProcess;
import com.dao.ga.GaIncomeMapper;
import com.dao.ga.GaPaymentMapper;
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

/**
 * @author 李鹏熠
 * @create 2019/8/19 9:42
 */
@Service("gaIncomeService")
public class GaIncomeServiceImpl implements GaIncomeService{
    @Resource
    private GaIncomeMapper gaIncomeMapper;
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;


    @Override
    public int add(GaIncome gaIncome, HttpServletRequest request) {
        int num = 0;
        try {
            String accessory = FileUtils.uploadFile(request, "file");
            if (accessory != null && !accessory.equals("")) {
                gaIncome.setAccessory(accessory);
            }
            SysApprovalProcess process = approvalProcessMapper.getProcessById(16);
            String[] arr = process.getUsersid().split(",");
            gaIncome.setProcessid(16);
            gaIncome.setProcessUserid(Integer.parseInt(arr[0]));
            gaIncome.setProcessState("未审批");
            num=gaIncomeMapper.add(gaIncome);
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
            GaIncome update = new GaIncome();
            int processUserid = 0;
            GaIncome pd = gaIncomeMapper.getListById(detailed.getApprovalId());
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
            if (pd.getProcessNode()==1){

            }
            if (pd.getProcessNode()==2){

            }

            update.setProcessNode(pd.getProcessNode());
            update.setProcessUserid(processUserid);
            update.setId(detailed.getApprovalId());
            update.setProcessState(state);
            return gaIncomeMapper.updateById(update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public int update(GaIncome gaIncome) {
        return gaIncomeMapper.updateById(gaIncome);
    }

    @Override
    public Map<String, Object> getlist(int projectid, String type, int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setTotalCount(gaIncomeMapper.getCount(projectid,type));
            page.setPageSize(10);
            page.setCurrentPageNo(pageIndex);
            List<GaIncome> list = gaIncomeMapper.getList(projectid,type, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
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
            GaIncome gaIncome = gaIncomeMapper.getListById(id);
            List<SysApprovalDetailed> list = approvalDetailedMapper.getListByapprovalId(id, "付款申请");
            map.put("gaIncome", gaIncome);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }
}