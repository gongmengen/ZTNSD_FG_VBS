package com.spider.service;

import cn.hutool.http.HtmlUtil;
import com.lawstar.law.model.RecordDataType;
import com.lawstar.law.robots.MainDeal;
import com.spider.bean.*;
import com.spider.elemente.ErrorPram;
import com.spider.elemente.JavaScript_static;

import com.spider.mapper.*;

import com.spider.utils.JavaScriptUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TWxAdapter_service {
    @Autowired
    private TWxAdapterMapper adapterMapper;
    @Autowired
    private TXwWebsiteMapper websiteMapper;
    @Autowired
    private TXwInformationMapper informationMapper;
    @Autowired
    private InformationcheckMapper informationcheckMapper;
    @Autowired
    private InformationtwiceMapper informationtwiceMapper;
    //验证新闻
    public String regNews(TXwInformationWithBLOBs information,int websiteid) throws ScriptException {

        JavaScriptUtils javaScriptUtils = new JavaScriptUtils();

        TWxAdapterWithBLOBs adapter = null;
        TWxAdapterExample adapterExample = new TWxAdapterExample();
        TWxAdapterExample.Criteria criteria = adapterExample.createCriteria();
        criteria.andSiteidEqualTo(websiteid);
        List<TWxAdapterWithBLOBs> tWxAdapterWithBLOBs = adapterMapper.selectByExampleWithBLOBs(adapterExample);
        adapter = tWxAdapterWithBLOBs.get(0);

            StringBuilder result = new StringBuilder();
            //所属网站名称
                result.append("<h4>所属网站名称：" + websiteMapper.selectByPrimaryKey(information.getWebsiteid()).getWebsitename()  + "</h4>");
            //所属网站名称
                result.append("<h5>所属网站url：" + websiteMapper.selectByPrimaryKey(information.getWebsiteid()).getWebsiteaddress()  + "</h5>");
            //标题
            if (adapter.getTitle()!=null&&adapter.getTitle()!="") {
                result.append("<h6>标题：" + javaScriptUtils.entry(information.getNewscontentnotupdate(),JavaScript_static.LAWSTARLIB_JS+adapter.getTitle()) + "</h6>");
            }else {
                result.append("<h6>标题：</h6>");
            }
            //正文
            if (adapter.getComposetext()!=null&&adapter.getComposetext()!="") {
                result.append("正文：<textarea style=\"margin: 0px; width: 1447px; height: 327px;\">"+javaScriptUtils.entry(information.getNewscontentnotupdate(),JavaScript_static.LAWSTARLIB_JS+adapter.getComposetext())+"</textarea>");
            }else {
                result.append("<p>正文：</p>");
            }
            //发布日期
            if (adapter.getReleasedate()!=null&&adapter.getReleasedate()!="") {
                result.append("<p>发布日期："+javaScriptUtils.entry(information.getNewscontentnotupdate(),JavaScript_static.LAWSTARLIB_JS+adapter.getReleasedate())+"</p>");
            }else {
                result.append("<p>发布日期：</p>");
            }
            //文号
            if (adapter.getNewnum()!=null&&adapter.getNewnum()!="") {
                result.append("<p>文号："+javaScriptUtils.entry(information.getNewscontentnotupdate(),JavaScript_static.LAWSTARLIB_JS+adapter.getNewnum())+"</p>");
            }else {
                result.append("<p>文号：</p>");
            }
            //实施日期
            if (adapter.getImplementdate()!=null&&adapter.getImplementdate()!="") {
                result.append("<p>实施日期："+javaScriptUtils.entry(information.getNewscontentnotupdate(),JavaScript_static.LAWSTARLIB_JS+adapter.getImplementdate())+"</p>");
            }else {
                result.append("<p>实施日期：</p>");
            }
            //附件
            if (adapter.getAttachment()!=null&&adapter.getAttachment()!="") {
                result.append("<p>附件："+javaScriptUtils.entry(information.getNewscontentnotupdate(),JavaScript_static.LAWSTARLIB_JS+adapter.getAttachment())+"</p>");
            }else {
                result.append("<p>附件：</p>");
            }



        return result.toString();
    }


    //随机验证10条新闻
    public List<String> regRandomNews(List<TXwInformationWithBLOBs> informationList,int websiteid,HttpServletRequest request) throws ScriptException {
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+
                request.getServerPort()+"/";

        List<String> resultList = new ArrayList<String>();
        JavaScriptUtils javaScriptUtils = new JavaScriptUtils();
        int count = 0;

        TWxAdapterWithBLOBs adapter = null;
        TWxAdapterExample adapterExample = new TWxAdapterExample();
        TWxAdapterExample.Criteria criteria = adapterExample.createCriteria();
        criteria.andSiteidEqualTo(websiteid);
        List<TWxAdapterWithBLOBs> tWxAdapterWithBLOBs = adapterMapper.selectByExampleWithBLOBs(adapterExample);
        adapter = tWxAdapterWithBLOBs.get(0);

        a:for (TXwInformationWithBLOBs information : informationList) {
            if (count==10){break a;}else {count++;}
            StringBuilder result = new StringBuilder();
                //标题
                if (adapter.getTitle()!=null&&adapter.getTitle()!="") {
                    result.append("<h4><a href=\""+basePath+"nextPage/1/"+information.getId()+"\">⚙</a>       标题：" + javaScriptUtils.entry(information.getNewscontentnotupdate(),JavaScript_static.LAWSTARLIB_JS+adapter.getTitle()) + "</h4>");
                }else {
                    result.append("<h4><a href=\""+basePath+"nextPage/1/"+information.getId()+"\">⚙</a>     标题：</h4>");
                }
                //正文
                if (adapter.getComposetext()!=null&&adapter.getComposetext()!="") {
                result.append("<p><a href=\""+basePath+"nextPage/2/"+information.getId()+"\">⚙</a>     正文：<p/><textarea style=\"margin: 0px; width: 1447px; height: 327px;\">"+javaScriptUtils.entry(information.getNewscontentnotupdate(),JavaScript_static.LAWSTARLIB_JS+adapter.getComposetext())+"</textarea>");
                }else {
                    result.append("<p><a href=\""+basePath+"nextPage/2/"+information.getId()+"\">⚙</a>     正文：</p>");
                }
                //发布日期
                if (adapter.getReleasedate()!=null&&adapter.getReleasedate()!="") {
                result.append("<p><a href=\""+basePath+"nextPage/3/"+information.getId()+"\">⚙</a>     发布日期："+javaScriptUtils.entry(information.getNewscontentnotupdate(),JavaScript_static.LAWSTARLIB_JS+adapter.getReleasedate())+"</p>");
                }else {
                    result.append("<p><a href=\""+basePath+"nextPage/3/"+information.getId()+"\">⚙</a>     发布日期：</p>");
                }
                //文号
                if (adapter.getNewnum()!=null&&adapter.getNewnum()!="") {
                result.append("<p><a href=\""+basePath+"nextPage/4/"+information.getId()+"\">⚙</a>     文号："+javaScriptUtils.entry(information.getNewscontentnotupdate(),JavaScript_static.LAWSTARLIB_JS+adapter.getNewnum())+"</p>");
                }else {
                    result.append("<p><a href=\""+basePath+"nextPage/4/"+information.getId()+"\">⚙</a>     文号：</p>");
                }
                //附件
                if (adapter.getAttachment()!=null&&adapter.getAttachment()!="") {
                result.append("<p><a href=\""+basePath+"nextPage/6/"+information.getId()+"\">⚙</a>     附件："+javaScriptUtils.entry(information.getNewscontentnotupdate(),JavaScript_static.LAWSTARLIB_JS+adapter.getAttachment())+"</p>");
                }else {
                    result.append("<p><a href=\""+basePath+"nextPage/6/"+information.getId()+"\">⚙</a>     附件：</p>");
                }
                result.append("<p><a href=\""+information.getSource()+"\" target=\"_blank\">"+information.getSource()+"</a></p>");
            resultList.add(result.toString());

        }
        return resultList;
    }


    /*
    验证单个脚本返回值
    *
    * pram1：newsContentNotUpdate - 页面正文
    * pram2：adapter - 脚本类
    * pram3：codeType - 脚本类型
    * */

    public String regSingleCode(String newsContentNotUpdate,TWxAdapterWithBLOBs adapter,int codeType) throws ScriptException {
        JavaScriptUtils javaScriptUtils = new JavaScriptUtils();
        String result = "";
            switch (codeType){
                case 1:
                    //标题

                    result = javaScriptUtils.entry(newsContentNotUpdate, JavaScript_static.LAWSTARLIB_JS+adapter.getTitle());

                    break;
                case 2:
                    //正文
                    result = javaScriptUtils.entry(newsContentNotUpdate,JavaScript_static.LAWSTARLIB_JS+adapter.getComposetext());
                    break;
                case 3:
                    //发布日期
                    result = javaScriptUtils.entry(newsContentNotUpdate,JavaScript_static.LAWSTARLIB_JS+adapter.getReleasedate());
                    break;
                case 4:
                    //文号
                    result = javaScriptUtils.entry(newsContentNotUpdate,JavaScript_static.LAWSTARLIB_JS+adapter.getNewnum());
                    break;
                case 5:
                    //实施日期
                    result = javaScriptUtils.entry(newsContentNotUpdate,JavaScript_static.LAWSTARLIB_JS+adapter.getImplementdate());
                    break;
                case 6:
                    //附件
                    result = javaScriptUtils.entry(newsContentNotUpdate,JavaScript_static.LAWSTARLIB_JS+adapter.getAttachment());
                    break;
            }

        int i = insertAdapterCode(adapter);
        return result;
    }


    //添加脚本代码
    public int insertAdapterCode(TWxAdapterWithBLOBs adapter){
        int flag = 0;
        TWxAdapterExample adapterExample = new TWxAdapterExample();
        TWxAdapterExample.Criteria criteria = adapterExample.createCriteria();
        criteria.andSiteidEqualTo(adapter.getSiteid());
        List<TWxAdapter> tWxAdapters = adapterMapper.selectByExample(adapterExample);
        if (tWxAdapters.size()==0){
            adapter.setStatus(1);
            adapter.setMethodname("entry");
            flag = adapterMapper.insertSelective(adapter);
        }else {
            //修改部分属性使用updateByExampleSelective
            adapter.setId(tWxAdapters.get(0).getId());
            adapter.setSiteid(null);
            adapterMapper.updateByPrimaryKeySelective(adapter);
        }

        return flag;
    }
    // 查询siteid
    public TWxAdapterWithBLOBs getAdapterWithSiteid(int siteid){
        TWxAdapterExample adapterExample = new TWxAdapterExample();
        TWxAdapterExample.Criteria criteria = adapterExample.createCriteria();
        criteria.andSiteidEqualTo(siteid);
        List<TWxAdapterWithBLOBs> tWxAdapterWithBLOBs = adapterMapper.selectByExampleWithBLOBs(adapterExample);
        return tWxAdapterWithBLOBs.size()>0?tWxAdapterWithBLOBs.get(0):new TWxAdapterWithBLOBs();
    }

    //执行js返回informationPipeline对象
    public Map getInformationPipelineRegJs(TXwInformationWithBLOBs information, HttpServletRequest request){

        //质量检查
        InformationcheckExample informationcheckExample_title = new InformationcheckExample();
        informationcheckExample_title.setOrderByClause("ck_priority DESC");
        InformationcheckExample.Criteria criteria_title = informationcheckExample_title.createCriteria();
        criteria_title.andCkKindEqualTo(1);
        List<Informationcheck> informationchecks_title = informationcheckMapper.selectByExampleWithBLOBs(informationcheckExample_title);

        InformationcheckExample informationcheckExample_content = new InformationcheckExample();
        informationcheckExample_content.setOrderByClause("ck_priority DESC");
        InformationcheckExample.Criteria criteria_content = informationcheckExample_content.createCriteria();
        criteria_content.andCkKindEqualTo(2);
        List<Informationcheck> informationchecks_content = informationcheckMapper.selectByExampleWithBLOBs(informationcheckExample_content);

        InformationcheckExample informationcheckExample_newsnum = new InformationcheckExample();
        informationcheckExample_newsnum.setOrderByClause("ck_priority DESC");
        InformationcheckExample.Criteria criteria_newsnum = informationcheckExample_newsnum.createCriteria();
        criteria_newsnum.andCkKindEqualTo(3);
        List<Informationcheck> informationchecks_newsnum = informationcheckMapper.selectByExampleWithBLOBs(informationcheckExample_newsnum);

        InformationcheckExample informationcheckExample_attachment = new InformationcheckExample();
        informationcheckExample_attachment.setOrderByClause("ck_priority DESC");
        InformationcheckExample.Criteria criteria_attachment = informationcheckExample_attachment.createCriteria();
        criteria_attachment.andCkKindEqualTo(4);
        List<Informationcheck> informationchecks_attachment = informationcheckMapper.selectByExampleWithBLOBs(informationcheckExample_attachment);

        InformationcheckExample informationcheckExample_releasedate = new InformationcheckExample();
        informationcheckExample_releasedate.setOrderByClause("ck_priority DESC");
        InformationcheckExample.Criteria criteria_releasedate = informationcheckExample_releasedate.createCriteria();
        criteria_releasedate.andCkKindEqualTo(5);
        List<Informationcheck> informationchecks_releasedate = informationcheckMapper.selectByExampleWithBLOBs(informationcheckExample_releasedate);

        //数据二次清洗脚本
        InformationtwiceExample informationtwiceExample_title = new InformationtwiceExample();
        informationtwiceExample_title.setOrderByClause("twice_priority DESC");
        InformationtwiceExample.Criteria criteria_title1 = informationtwiceExample_title.createCriteria();
        criteria_title1.andTwiceKindEqualTo(1);
        List<Informationtwice> informationtwices_title = informationtwiceMapper.selectByExampleWithBLOBs(informationtwiceExample_title);

        InformationtwiceExample informationtwiceExample_content = new InformationtwiceExample();
        informationtwiceExample_content.setOrderByClause("twice_priority DESC");
        InformationtwiceExample.Criteria criteria_content1 = informationtwiceExample_content.createCriteria();
        criteria_content1.andTwiceKindEqualTo(2);
        List<Informationtwice> informationtwices_content = informationtwiceMapper.selectByExampleWithBLOBs(informationtwiceExample_content);

        InformationtwiceExample informationtwiceExample_newsnum = new InformationtwiceExample();
        informationtwiceExample_newsnum.setOrderByClause("twice_priority DESC");
        InformationtwiceExample.Criteria criteria_newsnum1 = informationtwiceExample_newsnum.createCriteria();
        criteria_newsnum1.andTwiceKindEqualTo(3);
        List<Informationtwice> informationtwices_newsnum = informationtwiceMapper.selectByExampleWithBLOBs(informationtwiceExample_newsnum);

        InformationtwiceExample informationtwiceExample_attachment = new InformationtwiceExample();
        informationtwiceExample_attachment.setOrderByClause("twice_priority DESC");
        InformationtwiceExample.Criteria criteria_attachment1 = informationtwiceExample_attachment.createCriteria();
        criteria_attachment1.andTwiceKindEqualTo(4);
        List<Informationtwice> informationtwices_attachment = informationtwiceMapper.selectByExampleWithBLOBs(informationtwiceExample_attachment);

        InformationtwiceExample informationtwiceExample_releasedate = new InformationtwiceExample();
        informationtwiceExample_releasedate.setOrderByClause("twice_priority DESC");
        InformationtwiceExample.Criteria criteria_releasedate1 = informationtwiceExample_releasedate.createCriteria();
        criteria_releasedate1.andTwiceKindEqualTo(5);
        List<Informationtwice> informationtwices_releasedate = informationtwiceMapper.selectByExampleWithBLOBs(informationtwiceExample_releasedate);


        //信息处理异常记录
        List<TblErrorLog> errorLogs = new ArrayList<TblErrorLog>();
        JavaScriptUtils javaScriptUtils = new JavaScriptUtils();

        TWxAdapterWithBLOBs adapter = new TWxAdapterWithBLOBs();
        TWxAdapterExample adapterExample = new TWxAdapterExample();
        TWxAdapterExample.Criteria criteria = adapterExample.createCriteria();
        criteria.andSiteidEqualTo(information.getWebsiteid());
        List<TWxAdapterWithBLOBs> tWxAdapterWithBLOBs = adapterMapper.selectByExampleWithBLOBs(adapterExample);
        if (tWxAdapterWithBLOBs.size()>0) {
            adapter = tWxAdapterWithBLOBs.get(0);
        }
        InformationPipelineWithBLOBs result = new InformationPipelineWithBLOBs();
        //标题  必须不为空且执行无异常
        if (adapter.getTitle()!=null&&adapter.getTitle()!="") {
            try {
                String entry = javaScriptUtils.entry(information.getNewscontentnotupdate(), JavaScript_static.LAWSTARLIB_JS + adapter.getTitle());
                if ("".equals(entry)){
                    errorLogs.add(new TblErrorLog(10011,ErrorPram.getErrorPram().get(10011),information.getId(),information.getXwcolumn()));
                }
                result.setNewstitle(entry);
            }catch (Exception e){
                errorLogs.add(new TblErrorLog(1001,ErrorPram.getErrorPram().get(1001),information.getId(),information.getXwcolumn()));
            }
        }else {
            errorLogs.add(new TblErrorLog(10012,ErrorPram.getErrorPram().get(10012),information.getId(),information.getXwcolumn()));
        }
        //正文  必须不为空且执行无异常
        if (adapter.getComposetext()!=null&&adapter.getComposetext()!="") {
            try {
                String entry = javaScriptUtils.entry(information.getNewscontentnotupdate(), JavaScript_static.LAWSTARLIB_JS + adapter.getComposetext());
                String contentPart = javaScriptUtils.entry(information.getNewscontentnotupdate(), dynamicJavaScript(JavaScript_static.LAWSTARLIB_JS + adapter.getComposetext()));

                if ("".equals(entry)){
                    errorLogs.add(new TblErrorLog(10021,ErrorPram.getErrorPram().get(10021),information.getId(),information.getXwcolumn()));
                }
                result.setNewscontent(entry);
                result.setExtend2(contentPart);
            }catch (Exception e){
                errorLogs.add(new TblErrorLog(1002,ErrorPram.getErrorPram().get(1002),information.getId(),information.getXwcolumn()));
            }
        }else {
            errorLogs.add(new TblErrorLog(10022,ErrorPram.getErrorPram().get(10022),information.getId(),information.getXwcolumn()));
        }
        //发布日期  必须不为空且执行无异常
        if (adapter.getReleasedate()!=null&&adapter.getReleasedate()!="") {
            try {
                String entry = javaScriptUtils.entry(information.getNewscontentnotupdate(), JavaScript_static.LAWSTARLIB_JS + adapter.getReleasedate());

                if ("".equals(entry)){
                    errorLogs.add(new TblErrorLog(10041,ErrorPram.getErrorPram().get(10041),information.getId(),information.getXwcolumn()));
                }
                result.setReleasetime(entry);
            }catch (Exception e){
                errorLogs.add(new TblErrorLog(1004,ErrorPram.getErrorPram().get(1004),information.getId(),information.getXwcolumn()));
            }
        }else {
            errorLogs.add(new TblErrorLog(10042,ErrorPram.getErrorPram().get(10042),information.getId(),information.getXwcolumn()));
        }
        //文号
        if (adapter.getNewnum()!=null&&adapter.getNewnum()!="") {
            try {
                String entry = javaScriptUtils.entry(information.getNewscontentnotupdate(), JavaScript_static.LAWSTARLIB_JS + adapter.getNewnum());

/*                if ("".equals(entry)){
                    errorLogs.add(new TblErrorLog(10031,ErrorPram.getErrorPram().get(10031),information.getId(),information.getXwcolumn()));
                }*/
                result.setFilenum(entry);
            }catch (Exception e){
                errorLogs.add(new TblErrorLog(1003,ErrorPram.getErrorPram().get(1003),information.getId(),information.getXwcolumn()));
            }
        }else {
            errorLogs.add(new TblErrorLog(10032,ErrorPram.getErrorPram().get(10032),information.getId(),information.getXwcolumn()));
        }
        //实施日期
        if (adapter.getImplementdate()!=null&&adapter.getImplementdate()!="") {
            try {
                String entry = javaScriptUtils.entry(information.getNewscontentnotupdate(), JavaScript_static.LAWSTARLIB_JS + adapter.getImplementdate());

                if ("".equals(entry)){
                    //errorLogs.add(new TblErrorLog(10051,ErrorPram.getErrorPram().get(10051),information.getId()));
                }
                result.setImptime(entry);
            }catch (Exception e){
                //errorLogs.add(new TblErrorLog(1005,ErrorPram.getErrorPram().get(1005),information.getId()));
            }
        }else {
            result.setImptime("");
            //errorLogs.add(new TblErrorLog(10052,ErrorPram.getErrorPram().get(10052),information.getId()));
        }
        //附件
        if (adapter.getAttachment()!=null&&adapter.getAttachment()!="") {
            try {
                String entry = javaScriptUtils.entry(information.getNewscontentnotupdate(), JavaScript_static.LAWSTARLIB_JS + adapter.getAttachment());

/*                if ("".equals(entry)){
                    errorLogs.add(new TblErrorLog(10061,ErrorPram.getErrorPram().get(10061),information.getId(),information.getXwcolumn()));
                }*/

                //避免出现&被转义成&amp;的情况，因此将附件链接decode一下
                result.setAttachment(HtmlUtil.unescape(entry));
            }catch (Exception e){
                errorLogs.add(new TblErrorLog(1006,ErrorPram.getErrorPram().get(1006),information.getId(),information.getXwcolumn()));
            }
        }else {
            errorLogs.add(new TblErrorLog(10062,ErrorPram.getErrorPram().get(10062),information.getId(),information.getXwcolumn()));
        }
        result.setInformationId(information.getId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String createTime = simpleDateFormat.format(new Date());
        result.setCreatetime(createTime);
        result.setSource(information.getSource());
        result.setXwcolumn(information.getXwcolumn()+"");
        //使用实施日期字段存放 websiteid
        result.setImptime(information.getWebsiteid()+"");
        //存储结果集
        Map resu = new HashMap<String,String>();

        //正文和标题不为 "" 则进行rdt处理
        if (!"".equals(result.getNewstitle())&&!"".equals(result.getNewscontent())) {
            InformationPipelineWithBLOBs rdtResult = getRdtResult(information, request, errorLogs, result);

            //对rdt处理后的数据信息 再次进行数据清洗(二次检查【矫正】)
            rdtResult = twicedPipelineEntry(rdtResult,errorLogs,javaScriptUtils,information,informationtwices_title,informationtwices_content,informationtwices_newsnum,informationtwices_attachment,informationtwices_releasedate);


            //rdt处理后  进行质量检查
            validEntry(rdtResult,errorLogs,javaScriptUtils,information,informationchecks_title,informationchecks_content,informationchecks_newsnum,informationchecks_attachment,informationchecks_releasedate);
            resu.put("result",rdtResult);

        }
        resu.put("result",result);
        resu.put("errorlogs",errorLogs);
        return resu;
    }

    //动态修改脚本返回值  使其返回带标签的正文内容
    private String dynamicJavaScript(String s) {
        String replace = s.replace("txt = deal_prepared(txt);", "txt = deal_prepared(txt);return txt;");
        return replace;
    }

    private InformationPipelineWithBLOBs twicedPipelineEntry(InformationPipelineWithBLOBs rdtResult, List<TblErrorLog> errorLogs, JavaScriptUtils javaScriptUtils, TXwInformationWithBLOBs information, List<Informationtwice> informationchecks_title, List<Informationtwice> informationchecks_content, List<Informationtwice> informationchecks_newsnum, List<Informationtwice> informationchecks_attachment, List<Informationtwice> informationchecks_releasedate) {
        String xwcolumn = rdtResult.getXwcolumn();
        String dbn = "chl"; //数据库类型
        if (xwcolumn .equals("100002")){
            dbn = "chl";
        }else if (xwcolumn .equals("100003")){
            dbn = "lar";
        }

        if (informationchecks_title!=null){
            for (Informationtwice informationcheck:informationchecks_title
                    ) {
                try {
                    rdtResult.setNewstitle( javaScriptUtils.twicedEntry(rdtResult.getNewstitle(),rdtResult.getReleasetime(),rdtResult.getFilenum(),rdtResult.getDeptcode(),rdtResult.getDeptname(),dbn,rdtResult.getAttachment(),information.getNewscontentnotupdate(),rdtResult.getNewscontent(),JavaScript_static.LAWSTARLIB_JS+informationcheck.getTwiceScript()));
                } catch (Exception e) {
                    errorLogs.add(new TblErrorLog(10015, ErrorPram.getErrorPram().get(10015),information.getId(),information.getXwcolumn()));
                    e.printStackTrace();
                }
            }
        }
        if (informationchecks_content!=null){
            for (Informationtwice informationcheck:informationchecks_content
                    ) {
                try {
                    rdtResult.setNewscontent( javaScriptUtils.twicedEntry(rdtResult.getNewstitle(),rdtResult.getReleasetime(),rdtResult.getFilenum(),rdtResult.getDeptcode(),rdtResult.getDeptname(),dbn,rdtResult.getAttachment(),information.getNewscontentnotupdate(),rdtResult.getNewscontent(),JavaScript_static.LAWSTARLIB_JS+informationcheck.getTwiceScript()));

                } catch (Exception e) {
                    errorLogs.add(new TblErrorLog(10024, ErrorPram.getErrorPram().get(10024),information.getId(),information.getXwcolumn()));
                    e.printStackTrace();
                }
            }
        }
        if (informationchecks_newsnum!=null){
            for (Informationtwice informationcheck:informationchecks_newsnum
                    ) {
                try {
                    rdtResult.setFilenum( javaScriptUtils.twicedEntry(rdtResult.getNewstitle(),rdtResult.getReleasetime(),rdtResult.getFilenum(),rdtResult.getDeptcode(),rdtResult.getDeptname(),dbn,rdtResult.getAttachment(),information.getNewscontentnotupdate(),rdtResult.getNewscontent(),JavaScript_static.LAWSTARLIB_JS+informationcheck.getTwiceScript()));

                } catch (Exception e) {
                    errorLogs.add(new TblErrorLog(10035, ErrorPram.getErrorPram().get(10035),information.getId(),information.getXwcolumn()));
                    e.printStackTrace();
                }
            }
        }
        if (informationchecks_attachment!=null){
            for (Informationtwice informationcheck:informationchecks_attachment
                    ) {
                try {
                    rdtResult.setAttachment( javaScriptUtils.twicedEntry(rdtResult.getNewstitle(),rdtResult.getReleasetime(),rdtResult.getFilenum(),rdtResult.getDeptcode(),rdtResult.getDeptname(),dbn,rdtResult.getAttachment(),information.getNewscontentnotupdate(),rdtResult.getNewscontent(),JavaScript_static.LAWSTARLIB_JS+informationcheck.getTwiceScript()));

                } catch (Exception e) {
                    errorLogs.add(new TblErrorLog(10066, ErrorPram.getErrorPram().get(10066),information.getId(),information.getXwcolumn()));
                    e.printStackTrace();
                }
            }
        }
        if (informationchecks_releasedate!=null){
            for (Informationtwice informationcheck:informationchecks_releasedate
                    ) {
                try {
                    rdtResult.setReleasetime( javaScriptUtils.twicedEntry(rdtResult.getNewstitle(),rdtResult.getReleasetime(),rdtResult.getFilenum(),rdtResult.getDeptcode(),rdtResult.getDeptname(),dbn,rdtResult.getAttachment(),information.getNewscontentnotupdate(),rdtResult.getNewscontent(),JavaScript_static.LAWSTARLIB_JS+informationcheck.getTwiceScript()));

                } catch (Exception e) {
                    errorLogs.add(new TblErrorLog(10045, ErrorPram.getErrorPram().get(10045),information.getId(),information.getXwcolumn()));
                    e.printStackTrace();
                }
            }
        }

        return rdtResult;
        //errorLogs.add(new TblErrorLog(1009, ErrorPram.getErrorPram().get(1009),information.getId(),information.getXwcolumn()));

    }

    private void validEntry(InformationPipelineWithBLOBs rdtResult, List<TblErrorLog> errorLogs, JavaScriptUtils javaScriptUtils, TXwInformationWithBLOBs information, List<Informationcheck> informationchecks_title, List<Informationcheck> informationchecks_content, List<Informationcheck> informationchecks_newsnum, List<Informationcheck> informationchecks_attachment, List<Informationcheck> informationchecks_releasedate) {

        String xwcolumn = rdtResult.getXwcolumn();
        String dbn = "chl"; //数据库类型
        if (xwcolumn .equals("100002")){
            dbn = "chl";
        }else if (xwcolumn .equals("100003")){
            dbn = "lar";
        }

        if (informationchecks_title!=null){
            for (Informationcheck informationcheck:informationchecks_title
                    ) {
                try {
                    String resu = javaScriptUtils.validEntry(rdtResult.getNewstitle(),rdtResult.getReleasetime(),rdtResult.getFilenum(),rdtResult.getDeptcode(),rdtResult.getDeptname(),dbn,rdtResult.getAttachment(),information.getNewscontentnotupdate(),rdtResult.getNewscontent(),rdtResult.getExtend2(),JavaScript_static.LAWSTARLIB_JS +informationcheck.getCkScript());

                    if (resu.indexOf("false")>-1){
                        String[] resus = resu.split("#");
                        errorLogs.add(new TblErrorLog(Integer.parseInt(resus[1]), resus[2],information.getId(),information.getXwcolumn()));
                        break;
                    }
                } catch (Exception e) {
                    errorLogs.add(new TblErrorLog(10014, ErrorPram.getErrorPram().get(10014),information.getId(),information.getXwcolumn()));
                    e.printStackTrace();
                }
            }
        }
        if (informationchecks_content!=null){
            for (Informationcheck informationcheck:informationchecks_content
                    ) {
                try {
                    String resu = javaScriptUtils.validEntry(rdtResult.getNewstitle(),rdtResult.getReleasetime(),rdtResult.getFilenum(),rdtResult.getDeptcode(),rdtResult.getDeptname(),dbn,rdtResult.getAttachment(),information.getNewscontentnotupdate(),rdtResult.getNewscontent(),rdtResult.getExtend2(),JavaScript_static.LAWSTARLIB_JS +informationcheck.getCkScript());

                    if (resu.indexOf("false")>-1){
                        String[] resus = resu.split("#");
                        errorLogs.add(new TblErrorLog(Integer.parseInt(resus[1]), resus[2],information.getId(),information.getXwcolumn()));
                        break;
                    }
                } catch (Exception e) {
                    errorLogs.add(new TblErrorLog(10023, ErrorPram.getErrorPram().get(10023),information.getId(),information.getXwcolumn()));
                    e.printStackTrace();
                }
            }
        }
        if (informationchecks_newsnum!=null){
            for (Informationcheck informationcheck:informationchecks_newsnum
                    ) {
                try {
                    String resu = javaScriptUtils.validEntry(rdtResult.getNewstitle(),rdtResult.getReleasetime(),rdtResult.getFilenum(),rdtResult.getDeptcode(),rdtResult.getDeptname(),dbn,rdtResult.getAttachment(),information.getNewscontentnotupdate(),rdtResult.getNewscontent(),rdtResult.getExtend2(),JavaScript_static.LAWSTARLIB_JS +informationcheck.getCkScript());

                    if (resu.indexOf("false")>-1){
                        String[] resus = resu.split("#");
                        errorLogs.add(new TblErrorLog(Integer.parseInt(resus[1]), resus[2],information.getId(),information.getXwcolumn()));
                        break;
                    }
                } catch (Exception e) {
                    errorLogs.add(new TblErrorLog(10034, ErrorPram.getErrorPram().get(10034),information.getId(),information.getXwcolumn()));
                    e.printStackTrace();
                }
            }
        }
        if (informationchecks_attachment!=null){
            for (Informationcheck informationcheck:informationchecks_attachment
                    ) {
                try {
                    String resu = javaScriptUtils.validEntry(rdtResult.getNewstitle(),rdtResult.getReleasetime(),rdtResult.getFilenum(),rdtResult.getDeptcode(),rdtResult.getDeptname(),dbn,rdtResult.getAttachment(),information.getNewscontentnotupdate(),rdtResult.getNewscontent(),rdtResult.getExtend2(),JavaScript_static.LAWSTARLIB_JS +informationcheck.getCkScript());

                    if (resu.indexOf("false")>-1){
                        String[] resus = resu.split("#");
                        errorLogs.add(new TblErrorLog(Integer.parseInt(resus[1]), resus[2],information.getId(),information.getXwcolumn()));
                        break;
                    }
                } catch (Exception e) {
                    errorLogs.add(new TblErrorLog(10065, ErrorPram.getErrorPram().get(10065),information.getId(),information.getXwcolumn()));
                    e.printStackTrace();
                }
            }
        }
        if (informationchecks_releasedate!=null){
            for (Informationcheck informationcheck:informationchecks_releasedate
                    ) {
                try {
                    String resu = javaScriptUtils.validEntry(rdtResult.getNewstitle(),rdtResult.getReleasetime(),rdtResult.getFilenum(),rdtResult.getDeptcode(),rdtResult.getDeptname(),dbn,rdtResult.getAttachment(),information.getNewscontentnotupdate(),rdtResult.getNewscontent(),rdtResult.getExtend2(),JavaScript_static.LAWSTARLIB_JS +informationcheck.getCkScript());

                    if (resu.indexOf("false")>-1){
                        String[] resus = resu.split("#");
                        errorLogs.add(new TblErrorLog(Integer.parseInt(resus[1]), resus[2],information.getId(),information.getXwcolumn()));
                        break;
                    }
                } catch (Exception e) {
                    errorLogs.add(new TblErrorLog(10044, ErrorPram.getErrorPram().get(10044),information.getId(),information.getXwcolumn()));
                    e.printStackTrace();
                }
            }
        }

        //errorLogs.add(new TblErrorLog(1009, ErrorPram.getErrorPram().get(1009),information.getId(),information.getXwcolumn()));

    }

    public InformationPipelineWithBLOBs getRdtResult(TXwInformationWithBLOBs information, HttpServletRequest request, List<TblErrorLog> errorLogs, InformationPipelineWithBLOBs result) {
        //添加 rdt信息处理
        TXwWebsite tXwWebsite = new TXwWebsite();//避免空指针
        TXwWebsite tXwWebsite1 = websiteMapper.selectByPrimaryKey(information.getWebsiteid());
        //TXwWebsite tXwWebsite1 = websiteMapper.selectById(information.getWebsiteid());
        if (tXwWebsite1!=null){
            tXwWebsite = tXwWebsite1;//获取部门代码
        }

        //保存到临时库
        RecordDataType rdt = new RecordDataType();
        MainDeal md = new MainDeal();

/*        //title转换
        String title = "";
        try {
             title = new String(result.getNewstitle().getBytes(),"gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        Integer xwcolumn = information.getXwcolumn();
        String dbn = "chl"; //数据库类型
        if (xwcolumn == 100002){
            dbn = "chl";
        }else if (xwcolumn == 100003){
            dbn = "lar";
        }
        md.setPath(request.getRealPath("/resources/"));
        try {
            //记录未处理正文

            StringBuilder logs = new StringBuilder();
            logs.append("新闻ID："+result.getInformationId()+"\r\n");
            logs.append("原始正文："+result.getNewscontent()+"\r\n");

            rdt = md.doAllTask(tXwWebsite.getBelongdepartment()+"",tXwWebsite.getDepartmentDbName(), result.getNewstitle(), result.getFilenum(), result.getNewscontent(), dbn,tXwWebsite.getTitlestatus(),tXwWebsite.getNewsnumstatus(),result.getReleasetime(),null);

            //记录处理后的正文
            logs.append("rdt处理后正文："+rdt.getTxt()+"\r\n");

            String logscontent = logs.toString();
            //当前日期
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");//设置日期格式
            String date = dateFormat.format(now);
            writeLogs(request.getRealPath("/resources/logs/newscontentlogs"+date+".txt"),logscontent);
        }catch (ArrayIndexOutOfBoundsException e){
            errorLogs.add(new TblErrorLog(1009, ErrorPram.getErrorPram().get(1009),information.getId(),information.getXwcolumn()));
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        //处理后重新装载result

        result.setNewstitle(rdt.getRJS0()==null?"":rdt.getRJS0().equals("")?result.getNewstitle():rdt.getRJS0());
        result.setDeptcode(rdt.getRJS4()==null?"":rdt.getRJS4().equals("")?result.getDeptcode():rdt.getRJS4());
        result.setDeptname(rdt.getRJS10()==null?"":rdt.getRJS10().equals("")?result.getDeptname():rdt.getRJS10());
        result.setFilenum(rdt.getRJS12()==null?"":rdt.getRJS12().equals("")?result.getFilenum():rdt.getRJS12());
        result.setNewscontent(rdt.getTxt()==null?"":rdt.getTxt().equals("")?result.getNewscontent():rdt.getTxt());
        result.setRjs1(rdt.getRJS1()==null?"":rdt.getRJS1());
        result.setKeyword(rdt.getKword()==null?"":rdt.getKword());
        result.setRjs14(rdt.getRJS14()==null?"":rdt.getRJS14().equals("")?result.getRjs14():rdt.getRJS14());
        result.setRjs15(rdt.getRJS15()==null?"":rdt.getRJS15().equals("")?result.getRjs15():rdt.getRJS15());
        //设置 发布日期、实施日期
        result.setReleasetime(rdt.getRJS5()==null?"":rdt.getRJS5());
        result.setExtend1(rdt.getRJS6()==null?"":rdt.getRJS6());//实施日期

        //如果新闻的栏目与rdt返回的不同则标记为 error
        if (StringUtils.isNotBlank(rdt.getDbsType())){
            int rdt_type = Integer.parseInt(rdt.getDbsType().equals("chl")?"100002":"100003");

            if (!(rdt_type==information.getXwcolumn())){
                errorLogs.add(new TblErrorLog(1011, ErrorPram.getErrorPram().get(1011),information.getId(),information.getXwcolumn()));
            }
        }


        return result;
    }


    public  void writeLogs(String file, String conent) {
        FileWriter fw = null;
        try {
//如果文件存在，则追加内容；如果文件不存在，则创建文件
            File f=new File(file);
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(conent);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InformationPipelineWithBLOBs regSingleNews(int informationid) {
        TXwInformationWithBLOBs information = informationMapper.selectByPrimaryKey(informationid);
        TWxAdapterExample adapterExample = new TWxAdapterExample();
        TWxAdapterExample.Criteria criteria = adapterExample.createCriteria();
        criteria.andSiteidEqualTo(information.getWebsiteid());
        List<TWxAdapterWithBLOBs> tWxAdapters = adapterMapper.selectByExampleWithBLOBs(adapterExample);



        JavaScriptUtils javaScriptUtils = new JavaScriptUtils();
        InformationPipelineWithBLOBs result = new InformationPipelineWithBLOBs();
        for (TWxAdapterWithBLOBs adapter:tWxAdapters
             ) {

            //标题
            try {
                String entry = javaScriptUtils.entry(information.getNewscontentnotupdate(), JavaScript_static.LAWSTARLIB_JS + adapter.getTitle());
                result.setNewstitle(entry==null?"":entry);
            }catch (Exception e){
                result.setNewstitle("");
                e.printStackTrace();
            }

            //正文
            try {
                String entry = javaScriptUtils.entry(information.getNewscontentnotupdate(),JavaScript_static.LAWSTARLIB_JS+adapter.getComposetext());
                result.setNewscontent(entry==null?"":entry);
            }catch (Exception e){
                result.setNewscontent("");
                e.printStackTrace();
            }

            //发布日期
                try {
                String entry = javaScriptUtils.entry(information.getNewscontentnotupdate(),JavaScript_static.LAWSTARLIB_JS+adapter.getReleasedate());
                    result.setReleasetime(entry==null?"":entry);
                }catch (Exception e){
                    result.setReleasetime("");
                    e.printStackTrace();
                }
            //文号

               try {
                  String entry =   javaScriptUtils.entry(information.getNewscontentnotupdate(),JavaScript_static.LAWSTARLIB_JS+adapter.getNewnum());
                   result.setFilenum(entry==null?"":entry);
               }catch (Exception e){
                   result.setFilenum("");
                   e.printStackTrace();
               }


            //附件
               try {
                String entry =    javaScriptUtils.entry(information.getNewscontentnotupdate(),JavaScript_static.LAWSTARLIB_JS+adapter.getAttachment());
                   result.setAttachment(entry==null?"":entry);
               }catch (Exception e){
                   result.setAttachment("");
                   e.printStackTrace();
               }

        }
        result.setSource(information.getSource());
        result.setInformationId(information.getId());
        result.setId(information.getWebsiteid());
        return result;


    }

    public String get_IMG_URL_By_Js(String title,String appDate,String numTxt,String depcode,String deptName,String dbsType,String AttachStr,String src_code,String txt,String txt_code,String javaScript) {
        JavaScriptUtils javaScriptUtils = new JavaScriptUtils();
        String entry = "";
        try {
             entry = javaScriptUtils.imgEntry(title,appDate,numTxt,depcode,deptName,dbsType,AttachStr,src_code,txt,txt_code,javaScript);

        }catch (Exception e){

            e.printStackTrace();
        }


        return entry;
    }
}
