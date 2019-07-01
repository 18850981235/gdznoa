package com.service.sup;

import com.beans.SupplierTrademark;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @author 许思明
 * @create 2019/4/15
 */
public interface SupplierTrademarkService {
    //添加品牌信息
    int  addSupplierTrademark(SupplierTrademark supplierTrademark);
    //删除品牌信息
    int deleteTrademark(@Param("id") int id);
    //更改品牌信息
    int updateTrademark(SupplierTrademark supplierTrademark);
    //查询品牌信息
    Map<String ,Object> querybysom(@Param("name") String name, @Param("product") String product, @Param("enterpriseName") String enterpriseName,@Param("PageIndex") int PageIndex);
    //根据ID查询信息详情
   SupplierTrademark querybyid(@Param("id") int id);

    List<SupplierTrademark> allSupplierTrademark();
}
