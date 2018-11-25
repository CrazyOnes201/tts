package com.dbsd6th.controller;

import com.dbsd6th.entity.User;
import com.dbsd6th.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/login",method=RequestMethod.POST)
    public String login(HttpSession session, @ModelAttribute User user, Model model){
        int flag = this.userService.userLogin(user.getId(),user.getPassword());
        if(flag==0){
            System.out.println("系统不存在该用户！");
            model.addAttribute("result","0");
        }else if(flag==1) {
            System.out.println("登陆成功！");
            User getUser = this.userService.selectUser(user.getId());
            model.addAttribute("result", "1");
            session.setAttribute("user",getUser);
        }else{
            model.addAttribute("result","-1");
            System.out.println("密码错误，登录失败！");
        }
        return "index";
    }

}
