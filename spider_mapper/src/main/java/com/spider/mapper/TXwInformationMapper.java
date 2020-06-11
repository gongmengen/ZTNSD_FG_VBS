package com.spider.mapper;

import com.spider.bean.TXwInformation;
import com.spider.bean.TXwInformationExample;
import com.spider.bean.TXwInformationWithBLOBs;

import java.util.HashMap;
import java.util.List;

import com.spider.bean.TXwWebsite;
import org.apache.ibatis.annotations.Param;

public interface TXwInformationMapper {
    int countByExample(TXwInformationExample example);

    int deleteByExample(TXwInformationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TXwInformationWithBLOBs record);

    int insertSelective(TXwInformationWithBLOBs record);

    List<TXwInformationWithBLOBs> selectByExampleWithBLOBs(TXwInformationExample example);

    List<TXwInformation> selectByExample(TXwInformationExample example);

    TXwInformationWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TXwInformationWithBLOBs record, @Param("example") TXwInformationExample example);

    int updateByExampleWithBLOBs(@Param("record") TXwInformationWithBLOBs record, @Param("example") TXwInformationExample example);

    int updateByExample(@Param("record") TXwInformation record, @Param("example") TXwInformationExample example);

    int updateByPrimaryKeySelective(TXwInformationWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TXwInformationWithBLOBs record);

    int updateByPrimaryKey(TXwInformation record);

    /*
    自定义mapper
    */
    List<TXwInformation> findInformationList(int id);

    List<TXwInformation> getWebsiteidList();

    List<TXwInformationWithBLOBs> getTenInformationList(int websiteid);

    List<TXwInformation> getTenTXwInformationNewest();

    List<TXwInformationWithBLOBs> getTenTXwInformationPipelineIsZero();

    void updatePipelineStatusForOne(Integer id);

    void updatePipelineStatusForZero(Integer id);

    void updatePipelineStatusWithRefmainToZeroAll(Integer websiteid);

    void updatePipelineStatusWithRefmainToZeroTwenty(Integer websiteid);

    List<TXwInformationWithBLOBs> getNextTenInformationList(int informationid, int websiteid);

    void updatePipelineStatusWithRefmainToOne(int websiteid);

    List<TXwInformationWithBLOBs> getTenTXwInformationPipelineWithRefMan();

    List<TXwWebsite> getSpiderCountByWebsiteid(@Param("start") String start,@Param("end")String end);//获取 网站抓取数量

    List<TXwInformation> getInformationListWithWebsiteIdAndUpdateTime(HashMap map);

    List<TXwWebsite> getLastUpdateTimeList();
}