package com.service.sys;

import com.beans.SysCompany;
import com.dao.sys.CompanyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/2/26 10:40
 */
@Transactional
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
    @Resource()
    private CompanyMapper companyMapper;
    /**
     * 查询公司集合 id为0时返回全部
     * @param id 公司id
     * @return 公司集合
     */
    @Override
    public List<SysCompany> getCompanyList(int id){
        return companyMapper.getList(id);
    }
    /**
     * 添加公司
     * @param name 公司名字
     * @return 是否添加成功
     */
    @Override
    public int add(String name){
        return companyMapper.add(name);
    }

    /**
     * 删除公司
     * @param id 公司id
     * @return 是否删除成功
     */
    @Override
    public int deleteById(int id){
        return companyMapper.deleteById(id);
    }
    /**
     * 修改公司名字
     * @param id 公司id
     * @param name 公司名字
     * @return 是否修改成功
     */
    @Override
    public int updateById(int id,String name) {
        return companyMapper.updateById(id,name);
    }
}