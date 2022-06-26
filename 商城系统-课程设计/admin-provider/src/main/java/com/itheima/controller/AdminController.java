package com.itheima.controller;

/**
 * Created by itcast on 2019/10/31.
 */
import com.itheima.b2b.commonmodule.model.User;
import com.itheima.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {


    @Autowired
    AdminDao adminDao;



    @RequestMapping(value = "/AgetAllusers",method = RequestMethod.GET)
    public List<User> getAllusers(){
        return adminDao.getAllusers();
    };

    @RequestMapping(value = "/AdeleteUserByid" ,method = RequestMethod.GET)
    public int deleteUserByid(@RequestParam(value = "uid") int uid){
        return adminDao.deleteUserByid(uid);

    }



}

