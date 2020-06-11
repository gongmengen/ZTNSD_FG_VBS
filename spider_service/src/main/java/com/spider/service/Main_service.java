package com.spider.service;

import com.spider.bean.MainExample;
import com.spider.bean.MainWithBLOBs;
import com.spider.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Main_service {

    @Autowired
    private MainMapper mainMapper;

    public int insert(MainWithBLOBs main){
        return mainMapper.insert(main);
    }

    public String getMaxRjs8(String username) {
        return mainMapper.findMaxRjs8(username);
    }

    public List<MainWithBLOBs> getMainListWithRjs0(String rjs0){
        MainExample mainExample = new MainExample();
        MainExample.Criteria criteria = mainExample.createCriteria();
        criteria.andRjs0EqualTo(rjs0);
        return mainMapper.selectByExampleWithBLOBs(mainExample);
    }

    public List<MainWithBLOBs> getMainListWithRjs12(String rjs12){
        MainExample mainExample = new MainExample();
        MainExample.Criteria criteria = mainExample.createCriteria();
        criteria.andRjs12EqualTo(rjs12);
        return mainMapper.selectByExampleWithBLOBs(mainExample);
    }
}
