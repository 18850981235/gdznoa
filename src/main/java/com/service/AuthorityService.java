package com.service;

import com.beans.SysAuthority;
import com.beans.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/2/19 14:58
 */

public interface   AuthorityService {
    boolean add(int[] arr, int userid);
    //修改用户权限
    boolean updateAuthority(int userid, int[] arr);

    List<SysAuthority> getMenuIdByUserId(int userid);
}