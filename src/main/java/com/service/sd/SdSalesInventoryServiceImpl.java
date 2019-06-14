package com.service.sd;

import com.beans.SdSalesInventory;
import com.dao.sd.SdSalesInventoryMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("SdSalesInventoryService")
public class SdSalesInventoryServiceImpl implements SdSalesInventoryService{
    @Resource
    SdSalesInventoryMapper sdSalesInventoryMapper ;
    @Override
    public int addSdSalesContractInventory() {
        return 0;
    }

    @Override
    public SdSalesInventory getInventorybyId(@Param("id") int id) {
        return sdSalesInventoryMapper.getInstancebyid(id);
    }
}
