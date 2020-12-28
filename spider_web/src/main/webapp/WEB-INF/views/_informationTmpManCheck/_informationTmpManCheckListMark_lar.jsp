<%--
  Created by IntelliJ IDEA.
  User: msi-
  Date: 2020/12/4
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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


    <title>网站列表（地方）</title>
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
<div class="wrapper wrapper-content">
    <div class="row">

        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>柱状图</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="graph_flot.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="graph_flot.html#">选项1</a>
                            </li>
                            <li><a href="graph_flot.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">

                    <div class="echarts" id="echarts-bar-chart"></div>
                </div>
            </div>
        </div>


        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">

                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#">选项</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div id="loading"></div>
                <div class="ibox-content">
                    <table class="table table-striped table-bordered table-hover dataTables-example"><!-- 无分页查询功能：table table-bordered -->
                        <thead>
                        <tr>
                            <th class="hide_column">隐藏列</th>

                            <th><input type="checkbox" id="checkbox"></th>
                            <th>标题信息</th>
                            <%--                                    <th>原网站</th>
                                                                <th>新闻地址</th>--%>
                            <th>标记日期</th>
                            <th>标题</th>
                            <th>文号</th>
                            <th>部门代码</th>
                            <th>部门名称</th>
                            <th>实施日期</th>
                            <th>发布日期</th>
                            <th>附件</th>
                            <th>正文</th>
                            <th>所属分类</th>
                            <th>关键字</th>
                            <th>其他</th>


                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${mainList}" var="main" varStatus="xb">
                            <tr class="gradeX">
                                <td class="hide_column">${main.linksource}</td>
                                <td class="center">
                                    <input type="checkbox" name="mycheckbox" value="${main.number}">
                                </td>
                                <td class="center">
                                    <a  onclick="openDetail('${main.number}')">${main.rjs0}</a>
                                    <button type="button" class="btn btn-primary btn-xs" onclick="openSource('${main.linksource}')">来源</button>
                                </td>
                                    <%--                                        <td class="center"><a href="${websiteList.websiteAddress}" target="_blank">原网站</a> </td>
                                                                            <td class="center"><a href="${websiteList.source}" target="_blank">网站来源</a> </td>--%>
                                <td class="center"><fmt:formatDate value="${main.appdate}" pattern="yyyy-MM-dd HH:mm" ></fmt:formatDate></td>
                                <td class="center"><c:if test="${main.markTitle > 0}"><span style="color: red" class="glyphicon glyphicon-ok" aria-hidden="true"></span></c:if></td>
                                <td class="center"><c:if test="${main.markFilenum > 0}"><span style="color: red" class="glyphicon glyphicon-ok" aria-hidden="true"></span></c:if></td>
                                <td class="center"><c:if test="${main.markDeptcode > 0}"><span style="color: red" class="glyphicon glyphicon-ok" aria-hidden="true"></span></c:if></td>
                                <td class="center"><c:if test="${main.markDeptname > 0}"><span style="color: red" class="glyphicon glyphicon-ok" aria-hidden="true"></span></c:if></td>


                                <td class="center"><c:if test="${main.markImp > 0}"><span style="color: red" class="glyphicon glyphicon-ok" aria-hidden="true"></span></c:if></td>
                                <td class="center"><c:if test="${main.markRelease > 0}"><span style="color: red" class="glyphicon glyphicon-ok" aria-hidden="true"></span></c:if></td>
                                <td class="center"><c:if test="${main.markAttachment > 0}"><span style="color: red" class="glyphicon glyphicon-ok" aria-hidden="true"></span></c:if></td>
                                <td class="center"><c:if test="${main.markContent > 0}"><span style="color: red" class="glyphicon glyphicon-ok" aria-hidden="true"></span></c:if></td>
                                <td class="center"><c:if test="${main.markKind > 0}"><span style="color: red" class="glyphicon glyphicon-ok" aria-hidden="true"></span></c:if></td>
                                <td class="center"><c:if test="${main.markKeyword > 0}"><span style="color: red" class="glyphicon glyphicon-ok" aria-hidden="true"></span></c:if></td>
                                <td class="center"><c:if test="${main.markOther > 0}"><span style="color: red" class="glyphicon glyphicon-ok" aria-hidden="true"></span></c:if></td>



                            </tr>

                        </c:forEach>
                        </tbody>
                    </table>

                </div>
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

<!-- ECharts -->
<script src="<%=basePath%>js/plugins/echarts/echarts-all.js"></script>



<!--  echars -->
<script>
    $(function () {


        var barChart = echarts.init(document.getElementById("echarts-bar-chart"));
        var baroption = {
            title : {
                text: '已标记新闻'
            },
            tooltip : {
                trigger: 'none'
            },
            legend: {
                data:['数量']
            },

            xAxis : [
                {
                    type : 'category',
                    data : ['标题','文号','部门代码','部门名称','实施日期','发布日期','附件','正文','所属分类','关键字','其他']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'数量',
                    type:'bar',
                    data:[${data}],
                    markPoint : {
                        data : [
                            {type : 'max', name: '最大值'},
                            {type : 'min', name: '最小值'}
                        ]
                    }
                }
            ]
        };
        barChart.setOption(baroption);
        barChart.on('click', function (params) {
            window.location.href="<%=basePath%>manCheck/markList_lar?column="+params.name;
        });
    });

</script>
<!-- Page-Level Scripts -->
<script>
    $(document).ready(function () {
        $('.dataTables-example').dataTable();

        /* Init DataTables */
        var oTable = $('#editable').dataTable();

        /* Apply the jEditable handlers to the table */
        oTable.$('td').editable('../example_ajax.php', {
            "callback": function (sValue, y) {
                var aPos = oTable.fnGetPosition(this);
                oTable.fnUpdate(sValue, aPos[0], aPos[1]);
            },
            "submitdata": function (value, settings) {
                return {
                    "row_id": this.parentNode.getAttribute('id'),
                    "column": oTable.fnGetPosition(this)[2]
                };
            },

            "width": "90%",
            "height": "100%"
        });


    });

</script>

<script>

    function openDetail(data) {

        window.location.href="<%=path%>/manCheck/markDetail/"+data;
    }

    function openSource(source) {
        window.open(source,'_blank');
    }
</script>
<!-- 隐藏url列 -->
<style>
    .hide_column{
        display: none;
    }
</style>


</html>
