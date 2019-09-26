package com.dao.ga;


import com.beans.GaSalary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GaSalaryMapper {
    int add(GaSalary gaSalary);
    int updateById(GaSalary gaSalary);
    GaSalary getListById(int id);
    List<GaSalary> getList(@Param("projectid") int projectid,
                           @Param("pageIndex") int pageIndex,
                           @Param("pageSize") int pageSize);
    int getCount(@Param("projectid") int projectid);
}