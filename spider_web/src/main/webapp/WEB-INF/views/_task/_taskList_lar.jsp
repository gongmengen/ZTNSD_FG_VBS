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


    <title>网站分配列表（地方）</title>
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
    <div class="col-lg-10">
        <h2>网站分配列表（地方）</h2>
    </div>
    <div class="col-lg-2">
        <div class="text-center" style="padding-top: 30px">
            <a data-toggle="modal" class="btn btn-primary" href="form_basic.html#modal-form">分配任务</a>
        </div>
        <div id="modal-form" class="modal fade" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="row">

                            <form role="form" class="form-horizontal" method="post" action="/task/addLar" id="myform1" target="_self">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">可分配用户

                                    </label>
                                    <input type="hidden" id = "websiteids" name="websiteids">
                                    <div class="col-sm-10">
                                        <c:forEach items="${userTaskList}" var="userList">

                                            <div class="radio">
                                                <label>
                                                    <input type="radio" value="${userList.name}"  name="username">${userList.name}</label>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </form>
                            <div>
                                <button class="btn btn-sm btn-primary pull-right m-t-n-xs" onclick="sendPipeline()"><strong>确认分配</strong>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>基本 <small>分类，查找</small></h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="table_data_tables.html#">选项1</a>
                            </li>
                            <li><a href="table_data_tables.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>


                </div>
                <div class="ibox-content">

                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>网站ID</th>
                            <th>网站名称</th>
                            <th  style="display: none">URL</th>
                            <th>所属部门</th>
                            <th>推送状态</th>

                            <th>负责人</th>
                            <th><input type="checkbox" id="checkbox"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${websiteList}" var="websiteList">
                            <tr class="gradeX">
                                <td>${websiteList.id}</td>
                                    <%--                                    <c:forEach items="${informationWebsiteList}" var="informationWebsiteList">
                                                                            <c:if test="${websiteList.id == informationWebsiteList.websiteid}">
                                                                                <td>${websiteList.websitename}</td>

                                                                            </c:if>
                                                                            <c:if test="${websiteList.id != informationWebsiteList.websiteid}">
                                                                                <td style="color:red;">${websiteList.websitename}</td>
                                                                            </c:if>
                                                                        </c:forEach>--%>
                                <c:if test="${websiteList.istatus == 1}">
                                    <td>${websiteList.websitename}</td>
                                </c:if>
                                <c:if test="${websiteList.istatus == 0}">
                                    <td  style="color:red;">${websiteList.websitename}</td>
                                </c:if>
                                <td  style="display: none"><a href="${websiteList.websiteaddress}" target="_blank">${websiteList.websiteaddress}</a> </td>
                                <td class="center">${websiteList.columnid}</td>

                                <c:if test="${websiteList.refmain == 1}">
                                    <td class="center"><i class="fa fa-circle" style="color: greenyellow"></i></td>
                                </c:if>
                                <c:if test="${websiteList.refmain != 1 &&websiteList.refmain != 2&&websiteList.refmain != 3}">
                                    <td class="center"><i class="fa fa-circle" style="color: #8B91A0"></i></td>
                                </c:if>
                                <c:if test="${websiteList.refmain == 2}">
                                    <td class="center"><i class="fa fa-circle" style="color: #00E8D7"></i></td>
                                </c:if>
                                <c:if test="${websiteList.refmain == 3}">
                                    <td class="center"><i class="fa fa-circle" style="color: yellow"></i></td>
                                </c:if>

                                <td class="center"> ${websiteList.usertask}</td>
                                <td class="center">
                                    <input type="checkbox" name="mycheckbox" value="${websiteList.id}">
                                </td>
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
<!-- Page-Level Scripts -->
<script>
    $(document).ready(function () {
        if (!${selectLength eq null}){
            $('.dataTables-example').dataTable( {"pageLength": "${selectLength}"} );
        }//默认显示条数
        //$('.dataTables-example').dataTable( {"language": {"url": "http://localhost:8080/returnSearchJSON"}} );

        //分页数量控制

        $('.dataTables-example').on( 'length.dt', function ( e, settings, len ) {
            $.ajax({
                data:{length:len},
                url: "<%=basePath%>rememberSelectLength"});
        } ).DataTable();
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
<!-- js start  放到外面会找不到函数 -->
<script>
    function sendPipeline() {


        var informationPipelineIds = "";
        $('input[name="mycheckbox"]').each(function () {
            if (this.checked){
                informationPipelineIds += this.value+" ";
            }
        });
        if (informationPipelineIds.length>0) {
            $("#websiteids").val(informationPipelineIds);
            $("#myform1").submit();
        }else {
            alert("请选择要分配的新闻")
        }

    }
</script>
<!-- js end  -->
</html>
