package com.service.sd;

import com.beans.*;
import com.dao.sd.SdSalesContractMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
import com.util.FileUtils;
import com.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service("SdSalesContractService")
public class SdSalesContractServiceImpl implements SdSalesContractservice {
    @Resource
    private SdSalesContractMapper sdSalesContractMapper;
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper ;


    @Override
    public int addContractApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("销售合同审批");
        try {
            approvalDetailedMapper.add(detailed);
            SdSalesContract mr_update = new SdSalesContract();
            if (detailed.getState().equals("通过")) {
                String state = "审批中";
                int processUserid = 0;
                SdSalesContract fb=  sdSalesContractMapper.querybyid(detailed.getApprovalId());
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
                //mr_update.setId(detailed.getApprovalId());
            } else {
                mr_update.setProcessState(detailed.getState());
                //mr_update.setId(detailed.getApprovalId());
            }
            return sdSalesContractMapper.updateSalesContract(mr_update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }



    @Override
    public int addSdSalesContract(SdSalesContract sdSalesContract, HttpServletRequest request) {
        int num = 0;
        try {
            SysApprovalProcess process = approvalProcessMapper.getProcessById(15);
            String accessory= FileUtils.uploadFile(request,"file");
            if (accessory!=null&&!accessory.equals("")){
                sdSalesContract.setAccessory(accessory);
            }
            String[] arr = process.getUsersid().split(",");
            sdSalesContract.setProcessid(15);
            sdSalesContract.setProcessUserid(Integer.parseInt(arr[0]));
            sdSalesContract.setProcessState("未审批");
            num = sdSalesContractMapper.addSalesContract(sdSalesContract);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    };


    @Override
    public int updateSdSalesContract(SdSalesContract sdSalesContract) {
        return sdSalesContractMapper.updateSalesContract(sdSalesContract);
    }

    @Override
    public SdSalesContract querybyId(int id) {
        return sdSalesContractMapper.querybyid(id);
    }

    @Override
    public Map<String, Object>  querydetailbyid(int id) {
        Map<String,Object> map=new HashMap<>();
       SdSalesContract list=sdSalesContractMapper.querybyid(id);
        List<SysApprovalDetailed>lists=approvalDetailedMapper.getListByapprovalId(id,"销售合同审批");
        map.put("SdSalesContract",list);
        map .put("SysApprovalDetailed",lists);
        return map;
    }


    @Override
    public Map<String,Object> query(@Param("projectId") int projectId, int clientId, int deptId, Date didtimestart, Date didtimeend, int areauser, int vocational, int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();

            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(sdSalesContractMapper.querycount(projectId, clientId, deptId, didtimestart, didtimeend, areauser, vocational));
            page.setCurrentPageNo(pageIndex);

            List<SdSalesContract> List = sdSalesContractMapper.querybysome(projectId, clientId, deptId, didtimestart, didtimeend, areauser, vocational, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
            map.put("page",page);
            map.put("list",List);
            return map;
        }

    }
