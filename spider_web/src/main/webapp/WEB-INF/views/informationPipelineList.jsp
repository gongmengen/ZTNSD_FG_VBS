<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: msi-
  Date: 2019/10/14
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>爬虫规则适配系统</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="<%=basePath%>css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="<%=basePath%>font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="<%=basePath%>css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <link href="<%=basePath%>css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>css/style.css?v=2.2.0" rel="stylesheet">

</head>

<body>
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">

                    <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="img/profile_small.jpg" />
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                                <span class="clear">
                                    <span class="block m-t-xs"> <strong class="font-bold">${sessionScope.user.name}</strong></span>

                                </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="form_avatar.html">修改头像</a>
                            </li>
                            <li><a href="profile.html">个人资料</a>
                            </li>
                            <li><a href="contacts.html">联系我们</a>
                            </li>
                            <li><a href="mailbox.html">信箱</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="<%=basePath%>/outSys">安全退出</a>
                            </li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        H+
                    </div>

                </li>





                <li >
                    <a href="index.html#"><i class="fa fa-table"></i> <span class="nav-label">适配网站</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">

                        <li><a href="<%=basePath%>websiteList">网站列表(中央)</a>
                        </li>
                        <li><a href="<%=basePath%>websiteList_lar">网站列表(地方)</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="index.html#"><i class="fa fa-sitemap"></i> <span class="nav-label">已适配/未适配 </span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="javascript:void(0);" onclick="isApaterWebsiteList()">已适配</a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" onclick="isNotApaterWebsiteList()">未适配</a>
                        </li>
                    </ul>
                </li>
                <script type="text/javascript">
                    function isApaterWebsiteList() {
                        window.location.href="/isApaterWebsiteList";
                    }
                    function isNotApaterWebsiteList() {
                        window.location.href="/isNotApaterWebsiteList";
                    }
                </script>
                <li>
                    <a href="index.html#"><i class="fa fa-magic"></i> <span class="nav-label">通用脚本修改 </span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="javascript:void(0);" onclick="lawstar_title_update()">标题</a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" onclick="lawstar_content_update()">正文</a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" onclick="lawstar_implmentdate_update()">实施日期</a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" onclick="lawstar_appdate_update()">发布日期</a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" onclick="lawstar_wenhao_update()">文号</a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" onclick="lawstar_attments_update()">附件</a>
                        </li>
                    </ul>
                </li>
                <li class="active">
                    <a href="index.html#"><i class="fa fa-desktop"></i> <span class="nav-label">法规预处理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <!--                        <li><a href="table_basic.html">基本表格</a>
                                                </li>-->
                        <li class="active"><a href="/informationPipeline">中央法规</a>
                        <li><a href="/informationPipelinelar">地方法规</a>
                        </li>
                    </ul>
                </li>
                <c:if test="${sessionScope.user.level < 0}">
                    <li>
                        <a href="index.html#"><i class="fa fa-desktop"></i> <span class="nav-label">网站适配分配管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <!--                        <li><a href="table_basic.html">基本表格</a>
                                                    </li>-->
                            <li><a href="/task/list">网站分配列表(中央)</a>
                            <li><a href="/task/list_lar">网站分配列表(地方)</a>
                            </li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${sessionScope.user.level < 0}">
                    <li>
                        <a href="index.html#"><i class="fa fa fa-bar-chart-o"></i> <span class="nav-label">网站数据抓取监测</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <!--                        <li><a href="table_basic.html">基本表格</a>
                                                    </li>-->
                            <li><a href="/monitor/list">网站抓取列表(中央)</a>
                            <li><a href="/monitor/list_lar">网站抓取列表(地方)</a>
                            </li>
                        </ul>
                    </li>
                </c:if>
                <li>
                    <a href="/search/goSearchPage"><i class="fa fa-files-o"></i> <span class="nav-label">搜索</span></a>

                </li>
                <script type="text/javascript">
                    function lawstar_title_update() {
                        window.location.href="/lawstar_title_update";
                    }
                    function lawstar_content_update() {
                        window.location.href="/lawstar_content_update";
                    }
                    function lawstar_implmentdate_update() {
                        window.location.href="/lawstar_implmentdate_update";
                    }
                    function lawstar_appdate_update() {
                        window.location.href="/lawstar_appdate_update";
                    }
                    function lawstar_wenhao_update() {
                        window.location.href="/lawstar_wenhao_update";
                    }

                    function lawstar_attments_update() {
                        window.location.href="/lawstar_attments_update";
                    }
                </script>
            </ul>

        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="<%=basePath%>informationPipeline#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message"><a href="<%=basePath%>index" title="返回首页"><i class="fa fa-home"></i></a>欢迎使用爬虫规则适配系统</span>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="index.html#">
                            <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                        </a>
                        <ul class="dropdown-menu dropdown-messages">
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="img/a7.jpg">
                                    </a>
                                    <div class="media-body">
                                        <small class="pull-right">46小时前</small>
                                        <strong>小四</strong> 项目已处理完结
                                        <br>
                                        <small class="text-muted">3天前 2014.11.8</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="img/a4.jpg">
                                    </a>
                                    <div class="media-body ">
                                        <small class="pull-right text-navy">25小时前</small>
                                        <strong>国民岳父</strong> 这是一条测试信息
                                        <br>
                                        <small class="text-muted">昨天</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="mailbox.html">
                                        <i class="fa fa-envelope"></i>  <strong> 查看所有消息</strong>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="index.html#">
                            <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="mailbox.html">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> 您有16条未读消息
                                        <span class="pull-right text-muted small">4分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="profile.html">
                                    <div>
                                        <i class="fa fa-qq fa-fw"></i> 3条新回复
                                        <span class="pull-right text-muted small">12分钟钱</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="notifications.html">
                                        <strong>查看所有 </strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>


                    <li>
                        <a href="<%=basePath%>/outSys">
                            <i class="fa fa-sign-out"></i> 退出
                        </a>
                    </li>
                </ul>

            </nav>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">


            <script type="text/javascript">

                function openTimer() {
                    $.ajax({ url: "<%=basePath%>openTimer", success: function(data){
                        alert(data)
                    }});
                }
                function closeTimer() {
                    $.ajax({ url: "<%=basePath%>closeTimer", success: function(data){
                        alert(data)
                    }});
                }

            </script>
            <div class="col-lg-10">
             <span style="float: right;margin-top: 30px;">
<%--                <div class="btn-group">
                    <button data-toggle="dropdown" class="btn btn-warning dropdown-toggle">定时器<span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="javascript:void(0);" onclick="openTimer()">开启定时器</a></li>
                        <li><a href="javascript:void(0);" onclick="closeTimer()">关闭定时器</a></li>
                    </ul>
                </div>--%>
                                 <c:if test="${sessionScope.user.level < 0}">
                                     <button type="button" class="btn btn-primary btn-sm" onclick="output('bbb')">最新导出</button>
                                 </c:if>
                <button type="button" class="btn btn-primary btn-sm" onclick="output('aaa')">导出</button>
                <button type="button" class="btn btn-primary btn-sm" onclick="outPutOver()">已导出</button>
                <button type="button" class="btn btn-primary btn-sm" onclick="deleteAll()">删除</button>
                <button type="button" class="btn btn-primary btn-sm" onclick="restart()">重置</button>
            </span>
                <h2>中央法规</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="<%=basePath%>index">主页</a>
                    </li>
                    <li>
                        <a>法规预处理</a>
                    </li>
                    <li>
                        <strong>中央法规</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>

        </div>
        <div class="wrapper wrapper-content animated fadeInRight">
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
                                            <a href="javascript:void(0);"  target="_blank" onclick="openDetail('${websiteList.id}')">${websiteList.newstitle}</a>
                                            <button type="button" class="btn btn-primary btn-xs" onclick="openSource('${websiteList.source}')">来源</button>
                                            <button type="button" class="btn btn-primary btn-xs" onclick="openWebsiteAddress('${websiteList.websitesource}')">栏目</button>
                                        </td>
<%--                                        <td class="center"><a href="${websiteList.websiteAddress}" target="_blank">原网站</a> </td>
                                        <td class="center"><a href="${websiteList.source}" target="_blank">网站来源</a> </td>--%>
                                        <td class="center">${websiteList.releasetime}</td>
                                        <td class="center">${websiteList.filenum}</td>
                                        <td class="center">${websiteList.deptcode}</td>
                                        <td class="center">${websiteList.deptname}</td>
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
        <div class="footer">
            <div class="pull-right">
                By：<a href="http://www.zi-han.net" target="_blank">zihan's blog</a>
            </div>
            <div>
                <strong>Copyright</strong> H+ &copy; 2014
            </div>
        </div>

    </div>
</div>


</div>

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

    function fnClickAddRow() {
        $('#editable').dataTable().fnAddData([
            "Custom row",
            "New row",
            "New row",
            "New row",
            "New row"]);

    }
</script>
<style>

    .current {
        color: #b34927;
    }

    a:FOCUS{

        color: #b34927;

    }

</style>







<script type="text/javascript">

    $(function () {

        window.onload = function()
        {

            var $a = $('.gradeX td a');       //找到你的a标签在哪一个元素下面
            $a.click(function(){         //给a标签添加点击事件
                var $this = $(this);
                $a.removeClass();
                $this.addClass('current');
            });

        }
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

   function findErrorLog1007(id,column) {


       var targetUrl = "<%=basePath%>/findErrorLog1007";


       var informationid = $("#informationid").val();


       $.ajax({
           type:'post',
           url:targetUrl,
           cache: false,
           data:{"informationid":id,"column":column},
           success:function(data){
               alert(data)
           },
           error:function(){
               alert("请求失败")
           }
       })
   }

   function openDetail(data) {

       window.open("<%=path%>/informationDetail/"+data+"/100002",'_blank');
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
</body>

</html>
