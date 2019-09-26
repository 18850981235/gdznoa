package com.service.ga;

import com.beans.GaPayment;
import com.beans.SysApprovalDetailed;

import com.beans.bankflow;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/8/6 16:20
 */
public interface GaPaymentService {
    int add(GaPayment gaPayment, HttpServletRequest request);
    int addApproval(SysApprovalDetailed detailed);
    int update(GaPayment gaPayment);
    Map<String, Object> getlist(int projectid, String matter, String type, int pageIndex);
    Map<String,Object>  getById(int id);
    BigDecimal sumPaid(int projectid, String matter, int id);

    List<bankflow>getBankFlow(@Param("projectid") int prijectid , @Param("type") String type);
}
