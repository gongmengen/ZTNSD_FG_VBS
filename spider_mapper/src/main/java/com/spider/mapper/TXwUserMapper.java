package com.spider.mapper;

import com.spider.bean.TXwUser;
import com.spider.bean.TXwUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TXwUserMapper {
    int countByExample(TXwUserExample example);

    int deleteByExample(TXwUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TXwUser record);

    int insertSelective(TXwUser record);

    List<TXwUser> selectByExample(TXwUserExample example);

    TXwUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TXwUser record, @Param("example") TXwUserExample example);

    int updateByExample(@Param("record") TXwUser record, @Param("example") TXwUserExample example);

    int updateByPrimaryKeySelective(TXwUser record);

    int updateByPrimaryKey(TXwUser record);
}