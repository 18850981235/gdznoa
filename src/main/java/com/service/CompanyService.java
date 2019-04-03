package com.service;

import com.beans.SysCompany;

import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/2/26 10:39
 */
public interface CompanyService {

    List<SysCompany> getCompanyList(int id);
    int add(String name);
    int deleteById(int id);
    int updateById(int id, String name);
}
