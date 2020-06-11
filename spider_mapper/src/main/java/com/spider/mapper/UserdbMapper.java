package com.spider.mapper;

import com.spider.bean.Userdb;
import com.spider.bean.UserdbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserdbMapper {
    int countByExample(UserdbExample example);

    int deleteByExample(UserdbExample example);

    int insert(Userdb record);

    int insertSelective(Userdb record);

    List<Userdb> selectByExample(UserdbExample example);

    int updateByExampleSelective(@Param("record") Userdb record, @Param("example") UserdbExample example);

    int updateByExample(@Param("record") Userdb record, @Param("example") UserdbExample example);
}