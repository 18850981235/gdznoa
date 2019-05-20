package com.service.mc;

import com.beans.McDatumCost;
import com.beans.SysApprovalDetailed;
import com.beans.SysApprovalProcess;
import com.dao.mc.McDatumCostMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
import com.util.FileUtils;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/4/11 14:32
 */
@Transactional
@Service("mcDatumCostService")
public class McDatumCostServiceImpl implements McDatumCostService {
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;
    @Resource
    private McDatumCostMapper mcDatumCostMapper;


    @Override
    public int addProjectApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("商务资料费申请");
        try {
            approvalDetailedMapper.add(detailed);
            McDatumCost fb_update = new McDatumCost();
            if (detailed.getState().equals("通过")) {
                String state = "进行中";
                int processUserid = 0;
                McDatumCost fb=  mcDatumCostMapper.getListById(detailed.getApprovalId());
                String users = fb.getProcess().getUsersid();
                String[] userArr = users.split(",");
                for (int i = 0; i < userArr.length; i++) {
                    if (userArr[i].equals(String.valueOf(fb.getProcessUserid()))) {
                        if (i != userArr.length - 1) {
                            processUserid = Integer.parseInt(userArr[i + 1]);
                        } else {
                            state = "已结束";
                        }
                    }
                }
                fb_update.setProcessUserid(processUserid);
                fb_update.setProcessState(state);
                fb_update.setId(detailed.getApprovalId());
            } else {
                fb_update.setProcessState(detailed.getState());
                fb_update.setId(detailed.getApprovalId());
            }
            return mcDatumCostMapper.updateById(fb_update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public int add(McDatumCost mcDatumCost , HttpServletRequest request)
    {
        int num = 0;
        try {
            SysApprovalProcess process = approvalProcessMapper.getProcessById(7);
            String accessory= FileUtils.uploadFile(request,"file");
            if (accessory!=null&&!accessory.equals("")){
                mcDatumCost.setAccessory(accessory);
            }
            String[] arr = process.getUsersid().split(",");
            mcDatumCost.setProcessid(6);
            mcDatumCost.setProcessUserid(Integer.parseInt(arr[0]));
            mcDatumCost.setProcessState("进行中");
            num = mcDatumCostMapper.add(mcDatumCost);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    }

    @Override
    public int update(McDatumCost mcDatumCost) {
        return mcDatumCostMapper.updateById(mcDatumCost);
    }

    @Override
    public Map<String, Object> getList(String name, int deptid, Date start, Date end, int usreid, int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(mcDatumCostMapper.getCount(name, deptid, start, end, usreid));
            page.setCurrentPageNo(pageIndex);
            List<McDatumCost> list=mcDatumCostMapper.getList(name, deptid, start, end, usreid,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public McDatumCost getListById(int id) {
       return mcDatumCostMapper.getListById(id);
    }

    @Override
    public Map<String, Object> getParticular1ById(int id) {
        Map<String, Object> map = new HashMap<>();
        try {
            McDatumCost datumCost = mcDatumCostMapper.getListById(id);
            List<SysApprovalDetailed> list = approvalDetailedMapper.getListByapprovalId(id, "商务资料费申请");
            map.put("datumCost",datumCost);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }
}