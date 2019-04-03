package com.dao;

import com.beans.MyWork;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/3/18 14:30
 */
@Mapper
public interface MyWorkMapper {
    List<MyWork> getList(@Param("userid") int userid);
}
