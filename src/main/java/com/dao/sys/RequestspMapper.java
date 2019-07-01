package com.dao.sys;

import com.beans.Requestsp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RequestspMapper {
    int addQuestsp(Requestsp requestsp);

   List<Requestsp> querybyuserid(@Param("userid")int userid, @Param("pageIndex")int pageIndex, @Param("pageSize")int pageSize);

    int querycount(@Param("userid")int userid);

    Requestsp querybyid(@Param("id")int id);

    Requestsp getRequestspby(@Param("userid")int userid);

}
