package com.service.ed;

import com.beans.EdMessage;
import com.beans.SysApprovalDetailed;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface EdMessageService {
    int addMassageApproval(SysApprovalDetailed detailed);

    int addPdProcurement(EdMessage message, HttpServletRequest request);

    int updateProcurement(EdMessage message, HttpServletRequest request);

    EdMessage queryById(@Param("id")int id);

    int deletePdProcurement(@Param("id")int id);

    Map<String,Object>  queryBySome(@Param("projectid")int projectid,@Param("site")String site,@Param("userid") int userid,
                                    @Param("deptid")int deptid,@Param("clientid")int clientid,
                                    @Param("pageIndex")  int pageIndex);

    Map<String,Object>  getDetailById(int id);

}
