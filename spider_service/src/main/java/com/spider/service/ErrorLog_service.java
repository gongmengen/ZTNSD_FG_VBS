package com.spider.service;

import com.spider.bean.TblError;
import com.spider.bean.TblErrorLog;
import com.spider.bean.TblErrorLogExample;
import com.spider.mapper.TblErrorLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorLog_service {
    @Autowired
    private TblErrorLogMapper errorLogMapper;

    public List<TblErrorLog> getErrorLogListByInformationID(int informationid,int column){
        TblErrorLogExample example = new TblErrorLogExample();
        TblErrorLogExample.Criteria criteria = example.createCriteria();
        criteria.andInformationidEqualTo(informationid);
        criteria.andXwcolumnEqualTo(column);
        return errorLogMapper.selectByExample(example);
    }

    public void insert(List<TblErrorLog> errorLogs){
                //保存到errolog
        for (TblErrorLog errorlog:errorLogs
             ) {
            errorLogMapper.insertSelective(errorlog);
        }
    }

    public void deleteByInformationId(int id,int xwcolumn){
        TblErrorLogExample example = new TblErrorLogExample();
        TblErrorLogExample.Criteria criteria = example.createCriteria();
        criteria.andInformationidEqualTo(id);
        criteria.andXwcolumnEqualTo(xwcolumn);
        errorLogMapper.deleteByExample(example);
    }
}
