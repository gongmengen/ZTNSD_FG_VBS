package com.spider.service;

import cn.hutool.core.util.StrUtil;
import com.spider.bean.Main;
import com.spider.bean.MainExample;
import com.spider.bean.MainWithBLOBs;
import com.spider.bean.Newcode;
import com.spider.mapper.KeywordMapper;
import com.spider.mapper.MainMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Keyword_service {

    @Autowired
    private MainMapper mainMapper;
    @Autowired
    private KeywordMapper keywordMapper;


    public List<Newcode> getListNewcode() {
        return keywordMapper.getListNewcode();
    }
    
    public Newcode getNewcode(String code) {
        return keywordMapper.getNewcode(code);
    }
    
    public boolean updateNewcode(Newcode ncode) {
        return keywordMapper.updateNewcode(ncode);
    }
    
}
