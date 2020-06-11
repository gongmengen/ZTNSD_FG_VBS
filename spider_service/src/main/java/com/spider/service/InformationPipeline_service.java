package com.spider.service;

import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.spider.bean.*;
import com.spider.elemente.ErrorPram;
import com.spider.elemente.TimerParm;
import com.spider.mapper.InformationPipelineMapper;
import com.spider.mapper.MainCHLandLARMapper;
import com.spider.utils.DistinctMainPramUtil;
import com.spider.utils.NioFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class InformationPipeline_service {
    @Autowired
    private InformationPipelineMapper informationPipelineMapper;
    @Autowired
    private MainCHLandLARMapper mainCHLandLARMapper;
    @Autowired
    private MainCHLandLAR_service mainCHLandLAR_service;
    @Autowired
    private ErrorLog_service errorLog_service;



    //已导出数据中是否存在该id
    public  boolean checkOverOutPutExistId(int id){
        InformationPipelineExample example = new InformationPipelineExample();
        InformationPipelineExample.Criteria criteria = example.createCriteria();
        criteria.andInformationIdEqualTo(id);
        criteria.andIstatusEqualTo(1);
        List<InformationPipeline> informationPipelineList = informationPipelineMapper.selectByExample(example);
        return informationPipelineList.size()>0;
    }
    //获取已导入新闻
    public List<InformationPipeline> getOutPutOverInformationPipelineList(int xwcolumn,String websiteids,int level){
        List<InformationPipeline> informationPipelineList = new ArrayList<InformationPipeline>();
        if (level == -1) {
            InformationPipelineExample informationPipelineExample = new InformationPipelineExample();
            InformationPipelineExample.Criteria criteria = informationPipelineExample.createCriteria();
            criteria.andIstatusEqualTo(1);
            criteria.andXwcolumnEqualTo(xwcolumn + "");
            informationPipelineList = informationPipelineMapper.selectByExample(informationPipelineExample);
        }else {
            informationPipelineList = informationPipelineMapper.getOutPutOverByUser(xwcolumn,websiteids);
        }
        return informationPipelineList;
    }


    //检查是否重复
    public void checkInformationExist(InformationPipeline informationPipeline){
        List<InformationPipeline> information = informationPipelineMapper.getInformationBySource(informationPipeline.getSource());

        //结果集
        List<InformationPipeline> resu = new ArrayList<InformationPipeline>();
        ArrayList<TblErrorLog> tblErrorLogs = new ArrayList<>();
        if (information!=null&&information.size()>0){
            tblErrorLogs.add(new TblErrorLog(10071, ErrorPram.errorPram.get(10071), informationPipeline.getInformationId(), Integer.parseInt(informationPipeline.getXwcolumn())));
        }else {
            //pram
            DistinctMainPramUtil distinctMainPramUtil = new DistinctMainPramUtil();
            String sqlTitle = distinctMainPramUtil.getSQLTitle(informationPipeline.getNewstitle());
            String[] releaseTime = distinctMainPramUtil.getReleaseTime(informationPipeline.getReleasetime());
            String rjs12 = distinctMainPramUtil.getWenHao(informationPipeline.getFilenum());
            String rjs10 = informationPipeline.getDeptcode();
            //condition
            List<InformationPipeline> mainListWithRjs0 = new ArrayList<InformationPipeline>();
            List<InformationPipeline> mainListWithRjs12 = new ArrayList<InformationPipeline>();
            List<InformationPipeline> mainListWithRjs0NotLike = new ArrayList<InformationPipeline>();
            List<InformationPipeline> mainListWithRjs12NotLike = new ArrayList<InformationPipeline>();

            try {
                a:
                while (true) {
                    mainListWithRjs0NotLike = mainCHLandLARMapper.selectByRjs0NotLike_6(rjs10,informationPipeline.getNewstitle(), releaseTime[0], releaseTime[1]);
                    if (mainListWithRjs0NotLike.size() > 0) {
                        tblErrorLogs.add(new TblErrorLog(1007, ErrorPram.errorPram.get(1007) + "select * from information_pipeline where deptcode = '%"+rjs10+"%' AND newsTitle  = '" + informationPipeline.getNewstitle() + "' AND createTime &gt;= " + releaseTime[0] + " AND  createTime &lt;=" + releaseTime[1], informationPipeline.getInformationId(), Integer.parseInt(informationPipeline.getXwcolumn())));
                        break a;
                    }

                    mainListWithRjs0 = mainCHLandLARMapper.selectByRjs0_6(rjs10,sqlTitle, releaseTime[0], releaseTime[1]);
                    if (mainListWithRjs0.size() > 0) {
                        tblErrorLogs.add(new TblErrorLog(1007, ErrorPram.errorPram.get(1007) + "select * from information_pipeline where deptcode LIKE '%"+rjs10+"%' AND newsTitle " + sqlTitle + " and createTime &gt;= " + releaseTime[0] + " AND  createTime &lt;=" + releaseTime[1], informationPipeline.getInformationId(), Integer.parseInt(informationPipeline.getXwcolumn())));
                        break a;
                    }

                    if (!"".equals(rjs12) && !"".equals(rjs10)) {
                        mainListWithRjs12 = mainCHLandLARMapper.selectByRjs12_6(rjs12, rjs10, releaseTime[0], releaseTime[1]);
                        if (mainListWithRjs12.size() > 0) {
                            tblErrorLogs.add(new TblErrorLog(1007, ErrorPram.errorPram.get(1007) + "select * from information_pipeline where deptcode LIKE '%" + rjs10 + "%' AND filenum like '%" + rjs12 + "%' and createTime &gt;= " + releaseTime[0] + " AND  createTime &lt;=" + releaseTime[1], informationPipeline.getInformationId(), Integer.parseInt(informationPipeline.getXwcolumn())));
                            break a;
                        }
                    }
                    if (!"".equals(informationPipeline.getFilenum()) && !"".equals(rjs10)) {
                        mainListWithRjs12NotLike = mainCHLandLARMapper.selectByRjs12NotLike_6(informationPipeline.getFilenum(), rjs10, releaseTime[0], releaseTime[1]);
                        if (mainListWithRjs12NotLike.size() > 0) {
                            tblErrorLogs.add(new TblErrorLog(1007, ErrorPram.errorPram.get(1007) + "select * from information_pipeline where deptcode = '" + rjs10 + "' AND filenum = '" + informationPipeline.getFilenum() + "' and createTime &gt;= " + releaseTime[0] + " AND  createTime &lt;=" + releaseTime[1], informationPipeline.getInformationId(), Integer.parseInt(informationPipeline.getXwcolumn())));
                            break a;
                        }
                    }
                    break a;
                }
            } catch (Exception e) {
                System.out.println("判断重复执行异常");
            }
            //合并
            resu.addAll(mainListWithRjs0);
            resu.addAll(mainListWithRjs12);
            resu.addAll(mainListWithRjs0NotLike);
            resu.addAll(mainListWithRjs12NotLike);


            if (resu != null && resu.size() > 0) {

                informationPipeline.setPreDistinct(2);//设置为 ‘必重’
                //重复数据
                StringBuilder distinctStr = new StringBuilder();
                for (InformationPipeline main : resu
                        ) {
                    distinctStr.append("\r\n标题：" + main.getNewstitle());
                    distinctStr.append("\r\n部门：" + main.getDeptname());
                    distinctStr.append("\r\n部门代码：" + main.getDeptcode());
                    distinctStr.append("\r\n文号：" + main.getFilenum());
                    distinctStr.append("\r\n发布日期：" + main.getReleasetime());
                    distinctStr.append("\r\n文件名：" + main.getFilename());
                    distinctStr.append("\r\n唯一标识：" + main.getId());
                }
                tblErrorLogs.add(new TblErrorLog(1008, ErrorPram.errorPram.get(1008) + distinctStr, informationPipeline.getInformationId(), Integer.parseInt(informationPipeline.getXwcolumn())));
                //存放到tmp数据库
            }
        }
        errorLog_service.insert(tblErrorLogs);
    }



    //根据information_id获取js处理后的informationpipeline对象
    public InformationPipelineWithBLOBs findInformationPipelineByID(int id){

        return informationPipelineMapper.selectByPrimaryKey(id);
    }
    //根据information_id获取js处理后的informationpipeline对象
    public InformationPipelineWithBLOBs findInformationPipelineById(int id,int xwcolumn){
        InformationPipelineExample example = new InformationPipelineExample();
        InformationPipelineExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andXwcolumnEqualTo(xwcolumn+"");
        List<InformationPipelineWithBLOBs> informationPipelines = informationPipelineMapper.selectByExampleWithBLOBs(example);
        return informationPipelines.size()>0?informationPipelines.get(0):new InformationPipelineWithBLOBs();
    }

    //information 入库
    public void insertList(InformationPipelineWithBLOBs informationPipeline){
            informationPipelineMapper.insertSelective(informationPipeline);

    }
    //获取50篇预处理后的新闻 中央
    public List<InformationPipeline> findInformationPipelineList(Integer websiteid,String websiteids){
        List<InformationPipeline> fiftyInformation = new ArrayList<InformationPipeline>();
        if (websiteid<0){
            //root用户
            fiftyInformation = informationPipelineMapper.getFiftyInformation();
        }else {
            //已分配任务的用户

            fiftyInformation = informationPipelineMapper.getFiftyInformationByUserTask(websiteids);

        }
        return fiftyInformation;
    }

    //获取50篇预处理后的新闻 地方
    public List<InformationPipeline> findInformationPipelineListLar(Integer websiteid,String websiteids){
        List<InformationPipeline> fiftyInformation = new ArrayList<InformationPipeline>();
        if (websiteid<0){
            //root用户
            fiftyInformation = informationPipelineMapper.getFiftyInformationlar();
        }else {
            //已分配任务的用户

            fiftyInformation = informationPipelineMapper.getFiftyInformationlarByUserTask(websiteids);

        }
        return fiftyInformation;
    }

    //根据id获取
    public List<InformationPipelineWithBLOBs> getInformationPipelineByIds(String[] ids){
        List<InformationPipelineWithBLOBs> resu = new ArrayList<InformationPipelineWithBLOBs>();
        for (String id:ids
             ) {
            resu.add(informationPipelineMapper.selectByPrimaryKey(Integer.parseInt(id)));
        }
        return resu;
    }

    //修改导出状态为1
    public int updateIstatus(InformationPipelineWithBLOBs informationPipeline,int id){

        InformationPipelineExample example = new InformationPipelineExample();
        InformationPipelineExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return informationPipelineMapper.updateByExampleSelective(informationPipeline,example);
    }

    public String getMaxRjs8(String username) {
        return informationPipelineMapper.findMaxRjs8(username);
    }

    public void deleteAllByIds(String[] ids, HttpServletRequest request) throws IOException {
        //remove 服务器上上的附件 以及 txt
        List<InformationPipeline> resu = new ArrayList<InformationPipeline>();
        for (String id:ids
                ) {
            InformationPipelineWithBLOBs information = informationPipelineMapper.selectByPrimaryKey(Integer.parseInt(id));
            String filename = information.getFilename();//Timer001s001.txt
            String dirname = filename.substring(0,filename.indexOf("."));//Timer001s001

            //删除附件
            Path attachment = Paths.get(request.getRealPath(TimerParm.attachmentPATH)+ File.separator+dirname);
            NioFileUtil.deleteIfExists(attachment);
            //删除txt
            Path txt = Paths.get(request.getRealPath(TimerParm.destDir)+ File.separator+dirname);
            NioFileUtil.deleteIfExists(txt);
            //删除copytxt
            Path copytxt = Paths.get(request.getRealPath(TimerParm.copyDir)+ File.separator+filename);
            NioFileUtil.deleteIfExists(copytxt);

            //delete
            informationPipelineMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }


    }

    public int getLastInformationId(int id,String websiteids,int level,int xwcolumn) {
        if (level < 0){

            return informationPipelineMapper.getLastInformationId(id,xwcolumn)==null?-1:informationPipelineMapper.getLastInformationId(id,xwcolumn).getId();
        }else {
            return informationPipelineMapper.getLastInformationIdWithWebsiteid(id,xwcolumn,websiteids)==null?-1:informationPipelineMapper.getLastInformationIdWithWebsiteid(id,xwcolumn,websiteids).getId();
        }
    }

    public int getNextInformationId(int id,String websiteids,int level,int xwcolumn) {
        if (level < 0){
        return informationPipelineMapper.getNextInformationId(id,xwcolumn)==null?-1:informationPipelineMapper.getNextInformationId(id,xwcolumn).getId();
        }else {
            return informationPipelineMapper.getNextInformationIdWithWebsiteid(id,xwcolumn,websiteids)==null?-1:informationPipelineMapper.getNextInformationIdWithWebsiteid(id,xwcolumn,websiteids).getId();
        }
        }

    public int getOutOverLastInformationId(int id,int xwcolumn,String websiteids, Integer level) {
        if (level < 0){

            return informationPipelineMapper.getOutOverLastInformationId(id,xwcolumn)==null?-1:informationPipelineMapper.getOutOverLastInformationId(id,xwcolumn).getId();
        }else {
            return informationPipelineMapper.getOutOverLastInformationIdWithWebsiteid(id,xwcolumn,websiteids)==null?-1:informationPipelineMapper.getOutOverLastInformationIdWithWebsiteid(id,xwcolumn,websiteids).getId();
        }
    }

    public int getOutOverNextInformationId(int id,int xwcolumn, String websiteids, Integer level) {
        if (level < 0){
            return informationPipelineMapper.getOutOverNextInformationId(id,xwcolumn)==null?-1:informationPipelineMapper.getOutOverNextInformationId(id,xwcolumn).getId();
        }else {
            return informationPipelineMapper.getOutOverNextInformationIdWithWebsiteid(id,xwcolumn,websiteids)==null?-1:informationPipelineMapper.getOutOverNextInformationIdWithWebsiteid(id,xwcolumn,websiteids).getId();
        }
    }

    public List<InformationPipelineWithBLOBs> getInformationPipelineListWithRefmain2(String websiteids) {
        return informationPipelineMapper.getInformationPipelineListWithRefmain2(websiteids);
    }

    public List<InformationPipelineWithBLOBs> getInformationPipelineListWithRefmain3(String websiteids) {
        return informationPipelineMapper.getInformationPipelineListWithRefmain3(websiteids);
    }
}
