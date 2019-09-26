package com.dao.ga;




import com.beans.GaHarvestTicket;
import com.beans.GaOpenTicket;
import com.beans.bankflow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
@Mapper
public interface GaHarvestTicketMapper {
    int add(GaHarvestTicket gaHarvestTicket);
    int updateById(GaHarvestTicket gaHarvestTicket);
    GaHarvestTicket getListById(int id);
    List<GaHarvestTicket> getList(@Param("projectid") int projectid, @Param("type") String type
            , @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
    int getCount(@Param("projectid") int projectid, @Param("type") String type);
    BigDecimal sumCost(@Param("contractid") Integer contractid, @Param("type") String type);
    BigDecimal sumMoney(@Param("projectid") int projectid);
    String companyName(@Param("projectid") int projectid);
    List<bankflow> bankFlow(@Param("projectid") int projectid, @Param("type") String type);
}