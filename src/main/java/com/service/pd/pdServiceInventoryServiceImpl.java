package com.service.pd;

import com.beans.PdServiceInventory;
import com.dao.pd.PdServiceInventoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;
@Transactional
@Service("pdServiceInventoryService")
public class pdServiceInventoryServiceImpl implements  pdServiceInventoryService{
    @Resource
    private PdServiceInventoryMapper pdServiceInventoryMapper;
    @Override
    public int AddpdInventory(List<PdServiceInventory> list, int contractid) {
        try {
            pdServiceInventoryMapper.deleteInventory(contractid);
        for(int s=0;s<list.size();s++) {
            PdServiceInventory pdServiceInventory=list.get(s);
            pdServiceInventory.setContractid(contractid);
             pdServiceInventoryMapper.addInventory(pdServiceInventory);
        }
            return 1;
        }catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

}
