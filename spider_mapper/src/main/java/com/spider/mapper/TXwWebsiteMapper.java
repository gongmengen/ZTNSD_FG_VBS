package com.spider.mapper;

import com.spider.bean.TXwWebsite;
import com.spider.bean.TXwWebsiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TXwWebsiteMapper {
    int countByExample(TXwWebsiteExample example);

    int deleteByExample(TXwWebsiteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TXwWebsite record);

    int insertSelective(TXwWebsite record);

    List<TXwWebsite> selectByExample(TXwWebsiteExample example);

    TXwWebsite selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TXwWebsite record, @Param("example") TXwWebsiteExample example);

    int updateByExample(@Param("record") TXwWebsite record, @Param("example") TXwWebsiteExample example);

    int updateByPrimaryKeySelective(TXwWebsite record);

    int updateByPrimaryKey(TXwWebsite record);

    //自定义
    List<TXwWebsite> isApaterWebsiteList();

    List<TXwWebsite> isNotApaterWebsiteList();

    TXwWebsite selectById(Integer websiteid);

    void updateTitleAndNewsnumStatus(int id,int title, int newsnum);

    List<TXwWebsite> getTXwWebsiteListWithMonitorDate();
}