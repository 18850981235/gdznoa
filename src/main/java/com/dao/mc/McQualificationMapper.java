package com.dao.mc;

import com.beans.McQualificationCertificate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/*
许思明
2019/04/11
 */
@Mapper
public interface McQualificationMapper {
    //增加证书资质
    int addMcQualification(McQualificationCertificate mcQualificationCertificate);
    //修改资质证书
    int  updateMcQualification(McQualificationCertificate mcQualificationCertificate);
    //根据ID查询证书
    List<McQualificationCertificate> querybyid(@Param("id") int id);
    //根据条件查询
    List<McQualificationCertificate> querybytypename(@Param("name") String name, @Param("type") String type,@Param("content") String content, @Param("borrow") String borrow,@Param("state") String state, @Param("staretime") String staretime,@Param("endtime") String endtime ,@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
    int querycount(@Param("name") String name, @Param("type") String type,@Param("content") String content, @Param("borrow") String borrow,@Param("state") String state, @Param("staretime") String staretime,@Param("endtime") String endtime);
    //删除资质证书
    int delete( @Param("id") int id);

    List<McQualificationCertificate> queryall(@Param("projectName")String projectName);
}
