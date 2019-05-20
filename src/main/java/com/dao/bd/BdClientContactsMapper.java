package com.dao.bd;

import com.beans.BdClientContacts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/3/4 16:10
 */
@Mapper
public interface BdClientContactsMapper {
    //添加客户人员信息
    int add(BdClientContacts contacts);
    //用id修改客户人员信息
    int updateById(BdClientContacts contacts);
    //通过条件筛选客户人员信息
    List<BdClientContacts> getContactsList(@Param("name") String name,
                                           @Param("clientname") String clientname,
                                           @Param("pageIndex") int pageIndex,
                                           @Param("pageSize") int pageSize);
    //通过条件筛选客户信息人员总数
    int getCount(@Param("name") String name, @Param("clientname") String clientname);
    //用id查询具体的客户人员信息
    BdClientContacts getContactsById(@Param("id") int id);
    //通过客户id查询客户人员集合
    List<BdClientContacts> getContactsByClientid(@Param("clientid") int id);
    //用公司id查询旗下员工
    int deleteByClientid(@Param("clientid") int clientid);
    //查询旗下是否有员工
    int getContactsByClientidCount(@Param("clientid") int clientid);
}