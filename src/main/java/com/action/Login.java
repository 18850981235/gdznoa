package com.action;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.SysUser;
import com.service.sys.AuthorityService;
import com.service.sys.MenuService;
import com.service.sys.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/page")
public class Login {
    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "menuService")
    private MenuService menuService;
    @Resource(name = "authorityService")
    private AuthorityService authorityService;

    /**
     * 登录页面
     *
     * @return 登录页面视图
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 首页
     *
     * @return 首页视图
     */
    @RequestMapping("/sign")
    public String sign() {
        return "sign";
    }

    /**
     * 登录验证
     *
     * @param account  账号
     * @param password 密码
     * @return 视图
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String account,
                        @RequestParam String password,
                        Model model, HttpSession session) {
        SysUser user = userService.getByAccount(account);
        if (user == null) {
            model.addAttribute("error", "没有该账号");
            return "index";
        } else {
            if (!user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
                model.addAttribute("error", "密码错误");
                model.addAttribute("account", account);
                return "index";
            }
        }
        session.setAttribute("user", user);
        session.setAttribute("userId", user.getId());
        //return "sign";
        return "topleft";
    }

    /**
     * 注册
     *
     * @return 注册视图
     */
    @RequestMapping("/register")
    public String zhuce() {
        return "register";
    }

    /**
     * 注册验证
     *
     * @param mobile     账号
     * @param password   密码
     * @param name       名字
     * @param verifyCode 验证码
     * @return 状态
     */
    @RequestMapping(value = "register.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String register(@RequestParam String mobile,
                           @RequestParam String password, @RequestParam String name,
                           @RequestParam String verifyCode, HttpSession session) {
        JSONObject json = (JSONObject) session.getAttribute("json");
        if (json == null) {
            return "验证码错误";
        }
        if (!json.getString("mobile").equals(mobile)) {
            return "手机号码错误";
        }
        if (!json.getString("verifyCode").equals(verifyCode)) {
            return "验证码错误";
        }
        if ((System.currentTimeMillis() - json.getLong("createTime")) > 1000 * 60 * 5) {
            return "验证码过期";
        }
        userService.register(name, password, mobile);
        session.removeAttribute("json");
        return "注册成功";
    }


    /**
     * 验证码发送
     *
     * @param mobile 账号
     * @return 是否发送成功
     */
    @RequestMapping("/sendSms.json")
    @ResponseBody
    public String sendSms(@RequestParam String mobile, HttpSession session) {
        JSONObject json = userService.verify(mobile);
        if (json.get("status").equals("success")) {
            session.setAttribute("json", json);
            return "success";
        } else {
            return "fail";
        }
    }

    /**
     * 验证手机是否存在
     *
     * @param mobile 账号
     * @return 是否注册过
     */
    @RequestMapping(value = "isAccount.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String isAccount(@RequestParam(required = false) String mobile) {
        if (userService.isAccount(mobile)) {
            return "手机可以使用";
        } else {
            return "该手机已被注册过";
        }
    }

    /**
     * a
     * 退出用户
     *
     * @return 登录视图
     */
    @RequestMapping("/quit")
    public String quit(HttpSession session) {
        session.removeAttribute("user");
        session.removeAttribute("userId");
        return "redirect:/index";
    }

    /**
     * 修改用户密码
     *
     * @param mobile      账号
     * @param newpassword 新密码
     * @return 视图名
     */
    @RequestMapping("/updatePassword")
    public String updatePassword(@RequestParam String mobile, @RequestParam String newpassword) {
        if (userService.updatePassWord(mobile, newpassword) > 0) {
            return "redirect:/index";
        } else {
            return "";
        }
    }

    /**
     * 查询菜单栏跟用户权限
     *
     * @return 查询菜单栏跟用户权限集合
     */

    @RequestMapping(value = "/menu", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String menuList(HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        map.put("menuList", menuService.getMenuList(0));
        //int userid=(int)session.getAttribute("userId");
        int userid = 1;
        map.put("authority", authorityService.getMenuIdByUserId(userid));
        return JSONObject.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteNullStringAsEmpty);
    }
}
