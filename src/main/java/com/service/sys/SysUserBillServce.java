package com.service.sys;

import com.beans.SysUserBill;
import org.apache.ibatis.annotations.Param;

import java.util.Map;


public interface SysUserBillServce {
    Map<String,Object> querybillbyuserid(@Param("userId") int userId,@Param("PageIndex")int PageIndex);

    SysUserBill querybillbyid(@Param("id")int id);
}
