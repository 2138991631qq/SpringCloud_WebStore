package com.itheima.adminconsumer.service;

import com.itheima.b2b.commonmodule.model.User;
import com.itheima.adminconsumer.hystrix.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Classname LoginService
 * @Description TODO
 * @Date 2019-9-10 11:29
 * @Created by CrazyStone
 */
@Component
@FeignClient(value = "b2b-user-provider",fallback = UserServiceHystrix.class)
public interface UserService {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public User login(@RequestParam(value = "uname") String uname);

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public  int register(@RequestParam(value = "upassword")String upassword, @RequestParam(value = "uname")String uname, @RequestParam(value = "usex") String usex);

    @RequestMapping(value = "/updateuserinfo",method = RequestMethod.GET)
    public  int updateuserinfo(@RequestParam(value = "upassword")String upassword, @RequestParam(value = "uname")String uname, @RequestParam(value = "usex") String usex, @RequestParam(value = "uaccount") int uaccount);

    @RequestMapping(value = "/getuserbyid",method = RequestMethod.GET)
    public  User getuserbyid(@RequestParam(value = "uid")int uid);


    @RequestMapping(value = "/getAllusers",method = RequestMethod.GET)
    public List<User> getAllusers();


    @RequestMapping(value = "/deleteUserByid" ,method = RequestMethod.GET)
    public int deleteUserByid(@RequestParam(value = "uid") int uid);







}
