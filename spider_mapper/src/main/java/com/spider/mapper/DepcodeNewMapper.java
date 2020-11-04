package com.spider.mapper;

import com.spider.bean.DepcodeNew;
import com.spider.bean.DepcodeNewExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepcodeNewMapper {
    int countByExample(DepcodeNewExample example);

    int deleteByExample(DepcodeNewExample example);

    int insert(DepcodeNew record);

    int insertSelective(DepcodeNew record);

    List<DepcodeNew> selectByExample(DepcodeNewExample example);

    int updateByExampleSelective(@Param("record") DepcodeNew record, @Param("example") DepcodeNewExample example);

    int updateByExample(@Param("record") DepcodeNew record, @Param("example") DepcodeNewExample example);

    //自定义sql
    List<DepcodeNew> limitList(int nowPage, int pageSize);

    int getMaxNumber();
}