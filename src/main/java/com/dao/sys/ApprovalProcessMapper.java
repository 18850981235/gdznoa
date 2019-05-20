package com.dao.sys;

import com.beans.SysApprovalProcess;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/3/4 9:44
 */
@Mapper
public interface ApprovalProcessMapper {
    //修改审批流程
    int updateProcessById(@Param("usersid") String usersid, @Param("id") int id);
    //查询所有审批流程
    List<SysApprovalProcess> getProcessList();
    //按id查询审批流程
    SysApprovalProcess getProcessById(int id);

}
