package com.dao.sys;

import com.beans.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/2/25 14:47
 */
@Mapper
public interface RoleMapper {
    //查询所有的职位信息
    List<SysRole> getList(@Param("id") int id);
    //添加职位
    int add(@Param("name") String name);
    //按id修改职位信息
    int updateById(@Param("id") int id, @Param("name") String name);
    //按id删除职位信息
    int deleteById(@Param("id") int id);

    SysRole getbyid(@Param("roleid") int roleid);

}
