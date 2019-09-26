package com.service.sys;

import com.beans.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleService {

    List<SysRole> getAllRole();

    int addRole(@Param("name") String name);

    int  deleteRole(@Param("id") int id);

    int updateRole(@Param("id")int id,@Param("name")String name);


}
