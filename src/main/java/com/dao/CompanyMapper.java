package com.dao;

import com.beans.SysCompany;
import com.beans.SysDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/2/25 14:47
 */
@Mapper
public interface CompanyMapper {
    //查询所有公司
    List<SysCompany> getList(@Param("id") int id);
    //添加公司
    int add(@Param("name") String name);
    //按id修改公司名称
    int updateById(@Param("id") int id, @Param("name") String name);
    //删除公司
    int deleteById(@Param("id") int id);

}
