package com.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.SysApprovalProcess;
import com.beans.SysUser;
import com.service.sys.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author 李鹏熠
 * @create 2019/2/26 8:56
 */
@Controller
@RequestMapping("/sys")
public class SysAction {
    @Resource(name = "userService")
    private UserService userService;
    @Resource(name="SysUserService")
    private SysUserService sysUserService;
    @Resource(name = "menuService")
    private MenuService menuService;
    @Resource(name = "authorityService")
    private AuthorityService authorityService;
    @Resource(name="approvalProcessService")
    private ApprovalProcessService ProcessService;
    @Resource(name = "deptService")
    private DeptService deptService;
    @Resource(name="RoleService")
    private SysRoleService sysRoleService;
    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~部门~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //跳转到修改
    @RequestMapping("/dept/query")
    public String toDeptPage() {
        return "/background/user/department";
    }
//查询所有部门
    @RequestMapping(value = "/dept/query.json",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String showQuery(){
        return JSONObject.toJSONString(deptService.getDeptList(0),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    //修改部门
    @RequestMapping(value = "/dept/updateDept",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updateDept(@Param("id") int id,@Param("name")String name){
        if (name==null||name==""){
            return "nothing";
        }
      int a=  deptService.update(id, name);
        if(a>0){
            return "yes";
        }else {
            return "no";
        }
    }
    //增加部门
    @RequestMapping(value = "/dept/addDept",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addDept(@Param("name")String name){
        if (name==null||name==""){
            return "nothing";
        }
        int a=  deptService.add(name);
        if(a>0){
            return "yes";
        }else {
            return "no";
        }
    }
    //删除部门
    @RequestMapping(value = "/dept/deleteDept",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteDept(@Param("id") int id){
        if(userService.isCountClassify(0,id,0)>0){
            return "undelete";
        };
        int a=  deptService.delete(id);
        if(a>0){
            return "yes";
        }else {
            return "no";
        }
    }

   //endregion ~~部门结束~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//跳转到修改
    @RequestMapping("/user/query")
    public String updateMyself() {
        return "/background/user/userList";
    }
    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~职位的~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @RequestMapping("/role/query")
    public String toRolePage() {
        return "/background/user/position";
    }
//获取所有职位
    @RequestMapping(value = "/role/getAllRole",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAllRole(){
        return JSONObject.toJSONString(sysRoleService.getAllRole(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    //修改职位
    @RequestMapping(value = "/role/updateRole",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updateRole(@Param("id") int id,@Param("name")String name){
        if (name==null||name==""){
            return "nothing";
        }
        int a=  sysRoleService.updateRole(id, name);
        if(a>0){
            return "yes";
        }else {
            return "no";
        }
    }
    //增加职位
    @RequestMapping(value = "/role/addRole",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addRole(@Param("name")String name){
        if (name==null||name==""){
            return "nothing";
        }
        int a=  sysRoleService.addRole(name);
        if(a>0){
            return "yes";
        }else {
            return "no";
        }
    }
    //删除职位
    @RequestMapping(value = "/role/deleteRole",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteRole(@Param("id")int id){
        if(userService.isCountClassify(0,0,id)>0){
            return "undelete";
        };
        int a=  sysRoleService.deleteRole(id);
        if(a>0){
            return "yes";
        }else {
            return "no";
        }
    }
    //endregion ~~职位结束~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~流程设置~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //跳转到修改
    @RequestMapping("/approval/query")
    public String toProcessPage() {
        return "/background/user/Flowing";
    }
    //查询所有审批流程
    @RequestMapping(value = "/Process/getAllProcePage",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAllProcess(){
        return JSONObject.toJSONString(ProcessService.getProcessList(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }


    //根据ID获取审批流程详情
    @RequestMapping(value = "/Process/getProcessByID",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getProcessByID(@Param("id") int id){
        Map<String, Object> map=new HashMap<>();
        SysApprovalProcess ap =  ProcessService.getSysApprovalProcessById(id);
//        map.put("SysApprovalProcess",ap);
        String useridList=ap.getUsersid();
        String nameList=ap.getProcessname();
        String[] name = nameList.split(",");
        String[] split = useridList.split(",");

        List<Object> namelist=new ArrayList<>();
        List<SysUser> list=new ArrayList<>();

        for(int i=0;i<name.length;i++){
            Map<String,Object> maps=new HashMap<>();
            maps.put("name",name[i]);
            namelist.add(maps);
            SysUser user=null;
                if(useridList.length()<=0||useridList==null||useridList==""||useridList.isEmpty()){
                     user=null;
                }else{
                    if(i<split.length){
                        int a=Integer.parseInt(split[i]);
                        if(a==0){
                            user=null;
                        }else{
                        user= sysUserService.querybyId(a);
                        }
                        list.add(user);
                    }else {
                        user=null;
                    }

                }

        }
        map.put("NameList",namelist);
        map.put("UserList",list);
        return JSONObject.toJSONString(map,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }
    //修改审批流程
    @RequestMapping(value = "/Process/updateProcessByID",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updateProcessByID(@Param("userid")String userid,@Param("id")int id){
        int a=ProcessService.updateProcessById(userid, id);
        if (a>0){
            return "yes";
        }else {
            return "no";
        }
    }


    //endregion ~~审批的结束~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

}