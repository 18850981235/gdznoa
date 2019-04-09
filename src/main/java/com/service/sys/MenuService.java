package com.service.sys;

import com.beans.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/2/19 15:05
 */
public interface MenuService {
    List<SysMenu> getMenuList(int id);
}