package com.spider.service;

import com.spider.bean.TXwWebsite;
import com.spider.bean.TXwWebsiteExample;
import com.spider.bean.UserTask;
import com.spider.bean.UserTaskExample;
import com.spider.mapper.TXwWebsiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TXwWebsite_service {
    @Autowired
    private TXwWebsiteMapper websiteMapper;
    //获取所有适配网站集合
    @Transactional(readOnly = false)
    public List<TXwWebsite> getTXwWebsiteList(String userName){
        TXwWebsiteExample websiteExample = new TXwWebsiteExample();
        if (userName.equals("root")) {


            return websiteMapper.selectByExample(websiteExample);
        }else {
            TXwWebsiteExample.Criteria criteria = websiteExample.createCriteria();
            criteria.andUsertaskEqualTo(userName);
            return websiteMapper.selectByExample(websiteExample);
        }
        }

    //已适配
    public List<TXwWebsite> isApaterWebsiteList(){
        return websiteMapper.isApaterWebsiteList();
    }
    //未适配
    public List<TXwWebsite> isNotApaterWebsiteList(){
        return websiteMapper.isNotApaterWebsiteList();
    }
    //根据id获取website
    public TXwWebsite findWebsiteByid(int id){
        return websiteMapper.selectByPrimaryKey(id);
    }

    public void updateRefmainToOne(String[] ids) {

        for (String websiteid:ids
             ) {
            TXwWebsite tXwWebsite = new TXwWebsite();
            tXwWebsite.setId(Integer.parseInt(websiteid));
            tXwWebsite.setRefmain(1);
            websiteMapper.updateByPrimaryKeySelective(tXwWebsite);
        }

    }

    public void updateRefmainToZero(String[] ids) {
        for (String websiteid:ids
                ) {
            TXwWebsite tXwWebsite = new TXwWebsite();
            tXwWebsite.setId(Integer.parseInt(websiteid));
            tXwWebsite.setRefmain(0);
            websiteMapper.updateByPrimaryKeySelective(tXwWebsite);
        }
    }

    public void updateTaskName(String[] websiteids, String username) {

        for (String websiteid:websiteids
             ) {

            TXwWebsiteExample example = new TXwWebsiteExample();
            TXwWebsiteExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(Integer.parseInt(websiteid));
            TXwWebsite website = new TXwWebsite();
            website.setUsertask(username);
            websiteMapper.updateByExampleSelective(website,example);
        }

    }

    public void updateRefmainToTwo(String[] ids) {
        for (String websiteid:ids
                ) {
            TXwWebsite tXwWebsite = new TXwWebsite();
            tXwWebsite.setId(Integer.parseInt(websiteid));
            tXwWebsite.setRefmain(2);
            websiteMapper.updateByPrimaryKeySelective(tXwWebsite);
        }
    }

    public String getPersonChargeByID(String imptime) {
        TXwWebsite tXwWebsite = websiteMapper.selectByPrimaryKey(Integer.parseInt(imptime));

        return tXwWebsite.getUsertask();
    }

    public List<TXwWebsite> getidsByRefmain2() {
        TXwWebsiteExample example = new TXwWebsiteExample();
        TXwWebsiteExample.Criteria criteria = example.createCriteria();
        criteria.andRefmainEqualTo(2);
        return websiteMapper.selectByExample(example);
    }
    public List<TXwWebsite> getidsByRefmain3() {
        TXwWebsiteExample example = new TXwWebsiteExample();
        TXwWebsiteExample.Criteria criteria = example.createCriteria();
        criteria.andRefmainEqualTo(3);
        return websiteMapper.selectByExample(example);
    }

    public void updateRefmainToThree(String[] ids) {
        for (String websiteid:ids
                ) {
            TXwWebsite tXwWebsite = new TXwWebsite();
            tXwWebsite.setId(Integer.parseInt(websiteid));
            tXwWebsite.setRefmain(3);
            websiteMapper.updateByPrimaryKeySelective(tXwWebsite);
        }
    }

    public void updateTitleAndNewsnumStatus(int id,int title, int newsnum) {

        websiteMapper.updateTitleAndNewsnumStatus(id,title,newsnum);
    }
}
