package com.service.mc;

import com.beans.McStamp;
import com.beans.SysApprovalDetailed;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/3/18 11:23
 */
public interface McStampService {
    int addProjectApproval(SysApprovalDetailed detailed);

    int add(McStamp stamp, HttpServletRequest request);

    int update(McStamp stamp);

    Map<String, Object> getList(String projectName,int userid, String stampType,
                                int deptid, String content,
                                String purpose, Date start,
                                Date end,int pageIndex);

    McStamp getListById(int id);

    Map<String, Object> getParticular1ById(int id);


    int delete(@Param("id") int id);

}
