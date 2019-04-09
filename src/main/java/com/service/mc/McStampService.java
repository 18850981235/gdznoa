package com.service.mc;

import com.beans.McStamp;
import com.beans.SysApprovalDetailed;

import java.util.Date;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/3/18 11:23
 */
public interface McStampService {
    int addProjectApproval(SysApprovalDetailed detailed);

    int add(McStamp stamp);

    Map<String, Object> getList(String stampType, int deptid,
                                int userid, Date start,
                                Date end,int pageIndex);
}
