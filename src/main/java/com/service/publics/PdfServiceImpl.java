package com.service.publics;

import com.beans.Pdf;
import com.dao.publics.PdfMapper;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/5/9 10:12
 */
@Transactional
@Service("pdfService")
public class PdfServiceImpl implements PdfService{
    @Resource()
    private PdfMapper PdfMapper;

    @Override
    public int add(String userName,String name) {
        try {
            Pdf pdf=new Pdf();
            pdf.setName(name);
            pdf.setUsername(userName);
            pdf.setCreatetime(new Date());
            return  PdfMapper.add(pdf);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Map<String,Object> getlist(String name,int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();
        List<Pdf> list=null;
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(PdfMapper.getCount(name));
            page.setCurrentPageNo(pageIndex);
            list = PdfMapper.getlist(name, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
            map.put("page", page);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }


}