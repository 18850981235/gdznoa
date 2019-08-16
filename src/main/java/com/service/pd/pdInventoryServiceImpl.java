package com.service.pd;

import com.beans.SdSalesInventory;
import com.beans.pdProcurementInventory;
import com.dao.pd.PdProcurementInventoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

@Service("pdInventoryService")
public class pdInventoryServiceImpl implements pdInventoryService {
    @Resource
    private PdProcurementInventoryMapper PdInventoryMapper;

    @Override
    public int AddpdInventory(List<pdProcurementInventory> list, int contractid) {
        try{
            PdInventoryMapper.deleteInventory(contractid);
            for (int i = 0; i < list.size(); i++) {

                pdProcurementInventory pdInventory=list.get(i);
                pdInventory.setContractid(contractid);

                PdInventoryMapper.addInventory(pdInventory);
                }
            } catch (Exception e) {
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return 0;
            }
            return 1;
        }
}
