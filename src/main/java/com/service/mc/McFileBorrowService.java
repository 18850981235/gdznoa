package com.service.mc;

import com.beans.McFileBorrow;
import com.beans.SysApprovalDetailed;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/3/22 9:30
 */
public interface McFileBorrowService {
    int addProjectApproval(SysApprovalDetailed detailed);
    int add(McFileBorrow fileBorrow, HttpServletRequest request);
    int update(McFileBorrow fileBorrow);
    Map<String, Object> getList(String projectName,String name, int deptid,Date start,
                                Date end, int usreid, int pageIndex);
    McFileBorrow getListById(int id);
    Map<String, Object> getParticular1ById(int id);
}
