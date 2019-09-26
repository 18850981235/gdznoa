package com.service.sd;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.*;
import com.dao.bd.BdProjectMapper;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Transactional
@Service("SdSalesContractInventoryService")
public class SdSalesContractInventoryServiceImpl implements SdSalesContractInventoryService{
    @Resource
    private SdSalesContractInventoryMapper ContractInventoryMapper;
    @Resource
    private SdSalesInventoryMapper sdSalesInventoryMapper;

    @Resource
    private BdProjectMapper bdProjectMapper;

    @Override
    public void addContractInventory(@RequestParam("projectId")int projectId,
                                    @RequestParam("system")int system,
                                    @RequestParam("type")String type,
                                    HttpServletRequest request, HttpServletResponse response) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
        PrintWriter out = null;
        Map<String,Object>maps=new HashMap<>();
        try{
            int id=0;
            InputStream in = file.getInputStream();
            response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码
            out = response.getWriter();
            SdSalesContractInventory s=ContractInventoryMapper.querybysome(projectId, system, type);
            if (s!=null) {
              id=s.getId();
            }else {

            SdSalesContractInventory SalesContractInventory = new SdSalesContractInventory();
            SalesContractInventory.setProjectId(projectId);
            SalesContractInventory.setSystem(system);
            SalesContractInventory.setType(type);
            //先查询该工程的系统
            int a = ContractInventoryMapper.addSalesContractInventory(SalesContractInventory);
            if (a >= 0) {
                id= SalesContractInventory.getId();
            } else {
              id=0;
                    out.print("新增信息错误！请选择正确的清单归属！");
            }
        }
                if (file.isEmpty()) {
                    throw new Exception("文件不存在！");
                }

                List<Map<String,String>> list=new ArrayList<>();
                List<List<Object>> listob = ExcelUtils.getBankListByExcel(in, file.getOriginalFilename());
                for (int i = 1; i < listob.size(); i++) {
                    Map<String,String> map=new HashMap<>();
                    List<Object> ob = listob.get(i);
                    for( int j=0;j<ob.size();j++){
                        if (ob.get(j)==null){
                            map.put(String.valueOf(listob.get(0).get(j)),null);

                        }else{
                            map.put(String.valueOf(listob.get(0).get(j)),String.valueOf(ob.get(j)));
                        }
                    }

                    list.add(map);
                }
                    maps.put("id",id);
                    maps.put("List",list);
                in.close();

                if(list.isEmpty()||list.size()<=0){
                    out.print("上传失败。请校对合适的表格！");
                }
                out.print(JSONObject.toJSONString(maps,
                        SerializerFeature.DisableCircularReferenceDetect,
                        SerializerFeature.WriteNullStringAsEmpty));


        } catch (Exception e) {
                out.print("上传失败。请校对合适的表格！");
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                e.printStackTrace();


    }  finally {
                out.flush();
                out.close();
            }
    }

    @Override
    public Map<String, Object> queryContractInventory(int projectId, int system, String type,int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(ContractInventoryMapper.queryCount(projectId,system,type));
            page.setCurrentPageNo(pageIndex);
            List<SdSalesContractInventory> list=  ContractInventoryMapper.query(projectId, system,type,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;

    }

    @Override
    public Map<String, Object> queryContractInventory(int projectId, int system, int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(ContractInventoryMapper.queryCounts(projectId,system));
            page.setCurrentPageNo(pageIndex);
            List<SdSalesContractInventory> list=  ContractInventoryMapper.querys(projectId, system,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public  Map<String,Object> Inventorydetail(int id) {
        Map<String,Object> map=new HashMap<>();
        List<SdSalesContractInventory> Listcontract=ContractInventoryMapper.queryContractInventorbyid(id);
        List<SdSalesInventory>listInventory= sdSalesInventoryMapper.querySdSalesInventory(id);
        map.put("Listcontract",Listcontract );
        map.put("listInventory",listInventory );
        return map;

    }

    ;





    @Override
    public int addInventory( List<SdSalesInventory> list,int contractid,double total) {
        SdSalesContractInventory contractIn=new SdSalesContractInventory();
        contractIn.setTotal(total);
        contractIn.setId(contractid);
        try{
            ContractInventoryMapper.updateInventory(contractIn);
            sdSalesInventoryMapper.deleteInventory(contractid);
        for (int i = 0; i < list.size(); i++) {

            SdSalesInventory sdSalesInventory=list.get(i);
            sdSalesInventory.setContractid(contractid);

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
        book = ExcelUtils.createExcelFile(SdSalesInventory.class, InventoryList, map, sdSalesContractInventory.getProject().getName()+"详情清单表");
        return book;
    }

    @Override
    public  Map<String,Object> getbyprojectidandInt(int id) {
        Map<String,Object> map=new HashMap<>();
        BdProject project=bdProjectMapper.getProjectAllById(id);
        List<SdSalesContractInventory> list= ContractInventoryMapper.getbyprojectidandInt(id);
        map.put("project",project);
        map.put("list",list);
        return map;

    }

    @Override
    public List<SdSalesContractInventory> getbyprojecti(int id) {
        return ContractInventoryMapper.queryProjectid(id);
    }

    @Override
    public  List<SdSalesInventory>  QuerydetailsbyInt(int id) {

        List<SdSalesInventory> listInventory = sdSalesInventoryMapper.querySdSalesInventory(id);
        return listInventory;
    }


}
