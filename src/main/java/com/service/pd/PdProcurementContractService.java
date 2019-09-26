package com.service.pd;

import com.beans.PdProcurementContract;
import com.beans.SysApprovalDetailed;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public interface PdProcurementContractService {
    int addContractApproval(SysApprovalDetailed detailed);

    int addPdProcurement(PdProcurementContract procurementContract, HttpServletRequest request);

    int updatePdProcurement(PdProcurementContract procurementContract,HttpServletRequest request);



    int deletePdProcurement(@Param("id") int id);
    //查询单挑数据和清单
    Map<String,Object> querybyid(@Param("id") int id);

    //查询清单详情和审批流程
    Map<String,Object> querydetailbyid(@Param("id")int id);

    Map<String,Object>  queryBySome(@Param("projectid") int projectid,
                                    @Param("serialnumber") String  serialnumber,
                                    @Param("code") String  code,
                                    @Param("supplierid") int supplierid,
                                    @Param("id") int userid,
                                    @Param("pageIndex")  int pageIndex);

    List<PdProcurementContract>  queryAll();

    List<PdProcurementContract>  queryByProject(@Param("id")int id);



}
