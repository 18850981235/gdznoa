package com.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.*;
import com.itextpdf.text.DocumentException;
import com.service.mc.*;
import com.sun.corba.se.impl.encoding.TypeCodeOutputStream;
import com.util.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.crypto.Data;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.util.setWatermark.setWatermark;

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
    @Resource(name = "mcQualificationService")
    private McQualificationService mcQualificationService;
    @Resource(name = "mcRegisterService")
    private McRegisterService mcregisterservice;
    @Resource(name = "mcPerformanceDateservice")
    private McPerformanceDateService mcPerformanceDateService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        //true:允许输入空值，false:不能为空值
    }


    // region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~商务盖章~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping("/stamp/query")
    public String showStamp() {
        return "/mc/mcStamp/mcStampList";
    }

    @RequestMapping(value = "/stamp/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String stampList(@RequestParam(required = false) String projectName,
                            @RequestParam(required = false) String stampType,
                            @RequestParam(required = false, defaultValue = "0") int deptid,
                            @RequestParam(required = false) String content,
                            @RequestParam(required = false) String purpose,
                            @RequestParam(required = false) Date start,
                            @RequestParam(required = false) Date end,
                            @RequestParam(required = false, defaultValue = "0") int pageIndex,
                            HttpSession session) {
        if (projectName == null || projectName == "") {
            projectName = null;
        }
        if (stampType == null || stampType == "") {
            stampType = null;
        }
        if (content == null || content == "") {
            content = null;
        }
        if (purpose == null || purpose == "") {
            purpose = null;
        }
        //int userid=(int) session.getAttribute("userId");
        int userid = 1;
        return JSONObject.toJSONString(mcStampService.getList(projectName, userid, stampType, deptid, content, purpose, start, end, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/stamp/add")
    public String showAddStamp() {
        return "/mc/mcStamp/mcStampAdd";
    }

    @RequestMapping("/stamp/add.html")
    public String AddStamp(McStamp mcStamp, HttpServletRequest request) {
        int userid = (int) request.getSession().getAttribute("userId");
        mcStamp.setUserid(userid);
        mcStampService.add(mcStamp, request);
        return "redirect:/mc/stamp/query";
    }

    @RequestMapping("/stamp/update")
    public String showUpdateStamp() {
        return "/mc/mcStamp/mcStampUpdate";
    }

    @RequestMapping(value = "/stamp/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String UpdateStampJson(@RequestParam int id) {
        return JSONObject.toJSONString(mcStampService.getListById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/stamp/update.html")
    public String UpdateStamp(McStamp mcStamp) {
        mcStampService.update(mcStamp);
        return "redirect:/mc/stamp/query";
    }

    @RequestMapping("/stamp/particular")
    public String particularStamp() {
        return "/mc/mcStamp/mcStampParticular";
    }

    @RequestMapping(value = "/stamp/particular.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String StampJson(@RequestParam int id) {
        return JSONObject.toJSONString(mcStampService.getParticular1ById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/stamp/approvalDetailed")
    public String stampParticular(SysApprovalDetailed approvalDetailed, HttpSession session) {
        int userid = (int) session.getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        mcStampService.addProjectApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }
    // endregion

    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~原文件借用~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping("/borrow/query")
    public String showFileBorrow() {
        return "/mc/borrow/mcBorrowList";
    }

    @RequestMapping(value = "/borrow/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String borrowList(@RequestParam(required = false) String projectName,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false, defaultValue = "0") int deptid,
                             @RequestParam(required = false) Date start,
                             @RequestParam(required = false) Date end,
                             @RequestParam(required = false, defaultValue = "0") int pageIndex,
                             HttpSession session
    ) {
        if (name == null || name == "") {
            name = null;
        }
        if (projectName == null || projectName == "") {
            projectName = null;
        }
        int userid = (int) session.getAttribute("userId");
        //int  userid=1;
        return JSONObject.toJSONString(mcFileBorrowService.getList(projectName, name, deptid, start, end, userid, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/borrow/add")
    public String showAddFileBorrow() {
        return "/mc/borrow/mcBorrowAdd";
    }

    @RequestMapping("/borrow/add.html")
    public String AddFileBorrow(McFileBorrow mcFileBorrow, HttpServletRequest request) {
        mcFileBorrowService.add(mcFileBorrow, request);
        return "redirect:/mc/borrow/query";
    }

    @RequestMapping("/borrow/update")
    public String showUpdateFileBorrow() {
        return "/mc/borrow/mcBorrowPadute";
    }

    @RequestMapping("/borrow/update.html")
    public String UpdateFileBorrow(McFileBorrow mcFileBorrow) {
        return "redirect:/mc/borrow/query";
    }

    @RequestMapping(value = "/borrow/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String UpdateFileBorrowJson(@RequestParam int id) {
        return JSONObject.toJSONString(mcFileBorrowService.getListById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/borrow/particular")
    public String showBorrowParticular() {
        return "/mc/borrow/mcBorrowParticular";
    }

    @RequestMapping(value = "/borrow/particular.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String borrowJson(@RequestParam int id) {
        return JSONObject.toJSONString(mcFileBorrowService.getParticular1ById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/borrow/approvalDetailed")
    public String borrowParticular(SysApprovalDetailed approvalDetailed, HttpSession session) {
        int userid = (int) session.getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        mcFileBorrowService.addProjectApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }

    @RequestMapping(value = "/borrow/queryMailFile", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String queryMailFile(@Param("projectName") String projectName) {
        return JSONObject.toJSONString(mcFileBorrowService.queryMailFile(projectName),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }



    // endregion

    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~商务材料~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping("/materials/query")
    public String showMaterials() {
        return "/mc/mcMaterial/mcMaterialList";
    }

    @RequestMapping(value = "/materials/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String materialsList(@RequestParam(required = false) String offerTpye,
                                @RequestParam(required = false, defaultValue = "0") int deptid,
                                @RequestParam(required = false) Date start,
                                @RequestParam(required = false) Date end,
                                @RequestParam(required = false, defaultValue = "0") int pageIndex,
                                HttpSession session) {
        if (offerTpye == null || offerTpye == "") {
            offerTpye = null;
        }
        int userid = (int) session.getAttribute("userId");
        return JSONObject.toJSONString(mcMaterialsSevice.getList(offerTpye, deptid, start, end, userid, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/materials/add")
    public String showAddMaterials() {
        return "/mc/mcMaterial/mcMaterialAdd";
    }

    @RequestMapping("/materials/add.html")
    public String AddMaterials(McMaterials mcMaterials, HttpServletRequest request) {
        int userid = (int) request.getSession().getAttribute("userId");
        mcMaterials.setUserid(userid);
        mcMaterialsSevice.add(mcMaterials, request);
        return "redirect:/mc/materials/query";
    }

    @RequestMapping("/materials/update")
    public String showUpdateMaterials() {
        return "/mc/mcMaterial/mcMaterialPadute";
    }

    @RequestMapping(value = "/materials/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String UpdateMaterialsJson(@RequestParam int id) {
        return JSONObject.toJSONString(mcMaterialsSevice.getListById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/materials/update.html")
    public String UpdateMaterials(McMaterials materials) {
        mcMaterialsSevice.update(materials);
        return "redirect:/mc/materials/query";
    }

    @RequestMapping("/materials/particular")
    public String particularMaterials() {
        return "/mc/mcMaterial/mcMaterialParticular";
    }

    @RequestMapping(value = "/materials/particular.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String materialsJson(@RequestParam int id) {
        return JSONObject.toJSONString(mcMaterialsSevice.getParticular1ById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/materials/approvalDetailed")
    public String materialsParticular(SysApprovalDetailed approvalDetailed, HttpSession session) {
        int userid = (int) session.getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        mcMaterialsSevice.addProjectApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }
    // endregion

    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~人员派遣~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping("/dispatched/query")
    public String showDispatched() {
        return "/mc/mcDispatch/mcDispatchList";
    }

    @RequestMapping(value = "/dispatched/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String dispatchedList(@RequestParam(required = false) String projectName,
                                 @RequestParam(required = false) String personnelCondition,
                                 @RequestParam(required = false, defaultValue = "0") int deptid,
                                 @RequestParam(required = false) Date start,
                                 @RequestParam(required = false) Date end,
                                 @RequestParam(required = false, defaultValue = "0") int pageIndex,
                                 HttpSession session) {
        if (projectName == null || projectName == "") {
            projectName = null;
        }
        if (personnelCondition == null || personnelCondition == "") {
            personnelCondition = null;
        }

        int userid = (int) session.getAttribute("userId");
        return JSONObject.toJSONString(mcPersonnelDispatchedService.getList(projectName, personnelCondition, deptid, userid, start, end, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/dispatched/add")
    public String showAddDispatched() {
        return "/mc/mcDispatch/mcDispatchAdd";
    }

    @RequestMapping("/dispatched/add.html")
    public String AddDispatched(McPersonnelDispatched personnelDispatched, HttpServletRequest request) {
        int userid = (int) request.getSession().getAttribute("userId");
        personnelDispatched.setUserid(userid);
        personnelDispatched.setCreatetime(new Date());
        mcPersonnelDispatchedService.add(personnelDispatched);
        return "redirect:/mc/dispatched/query";
    }

    @RequestMapping("/dispatched/update")
    public String showUpdateDispatched() {
        return "/mc/mcDispatch/mcDispatchPadute";
    }

    @RequestMapping(value = "/dispatched/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String UpdateDispatchedJson(@RequestParam int id) {
        return JSONObject.toJSONString(mcPersonnelDispatchedService.getListById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/dispatched/update.html")
    public String UpdateDispatched(McPersonnelDispatched personnelDispatched) {
        mcPersonnelDispatchedService.update(personnelDispatched);
        return "redirect:/mc/dispatched/query";
    }

    @RequestMapping("/dispatched/particular")
    public String particulaDispatched() {
        return "/mc/mcDispatch/mcDispatchParticular";
    }

    @RequestMapping(value = "/dispatched/particular.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String dispatchedJson(@RequestParam int id) {
        return JSONObject.toJSONString(mcPersonnelDispatchedService.getParticular1ById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/dispatched/delete")
    public String delete(@RequestParam int id) {
        mcPersonnelDispatchedService.deleteById(id);
        return "redirect:/mc/dispatched/query";
    }

    @RequestMapping("/dispatched/approvalDetailed")
    public String dispatchedParticular(SysApprovalDetailed approvalDetailed, HttpSession session) {
        int userid = (int) session.getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        mcPersonnelDispatchedService.addProjectApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }
    // endregion

    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~资料费~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping("/datum/query")
    public String showDatum() {
        return "/mc/mcCost/mcCostList";
    }

    @RequestMapping(value = "/datum/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String datumList(@RequestParam(required = false) String projectName,
                            @RequestParam(required = false, defaultValue = "0") int deptid,
                            @RequestParam(required = false) Date start,
                            @RequestParam(required = false) Date end,
                            @RequestParam(required = false, defaultValue = "0") int pageIndex,
                            HttpSession session) {
        if (projectName == null || projectName == "") {
            projectName = null;
        }
        int userid = (int) session.getAttribute("userId");
        //int userid=1;
        return JSONObject.toJSONString(mcDatumCostService.getList(projectName, deptid, start, end, userid, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/datum/add")
    public String showAddDatum() {
        return "/mc/mcCost/mcCostAdd";
    }

    @RequestMapping("/datum/add.html")
    public String AddDatum(McDatumCost datumCost, HttpServletRequest request) {
        //personnelDispatched.setCreatetime(new Date());
        mcDatumCostService.add(datumCost, request);
        return "redirect:/mc/datum/query";
    }

    @RequestMapping("/datum/update")
    public String showUpdateDatum() {
        return "/mc/mcCost/mcCostPadute";
    }

    @RequestMapping(value = "/datum/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String UpdateDatumJson(@RequestParam int id) {
        return JSONObject.toJSONString(mcDatumCostService.getListById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/datum/update.html")
    public String UpdateDatum(McDatumCost datumCost) {
        mcDatumCostService.update(datumCost);
        return "redirect:/mc/datum/query";
    }

    @RequestMapping("/datum/particular")
    public String particulaDatum() {
        return "/mc/mcCost/mcCostParticular";
    }

    @RequestMapping(value = "/datum/particular.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String datumJson(@RequestParam int id) {
        return JSONObject.toJSONString(mcDatumCostService.getParticular1ById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/datum/delete")
    public String delectDatum(@RequestParam int id) {
        //mcDatumCostService.deleteById(id);
        return "redirect:/mc/datum/query";
    }

    @RequestMapping("/datum/approvalDetailed")
    public String datumParticular(SysApprovalDetailed approvalDetailed, HttpSession session) {
        int userid = (int) session.getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        mcDatumCostService.addProjectApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }
    // endregion

    // region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~注册备案~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //跳转到添加界面
    @RequestMapping("/register/add")
    public String addRegisterPage() {
        return "mc/mcRegister/mcRegisterAdd";
    }

    //添加注册备案
    @RequestMapping(value = "/register/addImpl")
    public String addRegister(McRegisterRecords mcRegisterRecords, HttpServletRequest request) {
        int sum;
        sum = mcregisterservice.addregister(mcRegisterRecords, request);
        if (sum > 0) {
            return "mc/mcRegister/mcRegisterList";

        } else {
            return "mc/mcRegister/mcRegisterAdd";
        }
    }

    //跳转到更改界面
    @RequestMapping("/register/update")
    public String updateRegisterPage() {
        return "mc/mcRegister/mcRegisterPadute";
    }

    //根据ID查询
    @RequestMapping(value = "/register/query.json", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String Query(@RequestParam int id) {
        return JSONObject.toJSONString(mcregisterservice.querybyid(id)
                , SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    //更改备案信息
    @RequestMapping(value = "/register/updateImpl")
    public String updateRegister(McRegisterRecords mcRegisterRecords) {
        int sum;
        sum = mcregisterservice.updateregist(mcRegisterRecords);
        if (sum > 0) {
            return "mc/mcRegister/mcRegisterList";
        } else {
            return "mc/mcRegister/mcRegisterPadute";
        }
    }

    //跳转到详情界面
    @RequestMapping("/register/detail")
    public String detailRegisterPage() {
        return "mc/mcRegister/mcRegisterParticular";
    }

    //根据ID查询详情
    @RequestMapping(value = "/register/querydetailsbyid.json", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String Querydetailsbyid(@RequestParam int id) {
        return JSONObject.toJSONString(mcregisterservice.querydetailbyid(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    //根据ID删除某条备案信息
    @RequestMapping(value = "/register/deleteImpl", produces = "application/json; charset=utf-8")
    public String deleteRegister(@RequestParam int id) {
        int sum = mcregisterservice.delete(id);
        if (sum > 0) {
            return "mc/mcRegister/mcRegisterList";
        } else {
            return "mc/mcRegister/mcRegisterList";
        }
    }

    //跳转到模糊查询界面
    @RequestMapping("/register/query")
    public String queryRegisterPage() {
        return "mc/mcRegister/mcRegisterList";
    }

    //模糊搜索备案信息
    @RequestMapping(value = "/register/querybynametype.json", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String querybynametype(@RequestParam(required = false, defaultValue = "0") int deptid, @RequestParam(required = false) String Name, @RequestParam(required = false) String Type,  @RequestParam(required = false) String startTime ,@RequestParam(required = false) String endTime,@RequestParam(required = false, defaultValue = "0") int pageIndex) {

        if (Name == null || Name == "") {
            Name = null;
        }
        if (Type == null || Type == "") {
            Type = null;
        }
        if (endTime == null || endTime == "") {
            endTime = null;
        }

        if (startTime == null || startTime == "") {
            startTime = null;
        }


        return JSONObject.toJSONString(mcregisterservice.querybyrecords(deptid, Name, Type,startTime, endTime, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/SdSalesContract/registerParticular")
    public String registerParticular(SysApprovalDetailed approvalDetailed, HttpSession session) {
        int userid = (int) session.getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        mcregisterservice.addProjectApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }
    // endregion

    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~资质证书~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//资历证书PDF导出：
    @RequestMapping("/qualification/pdf")
    public void  pdfout(HttpServletRequest request,HttpServletResponse response)throws DocumentException, IOException {
        response.setContentType("application/force-download");
    System.err.print("11111111111111111");
        Collection<Part> parts = null;
        try {
            parts = request.getParts();
        } catch (ServletException e1) {
            e1.printStackTrace();
        }
        for (Iterator<Part> iterator = parts.iterator(); iterator.hasNext();) {
        Part part = iterator.next();
        System.out.println("-----类型名称------->"+part.getName());
        System.out.println("-----类型------->"+part.getContentType());
        System.out.println("-----提交的类型名称------->"+part.getSubmittedFileName());
        System.out.println("----流-------->"+part.getInputStream());

        //设置PDF默认名称
            response.addHeader("Content-Type", "application/octet-stream");
            response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("已下载PDF"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()),"UTF-8")+".pdf");
        //输出流
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            // 将pdf文件先加水印然后输出
            setWatermark(bos, part.getInputStream(), format.format(cal.getTime())
                    + " 下载使用人：" + "测试user","jkahsd sah jkshj da ",16);


        }


//



    };


    //跳转到资历证书增加界面
    @RequestMapping("/qualification/add")
    public String addQualificationPage() {
        return "mc/mcCertificate/mcCertificateAdd";
    }

    //资质证书添加
    @RequestMapping(value = "/qualification/addImpl")
    public String addqualification(McQualificationCertificate mcQualificationCertificate, HttpServletRequest reques) {
        int sum;
        sum = mcQualificationService.addQualificationCertificate(mcQualificationCertificate, reques);
        if (sum > 0) {
            return "mc/mcCertificate/mcCertificateList";
        } else {
            return "mc/mcCertificate/mcCertificateAdd";
        }
    }

    //跳转到资历证书更改界面
    @RequestMapping("/qualification/update")
    public String updateQualificationPage() {
        return "mc/mcCertificate/mcCertificatePadute";
    }

    //根据ID查询
    @RequestMapping(value = "/qualification/querybyid.json")
    @ResponseBody
    public String querybyid(@RequestParam int id) {
        return JSONObject.toJSONString(mcQualificationService.querybyid(id),
                SerializerFeature.DisableCircularReferenceDetect);
    }

    //资质正式信息更改
    @RequestMapping(value = "/qualification/updateImpl", produces = "application/json; charset=utf-8")
    public String updatequalification(McQualificationCertificate mcQualificationCertificate) {
        int sum;
        sum = mcQualificationService.updateMcQualification(mcQualificationCertificate);
        if (sum > 0) {
            return "mc/mcCertificate/mcCertificateList";
        } else {
            return "mc/mcCertificate/mcCertificatePadute";
        }
    }

    //跳转到资历证书详情界面
    @RequestMapping("/qualification/detail")
    public String detailQualificationPage() {
        return "mc/mcCertificate/meCertificateParticular";
    }

    //根据ID查询详情
    @RequestMapping(value = "/qualification/querydetailbyid.json", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String querydetailbyid(@RequestParam int id) {
        return JSONObject.toJSONString(mcQualificationService.querydetailbyid(id)
                , SerializerFeature.DisableCircularReferenceDetect);
    }

    //跳转到资历证书详情界面
    @RequestMapping("/qualification/query")
    public String allQualificationPage() {
        return "mc/mcCertificate/mcCertificateList";
    }

    //模糊查询资历证书
    @RequestMapping(value = "/qualification/querybytypename.json", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String querybytypename( @RequestParam(required = false) String name,@RequestParam(required = false) String type, @RequestParam(required = false) String content, @RequestParam(required = false) String borrow,
                                   @RequestParam(required = false) String state,@RequestParam(required = false) String staretime,@RequestParam(required = false) String endtime,@RequestParam(required = false, defaultValue = "0") int pageIndex) {
        if (name == null || name == "") {
            name = null;
        }
        if (type == null || type == "") {
            type = null;
        }
        if (content == null || content == "") {
            content = null;
        }
        if (type == null || type == "") {
            type = null;
        }
        if (borrow == null || borrow == "") {
            borrow = null;
        }
        if (endtime == null || endtime == "") {
            endtime = null;
        }
        if (staretime == null || staretime == "") {
            staretime = null;
        }


        return JSONObject.toJSONString(mcQualificationService.querybytypename( name, type,content,borrow,state,staretime,endtime,pageIndex),
                SerializerFeature.DisableCircularReferenceDetect);
    }

    //删除资质证书
    @RequestMapping(value = "/qualification/delete", produces = "application/json; charset=utf-8")
    public String deleteQualification(@RequestParam int id) {
        int sum = mcQualificationService.delete(id);
        return "mc/mcCertificate/meCertificateParticular.";
    }
    @RequestMapping("/SdSalesContract/QualificationParticular")
    public String QualificationParticular(SysApprovalDetailed approvalDetailed, HttpSession session) {
        int userid = (int) session.getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        mcQualificationService.addProjectApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }

    // endregion
    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~业绩资料~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping("/performanceDate/addPerformanceDatePage")
    public String toaddaddPerformanceDate() {
        return "/mc/performanceDate/        " ;
    }

    @RequestMapping(value = "/performanceDate/addPerformanceDate", produces = "text/html;charset=UTF-8")
    public  String  addPerformanceDate(McPerformanceDate  PerformanceDate,HttpServletRequest request){
      int sum = mcPerformanceDateService.addPerformanceDate(PerformanceDate,request);
       if (sum>0){
           return "/mc/performanceDate/query";
       }else{
           return "/mc/performanceDate/query";
       }
    };

    @RequestMapping(value = "/performanceDate/delete", produces = "text/html;charset=UTF-8")
    public  String  deletePerformanceDate( @Param("id")int id){
        int sum = mcPerformanceDateService.deleteMcPerformanceDate(id);
        if (sum>0){
            return "/mc/performanceDate/query";
        }else{
            return "/mc/performanceDate/query";
        }
    };
    @RequestMapping("/performanceDate/updatePerformanceDatePage")
    public String toupdatePerformanceDate() {
        return "/mc/performanceDate/        " ;
    }

    @RequestMapping(value = "/performanceDate/updateperformanceDate.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updatePerformanceDateJson(@RequestParam int id) {
        return JSONObject.toJSONString(mcPerformanceDateService.queryMcPerformanceDatebyid(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/performanceDate/updatePerformanceDate", produces = "text/html;charset=UTF-8")
    public  String  updatePerformanceDate(McPerformanceDate  PerformanceDate,HttpServletRequest request){
        int sum = mcPerformanceDateService.updateMcPerformanceDate(PerformanceDate,request);
        if (sum>0){
            return "/mc/performanceDate/query";
        }else{
            return "/mc/performanceDate/query";
        }
    };
    @RequestMapping("/performanceDate/queryPerformanceDatebyidPage")
    public String toquerybyidPerformanceDate() {
        return "/mc/performanceDate/        " ;
    }
    @RequestMapping(value = "/performanceDate/querybyid", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public  String  queryMcPerformanceDatebyid(@Param("id") int id){
        return JSONObject.toJSONString(mcPerformanceDateService.queryMcPerformanceDatebyid(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    @RequestMapping("/performanceDate/queryPerformanceDatePage")
    public String toqueryPerformanceDate() {
        return "/mc/performanceDate/        " ;
    }

    @RequestMapping(value = "/performanceDate/queryPerformanceDate", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public  String  queryMcPerformanceDatebysome(@RequestParam(required = false) String projectName, @RequestParam(required = false) Date  bidtimeStart, @RequestParam(required = false) Date  bidtimeEnd,
                                                 @RequestParam(required = false) Date  accetimeStart,@RequestParam(required = false) Date acctimeEnd, @RequestParam(required = false)String borrow, @RequestParam(required = false, defaultValue = "0") int pageIndex){
        if (projectName == null || projectName == "") {
            projectName = null;
        }
        if (bidtimeStart == null ) {
            bidtimeStart = null;
        }
        if (bidtimeEnd == null  ) {
            bidtimeEnd = null;
        }
        if (accetimeStart == null ) {
            accetimeStart = null;
        }
        if (borrow == null || borrow == "") {
            borrow = null;
        }
        if (acctimeEnd == null ) {
            acctimeEnd = null;
        }


        return JSONObject.toJSONString( mcPerformanceDateService.queryMcPerformanceDatebysome(projectName, bidtimeStart, bidtimeEnd,
                accetimeStart, acctimeEnd, borrow, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };

    // endregion
}

