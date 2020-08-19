<%--
  Created by IntelliJ IDEA.
  User: msi-
  Date: 2019/12/10
  Time: 11:26
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
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>${informationPipeline.newstitle}</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="<%=basePath%>css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="<%=basePath%>font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="<%=basePath%>css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <link href="<%=basePath%>css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>css/style.css?v=2.2.0" rel="stylesheet">
    <link href="<%=basePath%>js/plugins/layui/css/layui.css" rel="stylesheet">

    <title>人工审核-新闻详情</title>
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
                <li class="active">
                    <a href="index.html#"><i class="fa fa fa-bar-chart-o"></i> <span class="nav-label">人工审核</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <!--                        <li><a href="table_basic.html">基本表格</a>
                                                </li>-->
                        <li><a href="/manCheck/list">临时库列表(中央)</a>
                        <li><a href="/manCheck/list_lar">临时库列表(地方)</a>
                        </li>
                    </ul>
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
                </script>
            </ul>

        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="empty_page.html#"><i class="fa fa-bars"></i> </a>
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
            <div class="col-sm-4">
                <h2>新闻详情</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="<%=basePath%>index">主页</a>
                    </li>
                    <li>
                        <a>人工审核</a>
                    </li>
                    <li>
                        <strong>新闻详情</strong>
                    </li>
                </ol>
            </div>
            <div class="col-sm-8">
                <div class="title-action">
                    <a href="${main.linksource}" target="_blank" class="btn btn-primary">来源</a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
<%--                <div class="wrapper wrapper-content">
                    <div class=" animated fadeInRightBig">

                        <p>    标题：${main.rjs0}</p>
                        <p>    文号：${main.rjs12}</p>
                        <p>    发布日期：${main.rjs5}</p>
                        <p>    正文：</p>

                    </div>
                    <textarea autoHeight="true" readonly="readonly" style="width:100%">${content}</textarea>
                </div>--%>
    <div class="ibox float-e-margins" style="padding-top: 10px;margin-bottom: 50px;">

        <div class="ibox-content">
            <form class="form-horizontal m-t" id="commentForm" action="<%=basePath%>manCheck/update" method="post">
                <input id="extend2" name="extend2" value="${main.number}" type="hidden">
                <input id="filename" name="filename" value="${main.rjs8}" type="hidden">
                <input id="extend3" name="extend3" value="${main.appuser}" type="hidden">
                <div class="form-group">
                    <label class="col-sm-3 control-label">标题：</label>
                    <div class="col-sm-8">
                        <input id="newstitle" name="newstitle"  value="${main.rjs0}" type="text" class="form-control" required="" aria-required="true">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">文号：</label>
                    <div class="col-sm-8">
                        <input id="filenum" name="filenum"  value="${main.rjs12}" type="text" class="form-control" required="" aria-required="true">
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">部门代码：</label>
                    <div class="col-sm-8">
                        <input id="deptcode" name="deptcode"  value="${main.rjs4}" type="text" class="form-control" required="" aria-required="true">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">部门名称：</label>
                    <div class="col-sm-8">
                        <input id="deptname" name="deptname"  value="${main.rjs10}" type="text" class="form-control" required="" aria-required="true">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">实时日期：</label>
                    <div class="col-sm-8">
                        <input id="imptime" name="imptime"  value="${main.rjs6}" type="text" class="form-control" required="" aria-required="true">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">发布日期：</label>
                    <div class="col-sm-8">
                        <input id="releasetime" name="releasetime"  value="${main.rjs5}" type="text" class="form-control" required="" aria-required="true" >
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">附件：</label>
                    <div class="col-sm-8">
                       <%-- <input type="file" multiple="multiple">--%>


                           <div class="layui-upload">
                               <button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button>
                               <div class="layui-upload-list">
                                   <table class="layui-table">
                                       <thead>
                                       <tr><th>文件名</th>
                                           <th>大小</th>
                                           <th>状态</th>
                                           <th>操作</th>
                                       </tr></thead>
                                       <tbody id="demoList"></tbody>
                                       <c:forEach items="${attachmentList}" var="attachment" varStatus="xb">
                                           <tr>
                                               <td><input type="text" style="border: none;overflow: hidden;height: 100%;width: 100%;" value="${attachment.filename}"  onBlur="resetFileName('${attachment.filename}',this)"></td>
                                               <td>${attachment.size}</td>
                                               <td>${attachment.status}</td>
                                               <td>
                                                   <button type="button" class="layui-btn layui-btn-xs layui-btn-danger my-delete" onclick="myDelButten('${main.number}',this)">删除</button>
                                                   <button type="button" class="layui-btn layui-btn-xs layui-btn-danger my-download" onclick="myDownloadButten('${main.number}',this)">下载</button>
                                               </td>
                                           </tr>

                                       </c:forEach>
                                   </table>
                               </div>
                               <button type="button" class="layui-btn" id="testListAction">开始上传</button>
                           </div>

                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">正文：</label>
                    <div class="col-sm-8">
                        <textarea id="newscontent" name="newscontent" autoHeight="true" style="overflow: hidden;" class="form-control" required="" aria-required="true">${content}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 col-sm-offset-3">
                        <button class="btn btn-primary" type="submit" style="float: right;">保存</button>
                    </div>
                </div>
            </form>
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
<!-- 文件上传插件 -->
<script src="http://yanshi.sucaihuo.com/modals/40/4078/demo/js/plugins/prettyfile/bootstrap-prettyfile.js"></script>
<script>
    $('input[type="file"]').prettyFile();
</script>
<!-- layui -->
<script src="<%=basePath%>js/plugins/layui/layui.js" charset="utf-8"></script>

<script>
    $(function(){
        $.fn.autoHeight = function(){
            function autoHeight(elem){
                elem.style.height = 'auto';
                elem.scrollTop = 0; //防抖动
                elem.style.height = elem.scrollHeight + 'px';
            }
            this.each(function(){
                autoHeight(this);
                $(this).on('keyup', function(){
                    autoHeight(this);
                });
            });
        }
        $('textarea[autoHeight]').autoHeight();
    })
</script>
<!-- jQuery Validation plugin javascript-->
<script src="<%=basePath%>js/plugins/validate/jquery.validate.min.js"></script>
<script src="<%=basePath%>js/plugins/validate/messages_zh.min.js"></script>
<script>
    //以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
    $.validator.setDefaults({
        highlight: function (element) {
            $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
        },
        success: function (element) {
            element.closest('.form-group').removeClass('has-error').addClass('has-success');
        },
        errorElement: "span",
        errorClass: "help-block m-b-none",
        validClass: "help-block m-b-none"


    });

    //以下为官方示例
    $().ready(function () {
        // validate the comment form when it is submitted
        $("#commentForm").validate();

        // validate signup form on keyup and submit
        $("#signupForm").validate({
            rules: {
                firstname: "required",
                lastname: "required",
                username: {
                    required: true,
                    minlength: 2
                },
                password: {
                    required: true,
                    minlength: 5
                },
                confirm_password: {
                    required: true,
                    minlength: 5,
                    equalTo: "#password"
                },
                email: {
                    required: true,
                    email: true
                },
                topic: {
                    required: "#newsletter:checked",
                    minlength: 2
                },
                agree: "required"
            },
            messages: {
                firstname: "请输入你的姓",
                lastname: "请输入您的名字",
                username: {
                    required: "请输入您的用户名",
                    minlength: "用户名必须两个字符以上"
                },
                password: {
                    required: "请输入您的密码",
                    minlength: "密码必须5个字符以上"
                },
                confirm_password: {
                    required: "请再次输入密码",
                    minlength: "密码必须5个字符以上",
                    equalTo: "两次输入的密码不一致"
                },
                email: "请输入您的E-mail",
                agree: "必须同意协议后才能注册"
            }
        });

    });
</script>


<!-- layui -->
<script>
    layui.use('upload', function(){
        var $ = layui.jquery
            ,upload = layui.upload;


        //多文件列表示例
        var demoListView = $('#demoList')
            ,uploadListIns = upload.render({
            elem: '#testList'
            ,url: '<%=basePath%>manCheck/upload' //改成您自己的上传接口
            ,data: {'number':'${main.number}'}
            ,accept: 'file'
            ,multiple: true
            ,auto: false
            ,bindAction: '#testListAction'
            ,choose: function(obj){
                var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                //读取本地文件
                obj.preview(function(index, file, result){
                    var tr = $(['<tr id="upload-'+ index +'">'
                        ,'<td>'+ '<input type=\"text\" style=\"border: none;overflow: hidden;height: 100%;width: 100%;\" value=\"'+file.name+'\"  onBlur=\"resetFileName(\''+file.name+'\',this)\">' +'</td>'
                        ,'<td>'+ (file.size/1024).toFixed(1) +'kb</td>'
                        ,'<td>等待上传</td>'
                        ,'<td>'
                        ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                        ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                        ,'</td>'
                        ,'</tr>'].join(''));

                    //单个重传
                    tr.find('.demo-reload').on('click', function(){
                        obj.upload(index, file);
                    });

                    //删除
                    tr.find('.demo-delete').on('click', function(){
                        delete files[index]; //删除对应的文件
                        tr.remove();
                        uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                    });

                    demoListView.append(tr);
                });
            }
            ,done: function(res, index, upload){
                if(res){ //上传成功
                    var tr = demoListView.find('tr#upload-'+ index)
                        ,tds = tr.children();
                    tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                    tds.eq(3).html('<button class="layui-btn layui-btn-xs layui-btn-danger my-delete" onclick="myDelButten(\'${main.number}\',this)">删除</button> <button type="button" class="layui-btn layui-btn-xs layui-btn-danger my-download" onclick="myDownloadButten(\'${main.number}\',this)">下载</button>'); //如果还想删除则调用删除接口
                    return delete this.files[index]; //删除文件队列已经上传成功的文件
                }
                this.error(index, upload);
            }
            ,error: function(index, upload){
                var tr = demoListView.find('tr#upload-'+ index)
                    ,tds = tr.children();
                tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
                tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
            }
        });

    });


    //自定义  删除按钮操作
    function myDelButten(number,_this) {
        //调用ajax删除磁盘文件

        var filename = $(_this).parent().prev().prev().prev().find('input').val();
        $.ajax({
            url: "<%=basePath%>manCheck/delAttachment",
            data:{"filename":encodeURI(filename),"number":number},
            success: function(){
                //删除成功删除掉对应行
                var $trNode = $(_this).parent().parent();//对应的tr
                $trNode.remove();//删除
            }
        });


    }

</script>
<script type="text/javascript">
    function resetFileName(oldname,_this) {
        var filename  =  _this.value;
        var oldname  =  oldname;

        $.ajax({
                    url: "<%=basePath%>manCheck/resetFileName",
            data:{"filename":encodeURI(filename),"number":"${main.number}","oldname":encodeURI(oldname)},
            success: function(){

            }
        });
    }
</script>
<script type="text/javascript">
    //自定义  下载按钮操作
    function myDownloadButten(number,_this) {
        var filename = $(_this).parent().prev().prev().prev().find('input').val();
        filename = filename.replace(new RegExp("\\.","gm"),"-");
        window.location.href="<%=basePath%>manCheck/downLoadAttachment/"+number+"/"+filename;
    }
</script>
</body>

</html>

