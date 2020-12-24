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


    <title>中央法规</title>
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

    <div class="col-lg-7">
        <h2>中央法规</h2>
    </div>
    <div class="col-lg-5">
             <span style="float: right;margin-top: 30px;">
                                 <c:if test="${sessionScope.user.level < 0}">
                                     <button type="button" class="btn btn-primary btn-sm" onclick="output('zysg')">最新导出</button>
                                 </c:if>
                <button type="button" class="btn btn-primary btn-sm" onclick="output('zyyz')">导出</button>
                <button type="button" class="btn btn-primary btn-sm" onclick="output('zyzd')">放行</button>
                <button type="button" class="btn btn-primary btn-sm" onclick="outPutOver()">已导出</button>
                <button type="button" class="btn btn-primary btn-sm" onclick="deleteAll()">删除</button>
                <button type="button" class="btn btn-primary btn-sm" onclick="restart()">重置</button>
                <button type="button" class="btn btn-primary btn-sm" onclick="img_download()">img—upload</button>
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
                            <th>所属库</th>
                            <th>收录时间</th>
                            <th>重复</th>
                            <th>待查</th>
                            <th>附件数</th>
                            <th>负责人</th>
                            <th><input type="checkbox" id="checkbox"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${informationList}" var="websiteList" varStatus="xb">
                            <tr class="gradeX">
                                <td class="hide_column">${websiteList.source}</td>
                                <td class="center">
                                    <a onclick="openDetail('${websiteList.id}')">${websiteList.newstitle}</a>
                                    <button type="button" class="btn btn-primary btn-xs" onclick="openSource('${websiteList.source}')">来源</button>
                                    <button type="button" class="btn btn-primary btn-xs" onclick="openWebsiteAddress('${websiteList.websitesource}')">栏目</button>
                                </td>
                                    <%--                                        <td class="center"><a href="${websiteList.websiteAddress}" target="_blank">原网站</a> </td>
                                                                            <td class="center"><a href="${websiteList.source}" target="_blank">网站来源</a> </td>--%>
                                <td class="center">${websiteList.releasetime}</td>
                                <td class="center">${websiteList.filenum}</td>
                                <td class="center">${websiteList.deptcode}</td>
                                <td class="center">${websiteList.deptname}</td>
                                <td class="center">${websiteList.rjs14}</td>
                                <td class="center">${websiteList.rjs15}</td>
                                <td class="center">
                                    <c:if test="${websiteList.xwcolumn.equals('100002')}">
                                        中央
                                    </c:if>
                                    <c:if test="${websiteList.xwcolumn.equals('100003')}">
                                        地方
                                    </c:if>
                                </td>
                                <td class="center"><fmt:parseDate value="${websiteList.createtime}" pattern="yyyy-MM-dd HH:mm" var="masterDate"/><fmt:formatDate value="${masterDate}" pattern="yyyy-MM-dd HH:mm" ></fmt:formatDate></td>
                                <td class="center">
                                        <%--                                           <c:if test="${websiteList.preDistinct == 1}">
                                                                                        <a href="javascript:void(0);" onclick="findErrorLog1007(${websiteList.informationId},${websiteList.xwcolumn})"><font color="red">是</font></a>
                                                                                    </c:if>--%>
                                    <c:if test="${websiteList.preDistinct == 11}">
                                        <font color="red">正式库必重</font>
                                    </c:if>
                                    <c:if test="${websiteList.preDistinct == 12}">
                                        <font color="yellow">正式库重复</font>
                                    </c:if>
                                    <c:if test="${websiteList.preDistinct == 13}">
                                        <font color="#00bfff">抓取库必重</font>
                                    </c:if>
                                    <c:if test="${websiteList.preDistinct == 14}">
                                        <font color="#7cfc00">抓取库重复</font>
                                    </c:if>

                                    <c:if test="${websiteList.preDistinct == 0}">
                                        否
                                    </c:if>

                                        <%--<i class="fa fa-circle"></i>--%>
                                </td>
                                <td class="center">
                                    <c:if test="${websiteList.errorStatus == 0}">
                                        <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>

                                    </c:if>
                                    <c:if test="${websiteList.errorStatus == 1}">
                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal5" onclick="reg(${websiteList.informationId},${websiteList.xwcolumn})">
                                            查看
                                        </button>
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
                                    </c:if>
                                </td>
                                <td class="center">
                                    <c:if test="${websiteList.fjcount == 0}">
                                        ${websiteList.fjcount}
                                    </c:if>
                                    <c:if test="${websiteList.fjcount != 0}">
                                        <a id="fjcount${websiteList.id}" data-toggle="modal" href="javascript:void(0);" data-target="#myModal6" onclick="downloadFJ(${websiteList.id})">${websiteList.fjcount}</a>
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
                                        ${websiteList.personincharge}
                                </td>
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


        /*        //隐藏url 列
                $('.dataTables-example').dataTable( {
                      "columnDefs" :
                          [{
                              className: "hide_column",
                              "targets": [0]
                          }]
                  } );*/

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

    function img_download() {

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
                url: "<%=basePath%>imgDownload",
                success: function(data){
                    alert(data);
                    window.location.reload();
                }});
        }else {
            alert("请选择要下载的新闻")
        }




    }

    //已导出

    function outPutOver() {
        window.location.href="<%=basePath%>/outPutOver/100002";
    }


    //导出
    function output(name) {
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
                data:{ids:informationPipelineIds,name:name},
                url: "<%=basePath%>output",
                success: function(data){
                    alert(data);
                    window.location.reload();
                }});
        }else {
            alert("请选择要导出的新闻")
        }
    }


    function reg(id,column) {
        var targetUrl = "<%=basePath%>/findErrorLog";


        var informationid = $("#informationid").val();


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

    function openDetail(data) {

        window.location.href="<%=path%>/informationDetail/"+data+"/100002";
    }
    function openWebsiteAddress(data) {
        window.open(data);
    }
    function downloadFJ(id) {
        var targetUrl = "<%=basePath%>/downloadFJ";

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
        var targetUrl = "<%=basePath%>/downLoadAttachment";
        var fjName = "";
        fjName = $("#fjian"+count).text();

        fjName = fjName.replace(new RegExp("\\.","gm"),"-");



        window.location.href=targetUrl+"/"+id+"/"+fjName;
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
                url: "<%=basePath%>deleteAll",
                success: function(data){
                    alert(data);
                    window.location.reload();
                }});
        }else {
            alert("请选择要删除的新闻")
        }
    }

    function restart() {
        var informationPipelineIds = "";
        $('input[name="mycheckbox"]').each(function () {
            if (this.checked){
                informationPipelineIds += this.value+" ";
            }
        });
        //重置的所属库
        var xwcolumn = "100002";
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
                data:{ids:informationPipelineIds,xwcolumn:xwcolumn},
                url: "<%=basePath%>restart",
                success: function(data){
                    alert(data);
                    window.location.reload();
                }});
        }else {
            alert("请选择要重置的新闻")
        }
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
