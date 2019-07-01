package com.dao.sys;

import com.beans.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    //按账号查询
    SysUser getByAccount(@Param("account") String account);

    //注册插入
    int register(@Param("name") String name, @Param("password") String password, @Param("mobile") String mobile);

    //用id查询用户
    SysUser getByID(@Param("id") int id);

    //用条件查询用户列表
    List<SysUser> getUserList(@Param("name") String name,
                              @Param("companyid") int companyid,
                              @Param("deptid") int deptid,
                              @Param("roleid") int roleid,
                              @Param("pageIndex") int pageIndex,
                              @Param("pageSize") int pageSize);

    //查询用户人数
    int getUserCount(@Param("name") String name,
                     @Param("companyid") int companyid,
                     @Param("deptid") int deptid,
                     @Param("roleid") int roleid);

    //用id删除员工
    int deleteByID(@Param("id") int id);

    //用id修改员工
    int updateByID(@Param("id") int id);

    //判断账号是否存在
    int isAccount(@Param("mobile") String mobile);

    //新增员工
    int add(SysUser user);
    //按账号修改密码
    int updatePassWord(@Param("account") String mobile, @Param("password") String password);
    //按公司或部门或职位查询有无员工
    int isCountClassify(@Param("companyid") int companyid,
                        @Param("deptid") int deptid,
                        @Param("roleid") int roleid);

    //按部门跟公司总经理职务查询总经理id
    List<SysUser> DeptroleUser(int deptid);

    //查询大区负责人
    List<SysUser> areaManagerUser(String areaManager);

    //按部门跟公司总经理职务查询总经理id
    List<SysUser> queryDeptroleUser(int deptid);



}
