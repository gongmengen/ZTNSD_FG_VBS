package com.spider.service;

import com.spider.bean.TblError;
import com.spider.bean.TblErrorLog;
import com.spider.bean.TblErrorLogExample;
import com.spider.mapper.ErrorLogMapper;
import com.spider.mapper.TblErrorLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ErrorLog_service {
    @Autowired
    private TblErrorLogMapper errorLogMapper;

    @Autowired
    private ErrorLogMapper errorLogMapper_CHL;

    public List<TblErrorLog> getErrorLogListByInformationID(int informationid,int column){

        return errorLogMapper.getErrorLogListByInformationID(informationid,column);
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

    public String getDealer(Integer errorCode) {

        return errorLogMapper.getDealer(errorCode);
    }

    public String getDealerByInformationID(Integer informationId) {
        String resu = "";
        List<String> dealerByInformationID = errorLogMapper.getDealerByInformationID(informationId);

        if (dealerByInformationID.size()>1){
            for (String s : dealerByInformationID) {
                resu = resu + s +",";
            }
            return resu.equals("")?resu:resu.substring(0,resu.length()-1);
        }else {
            for (String s : dealerByInformationID) {
                resu += s;
            }
            return resu;
        }

    }

    public void insertByTmpErrorLog(HashMap<String, String> map) {
        errorLogMapper_CHL.insertByTmpErrorLog(map);
    }
}
