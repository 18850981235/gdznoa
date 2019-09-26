package com.service.ga;

import com.beans.GaOuterTubePass;
import com.beans.SysApprovalDetailed;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/8/5 15:08
 */
public interface GaOuterTubePassService {
    int add(GaOuterTubePass gaOuterTubePass, HttpServletRequest request);
    int addApproval(SysApprovalDetailed detailed);
    int update(GaOuterTubePass gaOuterTubePass);
    int delete(int id);
    List<GaOuterTubePass> getProjectId(int projectId);
    Map<String,Object> getById(int id);
}
