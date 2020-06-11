<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>栏目列表</title>
<%@ include file="/WEB-INF/views/include/nav.jsp"%>
<link rel="stylesheet" href="${ctx }/front/css/index.css" type="text/css"/>
<!--导入首页启动时需要的相应资源文件(首页相应功能的 js 库、css样式以及渲染首页界面的 js 文件)-->
</head>
<body>

<!-- leftMenu -->
<ul class="breadNav">
    <li><a href="${ctx }/page/information/informationcolumn?leftMenu=1" title="" target="_self">新闻信息</a></li>
    <li style="min-width: 13px;">>></li>
    <li><a href="" title="" target="_self">${supername }</a></li>
    <li class="front_page"><a href="javascript:void(0)" onclick="backPage()" >返回</a></li>
</ul>
<!-- newsList -->  
<div class="newsList">
    <div class="listTxt">
	    <c:forEach var="stu" items="${list}">
			<c:choose>  
		   		<c:when test="${superid==8 }"> 
					<a href="${ctx}/information/LegalInformationList?xwColumn=${stu.id}" title="${stu.columnName}" target="_self">${stu.columnName}</a>
			   </c:when>  
			   <c:otherwise>
		   			<c:choose>  
				   		<c:when test="${stu.id==10016 || stu.id==10017 || stu.id==10018}"> 
							<a href="${ctx}/information/keyWorkInformationList.action?xwColumn=${stu.id}" title="${stu.columnName}" target="_self">${stu.columnName}</a>
					   </c:when>  
					   <c:otherwise>
							<a href="${ctx}/information/informationList?xwColumn=${stu.id}" title="${stu.columnName}" target="_self">${stu.columnName}</a>
					   </c:otherwise>  
					</c:choose>  
			   </c:otherwise>  
			</c:choose>  
		</c:forEach>
    </div>
</div>
</body>
</html>