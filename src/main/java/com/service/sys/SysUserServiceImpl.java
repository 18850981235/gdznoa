package com.service.sys;

import com.beans.RequestspErmissions;
import com.beans.SysUser;

import java.util.List;

public class SysUserServiceImpl implements SysUserService{

    @Override
    public int updateUser(SysUser user) {
        return 0;
    }

    @Override
    public List<SysUser> querybyId(int id) {
        return null;
    }

    @Override
    public List<SysUser> queryUser(String account, String name) {
        return null;
    }

    @Override
    public List<RequestspErmissions> querybyid(int userid, String state) {
        return null;
    }

    @Override
    public boolean add(int[] arr, int userid) {
        return false;
    }
}
