package com.service.sys;

import com.beans.SysRole;
import com.dao.sys.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("RoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Resource()
    private RoleMapper roleMapper;
    @Override
    public List<SysRole> getAllRole() {
        return roleMapper.getallRole();
    }

    @Override
    public int addRole(String name) {
        return roleMapper.add(name);
    }

    @Override
    public int deleteRole(int id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public int updateRole(int id,String name) {
        return roleMapper.updateById(id, name);
    }
}
