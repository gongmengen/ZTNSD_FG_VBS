package com.spider.service;

import com.spider.bean.*;
import com.spider.mapper.TXwInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class TXwInformation_service {
    @Autowired
    private TXwInformationMapper informationMapper;


    //获取10篇新闻
    public List<TXwInformationWithBLOBs> getTenInformationList(int websiteid){
        return informationMapper.getTenInformationList(websiteid);
    }


    //查询websiteid对应的集合
    public List<TXwInformationWithBLOBs> getInformationListWithWebsiteId(int websiteid){
        TXwInformationExample informationExample = new TXwInformationExample();
        TXwInformationExample.Criteria criteria = informationExample.createCriteria();
        criteria.andWebsiteidEqualTo(websiteid);
        return informationMapper.selectByExampleWithBLOBs(informationExample);

    }
    //优化informationList 获取页面
    public List<TXwInformation> getInformationListWithWebsiteId_fast(int websiteid){
/*        TXwInformationExample informationExample = new TXwInformationExample();
        TXwInformationExample.Criteria criteria = informationExample.createCriteria();
        criteria.andWebsiteidEqualTo(websiteid);
        informationMapper.selectByExampleWithBLOBs(informationExample);*/
        return informationMapper.findInformationList(websiteid);
    }
    //获取一篇新闻
    public TXwInformationWithBLOBs getInformation(int id){
        return informationMapper.selectByPrimaryKey(id);
    }

    //获取websiteid 列表
    public List<TXwInformation> getWebsiteidList(){
        return informationMapper.getWebsiteidList();
    }

    //获取10条最新抓取的新闻
    public List<TXwInformation> getTenTXwInformationNewest(){
        return informationMapper.getTenTXwInformationNewest();
    }

    //获取10条pipeline=0的新闻
    public List<TXwInformationWithBLOBs>  getTenTXwInformationPipelineIsZero(){
        return informationMapper.getTenTXwInformationPipelineIsZero();
    }

    //修改pipeline_status = 1
    public void  updatePipelineStatusForOne(TXwInformationWithBLOBs information){

            informationMapper.updatePipelineStatusForOne(information.getId());

    }

    public void updatePipelineStatusForZero(List<InformationPipelineWithBLOBs> informationPipelines) {
        for (InformationPipelineWithBLOBs informationPipeline:informationPipelines
             ) {
            informationMapper.updatePipelineStatusForZero(informationPipeline.getInformationId());
        }
    }

    public void updatePipelineStatusWithRefmainToZero(String[] ids, String flag) {
        for (String websiteid:ids
             ) {
            if (flag.equals("all")){
                informationMapper.updatePipelineStatusWithRefmainToZeroAll(Integer.parseInt(websiteid));

            }else {
                informationMapper.updatePipelineStatusWithRefmainToZeroTwenty(Integer.parseInt(websiteid));
            }


        }
    }

    public List<TXwInformationWithBLOBs> getNextTenInformationList(int informationid,int websiteid) {
        return informationMapper.getNextTenInformationList(informationid,websiteid);
    }

    public int getWebsiteidByInformationid(int informationid) {
        TXwInformationWithBLOBs information = informationMapper.selectByPrimaryKey(informationid);
        return information.getWebsiteid();
    }

    public void updatePipelineStatusWithRefmainToOne(String[] ids) {
        for (String websiteid:ids
                ) {
            informationMapper.updatePipelineStatusWithRefmainToOne(Integer.parseInt(websiteid));
        }
    }

    public List<TXwInformationWithBLOBs> getTenTXwInformationPipelineWithRefMan() {
       return informationMapper.getTenTXwInformationPipelineWithRefMan();
    }

    public List<TXwInformation> getInformationBySource(String keyword) {
        TXwInformationExample example = new TXwInformationExample();
        TXwInformationExample.Criteria criteria = example.createCriteria();
        criteria.andSourceEqualTo(keyword);
        return informationMapper.selectByExample(example);
    }

    public List<TXwWebsite> getSpiderCountByWebsiteid(String start,String end) {
        return informationMapper.getSpiderCountByWebsiteid(start,end);
    }

    public List<TXwInformation> getInformationListWithWebsiteIdAndUpdateTime(int websiteid, String start, String end) {
        HashMap map = new HashMap();
        map.put("id",websiteid);
        map.put("start",start.equals("")?null:start);
        map.put("end",end.equals("")?null:end);

        return informationMapper.getInformationListWithWebsiteIdAndUpdateTime(map);

    }

    public List<TXwWebsite> getLastUpdateTime() {
        return informationMapper.getLastUpdateTimeList();
    }
}
