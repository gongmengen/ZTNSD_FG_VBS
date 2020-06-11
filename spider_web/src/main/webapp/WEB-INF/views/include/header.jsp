<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!-- 皮肤 -->
<link rel="stylesheet" href="${ctx}/front/css/common.css"
	type="text/css" />
<link rel="stylesheet" href="${ctx}/front/css/pager.css" type="text/css" />
<link
	href="${ctx}/static/plugins/easyui/jquery-easyui-theme/<c:out value="${cookie.themeName.value}" default="default"/>/easyui.css"
	rel="stylesheet" type="text/css" />


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script src="${ctx}/front/js/jquery.js"></script>
<script src="${ctx}/front/js/common.js"></script>
<script src="${ctx}/front/js/jquery.validate.js"></script>
<script src="${ctx}/front/js/jqthumb.js"></script>
<!-- 前台缩放插件 -->
<script src="${ctx}/front/js/jquery.md5.js"></script>
<!-- 密码加密插件-->
<script
	src="${ctx}/static/plugins/easyui/jquery-easyui-1.3.6/jquery.easyui.min.js"
	type="text/javascript"></script>
<%-- <script type="text/javascript" src="${ctx}/front/js/jquery.1.8.3.js"></script> --%>
<script type="text/javascript" src="${ctx}/front/js/js-extend.js"></script>
<script type="text/javascript"
	src="${ctx}/front/js/jquery-ajax-pager.js"></script>
<script src="${ctx }/front/js/cssSelect.js"></script>
<script>
	//全局的AJAX访问，处理AJAX清求时SESSION超时
	$.ajaxSetup({
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		complete : function(XMLHttpRequest, textStatus) {
			//通过XMLHttpRequest取得响应头，sessionstatus           
			var sessionstatus = XMLHttpRequest
					.getResponseHeader("sessionstatus");
			if (sessionstatus == "timeout") {
				//跳转的登录页面
				window.location.replace('${ctx}/a/login');
			}
		}
	});
</script>
