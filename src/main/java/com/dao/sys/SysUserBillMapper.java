package com.dao.sys;

import com.beans.SysUserBill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysUserBillMapper {
    int  addBill(SysUserBill sysUserBill);
    List<SysUserBill> queryBiiByUserId(@Param("userId") int userId,@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    int queryCountByUserid(@Param("userId") int userId);

    SysUserBill queryBillById(@Param("id") int id);
}
