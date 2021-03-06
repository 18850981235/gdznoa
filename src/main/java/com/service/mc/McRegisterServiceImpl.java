package com.service.mc;

import com.beans.McRegisterRecords;
import com.beans.SysApprovalDetailed;
import com.beans.SysApprovalProcess;
import com.dao.mc.McRegisterMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
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
 * @author 许思明
 * @create 2019/4/08
 */
@Transactional
@Service("mcRegisterService")
public class McRegisterServiceImpl implements McRegisterService{

    @Resource
    private McRegisterMapper mcregistermapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper ;
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;


    @Override
    public int addProjectApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("注册备案");
        try {
            approvalDetailedMapper.add(detailed);
            McRegisterRecords mcRegisterRecords = new McRegisterRecords();

            if (detailed.getState().equals( "通过")) {
                String state = "进行中";
                int processUserid = 0;
              List<McRegisterRecords> list = mcregistermapper.querybyid(detailed.getApprovalId());
                 mcRegisterRecords=list.get(0);
                String users = mcRegisterRecords.getProcess().getUsersid();
                String[] userArr = users.split(",");
                for (int i = 0; i < userArr.length; i++) {
                    if (userArr[i].equals(String.valueOf(mcRegisterRecords.getProcessUserid()))) {
                        if (i != userArr.length - 1) {
                            processUserid = Integer.parseInt(userArr[i + 1]);
                        } else {
                            state = "已结束";
                        }
                    }
                }
                mcRegisterRecords.setProcessUserid(processUserid);
                mcRegisterRecords.setProcessState(state);
                mcRegisterRecords.setId(detailed.getApprovalId());
            } else {
                mcRegisterRecords.setProcessState(detailed.getState());
                mcRegisterRecords.setId(detailed.getApprovalId());
            }
            return mcregistermapper.update(mcRegisterRecords);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

//添加注册备案
   public  int addregister(McRegisterRecords mcregisterrecords, HttpServletRequest request){
       int num = 0;
       try {
           SysApprovalProcess process = approvalProcessMapper.getProcessById(6);
           String accessory= FileUtils.uploadFile(request,"file");
           if (accessory!=null&&!accessory.equals("")){
               mcregisterrecords.setAccessory(accessory);
           }
           String[] arr = process.getUsersid().split(",");
           mcregisterrecords.setProcessid(6);
           mcregisterrecords.setProcessUserid(Integer.parseInt(arr[0]));
           mcregisterrecords.setProcessState("进行中");
           num = mcregistermapper.add(mcregisterrecords);
       } catch (Exception e) {
           e.printStackTrace();
           TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
       }
       return num;
   };

    //更改注册备案
    public  int updateregist(McRegisterRecords mcRegisterRecords){
        return  mcregistermapper.update(mcRegisterRecords);
    }
    //根据ID查询注册备案
    public    List<McRegisterRecords>  querybyid(int id){
        return  mcregistermapper.querybyid(id);
    }
    //详情查询
    @Override
    public Map<String, Object> querydetailbyid(int id) {
        Map<String,Object> map=new HashMap<>();
        List<McRegisterRecords> list=mcregistermapper.querybyid(id);
        List<SysApprovalDetailed>lists=approvalDetailedMapper.getListByapprovalId(id,"注册备案");
        map.put("List",list);
        map .put("Lists",lists);
        return map;
    }

    //删除注册备案
    public int delete(int id) {
        return mcregistermapper.delete(id);
    }
    //添加查询注册备案
    public Map<String, Object>  querybyrecords(int id,String Name, String Type, int  pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(mcregistermapper.querybycount(id,Name,Type));
            page.setCurrentPageNo(pageIndex);
            List<McRegisterRecords> list=mcregistermapper.querybynameatype(id,Name,Type,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    };
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~资质证书管理~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}
