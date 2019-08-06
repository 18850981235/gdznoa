package com.dao.ga;


import com.beans.GaOuterTubePass;
import com.beans.GaPayment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GaPaymentMapper {
    int add(GaPayment gaPayment);
    int updateById(GaPayment gaPayment);
    GaPayment getListById(int id);
    List<GaPayment> getList(@Param("projectid")int projectid,@Param("matter")String matter
            ,@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize);
    int getCount(@Param("projectid")int projectid,@Param("matter")String matter);
}