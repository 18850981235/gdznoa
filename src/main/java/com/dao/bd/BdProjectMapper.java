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
    List<BdProject> getList(@Param("name") String name,
                            @Param("type") String type,
                            @Param("code") String code,
                            @Param("status") String status,
                            @Param("start") Date start,
                            @Param("end") Date end);

    //按条件统计数量
    int getCount(@Param("userid") int userid,
                 @Param("name") String name,
                 @Param("type") String type,
                 @Param("code") String code,
                 @Param("status") String status,
                 @Param("start") Date start,
                 @Param("end") Date end);

    //按审批人员查询
    List<BdProject> getByProcessUser(@Param("processUserId") int processUserId);

    List<BdProject> getProjectName();
}