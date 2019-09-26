package com.service.ga;

import com.beans.GaComeGO;
import com.beans.SysApprovalDetailed;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/8/6 16:20
 */
public interface GaComeGoService {
    int add(GaComeGO gaComeGo, HttpServletRequest request);
    int addApproval(SysApprovalDetailed detailed);
    int update(GaComeGO gaComeGo);
    Map<String, Object> getlist(int projectid, String matter, String type, String type2, int pageIndex);
    Map<String,Object> getById(int id);
}
