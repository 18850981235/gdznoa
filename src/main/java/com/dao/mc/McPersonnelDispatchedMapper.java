package com.dao.mc;


import com.beans.McPersonnelDispatched;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface McPersonnelDispatchedMapper {

     int  add(McPersonnelDispatched personnelDispatched);
     int  updateById(McPersonnelDispatched personnelDispatched);
     McPersonnelDispatched getListById(@Param("id")int id);
     List<McPersonnelDispatched>  getList(@Param("name") String name,
                                          @Param("deptid") int deptid,
                                          @Param("userid") int userid,
                                          @Param("start") Date start,
                                          @Param("end") Date end,
                                          @Param("pageIndex")int pageIndex,
                                          @Param("pageSize")int pageSize);
     int getCount(@Param("name") String name,
                  @Param("deptid") int deptid,
                  @Param("userid") int userid,
                  @Param("start") Date start,
                  @Param("end") Date end);
     int  deleteById(@Param("id") int id);
}