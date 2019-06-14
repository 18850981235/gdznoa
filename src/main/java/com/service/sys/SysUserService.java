package com.service.sys;

import com.beans.RequestspErmissions;
import com.beans.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserService {
    int updateUser(SysUser user);

    List<SysUser> querybyId(@Param("id") int id);

    List<SysUser> queryUser(@Param("account") String account,@Param("name") String name);

    List<RequestspErmissions> querybyid(@Param("userid")int userid,@Param("state")String  state);

    boolean add(int[] arr, int userid);

}
