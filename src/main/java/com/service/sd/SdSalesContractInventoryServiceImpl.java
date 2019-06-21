package com.service.sd;

import com.beans.ExcelBean;
import com.beans.SdSalesContractInventory;
import com.beans.SdSalesInventory;
import com.dao.sd.SdSalesContractInventoryMapper;
import com.dao.sd.SdSalesInventoryMapper;
import com.util.ExcelUtils;
import com.util.Page;
import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;
import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.*;


import javax.annotation.Resource;

@Transactional
@Service("SdSalesContractInventoryService")
public class SdSalesContractInventoryServiceImpl implements SdSalesContractInventoryService{
    @Resource
    private SdSalesContractInventoryMapper ContractInventoryMapper;
    @Resource
    private SdSalesInventoryMapper sdSalesInventoryMapper;
    @Override
    public int  addInventory(SdSalesContractInventory salesContractInventory, InputStream in, MultipartFile file) throws Exception{
      try{   salesContractInventory.setStateTime(new Date());
          ContractInventoryMapper.addSalesContractInventory(salesContractInventory);
          SdSalesContractInventory newdate=  ContractInventoryMapper.querynewdata();
          salesContractInventory.setId(newdate.getId());
        List<List<Object>> listob = ExcelUtils.getBankListByExcel(in, file.getOriginalFilename());
        List<SdSalesInventory> SdSalesInventory = new ArrayList<SdSalesInventory>();
        for (int i = 0; i < listob.size(); i++) {
            List<Object> ob = listob.get(i);
            SdSalesInventory sdSalesInventory = new SdSalesInventory();
            sdSalesInventory.setContractid(salesContractInventory.getId());
              if(String.valueOf(ob.get(0))==null||String.valueOf(ob.get(0))==""){
                sdSalesInventory.setCode(null);
            }else{sdSalesInventory.setCode(String.valueOf(ob.get(0)));};

              if(String.valueOf(ob.get(1))==null||String.valueOf(ob.get(1))==""){
                sdSalesInventory.setName(null);
            }else{sdSalesInventory.setName(String.valueOf(ob.get(1)));};

              if(String.valueOf(ob.get(2))==null||String.valueOf(ob.get(2))==""){
                sdSalesInventory.setModel(null);
            }else{sdSalesInventory.setModel(String.valueOf(ob.get(2)));};

            if(String.valueOf(ob.get(3))==null||String.valueOf(ob.get(3))==""){
                sdSalesInventory.setParameter(null);
            } else{sdSalesInventory.setParameter(String.valueOf(ob.get(3)));};

            if(String.valueOf(ob.get(4))==null||String.valueOf(ob.get(4))==""){
                sdSalesInventory.setTrademark(null);
            } else{sdSalesInventory.setTrademark(String.valueOf(ob.get(4)));};

            if(String.valueOf(ob.get(5))==null||String.valueOf(ob.get(5))==""){
                sdSalesInventory.setUnit(null);
            } else{sdSalesInventory.setUnit(String.valueOf(ob.get(5)));};

            if(String.valueOf(ob.get(6))==null||String.valueOf(ob.get(6))==""){
                sdSalesInventory.setNum(0);
            } else{sdSalesInventory.setNum(Integer.valueOf((String)ob.get(6)));};

            if(String.valueOf(ob.get(7))==null||String.valueOf(ob.get(7))==""){
                sdSalesInventory.setUnitCost(0);
            } else{sdSalesInventory.setUnitCost(Integer.valueOf((String)ob.get(7)));};

            if(String.valueOf(ob.get(8))==null||String.valueOf(ob.get(8))==""){
                sdSalesInventory.setSubtotal(0);
            } else{sdSalesInventory.setSubtotal(Integer.valueOf((String)ob.get(7)));};

            if(String.valueOf(ob.get(9))==null||String.valueOf(ob.get(9))==""){
                sdSalesInventory.setRemarks(null);
            } else{sdSalesInventory.setRemarks(String.valueOf(ob.get(9)));};


            SdSalesInventory.add(sdSalesInventory);
        }
        for (int i = 0; i < SdSalesInventory.size(); i++) {
            sdSalesInventoryMapper.addInventory(SdSalesInventory.get(i));
        }
    } catch (Exception e) {
        e.printStackTrace();
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return 0;
    }
        return 1;
}

    @Override
    public int addInventory(SdSalesContractInventory salesContractInventory, List<SdSalesInventory> list) {
        try{
        for (int i = 0; i < list.size(); i++) {

            SdSalesInventory sdSalesInventory=list.get(i);
            sdSalesInventory.setContractid(salesContractInventory.getId());
            sdSalesInventoryMapper.addInventory(sdSalesInventory);
        } } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        return 1;
    }


    public XSSFWorkbook queryDaily(SdSalesContractInventory sdSalesContractInventory) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException {
        List<SdSalesInventory> InventoryList = sdSalesInventoryMapper.querySdSalesInventory(sdSalesContractInventory.getId());
        List<ExcelBean> ems = new ArrayList<>();
        Map<Integer, List<ExcelBean>> map = new LinkedHashMap<>();
        XSSFWorkbook book = null;
        ems.add(new ExcelBean("编号", "code", 0));
        ems.add(new ExcelBean("名称", "name", 0));
        ems.add(new ExcelBean("规格型号", "model", 0));
        ems.add(new ExcelBean("技术参数", "parameter", 0));
        ems.add(new ExcelBean("品牌名称", "trademark", 0));
        ems.add(new ExcelBean("单位", "unit", 0));
        ems.add(new ExcelBean("数量", "num", 0));
        ems.add(new ExcelBean("单价", "unitCost", 0));
        ems.add(new ExcelBean("小计", "subtotal", 0));
        ems.add(new ExcelBean("备注", "remarks", 0));
        map.put(0, ems);
        book = ExcelUtils.createExcelFile(SdSalesInventory.class, InventoryList, map, sdSalesContractInventory.getBranchName()+"详情清单表");
        return book;
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
