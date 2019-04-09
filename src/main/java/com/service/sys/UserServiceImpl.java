package com.service.sys;

import com.alibaba.fastjson.JSONObject;
import com.beans.SysUser;
import com.dao.sys.UserMapper;
import com.util.Duanxin;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource()
    private UserMapper userMapper;
    @Override
    public SysUser getByAccount(String account){
        return userMapper.getByAccount(account);
    }

    /**
     * 注册账号
     * @param name 名字
     * @param mobile 手机号
     * @param password 密码
     * @return 是否成功 0失败 大于0成功
     */
    @Override
    public int register(String name,String password,String mobile) {
        return userMapper.register(name,DigestUtils.md5DigestAsHex(password.getBytes()),mobile);
    }

    /**
     * 手机短信验证
     * @param mobile 手机号
     * @return json类型 手机号 验证码  时间 是否发送
     */
    @Override
    public JSONObject verify(String mobile) {
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        JSONObject json = null;
        json = new JSONObject();
        json.put("mobile", mobile);
        json.put("verifyCode", verifyCode);
        json.put("createTime", System.currentTimeMillis());
        json.put("status",Duanxin.verify(mobile,verifyCode));
        return json;
    }

    /**
     * 手机号是否存在
     * @param mobile 手机号
     * @return 是否存在
     */
    @Override
    public boolean isAccount(String mobile) {
        int num=userMapper.isAccount(mobile);
        return num == 0;
    }

    /**
     * 修改账号下的密码
     * @param mobile 账号
     * @param newPassWord 新密码
     * @return 是否修改成功
     */
    @Override
    public int updatePassWord(String  mobile,String newPassWord){
        return userMapper.updatePassWord(mobile,newPassWord);
    }

    /**
     * 添加用户
     * @param user 用户类
     * @return 是否添加成功
     */
    @Override
    public int add(SysUser user) {
        return userMapper.add(user);
    }

    /**
     * 按公司,部门 ,职位 查询是否有用户
     * @param companyid 公司id
     * @param deptid 部门id
     * @param roleid 职位id
     * @return 有几个人
     */
    @Override
    public int isCountClassify(Integer companyid, Integer deptid, Integer roleid) {
        return userMapper.isCountClassify(companyid,deptid,roleid);
    }

    /**
     * 按名字,公司.部门 ,职位多条件查询用户
     * @param name 用户名字
     * @param companyid 公司id
     * @param deptid 部门id
     * @param roleid 职位id
     * @param pageIndex 第几页
     * @return 用户集合
     */
    @Override
    public List<SysUser> getUserList(String name, Integer companyid, Integer deptid, Integer roleid, int pageIndex, int pageSize) {
        return userMapper.getUserList(name,companyid,deptid,roleid,pageIndex,pageSize);
    }
}
