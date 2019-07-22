package com.service.mc;

import com.beans.McMaterials;
import com.beans.SysApprovalDetailed;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/4/10 17:16
 */
public interface McMaterialsSevice {
    int addProjectApproval(SysApprovalDetailed detailed);
    int add(McMaterials mcMaterials, HttpServletRequest request);
    int update(McMaterials materials);

    int delete(@Param("id")int id);
    Map<String, Object> getList(String projectName, int deptid, Date start,
                                Date end, int usreid, int pageIndex);
    McMaterials getListById(int id);
    Map<String, Object> getParticular1ById(int id);
}
