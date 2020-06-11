package com.spider.mapper;

import com.spider.bean.TblErrorLog;
import com.spider.bean.TblErrorLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblErrorLogMapper {
    int countByExample(TblErrorLogExample example);

    int deleteByExample(TblErrorLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblErrorLog record);

    int insertSelective(TblErrorLog record);

    List<TblErrorLog> selectByExample(TblErrorLogExample example);

    TblErrorLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblErrorLog record, @Param("example") TblErrorLogExample example);

    int updateByExample(@Param("record") TblErrorLog record, @Param("example") TblErrorLogExample example);

    int updateByPrimaryKeySelective(TblErrorLog record);

    int updateByPrimaryKey(TblErrorLog record);
}