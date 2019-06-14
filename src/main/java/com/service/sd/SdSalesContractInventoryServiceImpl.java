package com.service.sd;

import com.beans.SdSalesContract;
import com.beans.SdSalesContractInventory;
import com.beans.SdSalesInventory;
import com.dao.sd.SdSalesContractInventoryMapper;
import com.dao.sd.SdSalesInventoryMapper;
import com.util.ExcelUtils;
import com.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service("SdSalesContractInventoryService")
public class SdSalesContractInventoryServiceImpl implements SdSalesContractInventoryService{
    @Resource
    private SdSalesContractInventoryMapper ContractInventoryMapper;
    @Resource
    private SdSalesInventoryMapper sdSalesInventoryMapper;
    @Override
    public int  addInventory(SdSalesContractInventory salesContractInventory, InputStream in, MultipartFile file) throws Exception{
        return ContractInventoryMapper.addSalesContractInventory(salesContractInventory);
//        List<List<Object>> listob = ExcelUtils.getBankListByExcel(in, file.getOriginalFilename());
//        List<SdSalesInventory> medicalList = new ArrayList<SdSalesInventory>();
//        for (int i = 0; i < listob.size(); i++) {
//            List<Object> ob = listob.get(i);
//            SdSalesInventory sdSalesInventory = new SdSalesInventory();
//            medical.setMedical_city(String.valueOf(ob.get(0)));
//            medical.setMedical_id(Integer.valueOf((String) ob.get(1)));
//            medical.setDrug_name(String.valueOf(ob.get(2)));
//            medicalList.add(medical);
//        }
//        excelMapper.deleteMedical();
//        for (int i = 0; i < medicalList.size(); i++) {
//            excelMapper.medicalexcel(medicalList.get(i));
//        }
    }

    @Override
    public int  updateInventory(SdSalesContractInventory salesContractInventory) {
        return ContractInventoryMapper.updateInventory(salesContractInventory) ;
    }

    @Override
    public int deletecontractInven(int id) {
        try{

            ContractInventoryMapper.deletecontractInven(id);
            sdSalesInventoryMapper.deleteInventory(id);

    } catch (Exception e) {
        e.printStackTrace();
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return 0;
    }
        return 1;
    }

    @Override
    public    Map<String, Object> querybyProjectid(int projectId,int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();
try{
        if (pageIndex == 0) {
            pageIndex = 1;
        }
        page.setPageSize(10);
        page.setTotalCount(ContractInventoryMapper.querycountProjectid(projectId));
        page.setCurrentPageNo(pageIndex);

        List<SdSalesContractInventory> List = ContractInventoryMapper.querybyProjectid(projectId, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
        map.put("page",page);
        map.put("list",List);
} catch (Exception e) {
    e.printStackTrace();
    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
}
        return map;

    }

    @Override
    public  Map<String, Object> queryContractInventorbyid(@Param("id")int id) {

        Map<String, Object> map = new HashMap<>();
        try {
            List<SdSalesContractInventory> ContractInventoryList = ContractInventoryMapper.queryContractInventorbyid(id);
            List<SdSalesInventory> sdSalesInventoryList = sdSalesInventoryMapper.querySdSalesInventory(id);
            map.put("ContractInventory", ContractInventoryList);
            map.put("sdSalesInventoryList", sdSalesInventoryList);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public   List<SdSalesContractInventory> queryInventoryby(String  branch_name) {
        return ContractInventoryMapper.querybysales_contract(branch_name);
    }

    @Override
    public   Map<String, Object> queryInventory(@Param("projectId") int projectId, String branchName, int systemId, int subitemId, int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();
        try {
        if (pageIndex == 0) {
            pageIndex = 1;
        }
        page.setPageSize(10);
        page.setTotalCount(ContractInventoryMapper.querycount(projectId, branchName, systemId, subitemId));
        page.setCurrentPageNo(pageIndex);

        List<SdSalesContractInventory> List = ContractInventoryMapper.query(projectId, branchName,systemId, subitemId, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
        map.put("page",page);
        map.put("list",List);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }
}
