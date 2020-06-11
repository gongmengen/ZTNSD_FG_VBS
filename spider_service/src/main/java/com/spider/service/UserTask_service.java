package com.spider.service;

import com.spider.bean.UserTask;
import com.spider.bean.UserTaskExample;
import com.spider.bean.Userdb;
import com.spider.bean.UserdbExample;
import com.spider.mapper.UserTaskMapper;
import com.spider.mapper.UserdbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserTask_service {
    @Autowired
    private UserTaskMapper userdbMapper;

    //登陆
    public UserTask login(String username, String password){
        //用户名
        UserTaskExample usernameexample = new UserTaskExample();
        UserTaskExample.Criteria usernameexampleCriteria = usernameexample.createCriteria();
        usernameexampleCriteria.andNameEqualTo(username);
        List<UserTask> userdbs = userdbMapper.selectByExample(usernameexample);
        if (userdbs!=null&&userdbs.size()>0){
            //密码
            usernameexampleCriteria.andPassEqualTo((password));
            List<UserTask> userdbs1 = userdbMapper.selectByExample(usernameexample);
            if (userdbs1!=null&&userdbs1.size()>0){
                return userdbs1.get(0);
            }
        }
        return null;
    }

    public List<UserTask> getUserTaskList() {
        //获取可接受任务用户
        return userdbMapper.getUserTaskList();
    }

    public void addUserTask(String name, String password) {
        UserTask userTask = new UserTask();
        userTask.setName(name);
        userTask.setPass(password);
        userdbMapper.insertSelective(userTask);
    }

    public String getUserTaskWebsiteids(String userName) {
        UserTaskExample example = new UserTaskExample();
        UserTaskExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(userName);
        List<UserTask> userTaskList = userdbMapper.selectByExample(example);
        String websiteids = "";
        for (UserTask user:userTaskList
             ) {
            websiteids+=user.getWebsiteid()+" ";
        }
        websiteids = websiteids.trim().replaceAll(" ",",");
        return websiteids;
    }

    public void addUserTaskWithWebsiteid(String[] websiteids, String username) {
        UserTaskExample example = new UserTaskExample();
        UserTaskExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(username);
        List<UserTask> userTaskList = userdbMapper.selectByExample(example);
        UserTask userTask = userTaskList.get(0);
        for (String websiteid:websiteids
             ) {
            userTask.setId(null);
            userTask.setWebsiteid(Integer.parseInt(websiteid));
            userdbMapper.insertSelective(userTask);
        }

    }
}
