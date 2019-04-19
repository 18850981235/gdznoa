package com.dao.sys;

import com.beans.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/1/26 14:48
 */

@Mapper
public interface MenuMapper {
        //用用户权限获取菜单
        List<SysMenu> getMenuListByUserid(@Param("userid") int userid);
        //添加菜单信息
        int add(SysMenu menu);
        //修改菜单信息
        int updateById(SysMenu menu);
        //用id删除菜单信息
        int deleteById(@Param("id") int id);
        //用id查询菜单信息
        List<SysMenu> getMenuListById(@Param("id") int id);
        //查询所有菜单集合
        List<SysMenu> getMenuList(@Param("pageIndex") int pageIndex,
                                  @Param("pageSize") int pageSize);
}