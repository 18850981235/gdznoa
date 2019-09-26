package com.dao.ed;

import com.beans.EdMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface EdMessageMapper {
    int addMessageMapper(EdMessage edMessage);

    int updateMessage(EdMessage edMessage);

    int deleteMassage(@Param("id") int id);

    EdMessage queryAllById(@Param("id")int id);

    List<EdMessage> queryAllBySome(@Param("projectid")int projectid,@Param("site")String site,
                                   @Param("deptid")int deptid,@Param("clientid")int clientid,
                                   @Param("userid") int userid,
                                    @Param("pageIndex") int pageIndex,
                                    @Param("pageSize") int pageSize);

    int  querycountBySome(@Param("projectid")int projectid,@Param("site")String site,@Param("userid") int userid,
                          @Param("deptid")int deptid,@Param("clientid")int clientid);


}
