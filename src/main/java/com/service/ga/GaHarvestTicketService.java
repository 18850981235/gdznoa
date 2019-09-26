package com.service.ga;

import com.beans.GaHarvestTicket;
import com.beans.GaOpenTicket;
import com.beans.SysApprovalDetailed;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/8/7 9:26
 */
public interface GaHarvestTicketService {
    int add(GaHarvestTicket gaHarvestTicket);
    int addApproval(SysApprovalDetailed detailed);
    int update(GaHarvestTicket gaHarvestTicket);
    Map<String, Object> getlist(int projectid, String type, int pageIndex);
    Map<String,Object>  getById(int id);
    BigDecimal sumCost(Integer contractid, String type);
    Map<String,Object>  getSumMoneyAndCompanyName(int id);
}
