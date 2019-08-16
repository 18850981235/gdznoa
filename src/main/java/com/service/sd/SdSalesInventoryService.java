package com.service.sd;

import com.beans.SdSalesInventory;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

public interface SdSalesInventoryService {
   String  ExceltoSdSalesContractInventory(HttpServletRequest request, HttpServletResponse response ) throws Exception;

    SdSalesInventory getInventorybyId(@Param("id")int id);
}
