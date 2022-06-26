package com.itheima.adminconsumer.hystrix;


import com.itheima.b2b.commonmodule.model.User;
        import com.itheima.adminconsumer.service.AdminService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminServiceHystrix implements AdminService {


    @Override
    public List<User> getAllusers() {
        return null;
    }

    @Override
    public int deleteUserByid(int uid) {
        return 0;
    }
}
