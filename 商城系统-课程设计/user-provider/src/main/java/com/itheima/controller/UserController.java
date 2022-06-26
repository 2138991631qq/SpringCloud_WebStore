package com.itheima.controller;

/**
 * Created by itcast on 2019/10/31.
 */
import com.itheima.b2b.commonmodule.model.User;
import com.itheima.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDao userDao;


    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public int register(@RequestParam(value = "upassword")String
                                upassword, @RequestParam(value = "uname")String uname,
                        @RequestParam(value = "usex") String usex){
        return userDao.register(upassword,uname,usex);
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public User login(@RequestParam("uname") String uname){
        return userDao.login(uname);
    }

    @RequestMapping(value = "/updateuserinfo",method = RequestMethod.GET)
    public int updateuserinfo(@RequestParam(value = "upassword")String
                                upassword, @RequestParam(value = "uname")String uname,
                        @RequestParam(value = "usex") String usex,
                              @RequestParam(value = "uaccount") int uaccount){

        System.out.println(upassword+uaccount+uname+usex);


        return userDao.updateuserinfo(upassword,uname,usex,uaccount);


    }




    @RequestMapping(value = "/getuserbyid",method = RequestMethod.GET)
    public User getuserbyid(@RequestParam("uid") int uid){
        return userDao.getuserbyid(uid);
    }

    @RequestMapping(value = "/getAllusers",method = RequestMethod.GET)
    public List<User> getAllusers(){
        return userDao.getAllusers();
    };

    @RequestMapping(value = "/deleteUserByid" ,method = RequestMethod.GET)
    public int deleteUserByid(@RequestParam(value = "uid") int uid){
        return userDao.deleteUserByid(uid);

    }



}

