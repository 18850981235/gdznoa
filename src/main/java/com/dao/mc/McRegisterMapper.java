package com.dao.mc;

import com.beans.McRegisterRecords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author 许思明
 * @create 2019/4/08
 */
@Mapper
public interface McRegisterMapper {
    //i申请注册备案啊
    int add(McRegisterRecords mcregisterrecords);
    //修改注册备案数据
    int update(McRegisterRecords mcregisterrecords);
    //根据ID查询注册备案
    List<McRegisterRecords>   querybyid(@Param("id") int id);
    //删除备案
    int delete(@Param("id") int id);
    //根据名称和类型查询
    int querybycount( @Param("id") int id,@Param("name") String name, @Param("type") String type);
    List<McRegisterRecords> querybynameatype(@Param("id") int id,@Param("name") String name, @Param("type") String type, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
}