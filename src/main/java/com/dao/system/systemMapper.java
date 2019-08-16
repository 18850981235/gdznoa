package com.dao.system;

import com.beans.system;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface systemMapper {
    int  addsystem(system system);
    int  updatesystrm(system system);
    system querybyid(@Param("id")int id);

    List<system> querybyfid(@Param("fid")int fid);
    List<system> queryfid();

    List<system> query();
}
