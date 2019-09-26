package com.dao.sd;

import com.beans.SdSalesContractInventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Mapper
public interface SdSalesContractInventoryMapper {
    int addSalesContractInventory(SdSalesContractInventory salesContractInventory);

    SdSalesContractInventory querybysome(@Param("projectId")int projectId,
                                         @Param("system")int system,
                                         @Param("type")String type);

    int queryCount(@Param("projectId")int projectId,
                   @Param("system")int system,
                   @Param("type")String typ);
    int queryCounts(@Param("projectId")int projectId,
                   @Param("system")int system
                );
    List<SdSalesContractInventory> query(@Param("projectId")int projectId,
                                         @Param("system")int system,
                                         @Param("type")String type,
                                         @Param("pageIndex")int pageIndex,
                                         @Param("pageSize")int pageSize);
    List<SdSalesContractInventory> querys(@Param("projectId")int projectId,
                                         @Param("system")int system,
                                         @Param("pageIndex")int pageIndex,
                                         @Param("pageSize")int pageSize);
    int updateInventory(SdSalesContractInventory sdSalesContractInventory);

    int deletecontractInven(@Param("id")int id);

    List<SdSalesContractInventory> queryProjectid (@Param("id")int id);

    List<SdSalesContractInventory> queryContractInventorbyid(@Param("id") int id);

    SdSalesContractInventory querynewdata();

    List<SdSalesContractInventory> getbyprojectidandInt(@Param("id")int id);


}
