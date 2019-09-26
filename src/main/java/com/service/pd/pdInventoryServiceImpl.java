package com.service.pd;

import com.beans.PdProcurementContract;
import com.beans.SdSalesContractInventory;
import com.beans.SdSalesInventory;
import com.beans.pdProcurementInventory;
import com.dao.pd.PdProcurementInventoryMapper;
import com.dao.pd.PdProcurementMapper;
import com.dao.sd.SdSalesContractInventoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

@Service("pdInventoryService")
public class pdInventoryServiceImpl implements pdInventoryService {
    @Resource
    private PdProcurementInventoryMapper PdInventoryMapper;
    @Resource
    private PdProcurementMapper pdProcurementMapper;

    @Override
    public int AddpdInventory(List<pdProcurementInventory> list, int contractid,double total) {
        try{
            pdProcurementMapper.updatePdPTotal( contractid, total);
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
