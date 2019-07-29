package com.service.bd;

import com.beans.BdProject;
import com.beans.SysApprovalDetailed;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/3/12 10:41
 */

public interface BdProjectService {
    int add(BdProject project, HttpServletRequest request);
    int addProjectApproval(SysApprovalDetailed detailed);
    Map<String, Object> getlist(int userid, String projectName, int deptid, String stage, int areaManager,
                                String principalName,Date start, Date end, int pageIndex);
    Map<String,Object>  getProjectById(int id);
    int update(BdProject project);

    List<BdProject> getProjectName();

    List<BdProject>  getallPeoject();
    int deleteProject(int id);

}
