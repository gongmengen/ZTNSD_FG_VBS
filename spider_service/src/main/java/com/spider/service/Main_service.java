package com.spider.service;

import cn.hutool.core.util.ReUtil;
import com.spider.bean.*;
import com.spider.mapper.MainMapper;
import com.spider.mapper.MarkdetailMainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class Main_service {

    @Autowired
    private MainMapper mainMapper;

    @Autowired
    private MarkdetailMainMapper markMainMapper;

    public int insert(MainWithBLOBs main){
        //插入之前获取lawlevel
        return mainMapper.insert(getLawlevel(main));
    }



    public String getMaxRjs8(String username) {
        return mainMapper.findMaxRjs8(username);
    }

    public List<MainWithBLOBs> getMainListWithRjs0(String rjs0){
        MainExample mainExample = new MainExample();
        MainExample.Criteria criteria = mainExample.createCriteria();
        criteria.andRjs0EqualTo(rjs0);
        return mainMapper.selectByExampleWithBLOBs(mainExample);
    }

    public List<MainWithBLOBs> getMainListWithRjs12(String rjs12){
        MainExample mainExample = new MainExample();
        MainExample.Criteria criteria = mainExample.createCriteria();
        criteria.andRjs12EqualTo(rjs12);
        return mainMapper.selectByExampleWithBLOBs(mainExample);
    }

    public List<MainWithBLOBs> getListByAppuser(String appuser,String keyword,String url) {
        return mainMapper.getListByAppuser(appuser,keyword,url);
    }

    public List<MainWithBLOBs> getMarkListByAppuser(String appuser) {
        return mainMapper.getMarkListByAppuser(appuser);
    }
    public boolean deleteByNumbers(String[] id) {
        boolean flag = true;
        for (String number : id) {
            if (mainMapper.deleteByPrimaryKey(Long.parseLong(number))<0){
                flag = false;
            }
        }
        return flag;

    }

    public MainWithBLOBs getMainByNumber(long number) {
        return mainMapper.selectByPrimaryKey(number);
    }

    public List<MainWithBLOBs> getMainByNumbers(String[] id) {

        List<MainWithBLOBs> mains = new ArrayList<MainWithBLOBs>();
        for (String s : id) {
            mains.add(mainMapper.selectByPrimaryKey(Long.parseLong(s)));
        }
        return mains;
    }

    public boolean markUpdate(MainWithBLOBs main,String markcolumn) {
        //变更为标记状态
        MainExample mainExample = new MainExample();
        MainExample.Criteria criteria = mainExample.createCriteria();
        criteria.andNumberEqualTo(main.getNumber());
        mainMapper.updateByExampleSelective(main,mainExample);

        //插入标记记录表
        MarkdetailMainWithBLOBs markdetailMain = new MarkdetailMainWithBLOBs();
        //如果已经存在
        MarkdetailMainExample markdetailMainExample = new MarkdetailMainExample();
        MarkdetailMainExample.Criteria criteria1 = markdetailMainExample.createCriteria();
        criteria1.andNumberEqualTo(main.getNumber());
        List<MarkdetailMainWithBLOBs> markdetailMains = markMainMapper.selectByExampleWithBLOBs(markdetailMainExample);


        if (markdetailMains.size()>0){
            //如果已经存在
            markdetailMain = markdetailMains.get(0);
            markdetailMain = setMarkColumn(markdetailMain, markcolumn.split(" "));
        }else {
            //如果不存在
            //复制数据
            markMainMapper.copyMainDate(main.getNumber());
            //修改标记字段
            markdetailMain = setMarkColumn(markdetailMain,markcolumn.split(" "));
            criteria1.andNumberEqualTo(main.getNumber());


        }

        markMainMapper.updateByExampleSelective(markdetailMain,markdetailMainExample);
        return Boolean.TRUE;
    }

    public boolean update(MainWithBLOBs main) {
        //修改以后通过该字段确认修改
        main.setTruetag1(9);

        MainExample mainExample = new MainExample();
        MainExample.Criteria criteria = mainExample.createCriteria();
        criteria.andNumberEqualTo(main.getNumber());
        return mainMapper.updateByExampleSelective(main,mainExample)==1?true:false;
    }


    private MainWithBLOBs getLawlevel(MainWithBLOBs main) {

        //法规级别 人大的文件设置重点，使用人大部门
        String specail_p_arr [] = new String[]{"人大","人民代表大会","人大常委会","人民代表大会常务委员会"};
        for(int mm=0;mm<specail_p_arr.length;mm++){
            if (main.getRjs10()==null){
                main.setLawlevel(5);
            }else {
                if(main.getRjs10().indexOf(specail_p_arr[mm].toLowerCase())>-1){
                    main.setLawlevel(1);
                    break;
                }
            }
        }
        if (main.getRjs12()==null){
            main.setLawlevel(5);
        }else {
            if (main.getRjs12().indexOf("令")>0)main.setLawlevel(1);
        }

        return main;
    }

    public MarkdetailMainWithBLOBs getMainMarkByNumber(long l) {
        MarkdetailMainExample example = new MarkdetailMainExample();
        MarkdetailMainExample.Criteria criteria = example.createCriteria();
        criteria.andNumberEqualTo(l);
        List<MarkdetailMainWithBLOBs> markdetailMainWithBLOBs = markMainMapper.selectByExampleWithBLOBs(example);
        return markdetailMainWithBLOBs.get(0);
    }

    public List<MarkdetailMainWithBLOBs> getMarkList(String pram,String column) {

        MarkdetailMainExample markdetailMainExample = new MarkdetailMainExample();
        MarkdetailMainExample.Criteria criteria = markdetailMainExample.createCriteria();
        criteria.andAppuserEqualTo(pram);
        if (column!=null) {
            switch (column) {
                case "标题":
                    criteria.andMarkTitleEqualTo(1);
                    break;
                case "文号":
                    criteria.andMarkFilenumEqualTo(1);
                    break;
                case "部门代码":
                    criteria.andMarkDeptcodeEqualTo(1);
                    break;
                case "部门名称":
                    criteria.andMarkDeptnameEqualTo(1);
                    break;
                case "实施日期":
                    criteria.andMarkImpEqualTo(1);
                    break;
                case "发布日期":
                    criteria.andMarkReleaseEqualTo(1);
                    break;
                case "附件":
                    criteria.andMarkAttachmentEqualTo(1);
                    break;
                case "正文":
                    criteria.andMarkContentEqualTo(1);
                    break;
                case "所属分类":
                    criteria.andMarkKindEqualTo(1);
                    break;
                case "关键字":
                    criteria.andMarkKeywordEqualTo(1);
                    break;
                case "其他":
                    criteria.andMarkOtherEqualTo(1);
                    break;
            }
        }
        return markMainMapper.selectByExampleWithBLOBs(markdetailMainExample);
    }

    public String groupColumnStatus(String appuser) {
        return markMainMapper.groupColumnStatus(appuser);
    }

    //设置标记状态
    public MarkdetailMainWithBLOBs setMarkColumn(MarkdetailMainWithBLOBs markdetailMain,String[] mainColumns){

        //如果标记了正文内部详情自动标记正文
        boolean markContent = false;
        //初始化
        markdetailMain.setMarkTitle(0);
        markdetailMain.setMarkFilenum(0);
        markdetailMain.setMarkDeptcode(0);
        markdetailMain.setMarkDeptname(0);
        markdetailMain.setMarkRelease(0);
        markdetailMain.setMarkImp(0);
        markdetailMain.setMarkAttachment(0);
        markdetailMain.setMarkContent(0);
        markdetailMain.setMarkContentTitle(0);
        markdetailMain.setMarkContentFilenum(0);
        markdetailMain.setMarkContentContent(0);
        markdetailMain.setMarkContentLk(0);
        markdetailMain.setMarkContentAttachment(0);
        markdetailMain.setMarkKind(0);
        markdetailMain.setMarkKeyword(0);
        markdetailMain.setMarkOther(0);

        for (String mainColumn : mainColumns) {
            switch (mainColumn){
                case "mark_title":
                    markdetailMain.setMarkTitle(1);
                    break;
                case "mark_filenum":
                    markdetailMain.setMarkFilenum(1);
                    break;
                case "mark_deptcode":
                    markdetailMain.setMarkDeptcode(1);
                    break;
                case "mark_deptname":
                    markdetailMain.setMarkDeptname(1);
                    break;
                case "mark_release":
                    markdetailMain.setMarkRelease(1);
                    break;
                case "mark_imp":
                    markdetailMain.setMarkImp(1);
                    break;
                case "mark_attachment":
                    markdetailMain.setMarkAttachment(1);
                    break;
                case "mark_content":
                    markdetailMain.setMarkContent(1);
                    break;
                case "mark_content_title":
                    markdetailMain.setMarkContentTitle(1);
                    markContent = true;
                    break;
                case "mark_content_filenum":
                    markdetailMain.setMarkContentFilenum(1);
                    markContent = true;
                    break;
                case "mark_content_content":
                    markdetailMain.setMarkContentContent(1);
                    markContent = true;
                    break;
                case "mark_content_lk":
                    markdetailMain.setMarkContentLk(1);
                    markContent = true;
                    break;
                case "mark_content_attachment":
                    markdetailMain.setMarkContentAttachment(1);
                    markContent = true;
                    break;
                case "mark_kind":
                    markdetailMain.setMarkKind(1);
                    break;
                case "mark_keyword":
                    markdetailMain.setMarkKeyword(1);
                    break;
                case "mark_other":
                    markdetailMain.setMarkOther(1);
                    break;
            }
        }

        if (markContent){
            markdetailMain.setMarkContent(1);
        }

        return markdetailMain;
    }

    public Map getLimitListByAppuser(Integer start, Integer pageSize, String zyzd, String keyword) {
        List<MainWithBLOBs> mainList;
        List<MainWithBLOBs> total;
        if (ReUtil.isMatch("(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]",keyword)){
            mainList = mainMapper.getLimitListByAppuser(start,pageSize,zyzd,null,keyword);
            total  = mainMapper.getListByAppuser(zyzd,null,keyword);
        }else {
            mainList = mainMapper.getLimitListByAppuser(start, pageSize, zyzd, keyword, null);
            total  = mainMapper.getListByAppuser(zyzd,keyword,null);
        }


        Map resu = new HashMap();
        resu.put("mainList",mainList);
        resu.put("total",total.size());
        return resu;
    }
}
