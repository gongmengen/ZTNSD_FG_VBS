<%--
  Created by IntelliJ IDEA.
  User: msi-
  Date: 2020/12/4
  Time: 14:08
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
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>爬虫规则适配系统</title>


    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico">
    <link href="<%=basePath%>h+_ui/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="<%=basePath%>h+_ui/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="<%=basePath%>h+_ui/css/animate.min.css" rel="stylesheet">
    <link href="<%=basePath%>h+_ui/css/style.min.css?v=4.0.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span><img alt="image" class="img-circle" src="<%=basePath%>h+_ui/img/profile_small.jpg" /></span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">Beaut-zihan</strong></span>
                                <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
                                </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a class="J_menuItem" href="form_avatar.html">修改头像</a>
                            </li>
                            <li><a class="J_menuItem" href="profile.html">个人资料</a>
                            </li>
                            <li><a class="J_menuItem" href="contacts.html">联系我们</a>
                            </li>
                            <li><a class="J_menuItem" href="mailbox.html">信箱</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="login.html">安全退出</a>
                            </li>
                        </ul>
                    </div>
                    <div class="logo-element"><img alt="image" class="img-circle" src="img/profile_small.jpg" width="32"/>
                    </div>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-home"></i>
                        <span class="nav-label">适配网站</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>websiteList" data-index="0">网站列表(中央)</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>websiteList_lar">网站列表(地方)</a>
                        </li>
                    </ul>

                </li>

                <li>
                    <a href="#">
                        <i class="fa fa fa-bar-chart-o"></i>
                        <span class="nav-label">已适配/未适配</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>isApaterWebsiteList">已适配</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>isNotApaterWebsiteList">未适配</a>
                        </li>
                    </ul>
                </li>


                <li>
                    <a href="#"><i class="fa fa-table"></i> <span class="nav-label">通用脚本修改</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="<%=basePath%>lawstar_title_update">标题</a>
                        </li>
                        <li><a class="J_menuItem" href="<%=basePath%>lawstar_content_update">正文</a>
                        </li>
                        <li><a class="J_menuItem" href="<%=basePath%>lawstar_implmentdate_update">实施日期</a>
                        </li>
                        <li><a class="J_menuItem" href="<%=basePath%>lawstar_appdate_update">发布日期</a>
                        </li>
                        <li><a class="J_menuItem" href="<%=basePath%>lawstar_wenhao_update">文号</a>
                        </li>
                        <li><a class="J_menuItem" href="<%=basePath%>lawstar_attments_update">附件</a>
                        </li>
                        <li><a class="J_menuItem" href="<%=basePath%>lawstar_common_update">common.js</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-picture-o"></i> <span class="nav-label">法规预处理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/informationPipeline">中央法规</a>
                        </li>
                        <li><a class="J_menuItem" href="/informationPipelinelar">地方法规</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-cutlery"></i> <span class="nav-label">网站适配分配管理</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/task/list">网站分配列表(中央)</a>
                        </li>
                        <li><a class="J_menuItem" href="/task/list_lar">网站分配列表(地方)</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="#"><i class="fa fa-cutlery"></i> <span class="nav-label">网站数据抓取监测</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/monitor/list">网站抓取列表(中央)</a>
                        </li>
                        <li><a class="J_menuItem" href="/monitor/list_lar">网站抓取列表(地方)</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="#"><i class="fa fa-cutlery"></i> <span class="nav-label">人工审核</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="/manCheck/list">临时库列表(中央)</a>
                        </li>
                        <li><a class="J_menuItem" href="/manCheck/list_lar">临时库列表(地方)</a>
                        </li>
                        <li><a class="J_menuItem" href="/manCheck/markList">临时库列表(已标记/中央)</a>
                        </li>
                        <li><a class="J_menuItem" href="/manCheck/markList_lar">临时库列表(已标记/地方)</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a class="J_menuItem" href="/deptcode/index"><i class="fa fa-magic"></i> <span class="nav-label">部门代码维护</span></a>
                </li>

                <li>
                    <a class="J_menuItem" href="/search/goSearchPage"><i class="fa fa-magic"></i> <span class="nav-label">搜索</span></a>
                </li>
                <li>
               <!--     <a href="/keyWor/list"><i class="fa fa-files-o"></i> <span class="nav-label">关键字维护</span></a>-->
                    <a class="J_menuItem" href="/keyWor/list"><i class="fa fa-magic"></i> <span class="nav-label">关键字维护</span></a>

                </li>
                <li>
                    <a class="J_menuItem" href="/main/list"><i class="fa fa-magic"></i> <span class="nav-label">正式库数据编辑</span></a>
                </li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <!--顶部主题开始-->
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#">
                    <i class="fa fa-bars"></i> </a>
                    <!-- <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                        </div>
                    </form> -->
                </div>

            </nav>
        </div>
        <!--顶部主题结束-->
        <!--选项卡开始-->
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="index_v1.html">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="login.html" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <!--选项卡结束-->
        <!--右侧iframe内容开始-->
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="<%=basePath%>main.html?v=4.0" frameborder="0" data-id="<%=basePath%>index_v1.html" seamless></iframe>
        </div>
        <!--右侧iframe内容结束-->

        <div class="footer">
            <div class="pull-right">&copy; 2020-2021 <a href="https://github.com/2363878987?tab=repositories" target="_blank">gongmengen</a>
            </div>
        </div>
    </div>
    <!--右侧部分结束-->
</div>
<script src="<%=basePath%>h+_ui/js/jquery.min.js?v=2.1.4"></script>
<script src="<%=basePath%>h+_ui/js/bootstrap.min.js?v=3.3.5"></script>
<script src="<%=basePath%>h+_ui/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=basePath%>h+_ui/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>h+_ui/js/plugins/layer/layer.min.js"></script>
<script src="<%=basePath%>h+_ui/js/hplus.min.js?v=4.0.0"></script>
<script type="text/javascript" src="<%=basePath%>h+_ui/js/contabs.min.js"></script>
<script src="<%=basePath%>h+_ui/js/plugins/pace/pace.min.js"></script>
</body>

</html>
