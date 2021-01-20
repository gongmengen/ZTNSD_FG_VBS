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


    <title>临时库列表（中央）</title>
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

        <h2>临时库列表（中央）</h2>
        <ol class="breadcrumb">
            <li>
                <strong>临时库列表（中央）</strong>
            </li>
        </ol>
    </div>
    <div class="col-lg-2">
             <span style="float: right;margin-top: 30px;">

                <button type="button" class="btn btn-primary btn-sm" onclick="deleteAll()">删除</button>
                <button type="button" class="btn btn-primary btn-sm" onclick="nextStep()">下一步</button>

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
                    <input id="myInput" type="search" class="form-control input-sm" style="width: 10%;float: right" placeholder="查询：" oninput="searchData(this)">

                    <table class="table table-striped table-bordered table-hover dataTables-example"><!-- 无分页查询功能：table table-bordered -->
                        <thead>
                        <tr>


                            <th><input type="checkbox" id="checkbox"></th>
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
                            <th>操作</th>

                        </tr>
                        </thead>
                        <div class="modal inmodal fade" id="myModal5" tabindex="-1" role="dialog"  aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                        <h4 class="modal-title">错误日志</h4>

                                    </div>
                                    <div class="modal-body">
                                        <textarea id="p" style="height: 300px;width: 840px"></textarea>
                                    </div>

                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
                                    </div>
                                </div>
                            </div>
                        </div>
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
<!-- moment -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
<!-- Page-Level Scripts -->
<script>

    function dateFormat(date) {
        if (!$.isEmptyObject(date) || date == '' || date == null) {
            return '空';
        }
        return moment(date).format('YYYY-MM-DD HH:mm');
    }

    $(document).ready(function () {

        var table = $('.dataTables-example').DataTable({//绑定要遍历数据的 table 的 id

            pageLength : 25,/* 页大小，同时当前页每次加 10，不明白为什么每次增加 10 */

            serverSide : true,/* 启用服务端分页，如果前端分页，这里为 false */
            searching : false,

            ajax : {
                url : "<%=basePath%>manCheck/list",
                type : "post",
                data : {},
                dataFilter : function(json){
                    return json;
                }
            },

            /* 中间遍历的数据 */
            columns : [

                {data:"number",render:function(data){return ("<input type=\"checkbox\" name=\"mycheckbox\" value=\""+data+"\">");}},
                {data:"rjs0",render:function(data, type, full){

                    if (full.truetag1 > 0){
                        return data+
                            "<button type=\"button\" class=\"btn btn-primary btn-xs\" onclick=\"openSource('"+full.linksource+"')\">来源</button>"
                            +"<span class=\"badge badge-danger\"  data-toggle=\"modal\"  data-target=\"#myModal5\"  onclick=\"reg('"+full.appuser+"','100002')\">"+full.truetag1+"</span>";
                    }else {
                        return data+
                            "<button type=\"button\" class=\"btn btn-primary btn-xs\" onclick=\"openSource('"+full.linksource+"')\">来源</button>";
                    }


                }},
                {data:"rjs5",render:function(data){return (data);}},
                {data:"rjs12",render:function(data){return (data);}},
                {data:"rjs4",render:function(data){return (data);}},
                {data:"rjs10",render:function(data){return (data);}},
                {data:"rjs14",render:function(data){return (data);}},
                {data:"rjs15",render:function(data){return (data);}},
                {data:"appdate",render:function(data){return (dateFormat(data));}},
                {data:"fj_count",render:function(data){return (data);}},
                {data:"number",render:function(data){return ("<button type=\"button\" class=\"btn btn-warning btn-sm\" onclick=\"deleteConfirm('"+data+"')\">删除</button>");}}
            ]
        });

    });



</script>

<script>


    function deleteConfirm(deleteID)
    {
        $.ajax('<%=basePath%>manCheck/delete', {
            dataType : 'json',
            data: {
                ids:deleteID
            },
            success: function(data)
            {
                if (data==true)
                {
                    alert('删除成功!');
                    start = $('.dataTables-example').dataTable().fnSettings()._iDisplayStart;
                    total = $('.dataTables-example').dataTable().fnSettings().fnRecordsDisplay();
                    window.location.reload();
                    if((total-start)==1){
                        if (start > 0) {
                            $('.dataTables-example').dataTable().fnPageChange( 'previous', true );
                        }
                    }
                }
                else
                {
                    alert('删除发生错误，请联系管理员!');
                }
            },
            error: function()
            {
                alert('服务器无响应，请联系管理员!');
            }
        });


    }

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


    function nextStep() {

        var informationPipelineIds = "";
        $('input[name="mycheckbox"]').each(function () {
            if (this.checked){
                informationPipelineIds += this.value+" ";
            }
        });




        window.location.href="<%=path%>/manCheck/randomTwentyFive?informationIds="+informationPipelineIds;
    }

    function deleteAll() {
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
                url: "<%=basePath%>manCheck/delete",
                success: function(data){
                    alert("删除成功!");
                    window.location.reload();
                }});
        }else {
            alert("请选择要删除的新闻")
        }
    }

    function openSource(source) {
        window.open(source,'_blank');
    }

    function reg(id,column) {
        var targetUrl = "<%=basePath%>/findErrorLog";

        $.ajax({
            type:'post',
            url:targetUrl,
            cache: false,
            data:{"informationid":id,"column":column},
            success:function(data){
                $("#p").text(data);
            },
            error:function(){
                alert("请求失败")
            }
        })
    }
</script>

<script>
    function searchData(_this) {
        //try
        $('.dataTables-example').dataTable().fnDestroy();

        var keyword = $('#myInput').val();
        keyword = keyword.replaceAll("\'","");
        console.log(keyword);

        $('.dataTables-example').DataTable({//绑定要遍历数据的 table 的 id

            pageLength : 25,/* 页大小，同时当前页每次加 10，不明白为什么每次增加 10 */

            serverSide : true,/* 启用服务端分页，如果前端分页，这里为 false */
            searching : false,
            ajax : {
                url : "<%=basePath%>manCheck/list",
                type : "post",
                data : {"keyword":keyword},
                dataFilter : function(json){
                    return json;
                }
            },

            /* 中间遍历的数据 */
            columns : [

                {data:"number",render:function(data){return ("<input type=\"checkbox\" name=\"mycheckbox\" value=\""+data+"\">");}},
                {data:"rjs0",render:function(data, type, full){

                    if (full.truetag1 > 0){
                        return data+
                            "<button type=\"button\" class=\"btn btn-primary btn-xs\" onclick=\"openSource('"+full.linksource+"')\">来源</button>"
                            +"<span class=\"badge badge-danger\"  data-toggle=\"modal\"  data-target=\"#myModal5\"  onclick=\"reg('"+full.appuser+"','100002')\">"+full.truetag1+"</span>";
                    }else {
                        return data+
                            "<button type=\"button\" class=\"btn btn-primary btn-xs\" onclick=\"openSource('"+full.linksource+"')\">来源</button>";
                    }


                }},
                {data:"rjs5",render:function(data){return (data);}},
                {data:"rjs12",render:function(data){return (data);}},
                {data:"rjs4",render:function(data){return (data);}},
                {data:"rjs10",render:function(data){return (data);}},
                {data:"rjs14",render:function(data){return (data);}},
                {data:"rjs15",render:function(data){return (data);}},
                {data:"appdate",render:function(data){return (dateFormat(data));}},
                {data:"fj_count",render:function(data){return (data);}},
                {data:"number",render:function(data){return ("<button type=\"button\" class=\"btn btn-warning btn-sm\" onclick=\"deleteConfirm('"+data+"')\">删除</button>");}}
            ]
        });

    }
</script>
</html>
