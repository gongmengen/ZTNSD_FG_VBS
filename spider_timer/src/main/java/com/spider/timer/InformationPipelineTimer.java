package com.spider.timer;



import com.spider.elemente.TimerParm;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;


//法规抓取新闻预处理
@Component("scheduledManager")
public class InformationPipelineTimer{



    @Scheduled(fixedRate = 60000)
    public void runs() throws IOException, InterruptedException {
        System.out.println("定时任务执行。。。");
        if (TimerParm.TIMER_STATUS.equals("open")){//全局参数  标识是否继续执行定时器
            sendRequestByHttpclientGet(TimerParm.LOCAL_HOST);
            //sendRequestByHttpclientGet(TimerParm.timerurlforchl);
            sendRequestByHttpclientGet(TimerParm.timerurlfortmp);
        }
    }

    /**
     * Get方法
     */
    @Test
    public void test1() {
        try {
            URL url = new URL(TimerParm.LOCAL_HOST);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            System.out.println(result.toString());

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Test
    public void sendRequestByHttpclientGet(String url) throws IOException, InterruptedException {

        String resu = "";
        //创建CloseableHttpClient
        HttpClientBuilder builder = HttpClientBuilder.create();
        CloseableHttpClient client = builder.build();
        HttpUriRequest httpGet = new HttpGet(url);
        client.execute(httpGet);

        //Thread.sleep(10000);

    }
}
