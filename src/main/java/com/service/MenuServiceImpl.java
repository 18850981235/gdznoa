package com.service;

import com.beans.SysMenu;
import com.dao.AuthorityMapper;
import com.dao.MenuMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/2/19 15:05
 */
@Transactional
@Service("menuService")
public class MenuServiceImpl  implements MenuService{
    @Resource()
    private MenuMapper menuMapper;
    @Resource()
    private AuthorityMapper authorityMapper;


    /**
     * 按人员id查询菜单  id为0是返回全部
     * @param id 人员id
     * @return 菜单集合
     */
    @Override
    public List<SysMenu> getMenuList(int id) {
        return menuMapper.getMenuList(id);
    }
}