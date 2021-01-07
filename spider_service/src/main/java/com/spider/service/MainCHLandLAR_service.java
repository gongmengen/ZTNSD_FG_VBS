package com.spider.service;

import cn.hutool.core.date.DateUtil;
import com.spider.bean.Main_CHLandLAR;
import com.spider.mapper.MainCHLandLARMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.Condition;

@Service
public class MainCHLandLAR_service {
    @Autowired
    private MainCHLandLARMapper mainCHLandLARMapper;

    public List<Main_CHLandLAR> getMainListWithRjs0(String rjs4,String sqlTitle,String minTime,String maxTime){
        return mainCHLandLARMapper.selectByRjs0(rjs4,sqlTitle,minTime,maxTime);
    }

    public List<Main_CHLandLAR> getMainListWithRjs12(String rjs12,String rjs10,String minTime,String maxTime){
        return mainCHLandLARMapper.selectByRjs12(rjs12,rjs10,minTime,maxTime);
    }

    public List<Main_CHLandLAR> getMainListWithRjs0NotLike(String rjs4,String sqlTitle,String minTime,String maxTime){
        return mainCHLandLARMapper.selectByRjs0NotLike(rjs4,sqlTitle,minTime,maxTime);
    }

    public List<Main_CHLandLAR> getMainListWithRjs12NotLike(String rjs12,String rjs10,String minTime,String maxTime){
        return mainCHLandLARMapper.selectByRjs12NotLike(rjs12,rjs10,minTime,maxTime);
    }

    public void insert(Main_CHLandLAR main) {
        mainCHLandLARMapper.insert(main);
    }

    public List<Main_CHLandLAR> findAll() {

        Date date = new Date();
        String now = DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
        int lastYear = DateUtil.year(date)-1;
        now = lastYear + now.substring(4);

        Integer count = mainCHLandLARMapper.findAllCount(now);

        return mainCHLandLARMapper.findAll(count>10?(int)(count*0.2):count,now);
    }

    public Main_CHLandLAR selectByPrimaryKey(long l) {
        return mainCHLandLARMapper.selectByPrimaryKey(l);
    }

    public boolean update(Main_CHLandLAR main) {
        main.setRjs9((short) 9);
        Date date = new Date();
        main.setAppdate(date);
        main.setUpdatetime(Integer.parseInt(DateUtil.format(date,new SimpleDateFormat("yyyyMMdd"))));

        return mainCHLandLARMapper.update(main);
    }

    public boolean updateFjian(Main_CHLandLAR main) {
        return mainCHLandLARMapper.updateFjian(main);
    }

    public List<Main_CHLandLAR> search(Map<String, String> params) {
        if (StringUtils.isNotBlank(params.get("releaseDate"))){
            String releaseDate = params.get("releaseDate").replaceAll("-","");
            String[] date = releaseDate.split("  ");
            params.put("releaseDate",releaseDate);
            params.put("releaseDateStart",date[0]);
            params.put("releaseDateEnd",date[1]);
        }

        if (StringUtils.isNotBlank(params.get("appdate"))){
            String appdate = params.get("appdate");
            String[] date = appdate.split(" - ");
            params.put("appdate",appdate);
            params.put("appdateStart",date[0]);
            params.put("appdateEnd",date[1]);
        }

        List<Main_CHLandLAR> resu = mainCHLandLARMapper.search(params);

        if(StringUtils.isNotBlank(params.get("slide"))){
            double i = (double) Integer.parseInt(params.get("slide"))/100;
            if (resu.size()>25){
                Collections.shuffle(resu);

                return resu.subList(0, (int) (resu.size() * i));
            }else {
                return resu;
            }
        }else {
            return resu;
        }

    }

}
