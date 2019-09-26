package com.dao.ga;


import com.beans.GaComeGO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface GaComeGoMapper {
    int add(GaComeGO gaComeGo);

    int updateById(GaComeGO gaComeGo);

    GaComeGO getListById(int id);

    List<GaComeGO> getList(@Param("projectid") int projectid, @Param("matter") String matter
            , @Param("type") String type, @Param("type2") String type2
            , @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    int getCount(@Param("projectid") int projectid, @Param("matter") String matter, @Param("type2") String type2, @Param("type") String type);

}