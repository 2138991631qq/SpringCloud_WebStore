package com.itheima.adminconsumer.controller;

import com.itheima.b2b.commonmodule.model.User;
import com.itheima.adminconsumer.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;


    @GetMapping(value = "/tousersinfo")
    public String tousersinfo(HttpServletRequest request,String uaccount,String uname,String upassword,HttpSession session) {

        session.setAttribute("uaccount",uaccount);
        session.setAttribute("uname",uname);
        session.setAttribute("upassword",upassword);
        List<User> users = adminService.getAllusers();
        request.setAttribute("users",users);
        System.out.println(uaccount+uname+upassword);
        return "usersinfo";
//        return "a";

    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(HttpServletRequest request,String uid,HttpSession session) {

//        System.out.println("session的uname为测试一下"+session.getAttribute("uname"));
//        System.out.println(session.getAttribute("upassword"));
//        System.out.println(session.getAttribute("uaccount"));
        System.out.println("uid为+++++"+uid);
        int i = adminService.deleteUserByid(Integer.parseInt(uid));
//        return "usersinfo";

        System.out.println("i是不是等于1？"+i);
//        return "a";

        return "redirect:/admin/afterDeleteUser";
    }


    @GetMapping(value = "/afterDeleteUser")
    public String afterDeleteUser(HttpServletRequest request,HttpSession session) {

        System.out.println("session的uname为测试一下"+session.getAttribute("uname"));
        System.out.println(session.getAttribute("upassword"));
        System.out.println(session.getAttribute("uaccount"));
//        System.out.println("uid为+++++"+uid);
//        int i = userService.deleteUserByid(Integer.parseInt(uid));
//        return "usersinfo";
        List<User> users = adminService.getAllusers();
        request.setAttribute("users",users);
//        System.out.println(uaccount+uname+upassword);


//        System.out.println("i是不是等于1？"+i);
        return "usersinfo";

    }







}