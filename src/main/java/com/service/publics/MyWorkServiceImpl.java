package com.service.publics;

import com.beans.MyWork;
import com.dao.publics.MyWorkMapper;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/4/11 10:13
 */
@Transactional
@Service("myWorkService")
public class MyWorkServiceImpl implements MyWorkService {
    @Resource()
    private MyWorkMapper myWorkMapper;



    /**
     * 用该用户id查询所要的审批工作
     * @param userid 用户id
     * @return 审批工作的集合
     */
    @Override
    public Map<String, Object> getList(int userid, int processid, int id, Date start, Date end, int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setCurrentPageNo(pageIndex);
            List<MyWork> list=myWorkMapper.getList(userid,processid, id,start,end,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            page.setTotalCount(myWorkMapper.getCount(userid,processid, id,start,end));
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

}