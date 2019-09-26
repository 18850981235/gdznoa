package com.service.ga;

import com.beans.GaIncome;
import com.beans.SysApprovalDetailed;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/8/19 9:41
 */

public interface GaIncomeService {
    int add(GaIncome gaIncome, HttpServletRequest request);
    int addApproval(SysApprovalDetailed detailed);
    int update(GaIncome gaIncome);
    Map<String, Object> getlist(int projectid, String type, int pageIndex);
    Map<String,Object>  getById(int id);
}
