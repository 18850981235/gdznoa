package com.service.sys;

import com.beans.Requestsp;
import com.beans.RequestspErmissions;
import com.beans.SysMenu;
import com.beans.SysUser;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("SysRequestspService")
public class SysRequestspServiceImpl implements SysRequestspService{
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private RequestspMapper requestspMapper;
    @Resource
    private requestspErmissionsMapper requestspErmissionsMapper;
    @Resource
    private MenuMapper menuMapper;


   public  Requestsp getRequestspby(int userid){
       return requestspMapper.getRequestspby(userid);
   }
}
