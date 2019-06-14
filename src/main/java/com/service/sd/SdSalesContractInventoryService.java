package com.service.sd;

import com.beans.SdSalesContractInventory;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface SdSalesContractInventoryService {

    int  addInventory(SdSalesContractInventory salesContractInventory, InputStream in, MultipartFile file)throws Exception;

    int  updateInventory(SdSalesContractInventory salesContractInventory);

    int deletecontractInven(int id);

    Map<String, Object> querybyProjectid(@Param("projectId")int projectId,int pageIndex);

    Map<String, Object> queryContractInventorbyid(@Param("id")int id );

    List<SdSalesContractInventory> queryInventoryby(@Param("branchName") String  branch_name);

    Map<String, Object> queryInventory(@Param("projectId")int projectId, @Param("branchName")String branchName, @Param("systemId")int systemId, @Param("subitemId")int subitemId, int pageIndex);

}
