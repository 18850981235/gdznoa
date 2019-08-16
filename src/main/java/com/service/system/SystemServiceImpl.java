package com.service.system;

import com.beans.SupplierTrademark;
import com.beans.system;
import com.dao.sup.SupplierTrademarkMapper;
import com.dao.system.systemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("systemService")
public class SystemServiceImpl implements systemService {
    @Resource
    private systemMapper systemMapper;
    @Resource
    private SupplierTrademarkMapper supplierTrademarkMapper;


    @Override
    public int addsystem(system system) {
        return systemMapper.addsystem(system);
    }

    @Override
    public int updatesystrm(system system) {
        return systemMapper.updatesystrm(system);
    }

    @Override
    public system querybyid(int id) {
        return systemMapper.querybyid(id);
    }

    @Override
    public List<system> querybyfid(int fid) {
        return systemMapper.querybyfid(fid);
    }





    @Override
    public List<system> allsystem() {
        return systemMapper.query();
    }

    ;
}
