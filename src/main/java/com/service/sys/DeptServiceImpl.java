package com.service.sys;

import com.beans.SysDept;
import com.dao.sys.DeptMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/2/26 14:18
 */
@Transactional
@Service("deptService")
public class DeptServiceImpl implements DeptService{
    @Resource()
    private DeptMapper deptMapper;

    /**
     * 查询部门集合 id为0时返回全部
     * @param id 部门id
     * @return 部门集合
     */
    @Override
    public List<SysDept> getDeptList(int id){
        return  deptMapper.getList(id);
    }
    /**
     * 添加部门
     * @param name 部门名字
     * @return 是否添加成功
     */
    @Override
    public int add(String name){
        return deptMapper.add(name);
    }
    /**
     * 删除部门
     * @param id 部门id
     * @return 是否删除成功
     */
    @Override
    public int delete(int id){
        return deptMapper.deleteById(id);
    }
    /**
     * 查询每个部门下的员工
     * @return 部门以及部门下的员工
     */
    @Override
    public List<SysDept> getDeptUsers() {
        return deptMapper.getDeptUsers();
    }


}