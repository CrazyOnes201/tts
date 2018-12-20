package com.dbsd6th.controller;

import com.dbsd6th.entity.User;
import com.dbsd6th.service.UserService;
import com.dbsd6th.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author hjs
 * @date 2018/11/23 13:11
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;


    //注册
    @RequestMapping(value = "/register",method= RequestMethod.POST)
    public String regist(@ModelAttribute("user") User user, Model model){
        if(this.userService.userRegist(user)==true){
            System.out.println("注册成功");
        }else{
            System.out.println("注册失败");
        }
        return "/tots/login";
    }

    /**
     * 登录接口
     * @author CrazyWalker
     * @param session http session
     * @param loginName 传入的登陆信息 手机号或邮箱
     * @param password 传入的登陆信息 用户密码
     * @param model 返回model
     * @return 登陆成功则进入查票页，登陆失败则提示失败
     */
    @RequestMapping(value = "/login",method=RequestMethod.POST)
    public String login(HttpSession session, @RequestParam("loginname") String loginName,
                        @RequestParam("password") String password, Model model){
        User user = new User();
        user.setPassword(password);
        String[] emailString = loginName.split("@");
        if(emailString.length == 1) {
            user.setPhone(loginName);
        } else {
            user.setEmail(loginName);
        }
        User selectUser = userService.userLogin(user);
        if(selectUser == null || selectUser == null ||
                !selectUser.getPassword().equals(user.getPassword())){
            model.addAttribute("result","0");
            return "tots/login";
        }else {
            model.addAttribute("result", "1");
            selectUser.setIdentityNum("");
            session.setAttribute("user", selectUser);
            return "tots/searchTicket";
        }

    }

    /**
     *
     * @author CrazyWalker
     * @param session http session
     * @return 注销成功则返回登陆页面
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/tots/login";
    }

    @RequestMapping(path = "/operateUser", method = RequestMethod.POST)
    public String operateUser(String userName, String password, String phone,
                              String identityNum, String email, String operationType) {
        if(StringUtil.isEmpty(identityNum)) {
            return "/admin/form-amazeui";
        }
        User user = new User();
        user.setUserName(userName.equals("") ? null : userName);
        user.setPhone(phone.equals("") ? null : phone);
        user.setPassword(password.equals("") ? null : password);
        user.setIdentityNum(identityNum);
        user.setEmail(email.equals("") ? null : email);
        if (operationType.equals("a")) {
            userService.userRegist(user);
        } else if (operationType.equals("b")) {
            userService.updateUserByIdentityNum(user);
        } else {
            userService.deleteUserByIdentityNum(user.getIdentityNum());
        }

        return "/admin/form-amazeui";
    }

}
