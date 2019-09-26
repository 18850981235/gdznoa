package com.service.pd;

import com.beans.*;
import com.dao.pd.PdProcurementInventoryMapper;
import com.dao.pd.PdProcurementMapper;
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

@Service("PdProcurementService")
public class PdProcurementContractServiceImpl implements PdProcurementContractService{
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;
    @Resource
    private PdProcurementMapper pdProcurementMapper;
    @Resource
    private  PdProcurementInventoryMapper pdProcurementInventoryMapper;


    @Override
    public int addContractApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("商务资料费申请");
        try {
            approvalDetailedMapper.add(detailed);
            PdProcurementContract update = new PdProcurementContract();
            int processUserid = 0;
            PdProcurementContract pd = pdProcurementMapper.querybyid(detailed.getApprovalId());
            String state = "审批中";
            String users = pd.getProcess().getUsersid();
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
//                processUserid =Integer.parseInt(userArr[0]);
                processUserid =pd.getSupplierConsignor();
            }
            if(pd.getProcessNode()==2){
//                processUserid = userMapper.DeptroleUser(pd.getDeptid()).get(0).getId();
//                processUserid =Integer.parseInt(userArr[1]);
                processUserid =pd.getUserid();
            }
            if(pd.getProcessNode()==3){
//                processUserid=pd.getUserid();
                processUserid =Integer.parseInt(userArr[2]);
            }
            if(pd.getProcessNode()==4){
                processUserid =Integer.parseInt(userArr[3]);
            }
            if(pd.getProcessNode()==5){
//                processUserid =Integer.parseInt(userArr[0]);
                processUserid =Integer.parseInt(userArr[4]);
            }
            if(pd.getProcessNode()==6){
//                processUserid = userMapper.DeptroleUser(pd.getDeptid()).get(0).getId();
//                processUserid =Integer.parseInt(userArr[1]);
                processUserid =Integer.parseInt(userArr[5]);
            }
            if(pd.getProcessNode()==7){
//                processUserid=pd.getUserid();
                processUserid =pd.getUserid();
            }
            if(pd.getProcessNode()==8){
                processUserid =pd.getSupplierConsignor();
            }

            update.setProcessNode(pd.getProcessNode());
            update.setProcessUserid(processUserid);
            update.setId(detailed.getApprovalId());
            update.setProcessState(state);
            return pdProcurementMapper.updatePdProcurement(update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public int addPdProcurement(PdProcurementContract procurementContract, HttpServletRequest request) {

            int num = 0;
            try {
                SysApprovalProcess process = approvalProcessMapper.getProcessById(13);
                String demanderFile= FileUtils.uploadFile(request,"demanderFile");
                if (demanderFile!=null&&!demanderFile.equals("")){
                    procurementContract.setDemanderFile(demanderFile);
                }
                String supplierFile= FileUtils.uploadFile(request,"supplierFile");
                if (supplierFile!=null&&!supplierFile.equals("")){
                    procurementContract.setSupplierFile(supplierFile);
                }
                String[] arr = process.getUsersid().split(",");
                procurementContract.setProcessid(13);
                procurementContract.setProcessUserid(procurementContract.getSupplierConsignor());
                procurementContract.setProcessState("未审批");
                int s = pdProcurementMapper.addprocurement(procurementContract);
                if (s>0){
                    num=procurementContract.getId();
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
    public int updatePdProcurement(PdProcurementContract procurementContract,HttpServletRequest request) {
        SysApprovalProcess process = approvalProcessMapper.getProcessById(13);
        String demanderFile= FileUtils.uploadFile(request,"demanderFile");
        if (demanderFile!=null&&!demanderFile.equals("")){
            procurementContract.setDemanderFile(demanderFile);
        }
        String supplierFile= FileUtils.uploadFile(request,"supplierFile");
        if (supplierFile!=null&&!supplierFile.equals("")){
            procurementContract.setSupplierFile(supplierFile);
        }
        return pdProcurementMapper.updatePdProcurement(procurementContract);
    }

    @Override
    public int deletePdProcurement(int id) {
        try {
            pdProcurementInventoryMapper.deleteInventory(id);
         pdProcurementMapper.deletePdProcurement(id);
         return 1;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public Map<String,Object>  querybyid(int id) {
        Map<String,Object> map=new HashMap<>();
        try {
        List<SdSalesInventory> list=pdProcurementInventoryMapper.querySdSalesInventory(id);
        PdProcurementContract pdProcurementContract= pdProcurementMapper.querybyid(id);

        map.put("list",list);
        map.put("pdProcurementContract",pdProcurementContract);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public Map<String, Object> querydetailbyid(int id) {
        Map<String,Object> map=new HashMap<>();
        PdProcurementContract procurementContract=pdProcurementMapper.querybyid(id);
        List<SysApprovalDetailed>lists=approvalDetailedMapper.getListByapprovalId(id,"采购合同审批");
        map.put("procurementContract",procurementContract);
        map .put("SysApprovalDetailed",lists);
        return map;
    }

    @Override
    public Map<String, Object> queryBySome(int projectid, String serialnumber, String code, int supplierid,int userid, int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();

        if (pageIndex == 0) {
            pageIndex = 1;
        }
        page.setPageSize(10);
        page.setTotalCount(pdProcurementMapper.querycountBySome(projectid, serialnumber, code, supplierid, userid));
        page.setCurrentPageNo(pageIndex);
        List<PdProcurementContract> List = pdProcurementMapper.queryBySome(projectid, serialnumber,code,supplierid,userid,(page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
        map.put("page",page);
        map.put("list",List);
        return map;
    }

    @Override
    public List<PdProcurementContract> queryAll() {

        return pdProcurementMapper.queryAll();
    }

    @Override
    public List<PdProcurementContract> queryByProject (int id) {

        return pdProcurementMapper.queryByProject(id);
    }
}
