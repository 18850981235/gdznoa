package com.dao.mc;

import com.beans.McDatumCost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface McDatumCostMapper {

    int add(McDatumCost mcDatumCost);

    int updateById(McDatumCost mcDatumCost);

    McDatumCost getListById(int id);
    int delete(@Param("id")int id);

    int getCount(@Param("name") String name,
                 @Param("deptid") int deptid,
                 @Param("start") Date start,
                 @Param("end") Date end,
                 @Param("userid") int usreid);
    List<McDatumCost> getList(@Param("name") String name,
                              @Param("deptid") int deptid,
                              @Param("start") Date start,
                              @Param("end") Date end,
                              @Param("userid") int usreid,
                              @Param("pageIndex")int pageIndex,
                              @Param("pageSize")int pageSize
                              );
}