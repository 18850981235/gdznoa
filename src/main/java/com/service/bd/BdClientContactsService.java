package com.service.bd;

import com.beans.BdClientContacts;

import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/3/12 10:10
 */
public interface BdClientContactsService {
   public int add(BdClientContacts clientContacts);
   public Map<String,Object> getList(String name, String clientname,
                                     int pageIndex);
   public BdClientContacts getListById(int id);
   public int update(BdClientContacts clientContacts);
}

