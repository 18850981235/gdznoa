package com.service;

import com.beans.SysAuthority;
import com.dao.AuthorityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/2/19 14:59
 */
@Transactional
@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService {

    @Resource()
    private AuthorityMapper authorityMapper;

    @Override
    public boolean add(int[] arr, int userid) {
        try {
            for (int i = 0; i < arr.length; i++) {
                authorityMapper.add(userid, arr[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAuthority(int userid, int[] arr) {
        try {
            authorityMapper.deleteByUserId(userid);
            for (int i = 0; i < arr.length; i++) {
                authorityMapper.add(userid, arr[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }

    @Override
    public List<SysAuthority> getMenuIdByUserId(int userid) {
        return authorityMapper.getMenuIdByUserId(userid);
    }


}