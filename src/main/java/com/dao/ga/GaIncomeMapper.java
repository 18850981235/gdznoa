package com.dao.ga;


import com.beans.GaIncome;
import com.beans.bankflow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface GaIncomeMapper {
    int add(GaIncome gaIncome);

    int updateById(GaIncome gaIncome);

    GaIncome getListById(int id);

    List<GaIncome> getList(@Param("projectid") int projectid,
                           @Param("type") String type,
                           @Param("pageIndex") int pageIndex,
                           @Param("pageSize") int pageSize);

    int getCount(@Param("projectid") int projectid, @Param("type") String type);
    List<bankflow> bankFlow(@Param("projectid") int projectid, @Param("type") String type);

}