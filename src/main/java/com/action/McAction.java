package com.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.*;
import com.service.mc.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 李鹏熠
 * @create 2019/3/20 8:48
 */
@Controller
@RequestMapping("/mc")
public class McAction {

    @Resource(name = "mcPersonnelDispatchedService")
    private McPersonnelDispatchedService mcPersonnelDispatchedService;
    @Resource(name = "mcMaterialsSevice")
    private McMaterialsSevice mcMaterialsSevice;
    @Resource(name = "mcFileBorrowService")
    private McFileBorrowService mcFileBorrowService;
    @Resource(name = "mcStampService")
    private McStampService mcStampService;
    @Resource(name = "mcDatumCostService")
    private McDatumCostService mcDatumCostService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        //true:允许输入空值，false:不能为空值
    }

    //商务盖章
    @RequestMapping("/stamp/query")
    public String showStamp(){
        return "/mc/mcStamp/mcStampList";
    }
    @RequestMapping(value = "/stamp/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String stampList(@RequestParam(required = false)String stampType,
                            @RequestParam(required = false, defaultValue = "0")int deptid,
                            @RequestParam(required = false)Date start,
                            @RequestParam(required = false)Date end,
                            @RequestParam(required = false, defaultValue = "0")int pageIndex,
                            HttpSession session){
        if (stampType == null || stampType == "") {
            stampType = null;
        }
        int userid=(int) session.getAttribute("userId");
        return JSONObject.toJSONString(mcStampService.getList(stampType,deptid,userid,start,end,pageIndex),
                SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/stamp/add")
    public String showAddStamp(){
        return "/mc/mcStamp/mcStampAdd";
    }

    @RequestMapping("/stamp/add.html")
    public String AddStamp(McStamp mcStamp,HttpServletRequest request){
        int userid=(int) request.getSession().getAttribute("userId");
        mcStamp.setUserid(userid);
        mcStampService.add(mcStamp,request);
        return "redirect:/mc/stamp/query";
    }
    @RequestMapping("/stamp/update")
    public String showUpdateStamp(){
        return "/mc/mcStamp/mcStampUpdate";
    }

    @RequestMapping(value = "/stamp/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String UpdateStampJson(@RequestParam int id){
        return JSONObject.toJSONString(mcStampService.getListById(id),
                SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/stamp/update.html")
    public String UpdateStamp(McStamp mcStamp){
        mcStampService.update(mcStamp);
        return "redirect:/mc/stamp/query";
    }

    @RequestMapping("/stamp/particular")
    public String particularStamp(){
        return "/mc/mcStamp/mcStampParticular";
    }

    @RequestMapping(value = "/stamp/particular.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String StampJson(@RequestParam int id){
        return JSONObject.toJSONString(mcStampService.getParticular1ById(id),
                SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/stamp/approvalDetailed")
    public String stampParticular(SysApprovalDetailed approvalDetailed) {
        mcStampService.addProjectApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }

    //原文件借用
    @RequestMapping("/borrow/query")
    public String showFileBorrow(){
        return "/mc/borrow/mcBorrowList";
    }

    @RequestMapping(value = "/borrow/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String borrowList(@RequestParam(required = false)String name,
                             @RequestParam(required = false, defaultValue = "0")int deptid,
                             @RequestParam(required = false)Date start,
                             @RequestParam(required = false)Date end,
                             @RequestParam(required = false, defaultValue = "0")int pageIndex,
                             HttpSession session
                             ){
        if (name == null || name == "") {
            name = null;
        }
        int userid=(int) session.getAttribute("userId");
        //int  userid=1;
        return JSONObject.toJSONString(mcFileBorrowService.getList(name,deptid,start,end ,userid,pageIndex),
                SerializerFeature.DisableCircularReferenceDetect);

    }

    @RequestMapping("/borrow/add")
    public String showAddFileBorrow(){
        return "/mc/borrow/mcBorrowAdd";
    }

    @RequestMapping("/borrow/add.html")
    public String AddFileBorrow(McFileBorrow mcFileBorrow,HttpServletRequest request){
        mcFileBorrowService.add(mcFileBorrow,request);
        return "redirect:/mc/borrow/query";
    }

    @RequestMapping("/borrow/update")
    public String showUpdateFileBorrow(){
        return "/mc/borrow/mcBorrowPadute";
    }

    @RequestMapping("/borrow/update.html")
    public String UpdateFileBorrow(McFileBorrow mcFileBorrow){
        return "redirect:/mc/borrow/query";
    }

    @RequestMapping(value = "/borrow/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String UpdateFileBorrowJson(@RequestParam int id){
        return JSONObject.toJSONString(mcFileBorrowService.getListById(id),
                SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping("/borrow/particular")
    public String showBorrowParticular(){
        return "/mc/borrow/mcBorrowParticular";
    }

    @RequestMapping(value = "/borrow/particular.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String borrowJson(@RequestParam int id){
        return JSONObject.toJSONString(mcFileBorrowService.getParticular1ById(id),
                SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/borrow/approvalDetailed")
    public String borrowParticular(SysApprovalDetailed approvalDetailed) {
        mcFileBorrowService.addProjectApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }

    //商务材料
    @RequestMapping("/materials/query")
    public String showMaterials(){
        return "/mc/mcMaterial/mcMaterialList";
    }
    @RequestMapping(value = "/materials/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String materialsList(@RequestParam(required = false)String offerTpye,
                            @RequestParam(required = false, defaultValue = "0")int deptid,
                            @RequestParam(required = false)Date start,
                            @RequestParam(required = false)Date end,
                            @RequestParam(required = false, defaultValue = "0")int pageIndex,
                            HttpSession session){
        if (offerTpye == null || offerTpye == "") {
            offerTpye = null;
        }
        int userid=(int) session.getAttribute("userId");
        return JSONObject.toJSONString(mcMaterialsSevice.getList(offerTpye,deptid,start,end,userid,pageIndex),
                SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/materials/add")
    public String showAddMaterials(){
        return "/mc/mcMaterial/mcMaterialAdd";
    }

    @RequestMapping("/materials/add.html")
    public String AddMaterials(McMaterials mcMaterials, HttpServletRequest request){
        int userid=(int) request.getSession().getAttribute("userId");
        mcMaterials.setUserid(userid);
        mcMaterialsSevice.add(mcMaterials,request);
        return "redirect:/mc/materials/query";
    }
    @RequestMapping("/materials/update")
    public String showUpdateMaterials(){
        return "/mc/mcMaterial/mcMaterialPadute";
    }

    @RequestMapping(value = "/materials/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String UpdateMaterialsJson(@RequestParam int id){
        return JSONObject.toJSONString(mcMaterialsSevice.getListById(id),
                SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/materials/update.html")
    public String UpdateMaterials(McMaterials materials){
        mcMaterialsSevice.update(materials);
        return "redirect:/mc/materials/query";
    }

    @RequestMapping("/materials/particular")
    public String particularMaterials(){
        return "/mc/mcMaterial/mcMaterialParticular";
    }

    @RequestMapping(value = "/materials/particular.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String materialsJson(@RequestParam int id){
        return JSONObject.toJSONString(mcMaterialsSevice.getParticular1ById(id),
                SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping("/materials/approvalDetailed")
    public String materialsParticular(SysApprovalDetailed approvalDetailed) {
        mcMaterialsSevice.addProjectApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }

    //人员派遣
    @RequestMapping("/dispatched/query")
    public String showDispatched(){
        return "/mc/mcDispatch/mcDispatchList";
    }
    @RequestMapping(value = "/dispatched/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String dispatchedList(@RequestParam(required = false)String projectName,
                                @RequestParam(required = false, defaultValue = "0")int deptid,
                                @RequestParam(required = false)Date start,
                                @RequestParam(required = false)Date end,
                                @RequestParam(required = false, defaultValue = "0")int pageIndex,
                                HttpSession session){
        if (projectName == null || projectName == "") {
            projectName = null;
        }
        int userid=(int) session.getAttribute("userId");
        return JSONObject.toJSONString(mcPersonnelDispatchedService.getList(projectName,deptid, userid, start, end, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/dispatched/add")
    public String showAddDispatched(){
        return "/mc/mcDispatch/mcDispatchAdd";
    }

    @RequestMapping("/dispatched/add.html")
    public String AddDispatched(McPersonnelDispatched personnelDispatched, HttpServletRequest request){
        int userid=(int) request.getSession().getAttribute("userId");
        personnelDispatched.setUserid(userid);
        personnelDispatched.setCreatetime(new Date());
        mcPersonnelDispatchedService.add(personnelDispatched,request);
        return "redirect:/mc/dispatched/query";
    }
    @RequestMapping("/dispatched/update")
    public String showUpdateDispatched(){
        return "/mc/mcDispatch/mcDispatchPadute";
    }

    @RequestMapping(value = "/dispatched/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String UpdateDispatchedJson(@RequestParam int id){
        return JSONObject.toJSONString(mcPersonnelDispatchedService.getListById(id),
                SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/dispatched/update.html")
    public String UpdateDispatched(McPersonnelDispatched personnelDispatched){
        mcPersonnelDispatchedService.update(personnelDispatched);
        return "redirect:/mc/dispatched/query";
    }

    @RequestMapping("/dispatched/particular")
    public String particulaDispatched(){
        return "/mc/mcDispatch/mcDispatchParticular";
    }

    @RequestMapping(value = "/dispatched/particular.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String dispatchedJson(@RequestParam int id){
        return JSONObject.toJSONString(mcPersonnelDispatchedService.getParticular1ById(id),
                SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/dispatched/delete")
    public String delete(@RequestParam int id){
        mcPersonnelDispatchedService.deleteById(id);
        return "redirect:/mc/dispatched/query";
    }
    @RequestMapping("/dispatched/approvalDetailed")
    public String dispatchedParticular(SysApprovalDetailed approvalDetailed) {
        mcPersonnelDispatchedService.addProjectApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }

    //资料费
    @RequestMapping("/datum/query")
    public String showDatum(){
        return "/mc/";
    }
    @RequestMapping(value = "/datum/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String datumList(@RequestParam(required = false)String projectName,
                                 @RequestParam(required = false, defaultValue = "0")int deptid,
                                 @RequestParam(required = false)Date start,
                                 @RequestParam(required = false)Date end,
                                 @RequestParam(required = false, defaultValue = "0")int pageIndex,
                                 HttpSession session){
        if (projectName == null || projectName == "") {
            projectName = null;
        }
        int userid=(int) session.getAttribute("userId");
        //int userid=1;
        return JSONObject.toJSONString(mcDatumCostService.getList(projectName,deptid,start, end, userid,  pageIndex),
                SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/datum/add")
    public String showAddDatum(){
        return "/mc//Add";
    }

    @RequestMapping("/datum/add.html")
    public String AddDatum(McDatumCost datumCost, HttpServletRequest request){
        //personnelDispatched.setCreatetime(new Date());
        mcDatumCostService.add(datumCost,request);
        return "redirect:/mc/datum/query";
    }
    @RequestMapping("/datum/update")
    public String showUpdateDatum(){
        return "/mc//Padute";
    }

    @RequestMapping(value = "/datum/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String UpdateDatumJson(@RequestParam int id){
        return JSONObject.toJSONString(mcDatumCostService.getListById(id),
                SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping("/datum/update.html")
    public String UpdateDatum(McDatumCost datumCost){
        mcDatumCostService.update(datumCost);
        return "redirect:/mc/datum/query";
    }

    @RequestMapping("/datum/particular")
    public String particulaDatum(){
        return "/mc//Particular";
    }

    @RequestMapping(value = "/datum/particular.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String datumJson(@RequestParam int id){
        return JSONObject.toJSONString(mcDatumCostService.getParticular1ById(id),
                SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/datum/delete")
    public String delectDatum(@RequestParam int id){
        //mcDatumCostService.deleteById(id);
        return "redirect:/mc/datum/query";
    }

    @RequestMapping("/datum/approvalDetailed")
    public String datumParticular(SysApprovalDetailed approvalDetailed) {
        mcDatumCostService.addProjectApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }

}
