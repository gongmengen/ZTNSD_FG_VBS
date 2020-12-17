package com.spider.mapper;

import com.spider.bean.Main;
import com.spider.bean.MainExample;
import com.spider.bean.MainWithBLOBs;
import com.spider.bean.Newcode;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeywordMapper {
    List<Newcode> getListNewcode();
    Newcode getNewcode(String code);
    Boolean updateNewcode(Newcode ncode);
}