package com.action;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.GaOuterTubePass;
import com.beans.GaPayment;
import com.beans.SysApprovalDetailed;
import com.service.ga.GaOuterTubePassService;
import com.service.ga.GaPaymentService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * @create 2019/8/5 14:47
 */
@Controller
@RequestMapping("/ga")
public class GaAction {
    @Resource(name = "gaOuterTubePassService")
    private GaOuterTubePassService gaOuterTubePassService;

    @Resource(name = "gaPaymentService")
    private GaPaymentService GaPaymentService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        //true:允许输入空值，false:不能为空值
    }
    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~外经证审请~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping("/outerTube/query")
    public String showOuterTubeList() {
        return "/ga/outerTube/outerTubeList";
    }

    @RequestMapping(value = "/outerTube/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String outerTubeList(int projectId) {
        return JSONObject.toJSONString(gaOuterTubePassService.getProjectId(projectId)
                , SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/outerTube/add")
    public String showOuterTubeAdd() {
        return "/ga/outerTube/outerTubeAdd";
    }

    @RequestMapping("/outerTube/addouterTube")
    public String outerTubeAdd(GaOuterTubePass gaOuterTubePass, HttpServletRequest httpServletRequest) {
        gaOuterTubePassService.add(gaOuterTubePass, httpServletRequest);
        return "redirect:/ga/outerTube/query";
    }

    @RequestMapping("/outerTube/update")
    public String showouterTubeUpdate() {
        return "/ga/outerTube/outerTubeUpdate";
    }

    @RequestMapping(value = "/outerTube/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String outerTubeUpdateJson(@RequestParam int id) {
        return JSONObject.toJSONString(gaOuterTubePassService.getById(id)
                , SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/outerTube/update.html")
    public String outerTubeUpdate(GaOuterTubePass gaOuterTubePass) {
        gaOuterTubePassService.update(gaOuterTubePass);
        return "redirect:/ga/outerTube/query";
    }


    @RequestMapping("/outerTube/particular")
    public String showouterTubeParticular() {
        return "/ga/outerTube/outerTubeParticular";
    }

    @RequestMapping(value = "/outerTube/particular.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String outerTubeParticular(@RequestParam int id) {
        return JSONObject.toJSONString(gaOuterTubePassService.getById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/outerTube/delete")
    public String outerTubeUpdate(@RequestParam int id) {
        gaOuterTubePassService.delete(id);
        return "redirect:/ga/outerTube/query";
    }


    @RequestMapping("/outerTube/approvalDetailed")
    public String outerTubeParticular(SysApprovalDetailed approvalDetailed, HttpSession session) {
        int userid=(int) session.getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        gaOuterTubePassService.addApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }
    // endregion

    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~应付财务~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping(value = "/payment/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String paymentList(int projectId,String matter,int pageIndex) {
        return JSONObject.toJSONString(GaPaymentService.getlist(projectId,matter,pageIndex)
                , SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/payment/add")
    public String showPaymentAdd() {
        return "/ga/payment/paymentAdd";
    }

    @RequestMapping("/payment/addouterTube")
    public String paymentAdd(GaPayment gaPayment) {
        GaPaymentService.add(gaPayment);
        return "redirect:/ga/payment/query";
    }

    @RequestMapping("/payment/update")
    public String showPaymentUpdate() {
        return "/ga/payment/paymentUpdate";
    }

    @RequestMapping(value = "/payment/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String paymentUpdateJson(@RequestParam int id) {
        return JSONObject.toJSONString(GaPaymentService.getById(id)
                , SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/payment/update.html")
    public String paymentUpdate(GaPayment gaPayment) {
        GaPaymentService.update(gaPayment);
        return "redirect:/ga/payment/query";
    }


    @RequestMapping("/payment/particular")
    public String showPaymentParticular() {
        return "/ga/payment/paymentParticular";
    }

    @RequestMapping(value = "/payment/particular.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String paymentParticular(@RequestParam int id) {
        return JSONObject.toJSONString(GaPaymentService.getById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

/*    @RequestMapping(value = "/payment/delete")
    public String paymentUpdate(@RequestParam int id) {
        gaOuterTubePassService.delete(id);
        return "redirect:/ga/outerTube/query";
    }*/


    @RequestMapping("/payment/approvalDetailed")
    public String paymentParticular(SysApprovalDetailed approvalDetailed, HttpSession session) {
        int userid=(int) session.getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        GaPaymentService.addApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }


    // endregion
}