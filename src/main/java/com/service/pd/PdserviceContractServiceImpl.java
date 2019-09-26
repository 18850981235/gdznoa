package com.service.pd;

import com.beans.*;
import com.dao.pd.PdProcurementMapper;
import com.dao.pd.PdServiceContractMapper;
import com.dao.pd.PdServiceInventoryMapper;
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

@Service("PdserviceContractService")
public class PdserviceContractServiceImpl implements PdserviceContractService{
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private PdServiceContractMapper ServiceContractMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;
     @Resource
    private PdServiceInventoryMapper pdServiceInventoryMapper;


    @Override
    public int addPdServiceApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("劳务合同审批");
        try {
            approvalDetailedMapper.add(detailed);
            PdServiceContract update = new PdServiceContract();
            int processUserid = 0;
            PdServiceContract sd = ServiceContractMapper.queryOneByid(detailed.getApprovalId());
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
//                processUserid =Integer.parseInt(userArr[0]);
                processUserid =sd.getSecondConsignor();
            }
            if(sd.getProcessNode()==2){
//                processUserid = userMapper.DeptroleUser(pd.getDeptid()).get(0).getId();
//                processUserid =Integer.parseInt(userArr[1]);
                processUserid =sd.getUserid();
            }
            if(sd.getProcessNode()==3){
//                processUserid=pd.getUserid();
                processUserid =Integer.parseInt(userArr[2]);
            }
            if(sd.getProcessNode()==4){
                processUserid =Integer.parseInt(userArr[3]);
            }
            if(sd.getProcessNode()==5){
//                processUserid =Integer.parseInt(userArr[0]);
                processUserid =Integer.parseInt(userArr[4]);
            }
            if(sd.getProcessNode()==6){
//                processUserid = userMapper.DeptroleUser(pd.getDeptid()).get(0).getId();
//                processUserid =Integer.parseInt(userArr[1]);
                processUserid =Integer.parseInt(userArr[5]);
            }
            if(sd.getProcessNode()==7){
//                processUserid=pd.getUserid();
                processUserid =sd.getUserid();
            }
            if(sd.getProcessNode()==8){
                processUserid =sd.getSecondConsignor();
            }

            update.setProcessNode(sd.getProcessNode());
            update.setProcessUserid(processUserid);
            update.setId(detailed.getApprovalId());
            update.setProcessState(state);
            return ServiceContractMapper.UpdatePdServiceContract(update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public int addPdProcurement(PdServiceContract pdServiceContract, HttpServletRequest request) {

        int num = 0;
        try {
            SysApprovalProcess process = approvalProcessMapper.getProcessById(14);
            String fristfile= FileUtils.uploadFile(request,"fristfile");
            if (fristfile!=null&&!fristfile.equals("")){
                pdServiceContract.setFristFile(fristfile);
            }
            String secondfile= FileUtils.uploadFile(request,"secondfile");
            if (secondfile!=null&&!secondfile.equals("")){
                pdServiceContract.setSecondFile(secondfile);
            }
            String[] arr = process.getUsersid().split(",");
            pdServiceContract.setProcessid(14);
            pdServiceContract.setProcessUserid(pdServiceContract.getSecondConsignor());
            pdServiceContract.setProcessState("未审批");
            int s = ServiceContractMapper.AddPdServiceContract(pdServiceContract);
            if (s>0){
                num=pdServiceContract.getId();
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
    public int updateProcurement(PdServiceContract pdServiceContract, HttpServletRequest request) {
        try {
                String fristfile = FileUtils.uploadFile(request, "fristfile");
                if (fristfile != null && !fristfile.equals("")) {
                    pdServiceContract.setFristFile(fristfile);
                }
                String secondfile = FileUtils.uploadFile(request, "secondfile");
                if (secondfile != null && !secondfile.equals("")) {
                    pdServiceContract.setSecondFile(secondfile);
                }
                ServiceContractMapper.UpdatePdServiceContract(pdServiceContract);
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return 0;
                }
            }

    @Override
    public Map<String, Object> querydetailbyid(int id) {
        Map<String,Object> map=new HashMap<>();
        PdServiceContract pdServiceContract=ServiceContractMapper.queryOneByid(id);
        List<SysApprovalDetailed>lists=approvalDetailedMapper.getListByapprovalId(id,"劳务合同审批");
        map.put("pdServiceContract",pdServiceContract);
        map .put("SysApprovalDetailed",lists);
        return map;
    }

    @Override
    public Map<String, Object> queryById(int id) {
        Map<String, Object> map=new HashMap<>();
        map.put("Contract",ServiceContractMapper.queryOneByid(id));
        map.put("List", pdServiceInventoryMapper.querySdSalesInventory(id));
        return map;
    }

    @Override
    public int deletePdProcurement(int id) {
        try{
        ServiceContractMapper.deletePdService(id);
        pdServiceInventoryMapper.deleteInventory(id);
        return 1;
        }catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }


    }

    @Override
    public Map<String, Object> queryBySome(int projectid, String serialnumber, String code, String  secondName, int userid,int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();

        if (pageIndex == 0) {
            pageIndex = 1;
        }
        page.setPageSize(10);
        page.setTotalCount(ServiceContractMapper.queryCount(projectid, serialnumber, code, secondName,userid));
        page.setCurrentPageNo(pageIndex);
        List<PdServiceContract>  List = ServiceContractMapper.queryBySome(projectid, serialnumber,code,secondName,userid, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
        map.put("page",page);
        map.put("list",List);
        return map;
    }

    @Override
    public List<PdServiceContract> queryAll() {
        return ServiceContractMapper.queryAll();
    }

    @Override
    public List<PdServiceContract> queryByProject(int id) {
        return ServiceContractMapper.queryByProject(id);
    }


}
