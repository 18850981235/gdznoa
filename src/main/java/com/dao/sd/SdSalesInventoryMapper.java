package com.dao.sd;

import com.beans.SdSalesContractInventory;
import com.beans.SdSalesInventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SdSalesInventoryMapper {
   int addInventory(SdSalesInventory sdSalesInventory);

   int deleteInventory(int id);

   List<SdSalesInventory> querySdSalesInventory(@Param("contractid")int contractid);

   SdSalesInventory getInstancebyid(@Param("id")int id);

}
