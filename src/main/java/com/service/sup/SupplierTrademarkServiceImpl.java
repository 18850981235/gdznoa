package com.service.sup;

import com.beans.SupplierTrademark;
import com.dao.sup.MiddleMapper;
import com.dao.sup.SupplierTrademarkMapper;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author 许思明
 * @create 2019/4/15
 */
@Transactional
@Service("supplierTrademarkService")
public class SupplierTrademarkServiceImpl implements SupplierTrademarkService {

    @Resource
    private SupplierTrademarkMapper supplierTrademarkMapper;
    @Resource
    private MiddleMapper middleMapper;
    //添加品牌信息
    @Override
    public int addSupplierTrademark(SupplierTrademark supplierTrademark) {
        return supplierTrademarkMapper.addSrademark(supplierTrademark);
    }
    //删除品牌信息
    @Override
    public int deleteTrademark(int id) {
            int  a =middleMapper.queryCountbyStaff(id);
            if (a>0){
                return 0;
            }else{
                 return supplierTrademarkMapper.deleteSrademark(id);
            }

    }
    //更改品牌信息
    @Override
    public int updateTrademark(SupplierTrademark supplierTrademark) {
        return supplierTrademarkMapper.updateSrademark(supplierTrademark);
    }
    //条件查询品牌信息
    @Override
    public Map<String, Object> querybysom(String name, String product, String enterpriseName, int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(supplierTrademarkMapper.querycount(name,product,enterpriseName));
            page.setCurrentPageNo(pageIndex);
            List<SupplierTrademark> list= supplierTrademarkMapper.querybysome(name,product,enterpriseName,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }
    //根据ID查询详情
    @Override
    public SupplierTrademark querybyid(int id) {
        return supplierTrademarkMapper.querybyid(id);
    }

    @Override
    public List<SupplierTrademark> allSupplierTrademark() {
        return supplierTrademarkMapper.allSupplierTrademark();
    }
}
