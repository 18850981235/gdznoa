package com.service.publics;

import com.beans.PubTalking;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TalkingService {

    Map<String, Object> getTalkingByUserId(@Param("userId") int userId, @Param("PageIndex")int PageIndex);

    int addTalk(PubTalking pubTalking);

    Map<String, Object> queryoriginator(@Param("userId") int userId);

    Map<String, Object> getNewContent(@Param("userId") int userId);

    int addAdminTalk(PubTalking pubTalking);
}
