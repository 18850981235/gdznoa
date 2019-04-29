package com.dao.mc;


import com.beans.McStamp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface McStampMapper {
     //按id查询商务盖章
     McStamp getListById(@Param("id") int id);
     //添加商务盖章
     int add(McStamp stamp);
     //按id修改商务盖章
     int updateById(McStamp stamp);
     //删除盖章申请
     int deleteById(@Param("id") int id);
     //按条件查询盖章集合
     List<McStamp>  getList(@Param("userid") int userid,
                            @Param("stampType") String stampType,
                            @Param("deptid") int deptid,
                            @Param("content") String content,
                            @Param("stampType") String purpose,
                            @Param("start")Date start,
                            @Param("end") Date end,
                            @Param("pageIndex")int pageIndex,
                            @Param("pageSize")int pageSize);
     //按条件统计盖章个数
     int getCount(@Param("userid") int userid,
                  @Param("stampType") String stampType,
                  @Param("deptid") int deptid,
                  @Param("content") String content,
                  @Param("stampType") String purpose,
                  @Param("start")Date start,
                  @Param("end") Date end);

     List<McStamp>  getListProject(@Param("projectName")String projectName,
                            @Param("userid") int userid,
                            @Param("stampType") String stampType,
                            @Param("deptid") int deptid,
                            @Param("content") String content,
                            @Param("stampType") String purpose,
                            @Param("start")Date start,
                            @Param("end") Date end,
                            @Param("pageIndex")int pageIndex,
                            @Param("pageSize")int pageSize);
     int getCountProject(@Param("projectName")String projectName,
                  @Param("userid") int userid,
                  @Param("stampType") String stampType,
                  @Param("deptid") int deptid,
                  @Param("content") String content,
                  @Param("stampType") String purpose,
                  @Param("start")Date start,
                  @Param("end") Date end);
}