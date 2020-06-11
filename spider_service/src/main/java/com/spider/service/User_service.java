package com.spider.service;

import com.spider.bean.Userdb;
import com.spider.bean.UserdbExample;
import com.spider.mapper.UserdbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_service {

    @Autowired
    private UserdbMapper userdbMapper;

    //登陆
    public Userdb login(String username,String password){
        //用户名
        UserdbExample usernameexample = new UserdbExample();
        UserdbExample.Criteria usernameexampleCriteria = usernameexample.createCriteria();
        usernameexampleCriteria.andUidEqualTo(username);
        List<Userdb> userdbs = userdbMapper.selectByExample(usernameexample);
        if (userdbs!=null&&userdbs.size()>0){
            //密码
            usernameexampleCriteria.andPassEqualTo((password));
            List<Userdb> userdbs1 = userdbMapper.selectByExample(usernameexample);
            if (userdbs1!=null&&userdbs1.size()>0){
                return userdbs1.get(0);
            }
        }
        return null;
    }
}
