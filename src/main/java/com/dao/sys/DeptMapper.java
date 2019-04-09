package com.dao.sys;

import com.beans.SysDept;
import com.beans.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/2/25 14:47
 */
@Mapper
public interface DeptMapper {
    //查询所有部门
    List<SysDept> getList(@Param("id") int id);
    //添加部门
    int add(@Param("name") String name);
    //按ID修改部门
    int updateById(@Param("id") int id, @Param("name") String name);
    //删除部门
    int deleteById(@Param("id") int id);
    //查询部门以及部门下员工
    List<SysDept> getDeptUsers();
    //按id查询部门
    SysDept getListById(@Param("id") int id);

}
