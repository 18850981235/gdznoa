package com.service.sd;

import com.beans.SdSalesContract;
import com.beans.SysApprovalDetailed;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface SdSalesContractservice {
    int addContractApproval (SysApprovalDetailed sysApprovalDetailed);

    int addSdSalesContract(SdSalesContract sdSalesContract, HttpServletRequest reques);

    int updateSdSalesContract(SdSalesContract sdSalesContract);

   SdSalesContract querybyId(@Param("id")int id);

    Map<String,Object> querydetailbyid(@Param("id")int id);

    Map<String,Object> query(@Param("projectId")int projectId, @Param("clientId")int clientId, @Param("deptId")int deptId, @Param("didtimestart") Date didtimestart,
                             @Param("areauser")int areauser, @Param("vocational")int vocational, int pageIndex);

    List<SdSalesContract> querybyProjectId(@RequestParam("id")int id);




}
