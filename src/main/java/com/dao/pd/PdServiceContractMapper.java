package com.dao.pd;

import com.beans.PdServiceContract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PdServiceContractMapper {
    int AddPdServiceContract( PdServiceContract pdServiceContract);

    int UpdatePdServiceContract( PdServiceContract pdServiceContract);

    PdServiceContract queryOneByid(@Param("id") int id);

    int deletePdService(@Param("id")int id);

    int queryCount( @Param("projectid") int projectid , @Param("serialnumber")String serialnumber,@Param("code") String code,@Param("secondName") String secondName,@Param("userid")int userid);

    List<PdServiceContract> queryBySome(@Param("projectid") int projectid , @Param("serialnumber")String serialnumber,
                                        @Param("code") String code, @Param("secondName") String secondName,
                                        @Param("userid")int userid,
                                        @Param("pageIndex") int pageIndex,
                                        @Param("pageSize") int pageSize);

}
