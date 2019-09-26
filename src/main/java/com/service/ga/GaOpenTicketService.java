package com.service.ga;

import com.beans.GaOpenTicket;
import com.beans.GaPayment;
import com.beans.SysApprovalDetailed;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/8/7 9:26
 */
public interface GaOpenTicketService {
    int add(GaOpenTicket gaOpenTicket, HttpServletRequest request);
    int addApproval(SysApprovalDetailed detailed);
    int update(GaOpenTicket gaOpenTicket);
    Map<String, Object> getlist(int projectid, String type, int pageIndex);
    Map<String,Object>  getById(int id);
}
