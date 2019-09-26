package com.dao.ga;


import com.beans.GaOuterTubePass;
import com.beans.GaPayment;

import com.beans.bankflow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface GaPaymentMapper {
    int add(GaPayment gaPayment);

    int updateById(GaPayment gaPayment);

    GaPayment getListById(int id);

    List<GaPayment> getList(@Param("projectid") int projectid, @Param("matter") String matter
            , @Param("type") String type
            , @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    int getCount(@Param("projectid") int projectid, @Param("matter") String matter, @Param("type") String type);

    BigDecimal sumPaid(@Param("projectid") int projectid,
                       @Param("matter") String matter,
                       @Param("marketid") int marketid,
                       @Param("procurementid") int procurementid,
                       @Param("labourid") int labourid);

    List<bankflow> bankFlow (@Param("projectid") int projectid , @Param("type") String type);

}