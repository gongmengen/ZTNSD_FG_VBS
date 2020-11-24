package com.spider.test;

import cn.hutool.Hutool;
import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.lawstar.basic.util.Tools;
import com.lawstar.law.util.HttpsUtils;
import com.spider.elemente.TimerParm;
import com.spider.test.wordUtil.DocUtil;
//import com.spider.test.wordUtil.XlsUtil;
import com.spider.utils.NioFileUtil;


import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageProperties;
import org.apache.poi.openxml4j.util.Nullable;
import org.junit.jupiter.api.Test;


import java.io.*;
import java.net.URLEncoder;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.ListIterator;

public class T1 {

    @Test
    public void t13() throws IOException {
        Calendar cldr = Calendar.getInstance();
        cldr.set(cldr.get(1), cldr.get(2), cldr.get(5), 23, 0);
        System.out.println(cldr.getTimeInMillis());

    }
    @Test
    public void t12() throws IOException {
        String filepath = "E:\\target\\tmptxt\\zyzd\\zyzd001s116.txt";
        String targetpath = "E:\\target\\tmptxt_history\\zyzd";

        File file = new File(targetpath);
        if (!file.exists()){
            file.mkdirs();
        }
        FileUtil.copy(filepath,targetpath,true);


    }
    @Test
    public void t11() throws IOException {
        HashMap map = new HashMap();

        String jsonStr = "jQuery112404155277095262475_1604304675259({\"status\":0,\"data\":{\"list\":[{\"DocID\":139485195,\"Title\":\"Flamingoes fly over water in Kuwait City\",\"NodeId\":11143454,\"PubTime\":\"2020-11-02 15:40:59\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/02/c_139485195.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"Shi Yinglun\",\"Author\":\"Ghazy Qaffaf\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139485195_1604302840090_title.jpg\",\"IsMoreImg\":1,\"imgarray\":[\"http://www.xinhuanet.com/english/titlepic/13948/139485195_1317451860_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485195_1317451862_title0h.jpg\"],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139485195_1604302840090_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485195_1317451860_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485195_1317451862_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139485063,\"Title\":\"Berlin Brandenburg Airport opens to public\",\"NodeId\":11143454,\"PubTime\":\"2020-11-02 14:59:50\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/02/c_139485063.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"yhy\",\"Author\":\"单宇琦\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139485063_1604300041994_title.jpg\",\"IsMoreImg\":1,\"imgarray\":[\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451533_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451535_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451537_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451539_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451541_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451543_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451545_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451547_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451549_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451551_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451553_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451555_title0h.jpg\"],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1604300041994_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451533_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451535_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451537_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451539_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451541_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451543_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451545_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451547_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451549_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451551_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451553_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139485063_1317451555_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139484739,\"Title\":\"Xinhua photos of the day\",\"NodeId\":11143454,\"PubTime\":\"2020-11-02 11:19:33\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/02/c_139484739.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"yhy\",\"Author\":\"李一博\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139484739_1604287129343_title.jpg\",\"IsMoreImg\":1,\"imgarray\":[\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450932_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450934_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450936_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450938_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450940_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450942_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450944_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450946_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450948_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450950_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450952_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450954_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450956_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450958_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450960_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450962_title0h.jpg\"],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1604287129343_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450932_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450934_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450936_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450938_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450940_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450942_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450944_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450946_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450948_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450950_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450952_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450954_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450956_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450958_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450960_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484739_1317450962_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139484573,\"Title\":\"Moon rises over sky in Skopje, North Macedonia\",\"NodeId\":11143454,\"PubTime\":\"2020-11-02 10:40:50\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/02/c_139484573.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"yhy\",\"Author\":\"Tomislav Georgiev\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139484573_1604284767463_title.jpg\",\"IsMoreImg\":1,\"imgarray\":[\"http://www.xinhuanet.com/english/titlepic/13948/139484573_1317450615_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484573_1317450617_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484573_1317450619_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484573_1317450621_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484573_1317450623_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484573_1317450625_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484573_1317450627_title0h.jpg\"],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139484573_1604284767463_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484573_1317450615_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484573_1317450617_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484573_1317450619_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484573_1317450621_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484573_1317450623_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484573_1317450625_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484573_1317450627_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139484571,\"Title\":\"Barber shops across Israel reopen\",\"NodeId\":11143454,\"PubTime\":\"2020-11-02 10:40:47\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/02/c_139484571.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"Wang Yamei\",\"Author\":\"Gil Cohen Magen\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139484571_1604284817521_title.jpg\",\"IsMoreImg\":1,\"imgarray\":[\"http://www.xinhuanet.com/english/titlepic/13948/139484571_1317450609_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484571_1317450611_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484571_1317450613_title0h.jpg\"],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139484571_1604284817521_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484571_1317450609_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484571_1317450611_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484571_1317450613_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139484551,\"Title\":\"People attend early voting at polling station in New York\",\"NodeId\":11143454,\"PubTime\":\"2020-11-02 10:37:46\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/02/c_139484551.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"yhy\",\"Author\":\"王迎\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139484551_1604284625671_title.jpg\",\"IsMoreImg\":1,\"imgarray\":[\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450549_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450551_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450553_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450555_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450557_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450559_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450561_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450563_title0h.jpg\"],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1604284625671_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450549_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450551_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450553_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450555_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450557_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450559_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450561_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484551_1317450563_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139483704,\"Title\":\"Jordan to impose nationwide lockdown after parliamentary elections\",\"NodeId\":11143454,\"PubTime\":\"2020-11-02 05:35:26\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/02/c_139483704.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"Wang Yamei\",\"Author\":\"Mohammad Ghazal\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139483704_1604284609762_title.jpg\",\"IsMoreImg\":0,\"imgarray\":[],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483704_1604284609762_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139483592,\"Title\":\"UK records another 23,254 coronavirus cases with 162 deaths\",\"NodeId\":11143454,\"PubTime\":\"2020-11-02 00:46:36\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/02/c_139483592.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"Wang Yamei\",\"Author\":\"金晶\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139483592_1604284065220_title.jpg\",\"IsMoreImg\":0,\"imgarray\":[],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483592_1604284065220_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139483379,\"Title\":\"Israel begins human trials on COVID-19 vaccine\",\"NodeId\":11143454,\"PubTime\":\"2020-11-01 21:40:08\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/01/c_139483379.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"yhy\",\"Author\":\"[e]Eran Lahav\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139483379_1604279468783_title.jpg\",\"IsMoreImg\":0,\"imgarray\":[],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483379_1604279468783_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139483709,\"Title\":\"Voting for Algeria's amended constitution wrapped up\",\"NodeId\":11143454,\"PubTime\":\"2020-11-02 05:52:03\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/02/c_139483709.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"yhy\",\"Author\":\"[e]aeje\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139483709_1604278421854_title.jpg\",\"IsMoreImg\":0,\"imgarray\":[],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483709_1604278421854_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139484021,\"Title\":\"People board up stores in New York to protect themselves from looting\",\"NodeId\":11143454,\"PubTime\":\"2020-11-02 08:15:58\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/02/c_139484021.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"Wang Yamei\",\"Author\":\"王迎\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139484021_1604276084470_title.jpg\",\"IsMoreImg\":1,\"imgarray\":[\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449562_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449564_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449566_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449568_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449570_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449572_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449574_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449576_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449578_title0h.jpg\"],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1604276084470_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449562_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449564_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449566_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449568_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449570_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449572_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449574_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449576_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139484021_1317449578_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139483621,\"Title\":\"Early number shows turnout of 13 pct in Algeria's constitution referendum\",\"NodeId\":11143454,\"PubTime\":\"2020-11-02 01:55:47\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/02/c_139483621.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"yhy\",\"Author\":\"[e]aeje\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139483621_1604273837191_title.jpg\",\"IsMoreImg\":0,\"imgarray\":[],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483621_1604273837191_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139483840,\"Title\":\"Bangladesh National Zoo in Mirpur section of Dhaka reopens to public\",\"NodeId\":11143454,\"PubTime\":\"2020-11-02 07:43:14\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/02/c_139483840.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"yhy\",\"Author\":\"Salim\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139483840_1604274154855_title.jpg\",\"IsMoreImg\":1,\"imgarray\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483840_1317449059_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483840_1317449061_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483840_1317449063_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483840_1317449065_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483840_1317449067_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483840_1317449069_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483840_1317449071_title0h.jpg\"],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483840_1604274154855_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483840_1317449059_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483840_1317449061_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483840_1317449063_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483840_1317449065_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483840_1317449067_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483840_1317449069_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483840_1317449071_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139482527,\"Title\":\"Three policemen killed in bomb attack in W. Afghanistan\",\"NodeId\":11143454,\"PubTime\":\"2020-11-01 12:38:09\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/01/c_139482527.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"yhy\",\"Author\":\"Farid Behbud\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139482527_1604274014504_title.jpg\",\"IsMoreImg\":0,\"imgarray\":[],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139482527_1604274014504_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139483066,\"Title\":\"Uganda launches Chinese-constructed road linking Kenya\",\"NodeId\":11143454,\"PubTime\":\"2020-11-01 17:31:32\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/01/c_139483066.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"mingmei\",\"Author\":\"张改萍\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139483066_1604273531920_title.jpg\",\"IsMoreImg\":0,\"imgarray\":[],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483066_1604273531920_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139483815,\"Title\":\"In pics: giant pumpkin in Moscow\",\"NodeId\":11143454,\"PubTime\":\"2020-11-02 07:31:16\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/02/c_139483815.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"yhy\",\"Author\":\"Maxim Chernavsky\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139483815_1604273464971_title.jpg\",\"IsMoreImg\":1,\"imgarray\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483815_1317448976_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483815_1317448978_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483815_1317448980_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483815_1317448982_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483815_1317448984_title0h.jpg\"],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483815_1604273464971_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483815_1317448976_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483815_1317448978_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483815_1317448980_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483815_1317448982_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483815_1317448984_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139483797,\"Title\":\"People wearing costumes celebrate Halloween in Los Angeles\",\"NodeId\":11143454,\"PubTime\":\"2020-11-02 07:30:22\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/02/c_139483797.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"yhy\",\"Author\":\"Xinhua\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139483797_1604273157164_title.jpg\",\"IsMoreImg\":1,\"imgarray\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448881_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448884_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448887_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448889_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448892_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448894_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448897_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448899_title0h.jpg\"],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1604273157164_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448881_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448884_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448887_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448889_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448892_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448894_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448897_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483797_1317448899_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139483666,\"Title\":\"Iran's daily COVID-19 death toll hits record high as Lebanon, Gaza call for total lockdown\",\"NodeId\":11143454,\"PubTime\":\"2020-11-02 03:26:14\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/02/c_139483666.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"Liu\",\"Author\":\"刘曦\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139483666_1604272973815_title.jpg\",\"IsMoreImg\":0,\"imgarray\":[],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483666_1604272973815_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139483198,\"Title\":\"Rwandan students prepare for reopening of schools in Kigali\",\"NodeId\":11143454,\"PubTime\":\"2020-11-01 20:02:11\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/01/c_139483198.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"Zhong Yurui\",\"Author\":\"Cyril Ndegeya\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139483198_1604231852881_title.jpg\",\"IsMoreImg\":1,\"imgarray\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483198_1317447984_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483198_1317447986_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483198_1317447988_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483198_1317447990_title0h.jpg\"],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483198_1604231852881_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483198_1317447984_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483198_1317447986_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483198_1317447988_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483198_1317447990_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null},{\"DocID\":139483195,\"Title\":\"Int'l Women's Peace Centre inaugurated in Windhoek, Namibia\",\"NodeId\":11143454,\"PubTime\":\"2020-11-01 19:49:16\",\"LinkUrl\":\"http://www.xinhuanet.com/english/2020-11/01/c_139483195.htm\",\"Abstract\":null,\"keyword\":null,\"Editor\":\"Zhong Yurui\",\"Author\":\"Musa C Kaseke\",\"IsLink\":0,\"SourceName\":\"Source: Xinhua\",\"PicLinks\":\"139483195_1604231254494_title.jpg\",\"IsMoreImg\":1,\"imgarray\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483195_1317447971_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483195_1317447973_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483195_1317447975_title0h.jpg\"],\"SubTitle\":null,\"Attr\":63,\"m4v\":null,\"tarray\":[],\"uarray\":[],\"allPics\":[\"http://www.xinhuanet.com/english/titlepic/13948/139483195_1604231254494_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483195_1317447971_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483195_1317447973_title0h.jpg\",\"http://www.xinhuanet.com/english/titlepic/13948/139483195_1317447975_title0h.jpg\"],\"IntroTitle\":null,\"Ext1\":null,\"Ext2\":null,\"Ext3\":null,\"Ext4\":null,\"Ext5\":null,\"Ext6\":null,\"Ext7\":null,\"Ext8\":null,\"Ext9\":null,\"Ext10\":null}]},\"totalnum\":1000}\n)";

        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        System.out.println(jsonObject);


    }
    @Test
    public void t10() throws IOException {
        System.out.println(forceDeleteDirectory("E:\\target\\fujian\\fjian\\chl\\chl578s871"));

    }

    @Test
    public void t9() throws IOException {

        String str = "淄博市国三营运柴油货车统计表.pdf|淄博市国三营运柴油货车2019年淘汰补贴标准.pdf|淄博市国三营运柴油货车2020年淘汰补贴标准.pdf|";

        System.out.println(str.substring(0,str.length()-1));

    }
    @Test
    public void t8() throws IOException {

        String str = FileUtil.readString("E:\\target\\tmptxt\\zyzd\\zyzd001s116.txt","GBK");
        System.out.println(str);

    }

    @Test
    public void t7() throws IOException {
/*
        NioFileUtil fileUtil = new NioFileUtil();
        //附件文件夹移动到。5挂载文件夹下
        Path start = Paths.get("E:\\target\\tmptxt\\zyzd\\chl578s867.txt");
        Path target = Paths.get("E:\\target\\txt\\chl\\578");

        fileUtil.operateDir(true, start, target, StandardCopyOption.REPLACE_EXISTING);
*/

        File start = new File("E:\\target\\tmptxt\\zyzd\\chl578s867.txt");
        File target = new File("E:\\target\\txt\\chl\\578");
        FileUtil.move(start,target,true);

    }

    @Test
    public void t6(){
        try{
            //String filePath = "D:\\IDEAworkspace\\201910_ztrsd\\spider_vbs\\spider_VBS\\spider_web\\target\\spider_web\\resources\\fujian\\tmp\\Timer001s001\\中央对地方均衡性转移支付办法.docx";
            String filePath = "D:\\company\\个人信息登记表(转入).xls";
            OPCPackage opc = OPCPackage.open(filePath);
            PackageProperties pp = opc.getPackageProperties();

            Nullable<String> foo = pp.getCreatorProperty();
            System.out.println(foo.hasValue()?foo.getValue():"empty");
            //Set some properties
            pp.setCreatorProperty("法");
            Nullable<String> foo1 = pp.getCreatorProperty();
            System.out.println(foo1.getValue());


            opc.close();
        } catch (Exception e) {}


    }

    //主入口
    public static void main(String[] args) throws Exception {


        String path = "E:\\target\\fujian\\tmp\\difang001s002";
        NioFileUtil.reNameFile(path,"ceshi001s002");
        System.out.println("文件拷贝完成!");
    }

    @Test
    public void t1(){
        String str = "aa|bb|";
        String[] split = str.split("\\|");
        System.out.println(split.length);
    }
    @Test
    public void t2(){
        String filePath = "D:\\IDEAworkspace\\201910_ztrsd\\spider_vbs\\spider_VBS\\spider_web\\target\\spider_web\\resources\\tmptxt\\Timer001s001";

        File f = new File(filePath);
        boolean exists = f.exists();

        if (!exists){
            f.mkdir();
            boolean file = f.isFile();
            boolean directory = f.isDirectory();
            System.out.println("isfile"+file);
            System.out.println("isdir"+directory);
        }

        System.out.println(exists);

    }
    @Test
    public void t3() throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        long time = simpleDateFormat.parse(format).getTime();
        System.out.println(time);
/*        Long str = new Long(format);
        System.out.println(str);*/

    }

    @Test
    public void t4() throws Exception {
        String baseUrl = "http://www.mohrss.gov.cn/gkml/rsgl/sydwrsgl/202001/t20200116_355370.html";
        String url = "./P020200116338104720979.docx//aa##";
        String localFilePath = "D:\\临时文件\\project_test";
        //saveUrlAs(baseUrl,url,localFilePath);
       // com.spider.utils.HttpsUtils.saveUrlAs(baseUrl,url,localFilePath);
        //saveUrlAs1(baseUrl,url,localFilePath);

    }


    public  String[] saveUrlAs(String baseUrl, String url, String localFilePath)

    {
        String regxUrl = "";
        String remoteFileUrl = "";
        String attachListStr = "";
        String fileName = "";
        String[] retArr = new String[2];
        boolean b = false;
        String[] attachArr={""};
        if (url!=null){
            attachArr = url.split("##");
        }
        com.lawstar.law.util.HttpsUtils.delDir(new File(localFilePath));
        Tools.mkDir(localFilePath);

        for (String attachStr : attachArr)
            if (attachStr.trim().length() > 0) {

                //获取下载链接 、 附件名称 链接中自带http/https 直接返回链接，不带http/https的链接 通过原链接和 '//'前半部分拼接得到
                if (attachStr.lastIndexOf("//") != -1) {
                    remoteFileUrl = attachStr.substring(0, attachStr.lastIndexOf("//"));
                    fileName = attachStr.substring(attachStr.lastIndexOf("//") + 2);
                }



                if (fileName.indexOf(".") < 0) {
                    int ext_pos = remoteFileUrl.lastIndexOf(".");
                    if (ext_pos > -1) {
                        fileName = fileName + remoteFileUrl.substring(ext_pos);
                    }
                }
                if (fileName.indexOf("(") != -1) {
                    int ext_pos = fileName.lastIndexOf("(");
                    fileName = fileName.substring(0,ext_pos).trim();

                }

                //附件保存地址
                String newFilePath = localFilePath + File.separator + fileName;
                //pram
                String temp = null;
                String result = null;
                //处理原网站链接
                if (remoteFileUrl.indexOf("http")>-1) {

                }else {
                    String baseUrl_tmp = baseUrl;
                    if ((remoteFileUrl.length() > 0) && (remoteFileUrl.charAt(0) == '/')) {
                        int first_idx = baseUrl.indexOf("//");
                        first_idx = baseUrl.indexOf("/", first_idx + 2);
                        if (first_idx > -1) {
                            baseUrl_tmp = baseUrl.substring(0, first_idx);
                        }

                    }
                    if ((remoteFileUrl.length() > 0) && (remoteFileUrl.charAt(0) == '.')) {
                        int first_idx = baseUrl.lastIndexOf("/");
                        int idx = remoteFileUrl.lastIndexOf("/");
                        if (first_idx > -1) {
                            baseUrl_tmp = baseUrl_tmp.substring(0, first_idx);
                        }
                        if (idx > -1) {
                            remoteFileUrl = remoteFileUrl.substring(idx + 1);
                        }

                    }
                //参数

                int index = remoteFileUrl.lastIndexOf("/");
                result = remoteFileUrl.substring(0, index + 1);
                temp = remoteFileUrl.substring(index + 1);
                }
                String encode = null;
                try {
                    encode = URLEncoder.encode(temp, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                //System.out.println(encode);
                encode = encode.replace("%3D", "=");
                encode = encode.replace("%2F", "/");
                encode = encode.replace("+", "%20");
                encode = encode.replace("%26", "&");
                result = result + encode;
                remoteFileUrl = result;

                //System.out.println(result);
                //System.out.println("remoteFileUrl=" + remoteFileUrl);
                try {
                    b = HttpsUtils.executeDownloadFile(null, remoteFileUrl, newFilePath, "UTF-8", true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
/*                if (!b) {
                    Thread.currentThread();
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        b = HttpsUtils.executeDownloadFile(null, remoteFileUrl, newFilePath, "UTF-8", true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
                if (!b) break;
                if (fileName.indexOf(".") < 0) fileName = fileName + com.lawstar.law.util.HttpsUtils.ext;
                if (attachListStr.length() == 0) attachListStr = fileName; else
                    attachListStr = attachListStr + "|" + fileName;
            }
        retArr[0] = b+"";
        retArr[1] = attachListStr;
        return retArr;
    }


    public static String saveUrlAs1(String grabsonwebsite,String url,String folder) throws Exception{//ClientProtocolException, IO
        //正则表达式处理后的url
        String regxUrl = "";
        String remoteFileUrl = "";
        String localFilePath = "";
        String fileName      = "";
        boolean b =false;
        //处理url
        String[] URLs = url.split("##");
        for(String URL:URLs) {
            if(URL.length()<=0) continue;
            remoteFileUrl = URL.substring(0,URL.lastIndexOf("//"));
            //修改url为http格式
            regxUrl = remoteFileUrl.replaceAll("\\.{2}/+", "");
            //正则处理前和处理后的url一致时
            if(regxUrl.equals(remoteFileUrl)) {
                //判断该url是否包含http
                if(!remoteFileUrl.contains("http")) {
                    remoteFileUrl = grabsonwebsite+remoteFileUrl;
                }

            }else {
                remoteFileUrl = grabsonwebsite+"/"+regxUrl;
            }

            fileName 	  = URL.substring(URL.lastIndexOf("//")+2);
            if(fileName.indexOf(".")<0) fileName = fileName+".doc";

            localFilePath = "/bcn/192.168.0.5/fujian/tmp/"+folder;
            Tools.mkDir(localFilePath);
            localFilePath = localFilePath+"/"+fileName;
            System.out.println("附件保存地址"+localFilePath);
            int index = remoteFileUrl.lastIndexOf("/");
            String result = remoteFileUrl.substring(0,index+1);
            String temp = remoteFileUrl.substring(index+1);
            String encode = URLEncoder.encode(temp, "utf-8");
            System.out.println(encode);
            encode = encode.replace("%3D",  "=");
            encode = encode.replace("%2F", "/");
            encode = encode.replace("+", "%20");
            encode = encode.replace("%26", "&");
            result += encode;
            b = HttpsUtils.executeDownloadFile(null, remoteFileUrl, localFilePath, "UTF-8", true);
        }

        return ""+b;
    }


    public static String forceDeleteDirectory(String directory){
        File tagFile=new File(directory);
        if(tagFile.exists()){
            try {

                String[] cmd = new String[] {"sh", "-c", "rm -f -r "+directory};
                Runtime rt = Runtime.getRuntime(); // 获取运行时系统
                Process proc = rt.exec(cmd); // 执行命令
                InputStream stderr =  proc.getInputStream(); // 获取输入流
                InputStreamReader isr = new InputStreamReader(stderr,"gbk");
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                /*while ((line = br.readLine()) != null) { // 打印出命令执行的结果
                System.out.println(line);
            }*/
            } catch (Throwable t) {
                t.printStackTrace();
                return t.getMessage();
            }
            return "ok";
        }else {
            return "目录不存在";
        }
    }

}
