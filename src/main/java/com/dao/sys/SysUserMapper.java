package com.dao.sys;

import com.beans.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
     int updateUser(SysUser user);

     List<SysUser>  queryUser(@Param("id") int id);

     List<SysUser>  queryUser(@Param("account") String account,@Param("name") String name);

     int querycount(@Param("account") String account,@Param("name") String name);

}
