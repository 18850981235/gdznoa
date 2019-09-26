package com.service.ed;

import com.beans.BdProject;
import com.beans.EdMessage;
import com.beans.SysApprovalDetailed;
import com.beans.SysApprovalProcess;
import com.dao.ed.EdMessageMapper;
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
@Service("EdMessageService")
public class EdMessageServiceImpl  implements EdMessageService {
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;
    @Resource
    private EdMessageMapper messageMapper;
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Override
    public int   addMassageApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("工程信息审批");
        try {
            approvalDetailedMapper.add(detailed);
            EdMessage update = new EdMessage();
            int processUserid = 0;
            EdMessage sd = messageMapper.queryAllById(detailed.getApprovalId());
            String state = "审批中";
            String users = sd.getProcess().getUsersid();
            String[] userArr = users.split(",");
            if (detailed.getState().equals("同意")) {
                sd.setProcessNode(sd.getProcessNode()+1);
                if(userArr.length<sd.getProcessNode()){
                    state="审批结束";
                    sd.setProcessNode(0);
                }
            } else {
                sd.setProcessNode(sd.getProcessNode()-1);
            }
            if(sd.getProcessNode()==1){
                processUserid =Integer.parseInt(userArr[0]);
            }
            if(sd.getProcessNode()==2){
//                processUserid = userMapper.DeptroleUser(pd.getDeptid()).get(0).getId();
                processUserid =Integer.parseInt(userArr[1]);
            }
            if(sd.getProcessNode()==3){
//                processUserid=pd.getUserid();
                processUserid =Integer.parseInt(userArr[2]);
            }
            if(sd.getProcessNode()==4){
                processUserid =Integer.parseInt(userArr[3]);
            }

            update.setProcessNode(sd.getProcessNode());
            update.setProcessUserid(processUserid);
            update.setId(detailed.getApprovalId());
            update.setProcessState(state);
            return messageMapper.updateMessage(update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public int addPdProcurement(EdMessage message, HttpServletRequest request) {
        int num = 0;
        try {
            SysApprovalProcess process = approvalProcessMapper.getProcessById(14);
            String accessory= FileUtils.uploadFile(request,"file");
            if (accessory!=null&&!accessory.equals("")){
                message.setAccessory(accessory);
            }

            String[] arr = process.getUsersid().split(",");
            message.setProcessid(14);
            message.setProcessUserid(Integer.parseInt(arr[0]));
            message.setProcessState("未审批");
            int s = messageMapper.addMessageMapper(message);
            if (s>0){
                num=message.getId();
            }else {
                num=0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    }

    @Override
    public int updateProcurement(EdMessage message, HttpServletRequest request) {
      try{
          String accessory= FileUtils.uploadFile(request,"file");
        if (accessory!=null&&!accessory.equals("")){
            message.setAccessory(accessory);
        };
          messageMapper.updateMessage(message);
        return 1;
    } catch (Exception e) {
        e.printStackTrace();
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return 0;
    }
    }

    @Override
    public EdMessage queryById(int id) {

        return messageMapper.queryAllById(id);
    }

    @Override
    public int deletePdProcurement(int id) {
        return messageMapper.deleteMassage(id);
    }

    @Override
    public Map<String, Object> queryBySome(int projectid, String site, int userid, int deptid, int clientid, int pageIndex ) {

        Map<String, Object> map = new HashMap<>();
        Page page = new Page();

        if (pageIndex == 0) {
            pageIndex = 1;
        }
        page.setPageSize(10);
        page.setTotalCount(messageMapper.querycountBySome(projectid, site,userid, deptid, clientid));
        page.setCurrentPageNo(pageIndex);
        List<EdMessage> List = messageMapper.queryAllBySome(projectid, site,deptid,clientid,userid, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
        map.put("page",page);
        map.put("list",List);
        return map;
    }

    @Override
    public Map<String, Object> getDetailById(int id) {
        Map<String, Object> map = new HashMap<>();
        try {

            EdMessage edMessage  = messageMapper.queryAllById(id);
            List<SysApprovalDetailed> list = approvalDetailedMapper.getListByapprovalId(id, "工程信息审批");
            map.put("edMessage", edMessage);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }
}
