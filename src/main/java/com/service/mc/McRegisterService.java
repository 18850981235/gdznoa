package com.service.mc;

import com.beans.McRegisterRecords;
import com.beans.SysApprovalDetailed;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author 许思明
 * @create 2019/4/08 15:23
 */
public interface McRegisterService {
    //添加注册备案
    int addregister(McRegisterRecords mcregisterrecords, HttpServletRequest request);
    //更改注册备案
    int updateregist(McRegisterRecords mcRegisterRecords);
    //根据查询注册备案
    List<McRegisterRecords> querybyid(int id);
    //详情查询
    Map<String, Object> querydetailbyid(int id);
    //删除注册备案
    int delete(int id);
    //条件查询
    Map<String, Object>  querybyrecords(int id,String Name, String Type,String startTime,String endTime, int pageIndex);

    int addProjectApproval(SysApprovalDetailed detailed);
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~资质证书管理~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}
