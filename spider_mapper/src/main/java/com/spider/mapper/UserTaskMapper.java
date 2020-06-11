package com.spider.mapper;

import com.spider.bean.UserTask;
import com.spider.bean.UserTaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserTaskMapper {
    int countByExample(UserTaskExample example);

    int deleteByExample(UserTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserTask record);

    int insertSelective(UserTask record);

    List<UserTask> selectByExample(UserTaskExample example);

    UserTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserTask record, @Param("example") UserTaskExample example);

    int updateByExample(@Param("record") UserTask record, @Param("example") UserTaskExample example);

    int updateByPrimaryKeySelective(UserTask record);

    int updateByPrimaryKey(UserTask record);


    //自定义
    List<UserTask> getUserTaskList();
}