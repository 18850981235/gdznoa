package com.dao.sys;

import com.beans.SysApprovalDetailed;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/3/14 9:51
 */
@Mapper
public interface ApprovalDetailedMapper {
    //添加审批流程的详细信息
    int add(SysApprovalDetailed detailed);
    //按approvalId查询审批详细信息
    List<SysApprovalDetailed> getListByapprovalId(@Param("approvalId") int approvalId, @Param("approvalName") String approvalName);

}
