package com.dao.sys;

import com.beans.Requestsp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
@Mapper
public interface RequestspMapper {
    int addQuestsp(Requestsp requestsp);

   List<Requestsp> queryby(@Param("name") String name, @Param("StartTime")  Date StartTime,
                                 @Param("EndTime") Date EndTime, @Param("pageIndex")int pageIndex, @Param("pageSize")int pageSize);

    int count(@Param("name") String name, @Param("StartTime")  Date StartTime,
                   @Param("EndTime") Date EndTime);

    Requestsp querybyuserid(@Param("userid") int userid);

    int querycount(@Param("userid") int userid);


    Requestsp querybyid(@Param("id")int id);

    Requestsp getRequestspby(@Param("userid")int userid);

    int updateState(@Param("id") int id,@Param("state") String state);
}
