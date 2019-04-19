package com.dao.mc;

import com.beans.McFileBorrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface McFileBorrowMapper {
    int add(McFileBorrow fileBorrow);
    int updateById(McFileBorrow fileBorrow);
    McFileBorrow getListById(int id);
    List<McFileBorrow> getList(@Param("name") String name,
                               @Param("deptid") int deptid,
                               @Param("start") Date start,
                               @Param("end") Date end,
                               @Param("userid") int usreid,
                               @Param("pageIndex")int pageIndex,
                               @Param("pageSize")int pageSize);
    int  getCount(@Param("name") String name,
                  @Param("deptid") int deptid,
                  @Param("start") Date start,
                  @Param("end") Date end,
                  @Param("userid") int usreid);
}