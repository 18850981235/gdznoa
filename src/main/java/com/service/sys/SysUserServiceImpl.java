package com.service.sys;

import com.beans.*;
import com.dao.sys.*;
import com.util.FileUtils;
import com.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Transactional
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
    @Resource
    private AuthorityMapper authorityMapper;


    @Override
    public int updateUser(SysUser user) {
        return sysUserMapper.updateUser(user);
    }

    @Override
    public SysUser querybyId(@Param("id") int id) {
        return sysUserMapper.queryUserbyid(id);
    }

    @Override
    public Map<String ,Object> queryUser(@Param("account") String account, @Param("name") String name,@Param("pageIndex") int pageIndex) {
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
            String accessory= FileUtils.uploadFile(request,"evidence");

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
    public Map<String ,Object>queryRequestbyuserid(@Param("name") String name,  @Param("EndTime")  Date StartTime,
                                                   @Param("EndTime") Date EndTime,int pageIndex){
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(requestspMapper.count(name, StartTime, EndTime));
            page.setCurrentPageNo(pageIndex);
            List<Requestsp> list=requestspMapper.queryby(name, StartTime, EndTime, (page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public Requestsp queryRequestbyuserid(@Param("userid") int userid) {
        Requestsp requestsp=new Requestsp();
      try{
             requestsp=requestspMapper.querybyuserid(userid);

        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        };
        return requestsp;
    }

    @Override
    public int queryrequst(int userid) {
        return requestspMapper.querycount(userid);
    }

    @Override
    public Map<String, Object> queryAllMunebymyselef( @Param("userid") int userid) {
        Map<String, Object> map = new HashMap<>();
        try {

            List<SysAuthority>  ListAuthority =authorityMapper.getMenuIdByUserId(userid);
            List<SysMenu> listMenu = menuMapper.getMenuList(0, 0);
            map.put("ListAuthority", ListAuthority);
            map.put("listMenu", listMenu);
        }catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public Requestsp queryRequestbyid(@Param("id") int id) {
        return requestspMapper.querybyid(id);
    }

    @Override
    public List<RequestspErmissions> getListErmissions(@Param("quesid") int quesid, @Param("userid") int userid) {
        return requestspErmissionsMapper.queryErmissions(quesid, userid);
    }

    @Override
    public Map<String, Object> getallMenu( int userid) {
        Map<String, Object> map = new HashMap<>();
      try {
          Requestsp ListRequest= requestspMapper.querybyuserid(userid);
//          List<RequestspErmissions> ListRequest = requestspErmissionsMapper.queryErmissions(quesid, userid);
          List<SysAuthority>  ListAuthority =authorityMapper.getMenuIdByUserId(userid);
          List<SysMenu> listMenu = menuMapper.getMenuList(0, 0);
          map.put("ListRequest", ListRequest);
          map.put("ListAuthority", ListAuthority);
          map.put("listMenu", listMenu);
      }catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }


    @Override
    public int  add(List<RequestspErmissions> list,Requestsp requestsp ) {
        try {
            for (RequestspErmissions re : list) {
                re.setRequesid(requestsp.getId());
                re.setUserid(requestsp.getUserid());
                requestspErmissionsMapper.addErmissions(re);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }

    };
   public int updatePassword(@Param("userId")int userId,@Param("password") String password){
        return sysUserMapper.updatePassword(userId,password);
    }

}
