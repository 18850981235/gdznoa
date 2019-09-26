package com.dao.ga;


import com.beans.GaOpenTicket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GaOpenTicketMapper {
    int add(GaOpenTicket gaOpenTicket);
    int updateById(GaOpenTicket gaOpenTicket);
    GaOpenTicket getListById(int id);
    List<GaOpenTicket> getList(@Param("projectid") int projectid, @Param("type") String type
            , @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
    int getCount(@Param("projectid") int projectid, @Param("type") String type);
}