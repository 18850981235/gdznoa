package com.service.system;

import com.beans.system;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface systemService {
    int  addsystem(system system);
    int  updatesystrm(system system);
    system querybyid(@Param("id")int id);

    List<system> querybyfid(@Param("fid")int fid);



    List<system> allsystem();

}
