package com.dao;


import com.beans.BdClient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface BdClientMapper {
    //添加客户信息
    int add(BdClient client);
    //按id修改客户信息
    int updateById(BdClient client);
    //按条件筛选客户总数
    int getCount(@Param("name") String name, @Param("address") String address,
                 @Param("unitType") String unitType, @Param("userid") int userid);
    //按条件筛选客户信息集合
    List<BdClient> getClientList(@Param("name") String name, @Param("address") String address,
                                 @Param("unitType") String unitType, @Param("userid") int userid,
                                 @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
    //按id删除客户信息
    int deleteById(@Param("id") int id);
    //用查询具体的客户信息
    BdClient getClientById(@Param("id") int id);
    //判断是否有客户名称
    int isName(@Param("name") String name);
    //查询全部的地区
    List<String> getAddress();
    //查询客户名字ID
    List<BdClient> getClientName();
}