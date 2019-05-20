package com.service.mc;

import com.beans.McDatumCost;
import com.beans.SysApprovalDetailed;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/4/11 14:31
 */
public interface McDatumCostService {
    int addProjectApproval(SysApprovalDetailed detailed);
    int add(McDatumCost mcDatumCost, HttpServletRequest request);
    int update(McDatumCost mcDatumCost);
    Map<String, Object> getList(String name, int deptid, Date start,
                                Date end, int usreid, int pageIndex);
    McDatumCost getListById(int id);
    Map<String, Object> getParticular1ById(int id);
}

