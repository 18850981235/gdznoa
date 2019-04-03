package com.service;

import com.alibaba.fastjson.JSONObject;
import com.beans.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    SysUser getByAccount(String userName);
    int register(String name, String password, String mobile);
    JSONObject verify(String mobile);
    boolean isAccount(String mobile);
    int updatePassWord(String mobile, String newPassWord);
    int add(SysUser user);
    int isCountClassify(Integer companyid, Integer deptid, Integer roleid);
    List<SysUser> getUserList(String name, Integer companyid, Integer deptid,
                              Integer roleid, int pageIndex, int pageSize);
}
