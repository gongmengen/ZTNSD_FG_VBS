<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>主栏目列表</title>
<%@ include file="/WEB-INF/views/include/nav.jsp"%>

<!--导入首页启动时需要的相应资源文件(首页相应功能的 js 库、css样式以及渲染首页界面的 js 文件)-->
<link rel="stylesheet" href="${ctx}/front/css/index.css" type="text/css"/>
</head>

<body>
<!-- leftMenu -->
<ul class="breadNav">
    <li><a href="" title="" target="_self">网站管理</a></li>
<!--     <li class="on"><a href="" title="" target="_self">首页</a><i></i></li> -->
</ul>
<!-- mainNav -->  
<div class="mainNav">
    <a class="bg01" href="${ctx}/website/websiteList?xwColumn=1" title="社会新闻" target="_self">社会新闻</a>
    <a class="bg02" href="${ctx}/website/websiteList?xwColumn=2" title="科技前沿" target="_self">科技前沿</a>
    <a class="bg03" href="${ctx}/website/websiteList?xwColumn=3" title="英语" target="_self">英语</a>
    <a class="bg04" href="${ctx}/website/websiteList?xwColumn=4" title="中共党史" target="_self">中共党史</a>
    <a class="bg04" href="${ctx}/website/websiteList?xwColumn=5" title="国防" target="_self">国防</a>
    <a class="bg01" href="${ctx}/website/websiteList?xwColumn=6" title="人民法院报" target="_self">人民法院报</a>
    <a class="bg02" href="${ctx}/website/websiteList?xwColumn=7" title="法学文库" target="_self">法学文库</a>
    <a class="bg03" href="${ctx}/website/websiteList?xwColumn=8" title="法律信息网" target="_self">法律信息网</a>
    <a class="bg03" href="${ctx}/website/websiteList?xwColumn=10" title="法规" target="_self">法规</a>
</div>

<script>
$(function(){
    
})
</script>
</body>
</html>
