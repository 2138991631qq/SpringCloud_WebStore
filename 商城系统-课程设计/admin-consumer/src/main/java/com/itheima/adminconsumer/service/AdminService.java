package com.itheima.adminconsumer.service;

import com.itheima.b2b.commonmodule.model.User;
import com.itheima.adminconsumer.hystrix.AdminServiceHystrix;
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
@FeignClient(value = "b2b-admin-provider",fallback = AdminServiceHystrix.class)
public interface AdminService {



    @RequestMapping(value = "/AgetAllusers",method = RequestMethod.GET)
    public List<User> getAllusers();


    @RequestMapping(value = "/AdeleteUserByid" ,method = RequestMethod.GET)
    public int deleteUserByid(@RequestParam(value = "uid") int uid);







}
