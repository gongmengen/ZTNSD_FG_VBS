package com.spider.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpUtil;
import com.lawstar.law.util.FileTypeJudge;
import com.spider.bean.TblErrorLog;
import com.spider.elemente.ErrorPram;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import com.lawstar.basic.util.Tools;

import sun.net.www.content.image.jpeg;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.*;

public class HttpsUtils {
    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static SSLConnectionSocketFactory sslsf = null;
    private static PoolingHttpClientConnectionManager cm = null;
    private static SSLContextBuilder builder = null;
    public static String ext;
    static {
        try {
            builder = new SSLContextBuilder();
            // 全部信任 不做身份鉴定
            builder.loadTrustMaterial(null, new TrustStrategy() {
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            });
            sslsf = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1"}, null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTP, new PlainConnectionSocketFactory())
                    .register(HTTPS, sslsf)
                    .build();
            cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(200);//max connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * httpClient post请求
     * @param url 请求url
     * @param header 头部信息
     * @param param 请求参数 form提交适用
     * @param entity 请求实体 json/xml提交适用
     * @return 可能为空 需要处理
     * @throws Exception
     *
     */
    public static String post(String  url, Map<String, String> header, Map<String, String> param, HttpEntity entity) throws Exception {
        String result = "";
        CloseableHttpClient httpClient = null;
        try {
            httpClient = getHttpClient();
            HttpPost httpPost = new HttpPost(url);
            // 设置头信息
            if (MapUtils.isNotEmpty(header)) {
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }
            // 设置请求参数
            if (MapUtils.isNotEmpty(param)) {
                List<NameValuePair> formparams = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> entry : param.entrySet()) {
                    //给参数赋值
                    formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
                httpPost.setEntity(urlEncodedFormEntity);
            }
            // 设置实体 优先级高
            if (entity != null) {
                httpPost.setEntity(entity);
            }
            HttpResponse httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity resEntity = httpResponse.getEntity();
                result = EntityUtils.toString(resEntity);
            } else {
                 readHttpResponse(httpResponse);
            }
        } catch (Exception e) {throw e;
        } finally {
            if (httpClient != null) {
                httpClient.close();
            }
        }
        return result;
    }
    public static CloseableHttpClient getHttpClient() throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setConnectionManager(cm)
                .setConnectionManagerShared(true)
                .build();
        return httpClient;
    }
    public static String readHttpResponse(HttpResponse httpResponse)
            throws ParseException, IOException {
        StringBuilder builder = new StringBuilder();
        // 获取响应消息实体
        HttpEntity entity = httpResponse.getEntity();
        // 响应状态
        builder.append("status:" + httpResponse.getStatusLine());
        builder.append("headers:");
        HeaderIterator iterator = httpResponse.headerIterator();
        while (iterator.hasNext()) {
            builder.append("\t" + iterator.next());
        }
        // 判断响应实体是否为空
        if (entity != null) {
            String responseString = EntityUtils.toString(entity);
            builder.append("response length:" + responseString.length());
            builder.append("response content:" + responseString.replace("\r\n", ""));
        }
        return builder.toString();
    }
    
    /** 
     * 获取response header中Content-Disposition中的filename值 
     * @param response 
     * @return 
     */  
    public static String getFileName(HttpResponse response) {  
    	Header head [] =response.getAllHeaders();
    	for(int kk=0;kk<head.length;kk++){
    		System.out.println(head[kk].getName()+"==="+head[kk].getValue());
    	}
        Header contentHeader = response.getFirstHeader("Content-Disposition");  
        String filename = null;  
        if (contentHeader != null) {  
            HeaderElement[] values = contentHeader.getElements();
            System.out.println("llll"+values.length);
            if (values.length == 1) {  
                NameValuePair param = values[0].getParameterByName("filename");  
                if (param != null) {  
                    try {  
                        //filename = new String(param.getValue().toString().getBytes(), "utf-8");  
                        //filename=URLDecoder.decode(param.getValue(),"utf-8");  
                        filename = param.getValue();  
                    } catch (Exception e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }  
        return filename;  
    }
    
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
    /**
     * 执行文件下载
     *
     * @param httpClient      HttpClient客户端实例，传入null会自动创建一个
     * @param remoteFileUrl   远程下载文件地址
     * @param localFilePath   本地存储文件地址
     * @param charset         请求编码，默认UTF-8
     * @param closeHttpClient 执行请求结束后是否关闭HttpClient客户端实例
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @throws InterruptedException 
     */
    public static boolean executeDownloadFile(CloseableHttpClient httpClient, String remoteFileUrl, String localFilePath, String charset, boolean closeHttpClient) throws Exception {
        CloseableHttpResponse response = null;
        InputStream in = null;
        FileOutputStream fout = null;
        boolean isOK= false;
        if (httpClient == null) {
            try {
				httpClient = getHttpClient();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        try {
        	Thread.currentThread().sleep(3500);
        	//System.out.println("url="+URLEncoder.encode(remoteFileUrl,"UTF-8"));
            HttpGet httpget = new HttpGet(remoteFileUrl);
            String userAgent = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36";
            httpget.setHeader("User-Agent",userAgent);
      
            response = httpClient.execute(httpget);
           // / 判断返回状态是否为200
            if ( response.getStatusLine().getStatusCode() != 200) {
            	throw new Exception("连接失败，错误代码="+ response.getStatusLine().getStatusCode());
            }
            HttpEntity entity = response.getEntity();
            
            if (entity == null) {
                return false;
            }
            in = entity.getContent();
            
            if(localFilePath.indexOf(".")<=-1){//没有后缀名，从头信息获取
            	
            	String ext_file = getFileName(response);
            	int start =0;
            	
            	if(ext_file!=null && (start=ext_file.indexOf("."))>-1){
            		 ext = ext_file.substring(start);
            		localFilePath = localFilePath+ext;
            	}else{//从文件流里面读入
            		 byte [] ext_b = new byte[28];
                     in.read(ext_b, 0, 28);
                     //in.reset();
                   //  Tools.printArr(ext_b);
                     ext = FileTypeJudge.getTypeByBytes(ext_b).toString();
            	}
            }
            System.out.println(localFilePath);
            File file = new File(localFilePath);
           
            fout = new FileOutputStream(file);
            int l;
            byte[] tmp = new byte[1024];
            while ((l = in.read(tmp)) != -1) {
                fout.write(tmp, 0, l);
                // 注意这里如果用OutputStream.write(buff)的话，图片会失真
            }
            // 将文件输出到本地
            fout.flush();
            EntityUtils.consume(entity);
            isOK = true;
        } finally {
            // 关闭低层流。
            if (fout != null) {
                try {
                    fout.close();
                } catch (Exception e) {
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e) {
                }
            }
            if (closeHttpClient && httpClient != null) {
                try {
                    httpClient.close();
                } catch (Exception e) {
                }
            }
        }
        return isOK;
    }
    public static String getContentCharSet(final HttpEntity entity)   
    throws ParseException {   

    if (entity == null) {   
        throw new IllegalArgumentException("HTTP entity may not be null");   
    }   
    String charset = null;   
    if (entity.getContentType() != null) {    
        HeaderElement values[] = entity.getContentType().getElements();   
        if (values.length > 0) {   
            NameValuePair param = values[0].getParameterByName("charset" );   
            if (param != null) {   
                charset = param.getValue();   
            }   
        }   
    }   
     
    if(charset==null){  
        charset = "";  
    }  
    return charset;   
} 
    public static String  getHtml(String remoteFileUrl,  String charset ) throws ClientProtocolException, IOException, InterruptedException {
    	CloseableHttpClient httpClient=null;
        CloseableHttpResponse response = null;
        InputStream in = null;
        String content="";
        if (httpClient == null) {
            try {
				httpClient = getHttpClient();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        try {
        	Thread.currentThread().sleep(3000);
            HttpGet httpget = new HttpGet(remoteFileUrl);
            String userAgent = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36";
            httpget.setHeader("User-Agent",userAgent);
            response = httpClient.execute(httpget);
         // / 判断返回状态是否为200
            if ( response.getStatusLine().getStatusCode() != 200) {
            	System.out.println("连接失败，错误代码="+ response.getStatusLine().getStatusCode());
            	return "";
            }
            HttpEntity entity = response.getEntity();
            
            if (entity == null) {
                return "";
            }
             
            if (entity != null) {   
                try {
					String charset_src = getContentCharSet(entity);
					if(!charset_src.equals("")){
						charset = charset_src;
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
                   // 使用EntityUtils的toString方法，传递编码，默认编码是ISO-8859-1   
                content = EntityUtils.toString(entity, charset);   
          }   
        } finally {
            // 关闭低层流。
            
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e) {
                }
            }
            if ( httpClient != null) {
                try {
                    httpClient.close();
                } catch (Exception e) {
                	e.printStackTrace();
                }
            }
        }
        return content;
    }
  //只删除文件
    public static boolean delDir(File dir){
        if (dir.isDirectory()){
            String[] children = dir.list();
            for (int i=0; i<children.length;i++) {
            	(new File(dir, children[i])).delete();
            }

        }
       /* if (dir.delete()){
            System.out.println("目录已删除！！！");
            return true;
        }else {
            System.out.println("目录删除失败！！！！！");
        }*/
        return false;
    }
  	//保存附件/*
    /**
     * 返回结果，如果true，结果包含该文件名列表，可以直接保存数据库
     */
    
	public static Map saveUrlAs(String baseUrl,String url,String localFilePath,int informationId,int xwcolumn) throws Exception{//ClientProtocolException, IO
        ArrayList<TblErrorLog> tblErrorLogs = new ArrayList<>();
		//正则表达式处理后的url
		String regxUrl = "";
		String remoteFileUrl = "";
		String attachListStr ="";//存放数据库的附件名称列表，多个使用|隔开
		Map retArr = new HashMap();
		boolean b =false;
		boolean flag = true;
		//处理url
        url = url==null?"":url;
		String[] attachArr = url.split("##");
		delDir(new File (localFilePath));
		Tools.mkDir(localFilePath);
		//url_obj.
		
		for(String attachStr:attachArr) {
			if(attachStr.trim().length()<=0) continue;
			remoteFileUrl = attachStr.substring(0,attachStr.lastIndexOf("//"));


			String fileName 	  = URLDecoder.decode(attachStr.substring(attachStr.lastIndexOf("//")+2));

			if (!ReUtil.isMatch(".+\\.[a-z]+", fileName)){
                //如果不匹配正则则标记为false ，等下载链接确定后从下载链接中获取请求头的filename信息
                flag=false;
            }

/*			if(fileName.indexOf(".")<0){//从下载地址提取


				int ext_pos = remoteFileUrl.lastIndexOf(".");
				if(ext_pos>-1){
					fileName = fileName + remoteFileUrl.substring(ext_pos);
				}

			}else{


			    try {
			        Integer.parseInt(fileName.substring(fileName.indexOf(".")-1,fileName.indexOf(".")));
                    int ext_pos = remoteFileUrl.lastIndexOf(".");
                    if(ext_pos>-1){
                        fileName = fileName + remoteFileUrl.substring(ext_pos);
                    }
                }catch (Exception e){

                }
            }*/

			//修改url为http格式
			String baseUrl_tmp = baseUrl.substring(0,baseUrl.lastIndexOf("/")+1);
			if(remoteFileUrl.length()>0 && remoteFileUrl.charAt(0)=='/'){
				int first_idx =baseUrl.indexOf("//");
				first_idx =baseUrl.indexOf("/",first_idx+2);
				if(first_idx>-1){
					baseUrl_tmp = baseUrl.substring(0,first_idx);
				}
				
			}
			//regxUrl = remoteFileUrl.replaceAll("\\.{2}/+", "");

				//判断该url是否包含http
				if(!remoteFileUrl.contains("http")) {
			        if (remoteFileUrl.indexOf("../")>-1) {
                    //处理掉 ../
                    remoteFileUrl = remoteFileUrl.replaceAll("\\.\\./","");

                    //截取附件所在域  (http://www.baidu.com/)
                    String http = baseUrl_tmp.substring(0, baseUrl_tmp.indexOf("/",baseUrl_tmp.indexOf("//")+2)+1);
                    remoteFileUrl = http+remoteFileUrl;
                    }else if (remoteFileUrl.indexOf("./")>-1){
                        remoteFileUrl = baseUrl_tmp + remoteFileUrl.replaceAll("\\./","");
                    }else {
                        remoteFileUrl = baseUrl_tmp + remoteFileUrl;
                    }
                }

			
			//localFilePath = "/bcn/192.168.0.5/fujian/tmp/"+folder;

            if (!flag){
                //先尝试从请求头的filename中获取
                fileName = getFileName(remoteFileUrl)==null?getFileName(remoteFileUrl):URLDecoder.decode(getFileName(remoteFileUrl));

                if (StrUtil.isBlank(fileName)||!ReUtil.isMatch(".+\\.[a-z]+", fileName)) {
                    //再从请求链接中获取文件名
                    fileName = StrUtil.subSuf(remoteFileUrl, remoteFileUrl.lastIndexOf('/') + 1)==null?StrUtil.subSuf(remoteFileUrl, remoteFileUrl.lastIndexOf('/') + 1):URLDecoder.decode(StrUtil.subSuf(remoteFileUrl, remoteFileUrl.lastIndexOf('/') + 1));

                    if (StrUtil.isBlank(fileName)||!ReUtil.isMatch(".+\\.[a-z]+", fileName)) {
                        //以上都获取不到 就使用编码后的路径做为文件名
                        fileName = URLUtil.encodeQuery(remoteFileUrl, CharsetUtil.CHARSET_UTF_8);
                    }
                }



                if (fileName == null){
                    tblErrorLogs.add(new TblErrorLog(10067, ErrorPram.errorPram.get(10067)+remoteFileUrl, informationId, xwcolumn));
                    //throw new FileNameDownloadException("附件名获取失败！请检查下载链接【"+remoteFileUrl+"】");
                }
            }


			fileName = fileName==null?fileName:regFilename(fileName);
			String newFilePath  = localFilePath+File.separator+fileName;
			System.out.println("附件保存地址"+newFilePath);
/*			int index = remoteFileUrl.lastIndexOf("/");
	        String result = remoteFileUrl.substring(0,index+1);
	        String temp = remoteFileUrl.substring(index+1);
	    	String encode = URLEncoder.encode(temp, "utf-8");
	         System.out.println(encode);
	         encode = encode.replace("%3D",  "=");
	         encode = encode.replace("%2F", "/");
	         encode = encode.replace("+", "%20");
	         encode = encode.replace("%26", "&");
	         result += encode;
	         remoteFileUrl = result;
	         //result += encode;
	         System.out.println(result);*/
			System.out.println("remoteFileUrl="+remoteFileUrl);
			try {
			    b = HttpsUtils.executeDownloadFile(null, remoteFileUrl, newFilePath, "UTF-8", true);
/*                //如果是doc文件修改作者属性为 法律之星
                String newfileName = newFilePath.substring(newFilePath.lastIndexOf(File.separator));
                String fileExtension = newfileName.substring(newfileName.lastIndexOf("."));
                if (fileExtension.toLowerCase().contains("doc")){
                    DocUtil docUtil = new DocUtil();
                    boolean s = docUtil.updateAuthor(newFilePath, "法律之星");
                    if(!s){
                        b = HttpsUtils.executeDownloadFile(null, remoteFileUrl, newFilePath, "UTF-8", true);
                    }
                }*/
            }catch (Exception e){
                tblErrorLogs.add(new TblErrorLog(10064, ErrorPram.errorPram.get(10064)+e.getMessage(), informationId, xwcolumn));
                b = false;
            }
			if(!b) continue;
			if(fileName.indexOf(".")<0) fileName = fileName+HttpsUtils.ext;
			if (attachListStr.length()==0) attachListStr = fileName;
			else attachListStr = attachListStr+"|"+fileName;
		}
		retArr.put(0,b+"");
		retArr.put(1,attachListStr);
        retArr.put(2,tblErrorLogs);

		return retArr;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}
	public static  String getExt() {
		return ext;
	}

	public static String regFilename(String filename){
	    Map<String,String> signs = new HashMap<String,String>();
	    signs.put("*","＊");
	    signs.put("?","？");
	    signs.put(":","：");
	    signs.put("\"","＂");
	    signs.put("<","＜");
	    signs.put(">","＞");
	    signs.put("\\","＼");
	    signs.put("/","／");
	    signs.put("|","｜");

        String[] signs_arr  ={"*","?",":","\"","<",">","\\","/","|"};//特殊字符

        for (String singn:signs_arr
             ) {
            if (filename.contains(singn)){
                filename = filename.replace(singn,signs.get(singn));
            }
        }

	    return filename;
    }

    public static void main(String[] args) throws Exception {

        //String filename = getFileName("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1594383600179&di=af3a040288339e0a534e4aa8c2d543f0&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F14%2F75%2F01300000164186121366756803686.jpg");


        String url = "附件二：北京市知识产权局行政处罚裁量基准表（试行）.docx";
        System.out.println(URLDecoder.decode(url));

       //System.out.println(filename);
    }
    public static String getFileName(String urlStr){
        String fileName = null;
        HttpURLConnection uc = null;
        try {
            URL url = new URL(urlStr);
            uc = (HttpURLConnection)url.openConnection();
            //避免直接请求被权限导致403 因此设置 User-Agent 模拟用户
            uc.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            uc.connect();
            if (uc.getResponseCode()==200) {
                fileName = uc.getHeaderField("Content-Disposition");
                fileName = new String(fileName.getBytes("ISO-8859-1"), "GBK");
                fileName = URLDecoder.decode(fileName.substring(fileName.indexOf("filename=") + 9), "UTF-8");
            }else {
                System.out.println("请求状态："+uc.getResponseCode());
                System.out.println("请求信息："+uc.getResponseMessage());
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return fileName;
    }


}
