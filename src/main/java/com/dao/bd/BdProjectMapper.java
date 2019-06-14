package com.dao.bd;

import com.beans.BdProject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface BdProjectMapper {
    //按id查询立项信息
    BdProject getListById(@Param("id") int id);
    //按id修改立项信息
    int updateById(BdProject project);
    //按id删除立项信息
    int deleteById(@Param("id") int id);
    //新增立项信息
    int add(BdProject project);
    //按条件查询全部信息
    List<BdProject> getList(@Param("userid") int userid,
                            @Param("projectName") String projectName,
                            @Param("deptid") int deptid,
                            @Param("stage") String stage,
                            @Param("areaManager") int areaManager,
                            @Param("principalName") String principalName,
                            @Param("start") Date start,
                            @Param("end") Date end,
                            @Param("pageIndex") int pageIndex,
                            @Param("pageSize") int pageSize);

    //按条件统计数量
    int getCount(@Param("userid") int userid,
                 @Param("projectName") String projectName,
                 @Param("deptid") int deptid,
                 @Param("stage") String stage,
                 @Param("areaManager") int areaManager,
                 @Param("principalName") String principalName,
                 @Param("start") Date start,
                 @Param("end") Date end);

    //按审批人员查询
    List<BdProject> getByProcessUser(@Param("processUserId") int processUserId);

    List<BdProject> getProjectName();

    List<BdProject> getallProject();

    BdProject getProjectById(@Param("id") int id);

}