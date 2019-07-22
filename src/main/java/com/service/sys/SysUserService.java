package com.service.sys;

import com.beans.Requestsp;
import com.beans.RequestspErmissions;
import com.beans.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SysUserService {
    int updateUser(SysUser user);

   SysUser querybyId(@Param("id") int id);

    Map<String ,Object> queryUser(@Param("account") String account, @Param("name") String name ,  @Param("pageIndex") int pageIndex);

    int addyReques(Requestsp requestsp, HttpServletRequest request);

    Map<String ,Object> queryRequestbyuserid(@Param("name") String name, @Param("EndTime")  Date StartTime,
                                             @Param("EndTime") Date EndTime,int pageIndex);

    Requestsp queryRequestbyuserid(@Param("userid") int userid);

    int queryrequst(@Param("userid") int userid);

    Map<String, Object> queryAllMunebymyselef( @Param("userid") int userid);

    Requestsp queryRequestbyid(@Param("id")int id);

    List<RequestspErmissions> getListErmissions(@Param("quesid")int quesid,@Param("userid")int userid);

    Map<String ,Object> getallMenu(@Param("userid")int userid);

    int  add(List<RequestspErmissions> arr,Requestsp requestsp);

    int updatePassword(@Param("userId")int userId,@Param("password") String password);



}
