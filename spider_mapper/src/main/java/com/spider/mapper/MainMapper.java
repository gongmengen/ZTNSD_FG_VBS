package com.spider.mapper;

import com.spider.bean.Main;
import com.spider.bean.MainExample;
import com.spider.bean.MainWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MainMapper {
    int countByExample(MainExample example);

    int deleteByExample(MainExample example);

    int deleteByPrimaryKey(Long number);

    int insert(MainWithBLOBs record);

    int insertSelective(MainWithBLOBs record);

    List<MainWithBLOBs> selectByExampleWithBLOBs(MainExample example);

    List<Main> selectByExample(MainExample example);

    MainWithBLOBs selectByPrimaryKey(Long number);

    int updateByExampleSelective(@Param("record") MainWithBLOBs record, @Param("example") MainExample example);

    int updateByExampleWithBLOBs(@Param("record") MainWithBLOBs record, @Param("example") MainExample example);

    int updateByExample(@Param("record") Main record, @Param("example") MainExample example);

    int updateByPrimaryKeySelective(MainWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MainWithBLOBs record);

    int updateByPrimaryKey(Main record);


    //自定义

    String findMaxRjs8(@Param(value="username")String username);

    List<MainWithBLOBs> getListByAppuser(@Param(value="appuser")String appuser);

    List<MainWithBLOBs> getMarkListByAppuser(@Param(value="appuser")String appuser);
}