package com.spider.mapper;

import com.spider.bean.MarkdetailMain;
import com.spider.bean.MarkdetailMainExample;
import com.spider.bean.MarkdetailMainWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MarkdetailMainMapper {
    int countByExample(MarkdetailMainExample example);

    int deleteByExample(MarkdetailMainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MarkdetailMainWithBLOBs record);

    int insertSelective(MarkdetailMainWithBLOBs record);

    List<MarkdetailMainWithBLOBs> selectByExampleWithBLOBs(MarkdetailMainExample example);

    List<MarkdetailMain> selectByExample(MarkdetailMainExample example);

    MarkdetailMainWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MarkdetailMainWithBLOBs record, @Param("example") MarkdetailMainExample example);

    int updateByExampleWithBLOBs(@Param("record") MarkdetailMainWithBLOBs record, @Param("example") MarkdetailMainExample example);

    int updateByExample(@Param("record") MarkdetailMain record, @Param("example") MarkdetailMainExample example);

    int updateByPrimaryKeySelective(MarkdetailMainWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MarkdetailMainWithBLOBs record);

    int updateByPrimaryKey(MarkdetailMain record);

    //自定义

    void copyMainDate(Long number);

    String groupColumnStatus(String appuser);
}