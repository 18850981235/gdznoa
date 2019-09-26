package com.dao.pd;

import com.beans.SdSalesInventory;
import com.beans.pdProcurementInventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PdProcurementInventoryMapper {
   int addInventory(pdProcurementInventory Inventory);


   int deleteInventory(@Param("contractid") int contractid);

   List<SdSalesInventory> querySdSalesInventory(@Param("id") int id);

   SdSalesInventory getInstancebyid(@Param("id") int id);

}
