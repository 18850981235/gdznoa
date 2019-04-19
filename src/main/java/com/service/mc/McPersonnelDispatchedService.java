package com.service.mc;

import com.beans.McPersonnelDispatched;
import com.beans.SysApprovalDetailed;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/4/8 11:29
 */
public interface McPersonnelDispatchedService {
    int add(McPersonnelDispatched personnelDispatched, HttpServletRequest request);
    int update(McPersonnelDispatched personnelDispatched);
    int addProjectApproval(SysApprovalDetailed detailed);
    Map<String, Object> getList(String name, int deptid,
                                int userid, Date start,
                                Date end, int pageIndex);
    McPersonnelDispatched getListById(int id);
    Map<String, Object> getParticular1ById(int id);
    int deleteById(int id);
}
