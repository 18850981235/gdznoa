package com.service;

import com.beans.BdProject;
import com.beans.SysApprovalDetailed;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/3/12 10:41
 */

public interface BdProjectService {
    int add(BdProject project, HttpServletRequest request);
    int addProjectApproval(SysApprovalDetailed detailed);
    Map<String, Object> getlist(int userid, String name, String type, String code, String status,
                                Date start, Date end, int pageIndex);
    Map<String,Object>  getProjectById(int id);
    int update(BdProject project);
}
