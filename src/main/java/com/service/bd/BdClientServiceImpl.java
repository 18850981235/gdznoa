package com.service.bd;

import com.beans.BdClient;
import com.dao.bd.BdClientContactsMapper;
import com.dao.bd.BdClientMapper;
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
 * @create 2019/3/4 14:46
 */
@Transactional
@Service("bdClientService")
public class BdClientServiceImpl implements BdClientService {

    @Resource()
    private BdClientMapper bdClientMapper;

    @Resource
    private BdClientContactsMapper bdClientContactsMapper;


    /**
     * 按名称,地点,类型,创建人员查询客户信息
     * @param name  客户名称
     * @param address  客户地点
     * @param unitType  客户类型
     * @param userid 创建者
     * @param pageIndex 当前页数
     * @return 客户集合and分页类
     */
    @Override
    public Map<String, Object> getList(String name, String address,
                                       String unitType, int userid,
                                       int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(bdClientMapper.getCount(name, address , unitType, userid));
            page.setCurrentPageNo(pageIndex);
            List<BdClient> list=bdClientMapper.getClientList(name, address,
                    unitType, userid,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    /**
     * 查询客户地址 去除重复的
     * @return 地址集合
     */
    @Override
    public List<String> getAddres() {
        return bdClientMapper.getAddress();
    }

    /**
     * 添加客户信息
     * @param client  客户类
     * @return 是否添加成功
     */
    @Override
    public int add( BdClient client) {
        return bdClientMapper.add(client);
    }

    /**
     * 按id修改客户信息
     * @param client  客户类
     * @return 是否修改成功
     */
    @Override
    public int update(BdClient client) {
        return bdClientMapper.updateById(client);
    }

    /**
     * 按id查询客户信息
     * @param id  客户id
     * @return 客户类
     */
    @Override
    public BdClient getClientById(int id) {
        return bdClientMapper.getClientById(id);
    }

    /**
     * 按id删除客户信息
     * @param id  客户id
     * @return 是否删除成功
     */
    @Override
    public int deleteById(int id) {
        int num=bdClientContactsMapper.getContactsByClientidCount(id);
        try {
            if (num>0){
                bdClientContactsMapper.deleteByClientid(id);
            }
            return bdClientMapper.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }

    }

    /**
     * 查询所有的客户名称
     * @return 客户名称集合
     */
    @Override
    public List<BdClient> getClientName() {
        return bdClientMapper.getClientName();
    }
}