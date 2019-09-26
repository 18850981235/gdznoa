package com.service.ga;

import com.beans.GaComeGO;

import com.beans.SysApprovalDetailed;
import com.beans.SysApprovalProcess;
import com.dao.ga.GaComeGoMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
import com.dao.sys.UserMapper;
import com.util.FileUtils;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/8/6 16:20
 */
@Service("gaComeGoService")
public class GaComeGoServiceImpl implements GaComeGoService {
    @Resource
    private GaComeGoMapper gaComeGoMapper;
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;
    @Resource
    private UserMapper userMapper;


    @Override
    public int add(GaComeGO gaComeGo, HttpServletRequest request) {
        int num = 0;
        try {
            String accessory = FileUtils.uploadFile(request, "file");
            if (accessory != null && !accessory.equals("")) {
                gaComeGo.setAccessory(accessory);
            }
            int flow;
            if (gaComeGo.getType2().equals("支出")) {
                flow = 16;
            } else {
                flow = 4;
            }
            SysApprovalProcess process = approvalProcessMapper.getProcessById(flow);
            String[] arr = process.getUsersid().split(",");
            gaComeGo.setProcessid(flow);
            gaComeGo.setProcessUserid(Integer.parseInt(arr[0]));
            gaComeGo.setProcessState("未审批");
            gaComeGo.setCreatetime(new Date());
            gaComeGoMapper.add(gaComeGo);
            num = gaComeGo.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int addApproval(SysApprovalDetailed detailed) {
        GaComeGO pd = gaComeGoMapper.getListById(detailed.getApprovalId());
        if (pd.getType2().equals("支出")) {
            detailed.setApprovalName("往来款支出申请");
        } else {
            detailed.setApprovalName("往来款收入申请");
        }
        try {
            approvalDetailedMapper.add(detailed);
            GaComeGO update = new GaComeGO();
            int processUserid = 0;
            String state = "审批中";
            String users = approvalProcessMapper.getProcessById(pd.getProcessid()).getUsersid();
            String[] userArr = users.split(",");
            if (detailed.getState().equals("同意")) {
                pd.setProcessNode(pd.getProcessNode() + 1);
                if (userArr.length < pd.getProcessNode()) {
                    state = "审批结束";
                    pd.setProcessNode(0);
                }
            } else {
                pd.setProcessNode(pd.getProcessNode() - 1);
            }

            if (pd.getType2().equals("支出")) {
                if (pd.getProcessNode() == 1) {
                    processUserid = userMapper.DeptroleUser(pd.getUser().getDeptid()).get(0).getId();
                }
                if (pd.getProcessNode() == 2) {
                    processUserid = Integer.parseInt(userArr[1]);
                }
                if (pd.getProcessNode() == 3) {
                    processUserid = Integer.parseInt(userArr[2]);
                }
                if (pd.getProcessNode() == 4) {
                    processUserid = Integer.parseInt(userArr[3]);
                }
                if (pd.getProcessNode() == 5) {
                    processUserid = Integer.parseInt(userArr[4]);
                }
            } else {
                if (pd.getProcessNode() == 1) {
                    processUserid = userMapper.DeptroleUser(pd.getUser().getDeptid()).get(0).getId();
                }
                if (pd.getProcessNode() == 2) {
                    processUserid = Integer.parseInt(userArr[1]);
                }
                if (pd.getProcessNode() == 3) {
                    processUserid = Integer.parseInt(userArr[2]);
                }
                if (pd.getProcessNode() == 4) {
                    processUserid = Integer.parseInt(userArr[3]);
                }
                if (pd.getProcessNode() == 5) {
                    processUserid = Integer.parseInt(userArr[4]);
                }
            }
            update.setProcessNode(pd.getProcessNode());
            update.setProcessUserid(processUserid);
            update.setId(detailed.getApprovalId());
            update.setProcessState(state);
            return gaComeGoMapper.updateById(update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public int update(GaComeGO gaComeGo) {
        return gaComeGoMapper.updateById(gaComeGo);
    }


    @Override
    public Map<String, Object> getlist(int projectid, String matter, String type, String type2, int pageIndex) {
        Map<String, Object> map = new HashMap<>();
        Page page = new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setTotalCount(gaComeGoMapper.getCount(projectid, matter, type, type2));
            page.setPageSize(10);
            page.setCurrentPageNo(pageIndex);
            List<GaComeGO> list = gaComeGoMapper.getList(projectid, matter, type, type2, (page.getCurrentPageNo() - 1) * page.getPageSize(), page.getPageSize());
            map.put("page", page);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public Map<String, Object> getById(int id) {
        Map<String, Object> map = new HashMap<>();
        try {
            GaComeGO gaComeGo = gaComeGoMapper.getListById(id);
            List<SysApprovalDetailed> list = approvalDetailedMapper.getListByapprovalId(id, "付款申请");
            map.put("gaComeGo", gaComeGo);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }


}