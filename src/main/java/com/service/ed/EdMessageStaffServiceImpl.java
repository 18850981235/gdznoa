package com.service.ed;

import com.beans.EdMessage;
import com.beans.EdMessageStaff;
import com.dao.ed.EdMessageStaffMapper;
import com.util.FileUtils;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service("MessageStaffService")
public class EdMessageStaffServiceImpl  implements  EdMessageStaffService{
    @Resource
   private EdMessageStaffMapper messageStaffMapper;

    @Override
    public int addMessageStaff(EdMessageStaff messageStaff, HttpServletRequest request) {
        String idfile= FileUtils.uploadFile(request,"id_file");
        if (idfile!=null&&!idfile.equals("")){
            messageStaff.setIdfile(idfile);
        }
        String buyfile= FileUtils.uploadFile(request,"buy_file");
        if (buyfile!=null&&!buyfile.equals("")){
            messageStaff.setBuyfile(buyfile);
        }
        String securityfile= FileUtils.uploadFile(request,"security_file");
        if (securityfile!=null&&!securityfile.equals("")){
            messageStaff.setSecurityfile(securityfile);
        }
        String contractsfile= FileUtils.uploadFile(request,"contracts_file");
        if (contractsfile!=null&&!contractsfile.equals("")){
            messageStaff.setContractsfile(contractsfile);
        }

        return messageStaffMapper.addMessagestaffMapper(messageStaff);
    }

    @Override
    public int updateMessageStaff(EdMessageStaff messageStaff, HttpServletRequest request) {
        String idfile= FileUtils.uploadFile(request,"id_file");
        if (idfile!=null&&!idfile.equals("")){
            messageStaff.setIdfile(idfile);
        }
        String buyfile= FileUtils.uploadFile(request,"buy_file");
        if (buyfile!=null&&!buyfile.equals("")){
            messageStaff.setBuyfile(buyfile);
        }
        String securityfile= FileUtils.uploadFile(request,"security_file");
        if (securityfile!=null&&!securityfile.equals("")){
            messageStaff.setSecurityfile(securityfile);
        }
        String contractsfile= FileUtils.uploadFile(request,"contracts_file");
        if (contractsfile!=null&&!contractsfile.equals("")){
            messageStaff.setContractsfile(contractsfile);
        }
        return messageStaffMapper.updateMessagestaffMapper(messageStaff);
    }

    @Override
    public int deleteMessageStaff(int id) {
        return messageStaffMapper.deleteMassageStaff(id);
    }

    @Override
    public EdMessageStaff queryOneById(int id) {
        return messageStaffMapper.queryAllById(id);
    }

    @Override
    public Map<String, Object>  queryBySome(int projectid, String name, int userid, String identityCard, String staffRole, int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();

        if (pageIndex == 0) {
            pageIndex = 1;
        }
        page.setPageSize(10);
        page.setTotalCount(messageStaffMapper.querycountBySome(projectid, name, userid, identityCard, staffRole));
        page.setCurrentPageNo(pageIndex);
        List<EdMessageStaff> List = messageStaffMapper .queryAllBySome(projectid, name, userid, identityCard, staffRole, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
        map.put("page",page);
        map.put("list",List);
        return map;
    }
}
