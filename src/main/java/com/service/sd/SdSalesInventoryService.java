package com.service.sd;

import com.beans.SdSalesInventory;
import org.apache.ibatis.annotations.Param;

public interface SdSalesInventoryService {
    int addSdSalesContractInventory();

    SdSalesInventory getInventorybyId(@Param("id")int id);
}
