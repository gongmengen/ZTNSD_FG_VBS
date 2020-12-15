<%--
  Created by IntelliJ IDEA.
  User: msi-
  Date: 2020/12/4
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>适配网站 - 网站适配结果预览</title>
    <link rel="shortcut icon" href="<%=basePath%>favicon.ico">
    <link href="<%=basePath%>css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="<%=basePath%>font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

    <link href="<%=basePath%>css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>css/style.css?v=2.2.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="row wrapper border-bottom white-bg page-heading">

    <div class="col-lg-9">
        <h2>网站适配结果预览</h2>
    </div>
    <div class="col-lg-3">


        <button type="button" class="btn btn-primary btn-sm" onclick="lastPage(6)">上一步</button>
        <c:if test="${nextRegID > 0}">
            <button type="button" class="btn btn-primary btn-sm" onclick="nextReg(${nextRegID})">继续验证</button>
        </c:if>
        <c:if test="${nextRegID < 0}">
            <button type="button" class="btn btn-default btn-sm">继续验证</button>
        </c:if>
        <button type="button" class="btn btn-primary btn-sm" onclick="nextPage(7)">完成</button>

        <div class="btn-group">
            <button data-toggle="dropdown" class="btn btn-warning dropdown-toggle">脚本列表 <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="<%=basePath%>nextPage/1/${information.id}" target="_self">标题</a>
                </li>
                <li><a href="<%=basePath%>nextPage/2/${information.id}" target="_self">正文</a>
                </li>
                <li><a href="<%=basePath%>nextPage/3/${information.id}" target="_self">发布日期</a>
                </li>
                <li><a href="<%=basePath%>nextPage/4/${information.id}" target="_self">文号</a>
                </li>
                <li><a href="<%=basePath%>nextPage/6/${information.id}" target="_self">附件</a>
                </li>
                <li><a href="<%=basePath%>regsinglenews/${information.id}" target="_self">新闻适配结果预览</a>
                </li>
                <li><a href="<%=basePath%>regten/${information.websiteid}/${information.id}" target="_self">网站适配结果预览</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="wrapper wrapper-content">

    <input type="hidden" id="informationid" name="informationid" value="${information.id}">

    <div class="row">
        <div class="col-lg-12">
            <div class="wrapper wrapper-content animated fadeInUp">
                <ul class="notes">
                    <c:forEach items="${resultList}" var="resultList">
                        <li>
                            <div>

                                <p>
                                        ${resultList}
                                </p>

                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>

</body>

<!-- Mainly scripts -->
<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js?v=3.4.0"></script>
<script src="<%=basePath%>js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=basePath%>js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="<%=basePath%>js/hplus.js?v=2.2.0"></script>
<script src="<%=basePath%>js/plugins/pace/pace.min.js"></script>
<script type="text/javascript">
    function nextPage(page) {
        window.location.href = "<%=basePath%>/isNotApaterWebsiteList";
    }
    function lastPage(page) {
        var informationid = $("#informationid").val();
        window.location.href = "<%=basePath%>nextPage/"+page+"/"+informationid;
    }
    function nextReg(id) {
        window.location.href = "<%=basePath%>nextReg/"+id;
    }
</script>


</html>