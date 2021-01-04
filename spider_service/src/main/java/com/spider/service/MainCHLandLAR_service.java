package com.spider.service;

import com.spider.bean.Main_CHLandLAR;
import com.spider.mapper.MainCHLandLARMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        return mainCHLandLARMapper.findAll();
    }

    public Main_CHLandLAR selectByPrimaryKey(long l) {
        return mainCHLandLARMapper.selectByPrimaryKey(l);
    }

    public boolean update(Main_CHLandLAR main) {
        return mainCHLandLARMapper.update(main);
    }

    public boolean updateFjian(Main_CHLandLAR main) {
        return mainCHLandLARMapper.updateFjian(main);
    }

    public List<Main_CHLandLAR> search(Map<String, String> params) {
        String releaseDate = params.get("releaseDate").replaceAll("-","");
        params.put("releaseDate",releaseDate);
        return mainCHLandLARMapper.search(params);
    }
}
