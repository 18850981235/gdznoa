package com.service.sup;

import com.beans.SupplierStaff;
import com.dao.sup.SupplierStaffMapper;
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
 * @create 2019/4/16
 */
@Transactional
@Service("SupplierStaffService")
public class SupplierStaffServiceImpl implements SupplierStaffService{
     @Resource
    private SupplierStaffMapper supplierStaffMapper;
    @Override
    public int addstaff(List<SupplierStaff> list, int supplierid) {
        int a=0;
      try {
          for (int i=0;i<list.size();i++){
              SupplierStaff supplierStaff=list .get(i);
             int sid=supplierid;
              supplierStaff.setSupplierid(sid);

              int s= supplierStaffMapper.addstaff(supplierStaff) ;
              if(s>0){
                  a++;
              }


            }
            if(a>=list.size()){
                return 1;
            }else {
                return 0;}
        }catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }

    }

    @Override
    public int deleteStaff(int id) {
        return supplierStaffMapper.deleteStaff(id);
    }

    @Override
    public int updateStaff(SupplierStaff supplierStaff) {
        return supplierStaffMapper.updateStaff(supplierStaff);
    }

    @Override
    public List<SupplierStaff> querybyid(int id) {
        return supplierStaffMapper.querybyid(id);
    }

    @Override
    public Map<String,Object> querybysome(String name, String supname, int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(supplierStaffMapper.querycount(name,supname));
            page.setCurrentPageNo(pageIndex);
            List<SupplierStaff> list=supplierStaffMapper.querybysome(name,supname,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }


}
