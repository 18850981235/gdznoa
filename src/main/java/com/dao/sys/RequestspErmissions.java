package com.dao.sys;

import com.beans.SysAuthority;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RequestspErmissions {
    int add(@Param("userid") int userid, @Param("menuid") int menuid, @Param("state")String state, @Param("time")Date time);
    //删除用户所有权限
    int deleteByUserId(@Param("userid") int userid);
    //查询用户权限
    List<SysAuthority> getMenuIdByUserId(@Param("userid") int userid);
}
