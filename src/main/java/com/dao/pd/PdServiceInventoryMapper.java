package com.dao.pd;

import com.beans.PdServiceInventory;
import com.beans.SdSalesInventory;
import com.beans.pdProcurementInventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PdServiceInventoryMapper {

   int addInventory(PdServiceInventory Inventory);

   int deleteInventory(@Param("contractid") int contractid);

   List<PdServiceInventory> querySdSalesInventory(@Param("id") int id);

   PdServiceInventory getInstancebyid(@Param("id") int id);


}
