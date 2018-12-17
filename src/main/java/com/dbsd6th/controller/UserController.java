package com.dbsd6th.controller;

import com.dbsd6th.entity.User;
import com.dbsd6th.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(value = "/regist",method= RequestMethod.POST)
    public String regist(@ModelAttribute User user, Model model){
        if(this.userService.userRegist(user)==true){
            System.out.println("注册成功");
        }else{
            System.out.println("注册失败");
        }
        return "regist";
    }

    /**
     * 登录接口
     * @author CrazyWalker
     * @param session http session
     * @param userData 传入的登陆信息 loginname:手机号或邮箱  password:用户密码
     * @param model 返回model
     * @return 登陆成功则进入查票页，登陆失败则提示失败
     */
    @RequestMapping(value = "/login",method=RequestMethod.POST)
    public String login(HttpSession session, @RequestBody HashMap<String, String> userData, Model model){
        String password = userData.get("password") == null ? "" : userData.get("password");
        String loginName = userData.get("loginname") == null ? "" : userData.get("loginname");
        User user = new User();
        user.setPassword(password);
        String[] emailString = loginName.split("@");
        if(emailString.length == 1) {
            user.setPhone(loginName);
        } else {
            user.setEmail(loginName);
        }
        User selectUser = userService.userLogin(user);
        if(selectUser == null){
            model.addAttribute("result","0");
            return "tots/login";
        }else {
            model.addAttribute("result", "1");
            selectUser.setIdentityNum("");
            session.setAttribute("user", selectUser);
            return "tots/searchTicket";
        }

    }

}
