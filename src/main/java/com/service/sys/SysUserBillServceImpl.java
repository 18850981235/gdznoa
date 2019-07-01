package com.service.sys;

import com.beans.Requestsp;
import com.beans.SysUserBill;
import com.dao.sys.SysUserBillMapper;
import com.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("SysUserBillServce")
@Transactional
public class SysUserBillServceImpl implements SysUserBillServce {
    @Resource
  private SysUserBillMapper sysUserBillMapper;


    @Override
    public Map<String, Object> querybillbyuserid(@Param("userId") int userId, @Param("pageIndex") int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(sysUserBillMapper.queryCountByUserid(userId));
            page.setCurrentPageNo(pageIndex);
            List<SysUserBill> list=sysUserBillMapper.queryBiiByUserId(userId,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("SysUserBill",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;

    }

    @Override
    public SysUserBill querybillbyid(@Param("id") int id) {
        return sysUserBillMapper.queryBillById(id);
    }
}
