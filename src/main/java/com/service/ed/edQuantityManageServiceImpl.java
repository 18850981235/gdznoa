package com.service.ed;

import com.beans.PdProcurementContract;
import com.beans.SdSalesInventory;
import com.dao.pd.PdProcurementInventoryMapper;
import com.dao.pd.PdProcurementMapper;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class edQuantityManageServiceImpl implements  edQuantityManageService {
    @Resource
    private PdProcurementMapper pdProcurementMapper;
    @Resource
    private PdProcurementInventoryMapper pdProcurementInventoryMapper;


    @Override
    public Map<String, Object> querybyid(int id) {
        Map<String,Object> map=new HashMap<>();
        try {
            PdProcurementContract pdProcurementContract= pdProcurementMapper.querybyid(id);
            List<SdSalesInventory> list=pdProcurementInventoryMapper.querySdSalesInventory(id);


            map.put("list",list);
            map.put("pdProcurementContract",pdProcurementContract);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }
}
