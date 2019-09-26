package com.dao.ga;

import com.beans.GaOuterTubePass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/8/5 14:49
 */
@Mapper
public interface GaOuterTubePassMapper {
    int add(GaOuterTubePass gaOuterTubePass);
    int updateById(GaOuterTubePass gaOuterTubePass);
    int deleteById(Integer id);
    List<GaOuterTubePass> selectByProjectid(int projectid);
    GaOuterTubePass getListById(int id);
}

