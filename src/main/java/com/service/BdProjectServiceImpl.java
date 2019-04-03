package com.service;

import com.beans.*;
import com.dao.ApprovalDetailedMapper;
import com.dao.ApprovalProcessMapper;
import com.dao.BdProjectMapper;
import com.dao.UserMapper;
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
 * @create 2019/3/12 10:42
 */
@Transactional()
@Service("bdProjectService")
public class BdProjectServiceImpl implements BdProjectService {
    @Resource
    private BdProjectMapper bdProjectMapper;
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;
    @Resource
    private UserMapper userMapper;


    /**
     * 新增项目立项
     * @param project 项目立项类
     * @return 是否添加成功
     */
    @Override
    public int add(BdProject project, HttpServletRequest request) {
        int num = 0;
        try {
            SysApprovalProcess process = approvalProcessMapper.getProcessById(1);
            String accessory= FileUtils.uploadFile(request,"file");
            if (accessory!=null&&!accessory.equals("")){
                project.setAccessory(accessory);
            }
            String[] arr = process.getUsersid().split(",");
            int processid=(int) request.getSession().getAttribute("userId");
            project.setProcessid(processid);
            project.setProcessUserid(Integer.parseInt(arr[0]));
            project.setProcessState("进行中");
            num = bdProjectMapper.add(project);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    }

    /**
     * 项目立项审批
     * @param detailed 审批详情实体类
     * @return 是否添加成功
     */
    @Override
    public int addProjectApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("项目立项");
        try {
            approvalDetailedMapper.add(detailed);
            BdProject project_update = new BdProject();
            if (detailed.getState() == "通过") {
                String state = "进行中";
                int processUserid = 0;
                BdProject project = bdProjectMapper.getListById(detailed.getApprovalId());
                String users = project.getProcess().getUsersid();
                String[] userArr = users.split(",");
                for (int i = 0; i < userArr.length; i++) {
                    if (userArr[i].equals(String.valueOf(project.getProcessUserid()))) {
                        if (i != userArr.length - 1) {
                            processUserid = Integer.parseInt(userArr[i + 1]);
                        } else {
                            state = "已结束";
                        }
                    }
                }
                project_update.setProcessUserid(processUserid);
                project_update.setUpdatetime(new Date());
                project_update.setProcessState(state);
                project_update.setId(detailed.getApprovalId());
            } else {
                project_update.setUpdatetime(new Date());
                project_update.setProcessState(detailed.getState());
                project_update.setId(detailed.getApprovalId());
            }
            return bdProjectMapper.updateById(project_update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }


    /**
     * 按用户id,名字,类型,编号,状态,开始时间,结束时间查询立项信息
     * @param userid 用户id
     * @param name  立项名称
     * @param type  立项类型
     * @param code  立项编号
     * @param status 立项状态
     * @param start 开始时间
     * @param end 结束时间
     * @return 立项集合and分页类
     */
    @Override
    public Map<String, Object> getlist(int userid, String name, String type,
                                       String code, String status,
                                       Date start, Date end, int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(bdProjectMapper.getCount(userid, name, type, code, status, start, end));
            page.setCurrentPageNo(pageIndex);
            List<BdProject> list = bdProjectMapper.getList(userid, name, type, code, status, start, end, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
            map.put("page", page);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    /**
     * 按立项id查询立项信息
     * @param id 立项id
     * @return 立项类,审批详情,参与人员
     */
    @Override
    public Map<String, Object> getProjectById(int id) {
        Map<String, Object> map = new HashMap<>();
        try {
            BdProject project = bdProjectMapper.getListById(id);
            List<SysApprovalDetailed> list = approvalDetailedMapper.getListByapprovalId(id, "项目立项");
            List<SysUser> users=userMapper.getUserByIn(project.getExamine());
            map.put("project",project);
            map.put("list",list);
            map.put("users",users);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    /**
     * 按立项id修改立项信息
     * @param project 立项类
     * @return 是否修改成功
     */
    @Override
    public int update(BdProject project) {
        return bdProjectMapper.updateById(project);
    }

}