package com.service.sys;

import com.beans.SysDept;

import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/2/26 14:18
 */
public interface DeptService {

    List<SysDept> getDeptList(int id);
    int add(String name);
    int delete(int id);
    List<SysDept> getDeptUsers();
}
