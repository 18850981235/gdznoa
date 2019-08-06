package com.service.ga;

import com.beans.GaPayment;
import com.beans.SysApprovalDetailed;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/8/6 16:20
 */
public interface GaPaymentService {
    int add(GaPayment gaPayment);
    int addApproval(SysApprovalDetailed detailed);
    int update(GaPayment gaPayment);
    Map<String, Object> getlist(int projectid,String matter, int pageIndex);
    Map<String,Object>  getById(int id);
}
