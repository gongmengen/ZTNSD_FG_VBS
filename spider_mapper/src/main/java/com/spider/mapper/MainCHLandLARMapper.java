package com.spider.mapper;

import com.spider.bean.InformationPipeline;
import com.spider.bean.Main_CHLandLAR;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MainCHLandLARMapper {

    List<Main_CHLandLAR> selectByRjs0(@Param(value = "rjs4") String rjs4,@Param(value = "sqlTitle")String sqlTitle, @Param(value = "minTime")String minTime, @Param(value = "maxTime")String maxTime);

    List<Main_CHLandLAR> selectByRjs12(@Param(value = "rjs12")String rjs12,@Param(value = "rjs4") String rjs10, @Param(value = "minTime")String minTime, @Param(value = "maxTime")String maxTime);

    List<Main_CHLandLAR> selectByRjs0NotLike(@Param(value = "rjs4") String rjs4,@Param(value = "sqlTitle")String sqlTitle, @Param(value = "minTime")String minTime, @Param(value = "maxTime")String maxTime);

    List<Main_CHLandLAR> selectByRjs12NotLike(@Param(value = "rjs12")String rjs12,@Param(value = "rjs4") String rjs10, @Param(value = "minTime")String minTime, @Param(value = "maxTime")String maxTime);

    // .6自检

    List<InformationPipeline> selectByRjs0_6(@Param(value = "rjs4") String rjs4,@Param(value = "sqlTitle")String sqlTitle, @Param(value = "minTime")String minTime, @Param(value = "maxTime")String maxTime);

    List<InformationPipeline> selectByRjs12_6(@Param(value = "rjs12")String rjs12,@Param(value = "rjs4") String rjs10, @Param(value = "minTime")String minTime, @Param(value = "maxTime")String maxTime);

    List<InformationPipeline> selectByRjs0NotLike_6(@Param(value = "rjs4") String rjs4,@Param(value = "sqlTitle")String sqlTitle, @Param(value = "minTime")String minTime, @Param(value = "maxTime")String maxTime);

    List<InformationPipeline> selectByRjs12NotLike_6(@Param(value = "rjs12")String rjs12,@Param(value = "rjs4") String rjs10, @Param(value = "minTime")String minTime, @Param(value = "maxTime")String maxTime);

    List<InformationPipeline> selectByNewsTitleNotLike_6(@Param(value = "newsTitle") String newsTitle, @Param(value = "minTime")String minTime, @Param(value = "maxTime")String maxTime);
    //新增
    void insert(Main_CHLandLAR main);

    List<Main_CHLandLAR> findAll();

    Main_CHLandLAR selectByPrimaryKey(@Param(value = "rid")long l);

    boolean update(Main_CHLandLAR main);

    boolean updateFjian(Main_CHLandLAR main);

    List<Main_CHLandLAR> search(@Param(value = "params")Map<String, String> params);
}
