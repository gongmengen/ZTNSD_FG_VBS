package com.spider.timer;

import com.ifeng.auto.we_provider.common.db.DynamicDataSourceHolder;
import com.spider.bean.TblError;
import com.spider.bean.TblErrorExample;
import com.spider.elemente.ErrorPram;
import com.spider.elemente.JavaScript_static;
import com.spider.elemente.TimerParm;
import com.spider.mapper.TblErrorMapper;
import com.spider.utils.LoadResourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Component
public class Init {


    @Autowired
    private TblErrorMapper errorMapper;
    /*该注解标识在spring依赖注入完成后自动执行一次*/
    @PostConstruct
    private void init() throws IOException {
        System.out.println("正在加载js文件....");
        JavaScript_static javaScript_static = new JavaScript_static();
        javaScript_static.setLawstarlibJs();
        javaScript_static.setLawstar_title();
        javaScript_static.setLawstar_content();
        javaScript_static.setLawstar_appdate();
        javaScript_static.setLawstar_wenhao();
        javaScript_static.setLawstar_attments();
        javaScript_static.setLawstarIMG();
        System.out.println("js文件加载完成");
        //获取timerBasic.properties文件
        LoadResourceUtil loadResourceUtil = new LoadResourceUtil();
        Properties properties = loadResourceUtil.getProperties("timerBasic.properties");
        //初始化定时器参数
        TimerParm.TIMER_STATUS = properties.getProperty("timerstatus");
        TimerParm.LOCAL_HOST = properties.getProperty("timerurl");
        TimerParm.timerurlforchl = properties.getProperty("timerurlforchl");
        TimerParm.timerurlfortmp = properties.getProperty("timerurlfortmp");

        //初始化错误代码表
        Map<Integer,String> map = new HashMap<Integer, String>();
        TblErrorExample errorExample = new TblErrorExample();
        DynamicDataSourceHolder.clearCustomerType();//重点： 实际操作证明，切换的时候最好清空一下
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_B);
        List<TblError> tblErrors = errorMapper.selectByExample(errorExample);
        //切换会主数据源
        DynamicDataSourceHolder.clearCustomerType();
        DynamicDataSourceHolder.setCustomerType(DynamicDataSourceHolder.DATA_SOURCE_DEFAULT);
        for (TblError tblError:tblErrors
                ) {
            map.put(tblError.getErrorcode(),tblError.getErrordesc());
        }
        ErrorPram.errorPram = map;
        //初始化文件保存路径
        TimerParm.destDir = properties.getProperty("destDir");
        TimerParm.copyDir = properties.getProperty("copyDir");
        TimerParm.attachmentPATH = properties.getProperty("attachmentPATH");
        TimerParm.username = properties.getProperty("username");
        TimerParm.txtPath5 = properties.getProperty("txtPath5");
        TimerParm.txtCopyPath5 = properties.getProperty("txtCopyPath5");
        TimerParm.fjPath5 = properties.getProperty("fjPath5");
        TimerParm.username_chl = properties.getProperty("username_chl");
        TimerParm.txt_chlPath = properties.getProperty("txt_chlPath");
        TimerParm.fjPath5_chl = properties.getProperty("fjPath5_chl");
    }
}
