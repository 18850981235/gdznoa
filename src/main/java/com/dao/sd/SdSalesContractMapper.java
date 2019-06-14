package com.dao.sd;

import com.beans.SdSalesContract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface SdSalesContractMapper {
    int addSalesContract(SdSalesContract sdSalesContract);

    int updateSalesContract(SdSalesContract sdSalesContract);

    SdSalesContract querybyid(@Param("id") int id);


    List<SdSalesContract> querybysome(@Param("projectId")int projectId, @Param("clientId")int clientId,
                                      @Param("deptId")int deptId, @Param("didtimestart")Date didtimestart,
                                      @Param("didtimeend")Date didtimeend,@Param("areauser")int areauser,@Param("vocational")int vocational,
                                      @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    int querycount(@Param("projectId")int projectId, @Param("clientId")int clientId,
                   @Param("deptId")int deptId, @Param("didtimestart")Date didtimestart,
                   @Param("didtimeend")Date didtimeend,@Param("areauser")int areauser,
                   @Param("vocational")int vocational);

}
