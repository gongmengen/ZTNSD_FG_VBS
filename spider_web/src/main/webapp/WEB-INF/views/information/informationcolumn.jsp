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
    <li><a href="" title="" target="_self">新闻信息</a></li>
<!--     <li class="on"><a href="" title="" target="_self">首页</a><i></i></li> -->
</ul>
<!-- mainNav -->  
<div class="mainNav">
    <a class="bg01" href="${ctx }/column/1/list" title="社会新闻" target="_self">社会新闻</a>
    <a class="bg02" href="${ctx }/column/2/list" title="科技前沿" target="_self">科技前沿</a>
    <a class="bg03" href="${ctx }/column/3/list" title="英语" target="_self">英语</a>
    <a class="bg04" href="${ctx }/column/4/list" title="中共党史" target="_self">中共党史</a>
    <a class="bg04" href="${ctx }/column/5/list" title="国防" target="_self">国防</a>
    <a class="bg01" href="${ctx }/column/6/list" title="人民法院报" target="_self">人民法院报</a>
    <a class="bg02" href="${ctx }/column/7/list" title="法学文库" target="_self">法学文库</a>
    <a class="bg03" href="${ctx }/column/8/list" title="法律信息网" target="_self">法律信息网</a>
    <a class="bg03" href="${ctx }/column/10/list" title="法规" target="_self">法规</a>
</div>

<script>
$(function(){
    
})
</script>
</body>
</html>
