package com.spider.mapper;

import com.spider.bean.InformationPipeline;
import com.spider.bean.InformationPipelineExample;
import java.util.List;

import com.spider.bean.InformationPipelineWithBLOBs;
import org.apache.ibatis.annotations.Param;

public interface InformationPipelineMapper {
    int countByExample(InformationPipelineExample example);

    int deleteByExample(InformationPipelineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InformationPipelineWithBLOBs record);

    int insertSelective(InformationPipelineWithBLOBs record);

    List<InformationPipelineWithBLOBs> selectByExampleWithBLOBs(InformationPipelineExample example);

    List<InformationPipeline> selectByExample(InformationPipelineExample example);

    InformationPipelineWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InformationPipelineWithBLOBs record, @Param("example") InformationPipelineExample example);

    int updateByExampleWithBLOBs(@Param("record") InformationPipelineWithBLOBs record, @Param("example") InformationPipelineExample example);

    int updateByExample(@Param("record") InformationPipeline record, @Param("example") InformationPipelineExample example);

    int updateByPrimaryKeySelective(InformationPipelineWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(InformationPipelineWithBLOBs record);

    int updateByPrimaryKey(InformationPipeline record);

    //自定义mapper
    List<InformationPipeline> getFiftyInformation();

    List<InformationPipeline> getFiftyInformationlar();

    String findMaxRjs8(@Param(value="username")String username);

    List<InformationPipeline> getInformationBySource(@Param(value="source")String source);

    InformationPipeline getNextInformationId(int id,int xwcolumn);

    InformationPipeline getLastInformationId(int id,int xwcolumn);

    List<InformationPipeline> getFiftyInformationByUserTask(@Param(value="websiteid")String websiteid);

    List<InformationPipeline> getFiftyInformationlarByUserTask(@Param(value="websiteid")String websiteids);

    InformationPipeline getLastInformationIdWithWebsiteid(int id,int xwcolumn,@Param(value="websiteids") String websiteids);

    InformationPipeline getNextInformationIdWithWebsiteid(int id,int xwcolumn,@Param(value="websiteids") String websiteids);

    List<InformationPipeline> getOutPutOverByUser(int xwcolumn,@Param(value="websiteids") String websiteids);
    //已导出新闻详情上、下一篇

    InformationPipeline getOutOverLastInformationId(int id,int xwcolumn);

    InformationPipeline getOutOverLastInformationIdWithWebsiteid(int id,int xwcolumn,@Param(value="websiteids") String websiteids);

    InformationPipeline getOutOverNextInformationId(int id,int xwcolumn);

    InformationPipeline getOutOverNextInformationIdWithWebsiteid(int id,int xwcolumn,@Param(value="websiteids") String websiteids);

    List<InformationPipelineWithBLOBs> getInformationPipelineListWithRefmain2(@Param(value="websiteids") String websiteids);

    List<InformationPipelineWithBLOBs> getInformationPipelineListWithRefmain3(@Param(value="websiteids") String websiteids);
}