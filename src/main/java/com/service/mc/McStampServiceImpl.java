package com.service.mc;

import com.beans.*;
import com.dao.mc.McStampMapper;
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
 * @create 2019/3/18 11:23
 */
@Transactional
@Service("mcStampService")
public class McStampServiceImpl implements McStampService {
    @Resource
    private McStampMapper mcStampMapper;
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;


    /**
     * 添加盖章审批详情 修改盖章下一个审批人审批状态
     * @param detailed  审批详情实体类
     * @return 是否添加成功
     */
    @Override
    public int addProjectApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("商务盖章");
        try {
            approvalDetailedMapper.add(detailed);
            McStamp stamp_update = new McStamp();
            if (detailed.getState() == "通过") {
                String state = "进行中";
                int processUserid = 0;
                McStamp stamp = mcStampMapper.getListById(detailed.getApprovalId());
                String users = stamp.getProcess().getUsersid();
                String[] userArr = users.split(",");
                for (int i = 0; i < userArr.length; i++) {
                    if (userArr[i].equals(String.valueOf(stamp.getProcessUserid()))) {
                        if (i != userArr.length - 1) {
                            processUserid = Integer.parseInt(userArr[i + 1]);
                        } else {
                            state = "已结束";
                        }
                    }
                }
                stamp_update.setProcessUserid(processUserid);
                stamp_update.setUpdatetime(new Date());
                stamp_update.setProcessState(state);
                stamp_update.setId(detailed.getApprovalId());
            } else {
                stamp_update.setUpdatetime(new Date());
                stamp_update.setProcessState(detailed.getState());
                stamp_update.setId(detailed.getApprovalId());
            }
            return mcStampMapper.updateById(stamp_update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    /**
     * 添加盖章申请
     * @param  stamp 盖章实体类
     * @return 是否添加成功
     */
    @Override
    public int add(McStamp stamp, HttpServletRequest request) {
        int num = 0;
        try {

            SysApprovalProcess process = approvalProcessMapper.getProcessById(12);
            String accessory= FileUtils.uploadFile(request,"file");
            if (accessory!=null&&!accessory.equals("")){
                stamp.setAccessory(accessory);
            }
            String[] arr = process.getUsersid().split(",");
            stamp.setProcessid(12);
            stamp.setProcessUserid(Integer.parseInt(arr[0]));
            num = mcStampMapper.add(stamp);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    }

    @Override
    public Map<String, Object> getList(String stampType, int deptid, int userid, Date start, Date end,int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(mcStampMapper.getCount(stampType,deptid,userid,start,end));
            page.setCurrentPageNo(pageIndex);
            List<McStamp> list=mcStampMapper.getList(stampType,deptid,userid,start,end,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public int update(McStamp stamp) {
        return mcStampMapper.updateById(stamp);
    }

    @Override
    public McStamp getListById(int id) {
        return mcStampMapper.getListById(id);
    }

    @Override
    public Map<String, Object> getParticular1ById(int id) {
        Map<String, Object> map = new HashMap<>();
        try {
            McStamp mcStamp = mcStampMapper.getListById(id);
            List<SysApprovalDetailed> list = approvalDetailedMapper.getListByapprovalId(id, "商务盖章");
            map.put("mcStamp",mcStamp);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }
}