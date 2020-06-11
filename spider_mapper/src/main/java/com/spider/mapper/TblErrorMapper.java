package com.spider.mapper;

import com.spider.bean.TblError;
import com.spider.bean.TblErrorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblErrorMapper {
    int countByExample(TblErrorExample example);

    int deleteByExample(TblErrorExample example);

    int deleteByPrimaryKey(Integer errorid);

    int insert(TblError record);

    int insertSelective(TblError record);

    List<TblError> selectByExample(TblErrorExample example);

    TblError selectByPrimaryKey(Integer errorid);

    int updateByExampleSelective(@Param("record") TblError record, @Param("example") TblErrorExample example);

    int updateByExample(@Param("record") TblError record, @Param("example") TblErrorExample example);

    int updateByPrimaryKeySelective(TblError record);

    int updateByPrimaryKey(TblError record);
}