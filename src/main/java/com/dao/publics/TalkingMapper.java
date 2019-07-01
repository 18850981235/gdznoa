package com.dao.publics;

import com.beans.PubTalking;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TalkingMapper {

   List<PubTalking> getTalkingByUserId(@Param("userId") int userId, @Param("pageIndex")int pageIndex, @Param("pageSize")int pageSize);
    int  getcountByUserId(@Param("userId") int userId);

    int addTalking(PubTalking pubTalking);

    List<PubTalking> queryoriginator(@Param("userId") int userId);
    int querynnewcontent(@Param("userId")int userId);

    List<PubTalking> getNewContent(@Param("userId") int userId);


    int updateState(@Param("oriId") int oriId,@Param("recId") int recId);
}
