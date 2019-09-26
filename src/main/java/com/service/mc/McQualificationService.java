package com.service.mc;

import com.beans.McQualificationCertificate;
import com.beans.SysApprovalDetailed;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/*
许思明
2019/04/11
 */
public interface McQualificationService {
    //增加资质证书
     int addQualificationCertificate(McQualificationCertificate mcQualificationCertificate, HttpServletRequest reques) ;
     //修改资质证书
    int updateMcQualification(McQualificationCertificate mcQualificationCertificate);
    //根据ID查询证书
    List<McQualificationCertificate> querybyid(@Param("id") int id);
    //查询详情资质证书
    Map<String,Object> querydetailbyid(@Param("id") int id);
    //根据条件查询
    Map<String ,Object> querybytypename(@Param("name") String name, @Param("type") String type,@Param("content") String content, @Param("borrow") String borrow,@Param("state") String state, @Param("staretime") String staretime,@Param("endtime") String endtime,  int pageIndex);
    //删除资质证书
    int delete(@Param("id") int id);

    int addProjectApproval(SysApprovalDetailed detailed);

    List<McQualificationCertificate> queryAll();

    void PDfOut(HttpServletResponse response,HttpServletRequest request, String showFileName,String WaterName);

}
