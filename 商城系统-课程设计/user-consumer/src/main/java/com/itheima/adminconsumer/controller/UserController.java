package com.itheima.adminconsumer.controller;

import com.itheima.b2b.commonmodule.model.User;
import com.itheima.adminconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;
     //跳转登录界面
    @GetMapping(value = "/tologin")
    public String tologin() {
        return "login";
    }
     // 跳转注册界面
    @GetMapping(value = "/toregister")
    public String toregister() {
        return "register";
    }

    @GetMapping(value = "/tousersinfo")
    public String tousersinfo(HttpServletRequest request,String uaccount,String uname,String upassword,HttpSession session) {

        session.setAttribute("uaccount",uaccount);
        session.setAttribute("uname",uname);
        session.setAttribute("upassword",upassword);
        List<User> users = userService.getAllusers();
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
        int i = userService.deleteUserByid(Integer.parseInt(uid));
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
        List<User> users = userService.getAllusers();
        request.setAttribute("users",users);
//        System.out.println(uaccount+uname+upassword);


//        System.out.println("i是不是等于1？"+i);
        return "usersinfo";

    }



    //跳转用户个人信息修改界面
    @GetMapping(value = "/toupdateuserinfo")
    public String toupdateuserinfo(HttpServletRequest request,String uaccount,HttpSession session) {
        session.setAttribute("uaccount",uaccount);
        String a = (String)session.getAttribute("uaccount");
        int uid = Integer.parseInt(a);
        User userinfo = userService.getuserbyid(uid);
        System.out.println(uid);
       request.setAttribute("userinfo",
                userinfo);
        return "userinfo";
    }




     // 用户登录
    @GetMapping(value = "/login")
    public String login(String uname, String upassword, HttpServletRequest request) {
       if (userService.login(uname) != null) {
            if (userService.login(uname).getUpassword().equals(upassword)){
                HttpSession session = request.getSession(true);
                User user = userService.login(uname);
                String uaccount =(user.getUaccount());
                session.setAttribute("uaccount",uaccount);
                String a = (String)session.getAttribute("uaccount");
                int b = Integer.parseInt(a);
                System.out.println("b="+b);
              return "redirect:http://localhost:8896/goods/getAll?uaccount="+userService.login(uname).getUaccount()+"&upassword="+userService.login(uname).getUpassword()+"&uname="+userService.login(uname).getUname();
            }
        }
       // request.setAttribute("mag","账号密码错误");
        System.out.print("登录成功");
        return "login";
    }
    //用户注册
    @GetMapping(value = "/register")
    public String register(HttpServletRequest request,String upassword,String uname,String usex) {
       if(userService.register(upassword, uname, usex)>0){
           System.out.print("注册成功");
           return "login";
       }
        System.out.print("注册失败");
        return "register";
    }

    //用户info界面修改用户信息：
    @GetMapping(value = "/updateuserinfo")
    public String updateuserinfo(HttpServletRequest request,String upassword,String uname,String usex,String uaccount) {


        System.out.println(uaccount+uname+upassword+usex);

        System.out.println( Integer.parseInt(uaccount));


    if(userService.updateuserinfo(upassword, uname, usex,Integer.parseInt(uaccount))>0){
            System.out.print("修改用户个人成功");
            return "redirect:http://localhost:8896/goods/getAll?uaccount="+userService.login(uname).getUaccount()+"&upasswoed="+userService.login(uname).getUpassword()+"&uname="+userService.login(uname).getUname();
        }else {
        System.out.print("修改用户个人信息失败");

        return "userinfoerror";
    }

    }


}