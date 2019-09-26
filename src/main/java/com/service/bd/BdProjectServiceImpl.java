package com.service.bd;

import com.beans.*;
import com.dao.bd.BdProjectMapper;
import com.dao.sd.SdSalesContractInventoryMapper;
import com.dao.sd.SdSalesContractMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
import com.dao.sys.UserMapper;
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
    private SdSalesContractMapper contractMapper;
    @Resource
    private SdSalesContractInventoryMapper inventoryMapper;


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
            project.setProcessid(1);
            String accessory = FileUtils.uploadFile(request, "file");

            if (accessory != null && !accessory.equals("")) {
                project.setAccessory(accessory);
            }
//            int userId = (int) request.getSession().getAttribute("userId");
           int  userId=1;
            project.setUserid(userId);
            project.setProcessUserid(project.getAreaManager());
            project.setProcessState("未审批");
            num = bdProjectMapper.add(project);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    }

    /**
     * 项目立项审批
     *
     * @param detailed 审批详情实体类
     * @return 是否添加成功
     */
    @Override
    public int


    addProjectApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("项目立项");
        try {
            approvalDetailedMapper.add(detailed);
            BdProject project_update = new BdProject();
            String state = "审批中";
            int processUserid = 0;
            BdProject project = bdProjectMapper.getListById(detailed.getApprovalId());
            if (detailed.getState().equals("同意")) {
                String users = project.getProcess().getUsersid();
                String[] userArr = users.split(",");
                boolean flag = true;
                for (int i = 0; i < userArr.length; i++) {
                    if (userArr[i].equals(String.valueOf(project.getProcessUserid()))) {
                        flag = false;
                        if (i != userArr.length - 1) {
                            processUserid = Integer.parseInt(userArr[i + 1]);
                        } else {
                            state = "审批结束";
                        }
                    }
                }
                if (flag) {
                    processUserid = Integer.parseInt(userArr[1]);
                }
                project_update.setProcessNode(project.getProcessNode()+1);
                project_update.setProcessUserid(processUserid);
                project_update.setProcessState(state);
                project_update.setId(detailed.getApprovalId());
            } else {
                String users = project.getProcess().getUsersid();
                String[] userArr = users.split(",");
                for (int i = 0; i < userArr.length; i++) {
                    if (userArr[i].equals(String.valueOf(project.getProcessUserid()))) {
                        if (userArr[1].equals(String.valueOf(project.getProcessUserid()))) {
                            processUserid = project.getAreaManager();
                            break;
                        }
                        if (i != 0) {
                            processUserid = Integer.parseInt(userArr[i - 1]);
                        }
                    }
                }
                project_update.setProcessNode(project.getProcessNode()-1);
                project_update.setProcessUserid(processUserid);
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
     *
     * @param userid 用户id
     * @param start  开始时间
     * @param end    结束时间
     * @return 立项集合and分页类
     */
    @Override
    public Map<String, Object> getlist(int userid, String projectName, int deptid,
                                       String stage, int areaManager,
                                       String principalName,Date start,
                                       Date end, int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setTotalCount(bdProjectMapper.getCount(userid, projectName, deptid, stage, areaManager,principalName, start, end));
            page.setPageSize(10);
            page.setCurrentPageNo(pageIndex);
            List<BdProject> list = bdProjectMapper.getList(userid, projectName, deptid, stage, areaManager,principalName, start, end, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
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
     *
     * @param id 立项id
     * @return 立项类, 审批详情, 参与人员
     */
    @Override
    public Map<String, Object> getProjectById(int id) {
        Map<String, Object> map = new HashMap<>();
        try {
            BdProject project = bdProjectMapper.getListById(id);
            List<SysApprovalDetailed> list = approvalDetailedMapper.getListByapprovalId(id, "项目立项");
            map.put("project", project);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    /**
     * 按立项id修改立项信息
     *
     * @param project 立项类
     * @return 是否修改成功
     */
    @Override
    public int update(BdProject project) {
        return bdProjectMapper.updateById(project);
    }

    @Override
    public List<BdProject> getProjectName() {
        return bdProjectMapper.getProjectName();
    }

    @Override
    public List<BdProject> getallPeoject() {
        return bdProjectMapper.getallProject();
    }
    @Override
    public int  deleteProject(int id) {
        return bdProjectMapper.deleteById(id);
    }
    @Override
    public List<BdProject> getGCProject(int id) {
        String usersId = approvalProcessMapper.getProcessById(1).getUsersid();
        String[] arr = usersId.split(",");
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == String.valueOf(id)) {
                flag = true;
                break;
            }
        }
        List<BdProject> list=null;
        if (flag){
            list=bdProjectMapper.getProjectName();
        }else{
            list=bdProjectMapper.getByuseridAndAreaManager(id);
        }
        return list;
    }

    @Override
    public Map<String, Object> queryAllSome(int id) {
        Map<String, Object> map = new HashMap<>();
        try {
            BdProject project = bdProjectMapper.getListById(id);
            map.put("project", project);

            List<SdSalesContract>  list= contractMapper.querybyProjectId(id);
            map.put("list", list);
            List<SdSalesContractInventory> newlist= inventoryMapper.query(id, 0,"新建清单",0,0);
            double news=0;
            for(SdSalesContractInventory sd:newlist){
                news=news+sd.getTotal();
            }
            map.put("newtotal", news);
            List<SdSalesContractInventory> listadd= inventoryMapper.query(id, 0,"增加清单",0,0);
            double adds=0;
            for(SdSalesContractInventory sd:listadd){
                adds=adds+sd.getTotal();
            }
            map.put("addstotal", adds);
            List<SdSalesContractInventory> dele= inventoryMapper.query(id, 0,"减少清单",0,0);
            double deles=0;
            for(SdSalesContractInventory sd:dele){
                deles=deles+sd.getTotal();
            }
            map.put("deletotal", deles);
            List<SdSalesContractInventory> lists= inventoryMapper.query(id, 0,"增补清单",0,0);
            double a=0;
            for(SdSalesContractInventory sd:lists){
                a=a+sd.getTotal();
            }
            map.put("addpo", a);


        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }



}