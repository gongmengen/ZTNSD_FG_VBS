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


    <title>法规预处理 - 新闻详情</title>
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
        <h2>新闻详情</h2>
        <ol class="breadcrumb">
            <li>
                <a>法规预处理</a>
            </li>
            <li>
                <strong>新闻详情</strong>
            </li>
        </ol>
    </div>
    <div class="col-sm-8">
        <div class="title-action">
            <a href="${informationPipeline.source}" target="_blank" class="btn btn-primary">来源</a>
        </div>
    </div>
</div>

<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-lg-12">
            <div class="wrapper wrapper-content">
                <div class=" animated fadeInRightBig">

                    <%--                            <p><a href="<%=basePath%>nextPage/1/${informationPipeline.informationId}" style="font-size: 25px;">⚙</a>     标题：${informationPipeline.newstitle}</p>
                                                <p><a href="<%=basePath%>nextPage/4/${informationPipeline.informationId}" style="font-size: 25px;">⚙</a>     文号：${informationPipeline.filenum}</p>
                                                <p><a href="<%=basePath%>nextPage/3/${informationPipeline.informationId}" style="font-size: 25px;">⚙</a>     发布日期：${informationPipeline.releasetime}</p>
                                                <p><a href="<%=basePath%>nextPage/6/${informationPipeline.informationId}" style="font-size: 25px;">⚙</a>     附件：${informationPipeline.attachment}</p>
                                                <p><a href="<%=basePath%>nextPage/2/${informationPipeline.informationId}" style="font-size: 25px;">⚙</a>     正文：</p>--%>

                    <p><a href="<%=basePath%>nextPage/1/${informationPipeline.informationId}" style="font-size: 25px;" target="_self">⚙</a>     标题：${informationPipeline.newstitle}</p>
                    <p><a href="<%=basePath%>nextPage/4/${informationPipeline.informationId}" style="font-size: 25px;" target="_self">⚙</a>     文号：${informationPipeline.filenum}</p>
                    <p><a href="<%=basePath%>nextPage/3/${informationPipeline.informationId}" style="font-size: 25px;" target="_self">⚙</a>     发布日期：${informationPipeline.releasetime}</p>
                    <p><a href="<%=basePath%>nextPage/6/${informationPipeline.informationId}" style="font-size: 25px;" target="_self">⚙</a>     附件：${informationPipeline.attachment}</p>
                    <p><a href="<%=basePath%>nextPage/2/${informationPipeline.informationId}" style="font-size: 25px;" target="_self">⚙</a>     正文：</p>

                </div>
                <div class="checkbox">
                    <label style="margin-left: -20px;"><input type="radio" name="myradio" id="myradio0" value="0" onclick="javascript:checkMo(0);">排版模式</label>
                    <label style="margin-left: 10px;"> <input type="radio" name="myradio" id="myradio1" value="1" onclick="javascript:checkMo(1);">编辑模式</label>
                </div>
                <div id="newscontent22">
                    ${contentBuffer}
                </div>
                <div id="newscontent11">
                    <textarea readonly="readonly" style="width:100%;height: 1000px;">${informationPipeline.newscontent}</textarea>
                </div>

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
        checkMo(0);
    })


    function checkMo(flag) {
        //	alert(123);
        var s=flag;
        $("#myradio"+flag).attr("checked",true)
        if(s==1){
            $("#newscontent11").show();
            $("#newscontent22").hide();
        }else{
            $("#newscontent11").hide();
            $("#newscontent22").show(); //文本
        }
        // return reg.test(htmlStr);

    }
</script>
</html>
