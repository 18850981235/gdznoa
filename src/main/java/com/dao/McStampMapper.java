package com.dao;


import com.beans.McStamp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}