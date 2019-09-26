package com.service.sd;

import com.beans.SdSalesContractInventory;
import com.beans.SdSalesInventory;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface SdSalesContractInventoryService {


    void addContractInventory(@RequestParam("projectId")int projectId,
                             @RequestParam("system")int system,
                             @RequestParam("type")String type,
                              HttpServletRequest request,
                              HttpServletResponse response);

     Map<String,Object>  queryContractInventory(@RequestParam("projectId")int projectId,
                                                          @RequestParam("system")int system,
                                                          @RequestParam("type")String type,
                                                          int pageIndex);
    Map<String,Object>  queryContractInventory(@RequestParam("projectId")int projectId,
                                               @RequestParam("system")int system,
                                               int pageIndex);


    Map<String,Object>  Inventorydetail(@RequestParam("id")int id );


    int addInventory( List<SdSalesInventory> list,int contractid,double total);

    XSSFWorkbook queryDaily(SdSalesContractInventory sdSalesContractInventory)throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException;


    Map<String,Object> getbyprojectidandInt(@Param("id") int id);

    List<SdSalesContractInventory> getbyprojecti(@Param("id") int id);


    List<SdSalesInventory>  QuerydetailsbyInt(@Param("id")int id);






}
