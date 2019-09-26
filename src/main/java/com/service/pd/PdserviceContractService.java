package com.service.pd;


import com.beans.PdServiceContract;
import com.beans.PdServiceInventory;
import com.beans.SysApprovalDetailed;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface PdserviceContractService {

    int addPdServiceApproval(SysApprovalDetailed detailed);

    int addPdProcurement(PdServiceContract pdServiceContract, HttpServletRequest request);

    int updateProcurement(PdServiceContract pdServiceContract, HttpServletRequest request);

    //查询清单详情和审批流程
    Map<String,Object> querydetailbyid(@Param("id")int id);

    Map<String,Object> queryById(@Param("id")int id);

    int deletePdProcurement(@Param("id")int id);

    Map<String,Object>  queryBySome(@Param("projectid") int projectid,
                                    @Param("serialnumber") String  serialnumber,
                                    @Param("code") String  code,
                                    @Param("secondName") String  secondName,
                                    @Param("userid")int userid,
                                    @Param("pageIndex")  int pageIndex);

    List<PdServiceContract> queryAll ();

    List<PdServiceContract> queryByProject (@Param("id")int id);











}
