package com.service.sys;

import com.beans.RequestspErmissions;
import com.beans.SysMenu;
import com.beans.SysUser;
import com.beans.Requestsp;
import com.dao.sys.MenuMapper;
import com.dao.sys.RequestspMapper;
import com.dao.sys.SysUserMapper;
import com.dao.sys.requestspErmissionsMapper;
import com.util.FileUtils;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService{
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private RequestspMapper requestspMapper;
    @Resource
    private requestspErmissionsMapper requestspErmissionsMapper;
    @Resource
    private MenuMapper menuMapper;


    @Override
    public int updateUser(SysUser user) {
        return sysUserMapper.updateUser(user);
    }

    @Override
    public SysUser querybyId(int id) {
        return sysUserMapper.queryUserbyid(id);
    }

    @Override
    public Map<String ,Object> queryUser(String account, String name,int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(sysUserMapper.querycount(account, name));
            page.setCurrentPageNo(pageIndex);
            List<SysUser> list=sysUserMapper.queryUser(account, name,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public int addyReques(Requestsp requestsp, HttpServletRequest request) {
        int num = 0;
        try {
            String accessory= FileUtils.uploadFile(request,"file");

        if (accessory!=null&&!accessory.equals("")){
            requestsp.setEvidence(accessory);
        }
            num = requestspMapper.addQuestsp(requestsp);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    }





    @Override
    public Map<String ,Object>queryRequestbyuserid(int userid,int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(requestspMapper.querycount(userid));
            page.setCurrentPageNo(pageIndex);
            List<Requestsp> list=requestspMapper.querybyuserid(userid,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }
    @Override
    public Requestsp queryRequestbyuserid(int id) {
        return requestspMapper.querybyid(id);
    }

    @Override
    public List<RequestspErmissions> getListErmissions( int quesid,int userid) {
        return requestspErmissionsMapper.queryErmissions(quesid, userid);
    }

    @Override
    public Map<String, Object> getallMenu(int quesid, int userid) {
        Map<String, Object> map=new HashMap<>();
        List<RequestspErmissions> ListRequest=requestspErmissionsMapper.queryErmissions(quesid, userid);
        List<SysMenu> listMenu=menuMapper.getMenuList(0,0);
        map.put("ListRequest",ListRequest);
        map.put("listMenu",listMenu);
        return map;
    }


    @Override
    public int  add(List<RequestspErmissions> list,Requestsp requestsp ) {
        return requestspErmissionsMapper.addErmissions();
    }
}
