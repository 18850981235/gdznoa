package com.service;

import com.beans.BdClientContacts;
import com.dao.BdClientContactsMapper;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/3/12 10:11
 */
@Transactional
@Service("bdClientContactsService")
public class BdClientContactsServiceImpl implements BdClientContactsService {
    @Resource
    private BdClientContactsMapper bdClientContactsMapper;

    @Override
    public int add(BdClientContacts clientContacts) {
        return bdClientContactsMapper.add(clientContacts);
    }

    @Override
    public Map<String, Object> getList(String name, String clientname, int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(2);
            page.setTotalCount(bdClientContactsMapper.getCount(name,clientname));
            page.setCurrentPageNo(pageIndex);
            List<BdClientContacts> list=bdClientContactsMapper.getContactsList(name,clientname,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public BdClientContacts getListById(int id) {
        return bdClientContactsMapper.getContactsById(id);
    }

    @Override
    public int update(BdClientContacts clientContacts) {
        return bdClientContactsMapper.updateById(clientContacts);
    }
}