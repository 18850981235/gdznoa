package com.service.ga;

import com.alibaba.fastjson.JSONObject;
import com.beans.GaPayment;
import com.beans.GaSalary;
import com.dao.ga.GaPaymentMapper;
import com.dao.ga.GaSalaryMapper;
import com.util.FileUtils;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/8/14 17:49
 */
@Transactional
@Service("gaSalaryService")
public class GaSalaryServiceImpl implements GaSalaryService {
    @Resource
    private GaSalaryMapper gaSalaryMapper;
    @Resource
    private GaPaymentService gaPaymentService;
    @Resource
    private GaPaymentMapper gaPaymentMapper;

    @Override
    public int add(String json, HttpServletRequest request) {
        Map<String,Object> map=(Map<String,Object>)JSONObject.parse(json);
        GaPayment gaPayment=JSONObject.parseObject(map.get("payment").toString(),GaPayment.class);
        List<GaSalary> list= JSONObject.parseArray(map.get("list").toString(),GaSalary.class);
        int id= gaPaymentService.add(gaPayment,request);
        try {
            for (GaSalary gaSalary : list) {
                gaSalary.setProjectid(id);
                gaSalaryMapper.add(gaSalary);
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        return 1;
    }


    @Override
    public int update(GaSalary gaSalary) {
        return gaSalaryMapper.updateById(gaSalary);
    }

    @Override
    public Map<String, Object> getlist(int projectid, int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setTotalCount(gaSalaryMapper.getCount(projectid));
            page.setPageSize(10);
            page.setCurrentPageNo(pageIndex);
            List<GaSalary> list = gaSalaryMapper.getList(projectid ,(page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
            map.put("page", page);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map<String, Object> getById(int id) {
        Map<String, Object> map = new HashMap<>();
        try {
            GaPayment payment =gaPaymentMapper.getListById(id);
            List<GaSalary> list = gaSalaryMapper.getList(id ,0, 1000);
            map.put("payment", payment);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map<String, Object> getByIdParticular(int id) {
        Map<String, Object> map= gaPaymentService.getById(id);
        List<GaSalary> list = gaSalaryMapper.getList(id ,0, 1000);
        map.put("salaryList",list);
        return map;
    }


}