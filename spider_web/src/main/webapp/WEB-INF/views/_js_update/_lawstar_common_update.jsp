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


    <title>通用脚本修改 - common.js</title>
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
    <link href="<%=basePath%>css/plugins/codemirror/codemirror.css" rel="stylesheet">
    <link href="<%=basePath%>css/plugins/codemirror/ambiance.css" rel="stylesheet">
    <link href="<%=basePath%>css/style.css?v=2.2.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="row wrapper border-bottom white-bg page-heading">

    <div class="col-lg-10">
        <h2>common.js</h2>
    </div>
    <div class="col-lg-2">
        <button type="button" class="btn btn-primary btn-sm" onclick="reg()">保存</button>
    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-lg-66">
            <form id="myform" action="<%=basePath%>lawstar_common_update_upd" method="POST" target="_self">

                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>原始脚本代码</h5>
                    </div>
                    <div class="ibox-content">

                                <textarea id="code1" name="title" style="margin: 0px; height: 693px; width: 770px;">

                                    ${lawstar_common}

                                </textarea>

                    </div>
                </div>
            </form>
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


<!-- Peity -->
<script src="<%=basePath%>js/plugins/peity/jquery.peity.min.js"></script>

<!-- CodeMirror -->
<script src="<%=basePath%>js/plugins/codemirror/codemirror.js"></script>
<script src="<%=basePath%>js/plugins/codemirror/mode/javascript/javascript.js"></script>

<script type="text/javascript">

    var editor = CodeMirror.fromTextArea(document
        .getElementById("code1"), {
        lineNumbers : true,
        matchBrackets : true,
        styleActiveLine : true,
        theme: "ambiance"
    });

    function reg() {

        var title = editor.getValue();
        $("#myform").submit();
    }
</script>


</html>
