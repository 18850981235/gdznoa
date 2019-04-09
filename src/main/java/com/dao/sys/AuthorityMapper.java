package com.dao.sys;

import com.beans.SysAuthority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author 李鹏熠
 * @create 2019/1/27 10:58
 */
@Mapper
public interface AuthorityMapper {
    //给用户分配权限 插入
    int add(@Param("userid") int userid, @Param("menuid") int menuid);
    //删除用户所有权限
    int deleteByUserId(@Param("userid") int userid);
    //查询用户权限
    List<SysAuthority> getMenuIdByUserId(@Param("userid") int userid);

}
