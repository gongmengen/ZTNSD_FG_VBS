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


    <title>随机验证50篇</title>
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

        <h2>随机验证50篇</h2>
        <ol class="breadcrumb">
            <li>
                <a>临时库列表（地方）</a>
            </li>
            <li>
                <strong>随机验证50篇</strong>
            </li>
        </ol>
    </div>
    <div class="col-lg-2">
             <span style="float: right;margin-top: 30px;">

<button type="button" class="btn btn-primary btn-sm" onclick="output()">导入正式库</button>
            </span>
    </div>

</div>
<div class="wrapper wrapper-content">
    <div class="row">
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
                            <th>标题</th>
                            <%--                                    <th>原网站</th>
                                                                <th>新闻地址</th>--%>
                            <th>发布日期</th>
                            <th>文号</th>
                            <th>部门代码</th>
                            <th>部门名称</th>
                            <th>部门代码（新）</th>
                            <th>部门名称（新）</th>
                            <th>收录时间</th>
                            <th>附件</th>
                            <th><input type="checkbox" id="checkbox"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${mainList}" var="main" varStatus="xb">
                            <tr class="gradeX">
                                <td class="hide_column">${main.linksource}</td>
                                <td class="center">
                                    <a onclick="openDetail('${main.number}')">${main.rjs0}</a>
                                    <button type="button" class="btn btn-primary btn-xs" onclick="openSource('${main.linksource}')">来源</button>
                                </td>
                                    <%--                                        <td class="center"><a href="${websiteList.websiteAddress}" target="_blank">原网站</a> </td>
                                                                            <td class="center"><a href="${websiteList.source}" target="_blank">网站来源</a> </td>--%>
                                <td class="center">${main.rjs5}</td>
                                <td class="center">${main.rjs12}</td>
                                <td class="center">${main.rjs4}</td>
                                <td class="center">${main.rjs10}</td>
                                <td class="center">${main.rjs14}</td>
                                <td class="center">${main.rjs15}</td>
                                <td class="center"><fmt:formatDate value="${main.appdate}" pattern="yyyy-MM-dd HH:mm" ></fmt:formatDate></td>
                                <td class="center">
                                    <c:if test="${main.fj_count == 0}">
                                        ${main.fj_count}
                                    </c:if>
                                    <c:if test="${main.fj_count != 0}">
                                        <a id="fjcount${main.number}" data-toggle="modal" href="javascript:void(0);" data-target="#myModal6" onclick="manCheckDownloadFJ('${main.number}')">${main.fj_count}</a>
                                        <div class="modal inmodal fade" id="myModal6" tabindex="-1" role="dialog"  aria-hidden="true">
                                            <div class="modal-dialog modal-lg">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                                        <h4 class="modal-title">附件列表</h4>

                                                    </div>
                                                    <div class="modal-body">
                                                        <div contentEditable="true" id="p6">

                                                        </div>
                                                    </div>

                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                </td>
                                <td class="center">
                                    <input type="checkbox" name="mycheckbox" value="${main.number}">
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




    //debugger;
    $("#checkbox").click(function () {
        if(this.checked){
            $('input[name="mycheckbox"]').each(function () {
                this.checked = true;
            });
        }else {
            $('input[name="mycheckbox"]').each(function () {
                this.checked = false;
            });
        }

    })

    //导出
    function output() {
        var informationPipelineIds = "";
        $('input[name="mycheckbox"]').each(function () {
            if (this.checked){
                informationPipelineIds += this.value+" ";
            }
        });
        if (informationPipelineIds.length>0){
            $.ajax({
                beforeSend: function () {
                    $("#loading").html("<div class=\"spiner-example\">\n" +
                        "                            <div class=\"sk-spinner sk-spinner-wave\">\n" +
                        "                                <div class=\"sk-rect1\"></div>\n" +
                        "                                <div class=\"sk-rect2\"></div>\n" +
                        "                                <div class=\"sk-rect3\"></div>\n" +
                        "                                <div class=\"sk-rect4\"></div>\n" +
                        "                                <div class=\"sk-rect5\"></div>\n" +
                        "                            </div>\n" +
                        "                        </div>");
                    $("#loading").css("display","block");
                    $(".modal-body").css("display","none");

                },
                complete: function () {
                    $("#loading").css("display","none");
                    // $("#loading").remove();
                },
                data:{ids:informationPipelineIds},
                url: "<%=basePath%>/manCheck/output_lar",
                success: function(data){
                    alert(data);
                    window.location.reload();
                }});
        }else {
            alert("请选择要导出的新闻")
        }
    }

    function openSource(source) {
        window.open(source,'_blank');
    }

    function openDetail(data) {

        window.location.href="<%=path%>/manCheck/detail/"+data;
    }
    function manCheckDownloadFJ(id) {

        var targetUrl = "<%=basePath%>/manCheck/downloadFJ";

        $.ajax({
            type:'post',
            url:targetUrl,
            cache: false,
            data:{"id":id},
            success:function(data){
                $("#p6").html(data);
            },
            error:function(){
                alert("请求失败")
            }
        })
    }
    function downLoadAttachment(id,count) {
        debugger;
        var targetUrl = "<%=basePath%>/manCheck/downLoadAttachment";
        var fjName = "";
        fjName = $("#fjian"+count).text();

        fjName = fjName.replace(new RegExp("\\.","gm"),"-");


        /*       var dian = fjName.lastIndexOf(".");

               var q = fjName.substring(0,dian);

               fjName = q+"-"+fjName.substring(dian+1);
               if (fjName.indexOf(".")>0){
                   fjName = fjName.substring(fjName.indexOf(".")+1)
               }*/

        /*       $.ajax({
                   type:'post',
                   url:targetUrl,
                   cache: false,
                   data:{"id":id,"fjName":fjName},
                   success:function(data){
                       $("#p6").html(data);
                   },
                   error:function(){
                       alert("请求失败")
                   }
               })*/

        window.location.href=targetUrl+"/"+id+"/"+fjName;
    }
</script>
<!-- 隐藏url列 -->
<style>
    .hide_column{
        display: none;
    }
</style>
</html>
