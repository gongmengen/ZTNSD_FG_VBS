package com.spider.mapper;

import com.spider.bean.Informationcheck;
import com.spider.bean.InformationcheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InformationcheckMapper {
    int countByExample(InformationcheckExample example);

    int deleteByExample(InformationcheckExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Informationcheck record);

    int insertSelective(Informationcheck record);

    List<Informationcheck> selectByExampleWithBLOBs(InformationcheckExample example);

    List<Informationcheck> selectByExample(InformationcheckExample example);

    Informationcheck selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Informationcheck record, @Param("example") InformationcheckExample example);

    int updateByExampleWithBLOBs(@Param("record") Informationcheck record, @Param("example") InformationcheckExample example);

    int updateByExample(@Param("record") Informationcheck record, @Param("example") InformationcheckExample example);

    int updateByPrimaryKeySelective(Informationcheck record);

    int updateByPrimaryKeyWithBLOBs(Informationcheck record);

    int updateByPrimaryKey(Informationcheck record);
}