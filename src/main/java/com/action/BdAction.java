package com.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.BdClient;
import com.beans.BdClientContacts;
import com.beans.BdProject;
import com.beans.SysApprovalDetailed;
import com.service.bd.BdClientContactsService;
import com.service.bd.BdClientService;
import com.service.bd.BdProjectService;
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
 * @create 2019/3/4 14:30
 */
@Controller
@RequestMapping("/bd")
public class BdAction {

    @Resource(name = "bdClientService")
    private BdClientService bdClientService;
    @Resource(name = "bdClientContactsService")
    private BdClientContactsService bdClientContactsService;
    @Resource(name = "bdProjectService")
    private BdProjectService bdProjectService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        //true:允许输入空值，false:不能为空值
    }

    @RequestMapping("/client/query")
    public String getBdClient() {
        return "bd/client/clientList";
    }

    @RequestMapping(value = "/client/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getBdClientIson(@RequestParam(required = false) String name, @RequestParam(required = false) String address,
                                  @RequestParam(required = false) String unitType, @RequestParam(required = false, defaultValue = "0") int userid,
                                  @RequestParam(required = false, defaultValue = "0") int pageIndex) {
        if (name == null || name == "") {
            name = null;
        }
        if (address == null || address == "") {
            address = null;
        }
        if (unitType == null || unitType == "") {
            unitType = null;
        }
        return JSONObject.toJSONString(bdClientService.getList(name, address, unitType, userid, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/client/getAddres", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAddres() {
        return JSONObject.toJSONString(bdClientService.getAddres(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/client/deptUser")
    public String showDeptUser() {
        return "selectUser";
    }

    @RequestMapping("/client/add")
    public String showAddBdClient() {
        return "bd/client/clientAdd";
    }

    @RequestMapping(value = "/client/add.html")
    public String addBdClient(BdClient client, Model model) {
        if (bdClientService.add(client) > 0) {
            return "redirect:/bd/client/query";
        } else {
            model.addAttribute("error", "添加失败");
            return "/bd/client/add";



        }
    }

    @RequestMapping("/client/update")
    public String showUpdateBdClient(@RequestParam int id, Model model) {
        model.addAttribute("client", bdClientService.getClientById(id));
        return "bd/client/clientUpdate";
    }

    @RequestMapping("/client/update.html")
    public String updateBdClientHtml(BdClient client) {
        bdClientService.update(client);
        return "redirect:/bd/client/query";
    }

    @RequestMapping("/client/delete")
    public String deleteBdClient(@RequestParam int id) {
        bdClientService.deleteById(id);
        return "redirect:/bd/client/query";
    }

    @RequestMapping("/client/particular")
    public String BdClientParticular(@RequestParam int id, Model model) {
        model.addAttribute("client", bdClientService.getClientById(id));
        return "/bd/client/clientParticular";
    }

    @RequestMapping(value = "/client_contacts/add")
    public String showclientContactsAdd() {
        return "/bd/clientContacts/clientContactsAdd";
    }

    @RequestMapping(value = "/client_contacts/add.html")
    public String clientContactsAdd(BdClientContacts clientContacts) {
        bdClientContactsService.add(clientContacts);
        return "redirect:/bd/client_contacts/query";
    }

    @RequestMapping(value = "/client_contacts/query")
    public String showClientContactsList() {
        return "/bd/clientContacts/clientContactsList";
    }

    @RequestMapping(value = "/client_contacts/list", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String clientContactsList(@RequestParam(required = false) String name, @RequestParam(required = false) String clientname,
                                     @RequestParam(required = false, defaultValue = "0") int pageIndex
    ) {
        if (name == null || name == "") {
            name = null;
        }
        if (clientname == null || clientname == "") {
            clientname = null;
        }
        return JSONObject.toJSONString(bdClientContactsService.getList(name, clientname, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/client_contacts/update")
    public String showUpdateClientContacts(Model model, @RequestParam("id") int id) {
        model.addAttribute("clientName", bdClientService.getClientName());
        model.addAttribute("clientContacts", bdClientContactsService.getListById(id));
        return "/bd/clientContacts/clientContactsUpdate";
    }

    @RequestMapping(value = "/client_contacts/update.html")
    public String updateClientContacts(BdClientContacts clientContacts) {
        bdClientContactsService.update(clientContacts);
        return "redirect:/bd/client_contacts/query";
    }

    @RequestMapping(value = "/client_contacts/clientContactsParticular")
    public String clientContactsParticular(Model model, @RequestParam("id") int id) {
        model.addAttribute("clientContacts", bdClientContactsService.getListById(id));
        return "/bd/clientContacts/clientContactsParticular";
    }

    @RequestMapping("/project/query")
    public String showProjectList() {
        return "/bd/project/projectList";
    }

    @RequestMapping(value = "/project/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String ProjectList(@RequestParam(required = false) String projectName,
                              @RequestParam(required = false, defaultValue = "0") int deptid,
                              @RequestParam(required = false) String stage,
                              @RequestParam(required = false, defaultValue = "0") int areaManager,
                              @RequestParam(required = false) String principalName,
                              @RequestParam(required = false) Date start,
                              @RequestParam(required = false) Date end,
                              @RequestParam(required = false, defaultValue = "0") int pageIndex,
                              HttpSession session) {
        if (projectName == null || projectName == "") {
            projectName = null;
        }
        if (stage == null || stage == "") {
            stage = null;
        }
        if (principalName == null || principalName == "") {
            principalName = null;
        }

        int userid = (int) session.getAttribute("userId");
        if (userid==1){
            userid=0;
        }

        return JSONObject.toJSONString(bdProjectService.getlist(userid,projectName, deptid, stage, areaManager,principalName, start, end, pageIndex)
                , SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/project/add")
    public String showProjectAdd() {
        return "/bd/project/projectAdd";
    }

    @RequestMapping("/project/addProject")
    public String projectAdd(BdProject project, HttpServletRequest httpServletRequest) {
        bdProjectService.add(project, httpServletRequest);
        return "redirect:/bd/project/query";
    }

    @RequestMapping("/project/update")
    public String showProjectUpdate(@RequestParam int id, Model model) {
        return "/bd/project/projectUpdate";
    }

    @RequestMapping(value = "/project/update.html")
    public String projectUpdate(BdProject project) {
        bdProjectService.update(project);
        return "redirect:/bd/project/query";
    }

    @RequestMapping(value = "/project/update.json", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String projectUpdateJson(@RequestParam int id) {
        return JSONObject.toJSONString(bdProjectService.getProjectById(id)
                , SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/project/particular")
    public String showProjectParticular() {
        return "/bd/project/projectParticular";
    }

    @RequestMapping("/project/particular.html")
    @ResponseBody
    public String projectParticular(@RequestParam int id) {
        return JSONObject.toJSONString(bdProjectService.getProjectById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }
    @RequestMapping("/project/approvalDetailed")
    public String projectParticular(SysApprovalDetailed approvalDetailed,HttpServletRequest request) {
        int userid = (int)request.getSession().getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        bdProjectService.addProjectApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }

}