package com.spider.mapper;

import com.spider.bean.Informationtwice;
import com.spider.bean.InformationtwiceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InformationtwiceMapper {
    int countByExample(InformationtwiceExample example);

    int deleteByExample(InformationtwiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Informationtwice record);

    int insertSelective(Informationtwice record);

    List<Informationtwice> selectByExampleWithBLOBs(InformationtwiceExample example);

    List<Informationtwice> selectByExample(InformationtwiceExample example);

    Informationtwice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Informationtwice record, @Param("example") InformationtwiceExample example);

    int updateByExampleWithBLOBs(@Param("record") Informationtwice record, @Param("example") InformationtwiceExample example);

    int updateByExample(@Param("record") Informationtwice record, @Param("example") InformationtwiceExample example);

    int updateByPrimaryKeySelective(Informationtwice record);

    int updateByPrimaryKeyWithBLOBs(Informationtwice record);

    int updateByPrimaryKey(Informationtwice record);
}