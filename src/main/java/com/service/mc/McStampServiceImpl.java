package com.service.mc;

import com.beans.McStamp;
import com.beans.SysApprovalDetailed;
import com.beans.SysApprovalProcess;
import com.dao.mc.McStampMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
import com.dao.sys.UserMapper;
import com.util.FileUtils;
import com.util.Page;
import org.apache.ibatis.annotations.Param;
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
    @Resource
    private UserMapper userMapper;


    /**
     * 添加盖章审批详情 修改盖章下一个审批人审批状态
     *
     * @param detailed 审批详情实体类
     * @return 是否添加成功
     */
    @Override
    public int addProjectApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("商务盖章");
        try {
            approvalDetailedMapper.add(detailed);
            McStamp stamp_update = new McStamp();
            int processUserid = 0;
            McStamp stamp = mcStampMapper.getListById(detailed.getApprovalId());
            String state = "审批中";
            String users = stamp.getProcess().getUsersid();
            String[] userArr = users.split(",");
            if (detailed.getState().equals("同意")) {
                boolean flag=true;
                for (int i = 0; i < userArr.length; i++) {
                    if (userArr[i].equals(String.valueOf(stamp.getProcessUserid()))) {
                        flag=false;
                        if(userArr[1].equals(String.valueOf(stamp.getProcessUserid()))){
                            if(stamp.getDept().getName().contains("公司")){
                                processUserid = userMapper.DeptroleUser(stamp.getDeptid()).get(0).getId();
                                break;
                            }else {
                            }
                        }
                        if (i != userArr.length - 1) {
                            processUserid = Integer.parseInt(userArr[i + 1]);
                        } else {
                            state = "审批结束";
                        }
                    }
                }
                if(flag){
                    processUserid = Integer.parseInt(userArr[3]);
                }
                stamp_update.setProcessUserid(processUserid);
                stamp_update.setProcessState(state);
                stamp_update.setId(detailed.getApprovalId());
            } else {
                boolean flag=true;
                for (int i = 0; i < userArr.length; i++) {
                    if (userArr[i].equals(String.valueOf(stamp.getProcessUserid()))) {
                        flag=false;
                        if(userArr[3].equals(String.valueOf(stamp.getProcessUserid()))){
                            if(stamp.getDept().getName().contains("公司")){
                                processUserid = userMapper.DeptroleUser(stamp.getDeptid()).get(0).getId();
                                break;
                            }else {

                            }
                        }
                        if (i != 0) {
                            processUserid = Integer.parseInt(userArr[i -1 ]);
                        }
                    }
                }
                if(flag){
                    processUserid = Integer.parseInt(userArr[1]);
                }
                stamp_update.setProcessUserid(processUserid);
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
     *
     * @param stamp 盖章实体类
     * @return 是否添加成功
     */
    @Override
    public int add(McStamp stamp, HttpServletRequest request) {
        int num = 0;
        try {

            SysApprovalProcess process = approvalProcessMapper.getProcessById(12);

            String accessory = FileUtils.uploadFile(request, "file");
            if (accessory != null && !accessory.equals("")) {
                stamp.setAccessory(accessory);
            }
            String[] arr = process.getUsersid().split(",");
            stamp.setProcessid(12);
            stamp.setProcessUserid(Integer.parseInt(arr[0]));
            stamp.setProcessState("未审批");
            num = mcStampMapper.add(stamp);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    }

    @Override
    public Map<String, Object> getList(String projectName,int userid, String stampType,
                                       int deptid, String content,
                                       String purpose, Date start,
                                       Date end,int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();
        List<McStamp> list=null;
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            if(projectName==null){
                page.setTotalCount(mcStampMapper.getCount(userid,stampType, deptid, content,purpose, start, end));
                page.setCurrentPageNo(pageIndex);
                list = mcStampMapper.getList(userid,stampType, deptid, content,purpose, start, end, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
            }else{
                page.setTotalCount(mcStampMapper.getCountProject(projectName,userid,stampType, deptid, content,purpose, start, end));
                page.setCurrentPageNo(pageIndex);
                list = mcStampMapper.getListProject(projectName,userid,stampType, deptid, content,purpose, start, end, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
            }
            map.put("page", page);
            map.put("list", list);
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
            map.put("mcStamp", mcStamp);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }


    public int delete(@Param("id") int id){
        return mcStampMapper.deleteById(id);
    };
}