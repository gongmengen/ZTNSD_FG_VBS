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

        return depcodeNewMapper.limitList(nowPage,pageSize,keyword);
    }

    //获取总数
    public int getDepcodeCount(String keyword){
        int total = 0;
        if (StringUtils.isNotBlank(keyword)){
            total = depcodeNewMapper.getTotalByKeyword(keyword);
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
        criteria.andDepNumberEqualTo(depcodeNew.getDepNumber());
        return depcodeNewMapper.updateByExampleSelective(depcodeNew,example)==1?true:false;
    }

    public int getMaxNumber(String newDeptcode) {
        return depcodeNewMapper.getMaxNumber(newDeptcode);
    }

    public boolean insert(DepcodeNew depcodeNew) {
        return depcodeNewMapper.insertSelective(depcodeNew)==1?true:false;
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