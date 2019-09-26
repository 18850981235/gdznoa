package com.service.ga;

import com.beans.*;
import com.dao.bd.BdProjectMapper;
import com.dao.ga.GaOuterTubePassMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
import com.util.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/8/5 15:09
 */
@Service("gaOuterTubePassService")
public class GaOuterTubePassServiceImpl implements GaOuterTubePassService {
    @Resource
    private GaOuterTubePassMapper gaOuterTubePassMapper;
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;

    @Override
    public int add(GaOuterTubePass gaOuterTubePass, HttpServletRequest request) {
        int num = 0;
        try {
            SysApprovalProcess process = approvalProcessMapper.getProcessById(5);
            String accessory = FileUtils.uploadFile(request, "file");
            if (accessory != null && !accessory.equals("")) {
                gaOuterTubePass.setAccessory(accessory);
            }
            String[] arr = process.getUsersid().split(",");
            gaOuterTubePass.setProcessid(5);
            gaOuterTubePass.setProcessUserid(Integer.parseInt(arr[0]));
            gaOuterTubePass.setProcessState("未审批");
            num = gaOuterTubePassMapper.add(gaOuterTubePass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int addApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("外经证申请");
        try {
            approvalDetailedMapper.add(detailed);
            GaOuterTubePass update = new GaOuterTubePass();
            int processUserid = 0;
            GaOuterTubePass pd = gaOuterTubePassMapper.getListById(detailed.getApprovalId());
            String state = "审批中";
            String users = approvalProcessMapper.getProcessById(pd.getProcessid()).getUsersid();
            String[] userArr = users.split(",");
            if (detailed.getState().equals("同意")) {
                pd.setProcessNode(pd.getProcessNode()+1);
                if(userArr.length<pd.getProcessNode()){
                    state="审批结束";
                    pd.setProcessNode(0);
                }
            } else {
                pd.setProcessNode(pd.getProcessNode()-1);
            }
            if(pd.getProcessNode()==1){
                processUserid =Integer.parseInt(userArr[0]);
            }
            if(pd.getProcessNode()==2){
                processUserid = Integer.parseInt(userArr[1]);
            }


            update.setProcessNode(pd.getProcessNode());
            update.setProcessUserid(processUserid);
            update.setId(detailed.getApprovalId());
            update.setProcessState(state);
            return gaOuterTubePassMapper.updateById(update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    @Override
    public int update(GaOuterTubePass gaOuterTubePass) {
        return gaOuterTubePassMapper.updateById(gaOuterTubePass);
    }

    @Override
    public int delete(int id) {
        return gaOuterTubePassMapper.deleteById(id);
    }

    @Override
    public List<GaOuterTubePass> getProjectId(int projectId) {
        List<GaOuterTubePass> list=null;
        try {
            list=gaOuterTubePassMapper.selectByProjectid(projectId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Map<String,Object> getById(int id) {
        Map<String, Object> map = new HashMap<>();
        try {
            GaOuterTubePass gaOuterTubePass = gaOuterTubePassMapper.getListById(id);
            List<SysApprovalDetailed> list = approvalDetailedMapper.getListByapprovalId(id, "外经证申请");
            map.put("project", gaOuterTubePass);
            map.put("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

}