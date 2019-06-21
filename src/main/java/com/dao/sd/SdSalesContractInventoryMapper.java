package com.dao.sd;

import com.beans.SdSalesContractInventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SdSalesContractInventoryMapper {
    int addSalesContractInventory(SdSalesContractInventory salesContractInventory);

    int updateInventory(SdSalesContractInventory sdSalesContractInventory);

    int deletecontractInven(int id);

     List<SdSalesContractInventory> querybyProjectid(@Param("projectId") int projectId,@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
    int querycountProjectid (@Param("projectId")int projectId);

    List<SdSalesContractInventory> queryContractInventorbyid(@Param("id") int id);

    List<SdSalesContractInventory> queryry(@Param("id")int id);
    List<SdSalesContractInventory> querybysales_contract(@Param("branch_name")String branch_name);

    List<SdSalesContractInventory> query(@Param("projectId")int projectId,@Param("branchName")String branchName,@Param("systemId")int systemId,@Param("subitemId")int subitemId,@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
    int querycount (@Param("projectId")int projectId,@Param("branchName")String branchName,@Param("systemId")int systemId,@Param("subitemId")int subitemId);

    SdSalesContractInventory querynewdata();

}
