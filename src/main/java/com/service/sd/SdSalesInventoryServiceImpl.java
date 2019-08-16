package com.service.sd;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.SdSalesContractInventory;
import com.beans.SdSalesInventory;
import com.dao.sd.SdSalesInventoryMapper;
import com.util.ExcelUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("SdSalesInventoryService")
public class SdSalesInventoryServiceImpl implements SdSalesInventoryService{
    @Resource
    SdSalesInventoryMapper sdSalesInventoryMapper ;

    @Override
    public String
    ExceltoSdSalesContractInventory(HttpServletRequest request, HttpServletResponse response ) throws Exception{
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartRequest.getFile("file");
            InputStream in = file.getInputStream();
            PrintWriter out = null;
            response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码
            out = response.getWriter();
        try{
            if (file.isEmpty()) {
                throw new Exception("文件不存在！");

            }
//            List<SdSalesInventory> SdSalesInventory = new ArrayList<>();
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

//                System.err.println("list===>"+ob);
//                SdSalesInventory sdSalesInventory = new SdSalesInventory();
//                if(ob.get(0)==null){
////                    sdSalesInventory.setSerialnum(null);
//                }else{sdSalesInventory.setSerialnum(String.valueOf(ob.get(0)));};
//
//                if(ob.get(1)==null){
////                    sdSalesInventory.setCode(null);
//                }else{sdSalesInventory.setCode(String.valueOf(ob.get(1)));};
//
//                if(ob.get(2)==null){
////                    sdSalesInventory.setName(null);
//                }else{sdSalesInventory.setName(String.valueOf(ob.get(2)));};
//
//                if(ob.get(3)==null){
////                    sdSalesInventory.setModel(null);
//                }else{sdSalesInventory.setModel(String.valueOf(ob.get(3)));};
//
//                if(ob.get(4)==null){
////                    sdSalesInventory.setParameter(null);
//                } else{sdSalesInventory.setParameter(String.valueOf(ob.get(4)));};
//
//                if(ob.get(5)==null){
////                    sdSalesInventory.setTrademark(null);
//                } else{sdSalesInventory.setTrademark(String.valueOf(ob.get(5)));};
//
//                if(ob.get(6)==null){
////                    sdSalesInventory.setUnit(null);
//                } else{sdSalesInventory.setUnit(String.valueOf(ob.get(6)));};
//
//                if(ob.get(7)==null){
////                    sdSalesInventory.setNum(0);
//                } else{sdSalesInventory.setNum(Integer.valueOf((String)ob.get(7)));};
//
//                if(ob.get(8)==null){
////                    sdSalesInventory.setUnitCost(0);
//                } else{sdSalesInventory.setUnitCost(Double.valueOf((String)ob.get(8)));};
//
//                if(ob.get(9)==null){
////                    sdSalesInventory.setSubtotal(0);
//                } else{sdSalesInventory.setSubtotal(Double.valueOf((String)ob.get(9)));};
//
//                if(ob.get(10)==null){
////                    sdSalesInventory.setRemarks(null);
//                } else{sdSalesInventory.setRemarks(String.valueOf(ob.get(10)));};
//
//                SdSalesInventory.add(sdSalesInventory);
            }
                  in.close();

            if(list.isEmpty()||list.size()<=0){
//                Map<String,String> map=new HashMap<>();

                out.print("上传失败。请校对合适的表格！");
            }
            out.print(JSONObject.toJSONString(list,
                    SerializerFeature.DisableCircularReferenceDetect,
                    SerializerFeature.WriteNullStringAsEmpty));

        } catch (Exception e) {
            out.print("上传失败。请校对合适的表格！");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }finally {
            out.flush();
            out.close();
        }
        return "yes" ;

    }

    @Override
    public SdSalesInventory getInventorybyId(@Param("id") int id) {
        return sdSalesInventoryMapper.getInstancebyid(id);
    }


}
