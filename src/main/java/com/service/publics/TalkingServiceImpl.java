package com.service.publics;

import com.beans.PubTalking;
import com.beans.SysUserBill;
import com.dao.publics.TalkingMapper;
import com.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("TalkingService")
public class TalkingServiceImpl implements TalkingService {
    @Resource
    private TalkingMapper talkingMapper;

    @Override
    public   Map<String, Object> getTalkingByUserId(int userId,int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(talkingMapper.getcountByUserId(userId));
            page.setCurrentPageNo(pageIndex);
            List<PubTalking> list = talkingMapper.getTalkingByUserId(userId, (page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page", page);
            map.put("PubTalking", list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    public  int addTalk(PubTalking pubTalking){
        return talkingMapper.addTalking(pubTalking);
    };

    public  Map<String, Object> queryoriginator(@Param("userId")int userId){
        Map<String, Object> map = new HashMap<>();
        try {
            List<PubTalking> list= talkingMapper.queryoriginator(userId);
            int i=talkingMapper.querynnewcontent(userId);
            map.put("userList",list);
            map.put("count",i);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    public List<PubTalking> getNewContent(@Param("userId") int userId){
        return talkingMapper.getNewContent(userId);

    };


    public int addAdminTalk(PubTalking pubTalking){
        try{
            talkingMapper.addTalking(pubTalking);
            talkingMapper.updateState(pubTalking.getReceive(),pubTalking.getOriginator());
            return 1;
        }catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    };
}
