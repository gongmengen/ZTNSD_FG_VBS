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
                                    <span class="block m-t-xs"> <strong class="font-bold">${sessionScope.user.name} </strong></span>

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
                            <li><a href="login.html">安全退出</a>
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
                <li class="active">
                    <a href="index.html#"><i class="fa fa-sitemap"></i> <span class="nav-label">已适配/未适配 </span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="javascript:void(0);" onclick="isApaterWebsiteList()">已适配</a>
                        </li>
                        <li class="active">
                            <a href="/isNotApaterWebsiteList">未适配</a>
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
                        <li>
                            <a href="javascript:void(0);" onclick="lawstar_common_update()">common.js</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="index.html#"><i class="fa fa-desktop"></i> <span class="nav-label">法规预处理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <!--                        <li><a href="table_basic.html">基本表格</a>
                                                </li>-->
                        <li><a href="/informationPipeline">中央法规</a>
                        <li><a href="/informationPipelinelar">地方法规</a>
                        </li>
                    </ul>
                </li>
                <c:if test="${sessionScope.user.level < 0}">
                    <li>
                        <a href="index.html#"><i class="fa fa-comments"></i> <span class="nav-label">网站适配分配管理</span><span class="fa arrow"></span></a>
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
                <c:if test="${sessionScope.user.level < 0}">
                    <li>
                        <a href="index.html#"><i class="fa fa fa-bar-chart-o"></i> <span class="nav-label">人工审核</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <!--                        <li><a href="table_basic.html">基本表格</a>
                                                    </li>-->
                            <li><a href="/manCheck/list">临时库列表(中央)</a>
                            <li><a href="/manCheck/list_lar">临时库列表(地方)</a>
                            </li>
                        </ul>
                    </li>
                </c:if>                <li>
                <a href="/deptcode/index"><i class="fa fa-files-o"></i> <span class="nav-label">部门代码维护</span></a>
            </li>
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
                    function lawstar_common_update() {
                        window.location.href="/lawstar_common_update";
                    }
                </script>
            </ul>

        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="table_data_tables.html#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message"><a href="index.html" title="返回首页"><i class="fa fa-home"></i></a>欢迎使用H+后台主题</span>
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
                        <a href="login.html">
                            <i class="fa fa-sign-out"></i> 退出
                        </a>
                    </li>
                </ul>

            </nav>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <button type="button" class="btn btn-primary btn-sm" onclick="asSame()">传递脚本</button>
            <div class="col-lg-10">
                <h2>数据表格</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="index.html">主页</a>
                    </li>
                    <li>
                        <a>表格</a>
                    </li>
                    <li>
                        <strong>数据表格</strong>
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
                                    <th></th>
                                    <th>网站ID</th>
                                    <th>网站名称</th>
                                    <th>URL</th>
                                    <th>所属部门</th>
                                    <th>适配脚本</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${websiteList}" var="websiteList">
                                    <tr class="gradeX">
                                        <td>
                                            <input type="checkbox" name="asSameWebsite" value="${websiteList.id}">
                                        </td>
                                        <td>${websiteList.id}</td>
                                        <c:if test="${websiteList.istatus == 1}">
                                            <td>${websiteList.websitename}</td>
                                        </c:if>
                                        <c:if test="${websiteList.istatus == 0}">
                                            <td  style="color:red;">${websiteList.websitename}</td>
                                        </c:if>
                                        <td><a href="${websiteList.websiteaddress}" target="_blank">${websiteList.websiteaddress}</a> </td>
                                        <td class="center">${websiteList.columnid}</td>
                                        <td class="center"><a href="<%=basePath%>informationList/${websiteList.id}/2">添加脚本</a> </td>
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

<script type="text/javascript">

    function asSame() {
        var websiteids = $("input[type = checkbox][name = 'asSameWebsite']");
        var length = websiteids.length;
        var siteids = "";

            for (var x = 0; x < length; x++) {
                if (websiteids[x].checked) {
                    siteids += $(websiteids[x]).val() +",";
                }

            }


        //删除末尾逗号
        siteids = siteids.substring(0,siteids.length-1);
        if(siteids.length>0) {
        window.location.href = "<%=basePath%>chooseWebsite/"+siteids;
        }else {
            alert("请选择需要传递的网站")
        }

    }
</script>
</body>

</html>
