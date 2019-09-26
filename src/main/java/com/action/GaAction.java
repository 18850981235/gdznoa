package com.action;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.*;
import com.service.ga.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Resource(name = "gaHarvestTicketService")
    private GaHarvestTicketService gaHarvestTicketService;

    @Resource(name = "gaSalaryService")
    private GaSalaryService gaSalaryService;

    @Resource(name = "gaComeGoService")
    private GaComeGoService gaComeGoService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        //true:允许输入空值，false:不能为空值
    }

    //财务主页
    @RequestMapping("/show")
    public String showIndex() {
        return "/ga/index";
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
        return "redirect:/ga/show";
    }

    @RequestMapping("/outerTube/update")
    public String showouterTubeUpdate() {
        return "/ga/outerTube/outerTubePadute";
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
        return "redirect:/ga/show";
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
        return "redirect:/ga/show";
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

    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~应付财务~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping(value = "/payment/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String paymentList(@RequestParam(required = false) int projectId,@RequestParam(required = false) String matter,@RequestParam(required = false)String type,@RequestParam(required = false, defaultValue = "0")int pageIndex) {
        if(type==null||type.equals("")){
            type=null;
        }
        return JSONObject.toJSONString(GaPaymentService.getlist(projectId,matter,type,pageIndex)
                , SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }
    @RequestMapping("/payment/add")
    public String showPaymentAdd() {
        return "/ga/payment/paymentAdd";
    }

    @RequestMapping("/payment/addPayment")
    public String paymentAdd(GaPayment gaPayment, HttpServletRequest httpServletRequest) {
        GaPaymentService.add(gaPayment,httpServletRequest);
        return "redirect:/ga/show";
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
        return "redirect:/ga/show";
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
    @RequestMapping(value = "/payment/paymentSumPaid", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String paymentSumPaid(@RequestParam(required = false) int projectId,
                                 @RequestParam(required = false) String matter,
                                 @RequestParam(required = false) int id) {
        if(GaPaymentService.sumPaid(projectId,matter,id)==null){
            return "0";
        }else{
            return GaPaymentService.sumPaid(projectId,matter,id).toString();
        }
    }

    // endregion

    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~发票申请-~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //跳转
    @RequestMapping("/openTicket/add")
    public String openTicketAdd() {
        return "/ga/taxRevenue/add";
    }
    @RequestMapping("/openTicket/update")
    public String openTicketUpdate() {
        return "/ga/taxRevenue/update";
    }

    @RequestMapping("/openTicket/list")
    public String openTicketList(){
        return "/ga/taxRevenue/list";
    }
    @RequestMapping("/openTicket/paricular")
    public String show() {
        return "/ga/taxRevenue/paricular";
    }





    @RequestMapping(value = "/harvestTicket/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String harvestTicketList(@RequestParam(required = false)int projectId,@RequestParam(required = false)String type,@RequestParam(required = false, defaultValue = "0")int pageIndex) {
        return JSONObject.toJSONString(gaHarvestTicketService.getlist(projectId,type,pageIndex)
                , SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/harvestTicket/add")
    public String showHarvestTicketAdd() {
        return "/ga/harvestTicket/harvestTicketAdd";
    }

    @RequestMapping("/harvestTicket/addHarvestTicket")
    public String harvestTicketAdd(GaHarvestTicket gaHarvestTicket) {
        gaHarvestTicketService.add(gaHarvestTicket);
        return "redirect:/ga/show";
    }

    @RequestMapping("/harvestTicket/update")
    public String showHarvestTicketUpdate() {
        return "/ga/harvestTicket/harvestTicketUpdate";
    }

    @RequestMapping(value = "/harvestTicket/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String harvestTicketUpdateJson(@RequestParam int id) {
        return JSONObject.toJSONString(gaHarvestTicketService.getById(id)
                ,SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/harvestTicket/update.html")
    public String harvestTicketUpdate(GaHarvestTicket gaHarvestTicket) {
        gaHarvestTicketService.update(gaHarvestTicket);
        return "redirect:/ga/show";
    }


    @RequestMapping("/harvestTicket/particular")
    public String showHarvestTicketParticular() {
        return "/ga/harvestTicket/harvestTicketParticular";
    }

    @RequestMapping(value = "/harvestTicket/particular.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String harvestTicketParticular(@RequestParam int id) {
        return JSONObject.toJSONString(gaHarvestTicketService.getById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

/*    @RequestMapping(value = "/payment/delete")
    public String paymentUpdate(@RequestParam int id) {
        gaOuterTubePassService.delete(id);
        return "redirect:/ga/outerTube/query";
    }*/


    @RequestMapping("/harvestTicket/approvalDetailed")
    public String harvestTicketParticular(SysApprovalDetailed approvalDetailed, HttpSession session) {
        int userid=(int) session.getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        gaHarvestTicketService.addApproval(approvalDetailed);
        return "redirect: /showMyWork";
    }

    @RequestMapping(value = "/harvestTicket/sumCost", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String harvestTicketSumCost(Integer contractid,String type) {
        if(gaHarvestTicketService.sumCost(contractid,type)==null){
            return "0";
        }else{
            return  gaHarvestTicketService.sumCost(contractid,type).toString();
        }
    }


    // endregion

    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~工程工资~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping("/payment/addPaymentSalary")
    public String paymentSalaryAdd(@RequestBody String json, HttpServletRequest httpServletRequest) {
        gaSalaryService.add(json,httpServletRequest);
        return "redirect:/ga/show";
    }

    @RequestMapping(value = "/payment/paymentSalaryList", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String paymentSalaryList(int id,@RequestParam(required = false, defaultValue = "0")int pageIndex) {
        return JSONObject.toJSONString(gaSalaryService.getlist(id,pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/paymentSalaryUpdate/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String showPaymentSalaryUpdate(int id ) {
        return JSONObject.toJSONString(gaSalaryService.getById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/paymentSalaryUpdate/update", produces = "text/html;charset=UTF-8")
    public String paymentSalaryUpdate(@RequestBody String list ) {
        Map<String,Object> aa= JSON.parseObject(list);
        List<GaSalary> list1=JSON.parseArray(aa.get("list").toString(), GaSalary.class);
        GaPayment payment=JSON.parseObject(aa.get("payment").toString(),GaPayment.class);
        GaPaymentService.update(payment);
        for (GaSalary gaSalary : list1) {
            gaSalaryService.update(gaSalary);
        }
        return  "redirect:/ga/show";
    }

    @RequestMapping(value = "/paymentSalaryUpdate/particular.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String paymentSalaryParticular(@RequestParam int id) {
        return JSONObject.toJSONString(gaSalaryService.getByIdParticular(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    // endregion


    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~xusm····银行流水~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /*@RequestMapping(value = "/payment/bankFlow.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String bankFlow(@RequestParam(required = false, defaultValue = "0") int projectid,
                           @RequestParam(required = false) String type,
                           @RequestParam(required = false, defaultValue = "0") int pageIndex) {
        if(type==null||type==""){
            type=null;
        }
        return JSONObject.toJSONString(GaPaymentService.getBankFlow(projectid, type,pageIndex)
                , SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }*/

    //endregion~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~税收项计算~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping(value = "/harvestTicket/sumMoneyAndCompanyName", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String sumMoneyAndCompanyName(@RequestParam(required = false, defaultValue = "0") int projectid){
        return JSONObject.toJSONString(gaHarvestTicketService.getSumMoneyAndCompanyName(projectid),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }


    //endregion~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~往来款~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping(value = "/comego/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String comegoList(@RequestParam(required = false) int projectId,@RequestParam(required = false) String matter,
                             @RequestParam(required = false)String type,@RequestParam(required = false)String type2
            ,@RequestParam(required = false, defaultValue = "0")int pageIndex) {
        if(type==null||type.equals("")){
            type=null;
        }
        if(type2==null||type2.equals("")){
            type2=null;
        }
        return JSONObject.toJSONString(gaComeGoService.getlist(projectId,matter,type,type2,pageIndex)
                , SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }


    @RequestMapping("/comego/addComeGo")
    public String comegoAdd(GaComeGO gaComeGO, HttpServletRequest httpServletRequest) {
        gaComeGoService.add(gaComeGO,httpServletRequest);

        return "redirect:/ga/show";
    }



    @RequestMapping(value = "/comego/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String comegoUpdateJson(@RequestParam int id) {
        return JSONObject.toJSONString(gaComeGoService.getById(id)
                , SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/comego/update.html")
    public String comegoUpdate(GaComeGO gaComeGO) {
        gaComeGoService.update(gaComeGO);
        return "redirect:/ga/show";
    }



    @RequestMapping(value = "/comego/particular.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String comegoParticular(@RequestParam int id) {
        return JSONObject.toJSONString(gaComeGoService.getById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

/*    @RequestMapping(value = "/payment/delete")
    public String paymentUpdate(@RequestParam int id) {
        gaOuterTubePassService.delete(id);
        return "redirect:/ga/outerTube/query";
    }*/




    @RequestMapping("/comego/approvalDetailed")
    public String comegoParticular(SysApprovalDetailed approvalDetailed, HttpSession session) {
        int userid=(int) session.getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        GaPaymentService.addApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }


    //endregion~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~跳转~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //合同付款
    @RequestMapping("/payment/purchase/add")
    public String purchaseAdd(){
        return "/ga/expenditure/sale/add";
    }
    //项目工资付款
    @RequestMapping("/payment/salary/add")
    public String salaryAdd(){
        return "/ga/expenditure/wages/add";
    }

    @RequestMapping("/payment/common/add")
    public String commonAdd(){
        return "/ga/expenditure/add";
    }


    @RequestMapping("/payment/purchase/update")
    public String purchaseUpdate(){
        return "/ga/expenditure/sale/update";
    }

    @RequestMapping("/payment/salary/update")
    public String salaryUpdate(){
        return "/ga/expenditure/wages/update";
    }

    @RequestMapping("/payment/common/update")
    public String commonUpdate(){
        return "/ga/expenditure/update";
    }

    @RequestMapping("/payment/purchase/list")
    public String purchaseList(){
        return "/ga/expenditure/sale/list";
    }

    @RequestMapping("/payment/salary/list")
    public String salaryList(){
        return "/ga/expenditure/wages/list";
    }

    @RequestMapping("/payment/common/list")
    public String commonList(){
        return "/ga/expenditure/list";
    }

    @RequestMapping("/payment/purchase/particular")
    public String purchaseParticular(){
        return "/ga/expenditure/sale/particular";
    }

    @RequestMapping("/payment/salary/particular")
    public String salaryParticular(){
        return "/ga/expenditure/wages/particular";
    }

    @RequestMapping("/payment/common/particular")
    public String commonParticular(){
        return "/ga/expenditure/particular";
    }





    //合约
    @RequestMapping("/contract/add")
    public String contractAdd(){
        return "/ga/contract/add";
    }

    @RequestMapping("/contract/update")
    public String contractUpdate(){
        return "/ga/contract/update";
    }

    @RequestMapping("/contract/list")
    public String contractList(){
        return "/ga/contract/list";
    }

    @RequestMapping("/contract/particular")
    public String contractParicular(){
        return "/ga/contract/particular";
    }
    //往来款
    @RequestMapping("/comego/add")
    public String comegoAdd(){
        return "/ga/comego/add";
    }

    @RequestMapping("/comego/update")
    public String comegoUpdate(){
        return "/ga/comego/update";
    }

    @RequestMapping("/comego/list")
    public String comegoList(){
        return "/ga/comego/list";
    }

    @RequestMapping("/comego/particular")
    public String comegoParicular(){
        return "/ga/comego/particular";
    }


    //我的工作
    @RequestMapping("/harvestTicket/approval")
    public String harvestTicketApproval(){
        return "/ga/mywork/myGaContract";
    }

    @RequestMapping("/openTicket/approval")
    public String openTicketApproval(@RequestParam String type){
        if(type.equals("往来收入")){
            return "/ga/mywork/myGaComego-N";
        }
        if(type.equals("项目收入")){
            return "/ga/mywork/myGaContract";
        }
        if(type.equals("合约")){
            return "/ga/mywork/myGaTaxRevenue";
        }

        return "redirect: /showMyWork";
    }

    @RequestMapping("/payment/approval")
    public String paymentApproval(@RequestParam String type){
        if(type.equals("合同付款")){
            return "/ga/mywork/myGaSale";
        }
        if(type.equals("工资付款")){
            return "/ga/mywork/myGaWages";
        }
        if(type.equals("其他付款")){
            return "/ga/mywork/myGaExpenditure";
        }
        if(type.equals("往来款付款")){
            return "/ga/mywork/myGaComego";
        }
        return "redirect: /showMyWork";
    }
    @RequestMapping("/outerTube/approval")
    public String outerTubeApproval(){
        return "/ga/mywork/myGaOuterTube";
    }


    //endregion~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~xusm····银行流水~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping("/journal/Account")
    public String toOuterTubeList() {
        return "/ga/journal/Account";
    }

    @RequestMapping("/journal/Bank")
    public String tobankOuterTubeList() {
        return "/ga/journal/Bank";
    }


    @RequestMapping(value = "/payment/bankFlow.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String bankFlow(@RequestParam(required = false, defaultValue = "0") int projectid,
                           @RequestParam(required = false) String type) {

        if(type==null||type==""){
            type=null;
        }
        return JSONObject.toJSONString(GaPaymentService.getBankFlow(projectid, type)
                , SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }


}