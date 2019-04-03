package com.service;

import com.beans.BdClient;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/3/4 14:30
 */
public interface BdClientService {

    public Map<String,Object> getList(String name, String address,
                                      String unitType, int userid,
                                      int pageIndex);
    public List<String> getAddres();

    public int add(BdClient client);

    public int update(BdClient client);

    public BdClient getClientById(int id);

    public int deleteById(int id);

    public  List<BdClient> getClientName();
}
