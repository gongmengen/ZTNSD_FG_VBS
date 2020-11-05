package com.spider.service;

import cn.hutool.core.util.StrUtil;
import com.spider.bean.Main;
import com.spider.bean.MainExample;
import com.spider.bean.MainWithBLOBs;
import com.spider.mapper.MainMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Main_service {

    @Autowired
    private MainMapper mainMapper;

    public int insert(MainWithBLOBs main){
        //插入之前获取lawlevel
        return mainMapper.insert(getLawlevel(main));
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

    public List<MainWithBLOBs> getListByAppuser(String appuser) {
        return mainMapper.getListByAppuser(appuser);
    }

    public List<MainWithBLOBs> getMarkListByAppuser(String appuser) {
        return mainMapper.getMarkListByAppuser(appuser);
    }
    public boolean deleteByNumbers(String[] id) {
        boolean flag = true;
        for (String number : id) {
            if (mainMapper.deleteByPrimaryKey(Long.parseLong(number))<0){
                flag = false;
            }
        }
        return flag;

    }

    public MainWithBLOBs getMainByNumber(long number) {
        return mainMapper.selectByPrimaryKey(number);
    }

    public List<MainWithBLOBs> getMainByNumbers(String[] id) {

        List<MainWithBLOBs> mains = new ArrayList<MainWithBLOBs>();
        for (String s : id) {
            mains.add(mainMapper.selectByPrimaryKey(Long.parseLong(s)));
        }
        return mains;
    }

    public boolean update(MainWithBLOBs main) {
        MainExample mainExample = new MainExample();
        MainExample.Criteria criteria = mainExample.createCriteria();
        criteria.andNumberEqualTo(main.getNumber());
        return mainMapper.updateByExampleSelective(main,mainExample)==1?true:false;
    }


    private MainWithBLOBs getLawlevel(MainWithBLOBs main) {

        //法规级别 人大的文件设置重点，使用人大部门
        String specail_p_arr [] = new String[]{"人大","人民代表大会","人大常委会","人民代表大会常务委员会"};
        for(int mm=0;mm<specail_p_arr.length;mm++){
            if(main.getRjs10().indexOf(specail_p_arr[mm].toLowerCase())>-1){
                main.setLawlevel(1);
                break;
            }
        }
        if (main.getRjs12().indexOf("令")>0) main.setLawlevel(1);

        return main;
    }
}
