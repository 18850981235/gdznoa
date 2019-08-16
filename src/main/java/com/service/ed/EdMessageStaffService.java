package com.service.ed;

import com.beans.EdMessageStaff;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface EdMessageStaffService {
    int addMessageStaff(EdMessageStaff messageStaff, HttpServletRequest request);

    int updateMessageStaff(EdMessageStaff messageStaff, HttpServletRequest request);

    int deleteMessageStaff(@Param("id")int id);

    EdMessageStaff queryOneById(@Param("id")int id);

    Map<String, Object> queryBySome(@Param("projectid")int projectid, @Param("id")String  name, @Param("id") int userid,
                                    @Param("identityCard")String identityCard, @Param("staffRole")String staffRole,
                                    @Param("pageIndex")  int pageIndex);
}
