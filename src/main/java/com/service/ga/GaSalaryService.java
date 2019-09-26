package com.service.ga;

import com.beans.GaPayment;
import com.beans.GaSalary;
import com.beans.SysApprovalDetailed;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/8/14 17:48
 */
public interface GaSalaryService {
    int add(String json, HttpServletRequest request);
    int update(GaSalary gaSalary);
    Map<String, Object> getlist(int projectid, int pageIndex);
    Map<String, Object> getById(int id);
    Map<String, Object> getByIdParticular(int id);
}
