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


    <title>适配网站 - 新闻适配结果预览</title>
    <link rel="shortcut icon" href="<%=basePath%>favicon.ico">
    <link href="<%=basePath%>h+_ui/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="<%=basePath%>h+_ui/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

    <!-- Morris -->
    <link href="<%=basePath%>h+_ui/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">

    <!-- Gritter -->
    <link href="<%=basePath%>h+_ui/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

    <link href="<%=basePath%>h+_ui/css/animate.min.css" rel="stylesheet">
    <link href="<%=basePath%>h+_ui/css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">

    <!-- 自由添加 -->
    <link href="<%=basePath%>css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link href="<%=basePath%>css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>css/style.css?v=2.2.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="row wrapper border-bottom white-bg page-heading">

    <div class="col-sm-4">
        <h2>新闻适配结果预览</h2>
    </div>
    <div class="col-sm-8">
        <div class="title-action">
            <div class="btn-group">
                <button data-toggle="dropdown" class="btn btn-warning dropdown-toggle">脚本列表 <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="<%=basePath%>nextPage/1/${informationPipeline.informationId}" target="_self">标题</a>
                    </li>
                    <li><a href="<%=basePath%>nextPage/2/${informationPipeline.informationId}" target="_self">正文</a>
                    </li>
                    <li><a href="<%=basePath%>nextPage/3/${informationPipeline.informationId}" target="_self">发布日期</a>
                    </li>
                    <li><a href="<%=basePath%>nextPage/4/${informationPipeline.informationId}" target="_self">文号</a>
                    </li>
                    <li><a href="<%=basePath%>nextPage/6/${informationPipeline.informationId}" target="_self">附件</a>
                    </li>
                    <li><a href="<%=basePath%>regsinglenews/${informationPipeline.informationId}" target="_self">新闻适配结果预览</a>
                    </li>
                    <li><a href="<%=basePath%>regten/${informationPipeline.id}/${informationPipeline.informationId}" target="_self">网站适配结果预览</a>
                    </li>
                </ul>
            </div>
            <a href="${informationPipeline.source}" target="_blank" class="btn btn-primary">来源</a>
        </div>
    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-lg-12">
            <div class="wrapper wrapper-content">
                <div class=" animated fadeInRightBig">

                    <p>标题：${informationPipeline.newstitle}</p>
                    <p>文号：${informationPipeline.filenum}</p>
                    <p>发布日期：${informationPipeline.releasetime}</p>
                    <p>附件：${informationPipeline.attachment}</p>
                    <p>正文：</p>

                </div>
                <textarea autoHeight="true" readonly="readonly" style="width:100%">${informationPipeline.newscontent}</textarea>
                <%--                    <div class="middle-box text-center animated fadeInRightBig">
                                        <textarea>
                                            ${informationPipeline.newscontent}
                &lt;%&ndash;                            <p>标题：${informationPipeline.newstitle}</p>
                                            <p>文号：${informationPipeline.filenum}</p>
                                            <p>发布日期：${informationPipeline.releasetime}</p>
                                            <p>附件：${informationPipeline.attachment}</p>&ndash;%&gt;
                                        </textarea>
                                    </div>--%>
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

<script src="<%=basePath%>js/plugins/jeditable/jquery.jeditable.js"></script>

<!-- Data Tables -->
<script src="<%=basePath%>js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="<%=basePath%>js/plugins/dataTables/dataTables.bootstrap.js"></script>

<!-- Custom and plugin javascript -->
<script src="<%=basePath%>js/hplus.js?v=2.2.0"></script>
<script src="<%=basePath%>js/plugins/pace/pace.min.js"></script>
<!-- Page-Level Scripts -->
<script>
    $(function(){
        $.fn.autoHeight = function(){
            function autoHeight(elem){
                elem.style.height = 'auto';
                elem.scrollTop = 0; //防抖动
                elem.style.height = elem.scrollHeight + 'px';
            }
            this.each(function(){
                autoHeight(this);
                $(this).on('keyup', function(){
                    autoHeight(this);
                });
            });
        }
        $('textarea[autoHeight]').autoHeight();
    })
</script>
</html>
