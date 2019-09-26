package com.service.ga;

import com.beans.*;
import com.dao.ga.GaOpenTicketMapper;
import com.dao.ga.GaOuterTubePassMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
import com.dao.sys.UserMapper;
import com.util.FileUtils;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/8/7 9:26
 */
@Service("gaOpenTicketService")
public class GaOpenTicketServiceImpl implements GaOpenTicketService{

    @Resource
    private GaOpenTicketMapper gaOpenTicketMapper;
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public int add(GaOpenTicket gaOpenTicket, HttpServletRequest request) {
        int num = 0;
        try {
            String accessory = FileUtils.uploadFile(request, "file");
            if (accessory != null && !accessory.equals("")) {
                gaOpenTicket.setAccessory(accessory);
            }
            SysApprovalProcess process = approvalProcessMapper.getProcessById(4);
            String[] arr = process.getUsersid().split(",");
            gaOpenTicket.setProcessid(4);
            gaOpenTicket.setProcessUserid(Integer.parseInt(arr[0]));
            gaOpenTicket.setProcessState("未审批");
            num = gaOpenTicketMapper.add(gaOpenTicket);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int addApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("开票申请");
        try {
            approvalDetailedMapper.add(detailed);
            GaOpenTicket update = new GaOpenTicket();
            int processUserid = 0;
            GaOpenTicket pd = gaOpenTicketMapper.getListById(detailed.getApprovalId());
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
            if(pd.getProcessNode()==1){
                processUserid = userMapper.DeptroleUser(pd.getProject().getDeptid()).get(0).getId();
            }
            if(pd.getProcessNode()==2){
                processUserid = Integer.parseInt(userArr[1]);
            }
            update.setProcessNode(pd.getProcessNode());
            update.setProcessUserid(processUserid);
            update.setId(detailed.getApprovalId());
            update.setProcessState(state);
            return gaOpenTicketMapper.updateById(update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public int update(GaOpenTicket gaOpenTicket) {
        return gaOpenTicketMapper.updateById(gaOpenTicket);
    }

    @Override
    public Map<String, Object> getlist(int projectid, String type, int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setTotalCount(gaOpenTicketMapper.getCount(projectid,type));
            page.setPageSize(10);
            page.setCurrentPageNo(pageIndex);
            List<GaOpenTicket> list = gaOpenTicketMapper.getList(projectid,type, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
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
            GaOpenTicket gaOpenTicket = gaOpenTicketMapper.getListById(id);
            List<SysApprovalDetailed> list = approvalDetailedMapper.getListByapprovalId(id, "开票申请");
            map.put("gaOpenTicket", gaOpenTicket);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }
}