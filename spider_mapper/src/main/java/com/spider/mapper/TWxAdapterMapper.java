package com.spider.mapper;

import com.spider.bean.TWxAdapter;
import com.spider.bean.TWxAdapterExample;
import com.spider.bean.TWxAdapterWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWxAdapterMapper {
    int countByExample(TWxAdapterExample example);

    int deleteByExample(TWxAdapterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TWxAdapterWithBLOBs record);

    int insertSelective(TWxAdapterWithBLOBs record);

    List<TWxAdapterWithBLOBs> selectByExampleWithBLOBs(TWxAdapterExample example);

    List<TWxAdapter> selectByExample(TWxAdapterExample example);

    TWxAdapterWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TWxAdapterWithBLOBs record, @Param("example") TWxAdapterExample example);

    int updateByExampleWithBLOBs(@Param("record") TWxAdapterWithBLOBs record, @Param("example") TWxAdapterExample example);

    int updateByExample(@Param("record") TWxAdapter record, @Param("example") TWxAdapterExample example);

    int updateByPrimaryKeySelective(TWxAdapterWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TWxAdapterWithBLOBs record);

    int updateByPrimaryKey(TWxAdapter record);
}