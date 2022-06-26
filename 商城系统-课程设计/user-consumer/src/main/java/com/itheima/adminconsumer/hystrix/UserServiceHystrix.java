package com.itheima.adminconsumer.hystrix;


import com.itheima.b2b.commonmodule.model.User;
        import com.itheima.adminconsumer.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceHystrix implements UserService {
    @Override
    public User login(String uaccount) {
        return null;
    }

    @Override
    public int register(String upassword, String uname, String usex) {
        return 0;
    }

    @Override
    public int updateuserinfo(String upassword, String uname, String usex, int uaccount) {
        return 0;
    }


    @Override
    public User getuserbyid(int uid) {
        return null;
    }

    @Override
    public List<User> getAllusers() {
        return null;
    }

    @Override
    public int deleteUserByid(int uid) {
        return 0;
    }
}
