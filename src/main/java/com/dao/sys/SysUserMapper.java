package com.dao.sys;

import com.beans.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysUserMapper {

     List<SysUser>  queryUser(@Param("account") String account,@Param("name") String name,
                              @Param("pageIndex") int pageIndex,
                              @Param("pageSize") int pageSize);

     int querycount(@Param("account") String account,@Param("name") String name);

     SysUser queryUserbyid(@Param("id") int id);


     int updateUser(SysUser user);



}
