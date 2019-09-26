package com.dao.pd;

import com.beans.PdProcurementContract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PdProcurementMapper {
    int addprocurement(PdProcurementContract procurement);

    int updatePdProcurement(PdProcurementContract procurement);

    int updatePdPTotal(@Param("contractid")int contractid,@Param("total")double total);

    int deletePdProcurement(@Param("id")int id);

    PdProcurementContract querybyid(@Param("id")int id);


    List<PdProcurementContract> queryBySome(@Param("projectid") int projectid,
                                            @Param("serialnumber") String  serialnumber,
                                            @Param("code") String  code,
                                            @Param("supplierid") int supplierid,
                                            @Param("userid") int userid,
                                            @Param("pageIndex") int pageIndex,
                                            @Param("pageSize") int pageSize);
    int querycountBySome(@Param("projectid") int projectid,
                         @Param("serialnumber") String  serialnumber,
                         @Param("code") String  code,
                         @Param("supplierid") int supplierid,
                         @Param("userid") int userid
                         );

    List<PdProcurementContract> queryAll();

    List<PdProcurementContract> queryByProject(@Param("id")int id);

}
