package com.spider.service;

import com.spider.bean.DepcodeNew;
import com.spider.bean.DepcodeNewExample;
import com.spider.mapper.DepcodeNewMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Deptcode_service
 * </p>
 *
 * @author msi-
 * @package: com.spider.service
 * @description: 部门代码维护
 * @date: Created in 2020-09-24 10:13
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: msi-
 */
@Service
public class Deptcode_service {

    @Autowired
    private DepcodeNewMapper depcodeNewMapper;


    //获取列表
    public List<DepcodeNew> getDepcodeList(int nowPage, int pageSize, String keyword){

        String[] array = null;

        if (StringUtils.isNotBlank(keyword)){
            array = keyword.split(" ");
        }
        return depcodeNewMapper.limitList(nowPage,pageSize,array);
    }

    //获取总数
    public int getDepcodeCount(String keyword){
        int total = 0;
        if (StringUtils.isNotBlank(keyword)){
            String[] split = keyword.split(" ");
            total = depcodeNewMapper.getTotalByKeyword(split);
        }else {
            DepcodeNewExample example = new DepcodeNewExample();
            List<DepcodeNew> depcodeNews = depcodeNewMapper.selectByExample(example);
            total = depcodeNews.size();
        }

        return total;
    }

    public boolean deleteByNumber(String ids) {
        DepcodeNewExample example = new DepcodeNewExample();
        DepcodeNewExample.Criteria criteria = example.createCriteria();
        criteria.andDepNumberEqualTo(ids);
        return depcodeNewMapper.deleteByExample(example)==1?true:false;
    }

    public boolean update(DepcodeNew depcodeNew) {
        DepcodeNewExample example = new DepcodeNewExample();
        DepcodeNewExample.Criteria criteria = example.createCriteria();
        criteria.andDepNameEqualTo(depcodeNew.getDepName());
        criteria.andAlisNameEqualTo(depcodeNew.getAlisName());
        List<DepcodeNew> depcodeNews = depcodeNewMapper.selectByExample(example);
        if (depcodeNews.size()>0){
            return false;
        }else {
            DepcodeNewExample example1 = new DepcodeNewExample();
            DepcodeNewExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andDepNumberEqualTo(depcodeNew.getDepNumber());

            return depcodeNewMapper.updateByExampleSelective(depcodeNew,example1)==1;
        }

    }

    public int getMaxNumber(String newDeptcode) {
        return depcodeNewMapper.getMaxNumber(newDeptcode);
    }

    public boolean insert(DepcodeNew depcodeNew) {

        DepcodeNewExample example = new DepcodeNewExample();
        DepcodeNewExample.Criteria criteria = example.createCriteria();
        criteria.andDepNameEqualTo(depcodeNew.getDepName());
        criteria.andAlisNameEqualTo(depcodeNew.getAlisName());
        List<DepcodeNew> depcodeNews = depcodeNewMapper.selectByExample(example);
        if (depcodeNews.size()>0){
            return false;
        }else {
            return  depcodeNewMapper.insertSelective(depcodeNew)==1?true:false;
        }
    }

    public List<DepcodeNew> getDeptOneLevel() {
        List<DepcodeNew> deptOneLevel = depcodeNewMapper.getDeptOneLevel();
        return deptOneLevel;

    }

    public Map<String, List<DepcodeNew>> getDeptTwoLevel(String deptcode) {

        List<DepcodeNew> deptOneLevel = depcodeNewMapper.getDeptTwoLevel(deptcode);

        Map<String,List<DepcodeNew>> map = new HashMap<String,List<DepcodeNew>>();

        map.put("deptOneLevel",deptOneLevel);
        return map;



    }
}