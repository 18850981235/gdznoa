package com.dao.sd;

import com.beans.SdSalesContractInventory;
import com.beans.SdSalesInventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SdSalesInventoryMapper {
   int addInventory(SdSalesInventory sdSalesInventory);


   int deleteInventory(@Param("contractid") int contractid);

   List<SdSalesInventory> querySdSalesInventory(@Param("id")int id);

   SdSalesInventory getInstancebyid(@Param("id")int id);

}
