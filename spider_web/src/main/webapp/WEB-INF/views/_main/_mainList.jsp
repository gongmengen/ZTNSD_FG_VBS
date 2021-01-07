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
<STYLE>

    .label1{
        padding: 2px 5px;
        background: #52b0a1;
        border-radius: 2px;
        color: #fff;
        display: block;
        line-height: 26px;
        height: 30px;
        margin: 2px 5px 2px 0;
        float: left;
        font-size: 18px;

    }
    .label1:hover{color: #bababa;}
    .label1 i{
        color: white;
        border-radius: 2px;
        margin-top: 4px;
        margin-left: 10px;
    }
</STYLE>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>二次校验查询 - 正式库数据列表</title>
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
    <link href="<%=basePath%>js/plugins/layui/css/layui.css" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>二次校验查询</h2>
    </div>
    <div class="col-lg-2">
             <span style="float: right;margin-top: 30px;">
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal1">
        随机抽查
    </button>
    <div class="modal inmodal fade" id="myModal1" tabindex="-1" role="dialog"  aria-hidden="true">
                        <div class="modal-dialog modal-lg">

                            <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title">随机抽查</h4>
                            </div>
<form class="layui-form" action="<%=basePath%>main/search" method="post" target="_self">
                                <div class="modal-body">
                                    <div class="layui-form-item">
                                    <label class="layui-form-label" style="width: 100px">入库日期：</label>
                                        <div class="layui-input-block"  style="width: 50%;display: block;float: left;margin-left: 0px;">

                                                <input style="width: 75%;display: inline-block;" type="text" name="appdate" required placeholder="请输入入库时间" class="layui-input" id="test3" value="${params.get('appdate')}">

                                        </div>
                                    </div>

                                    <div id="slideTest2" class="demo-slider"></div>
                                    <input type="hidden" id="slide" name="slide" value="20">
                                </div>

                                <div class="modal-footer" style="text-align: center;">
                                      <button class="layui-btn" lay-submit lay-filter="form">查询</button>

                                </div>
</form>
                            </div>
                        </div>


</div>


    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal5">
        自定义查询
    </button>
    <div class="modal inmodal fade" id="myModal5" tabindex="-1" role="dialog"  aria-hidden="true">
                        <div class="modal-dialog modal-lg">

                            <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title">自定义查询</h4>
                            </div>
<form class="layui-form" action="<%=basePath%>main/search" method="post" target="_self">
                                <div class="modal-body">
                                    <div class="layui-form-item">
                                    <label class="layui-form-label" style="width: 100px">常规检索：</label>
                                    <div class="layui-input-block"  style="width: 20%;display: block;float: left;margin-left: 0px;">
                                    <select>
                                    <option value=""></option>
                                    <option value="title">标题</option>
                                    <option value="releaseDate">发布日期</option>
                                    <option value="dept">部门</option>
                                    <option value="fileNum">文号</option>
                                    <option value="fileName">文件名</option>
                                    <option value="appdate">入库时间</option>
                                    </select>
                                    </div>

                                    <div id="title" name="selectBar" class="layui-input-block"  style="width: 60%;display: none;float: left;margin-left: 20px;">
                                        <input style="width: 75%;display: inline-block;" type="text" name="title"  placeholder="请输入标题" autocomplete="off" class="layui-input" value="${params.get('title')}"><button type="button" class="layui-btn" style="margin-left: 20px;" onclick="addCondition(this)"><i class="layui-icon">&#xe608;</i> 添加</button>
                                    </div>

                                    <div id="releaseDate" name="selectBar" class="layui-input-block"  style="width: 60%;display: none;float: left;margin-left: 20px;">
                                        <input style="width: 75%;display: inline-block;" type="text" name="releaseDate" placeholder="请输入发布日期" class="layui-input" id="test1" value="${params.get('releaseDate')}"><button type="button" class="layui-btn" style="margin-left: 20px;" onclick="addCondition(this)"><i class="layui-icon">&#xe608;</i> 添加</button>
                                    </div>

                                    <div id="dept" name="selectBar" class="layui-input-block"  style="width: 60%;display: none;float: left;margin-left: 20px;">
                                        <input style="width: 75%;display: inline-block;" type="text" name="dept"  placeholder="请输入部门" autocomplete="off" class="layui-input" value="${params.get('dept')}"><button type="button" class="layui-btn" style="margin-left: 20px;" onclick="addCondition(this)"><i class="layui-icon">&#xe608;</i> 添加</button>
                                    </div>

                                    <div id="fileNum" name="selectBar" class="layui-input-block"  style="width: 60%;display: none;float: left;margin-left: 20px;">
                                        <input style="width: 75%;display: inline-block;" type="text" name="fileNum"  placeholder="请输入文号" autocomplete="off" class="layui-input" value="${params.get('fileNum')}"><button type="button" class="layui-btn" style="margin-left: 20px;" onclick="addCondition(this)"><i class="layui-icon">&#xe608;</i> 添加</button>
                                    </div>

                                    <div id="fileName" name="selectBar" class="layui-input-block"  style="width: 60%;display: none;float: left;margin-left: 20px;">
                                        <input style="width: 75%;display: inline-block;" type="text" name="fileName"  placeholder="请输入文件名" autocomplete="off" class="layui-input" value="${params.get('fileName')}"><button type="button" class="layui-btn" style="margin-left: 20px;" onclick="addCondition(this)"><i class="layui-icon">&#xe608;</i> 添加</button>
                                    </div>

                                    <div id="appdate" name="selectBar" class="layui-input-block"  style="width: 60%;display: none;float: left;margin-left: 20px;">
                                        <input style="width: 75%;display: inline-block;" type="text" name="appdate" placeholder="请输入入库时间" class="layui-input" id="test2" value="${params.get('appdate')}"><button type="button" class="layui-btn" style="margin-left: 20px;" onclick="addCondition(this)"><i class="layui-icon">&#xe608;</i> 添加</button>
                                    </div>


                                    </div>
                                    <div class="layui-form-item">
                                    <label class="layui-form-label" style="width: 100px">问题检索：</label>
                                    <div class="layui-input-block" style="margin-left: 100px;">

                                        <c:if test="${params.get('noDeptCode') == null}"><input type="checkbox" name="noDeptCode" title="无部门代码"></c:if>
                                        <c:if test="${params.get('noDeptCode') != null}"><input type="checkbox" name="noDeptCode" title="无部门代码" checked></c:if>

                                        <c:if test="${params.get('noDeptName') == null}"><input type="checkbox" name="noDeptName" title="无部门名称"></c:if>
                                        <c:if test="${params.get('noDeptName') != null}"><input type="checkbox" name="noDeptName" title="无部门名称" checked></c:if>

                                        <c:if test="${params.get('noReleaseDate') == null}"><input type="checkbox" name="noReleaseDate" title="无发布日期"></c:if>
                                        <c:if test="${params.get('noReleaseDate') != null}"><input type="checkbox" name="noReleaseDate" title="无发布日期" checked></c:if>

                                        <c:if test="${params.get('noImpDate') == null}"><input type="checkbox" name="noImpDate" title="无实施日期"></c:if>
                                        <c:if test="${params.get('noImpDate') != null}"><input type="checkbox" name="noImpDate" title="无实施日期" checked></c:if>

<%--                                        <c:if test="${params.get('noContent') == null}"><input type="checkbox" name="noContent" title="正文缺失"></c:if>
                                        <c:if test="${params.get('noContent') != null}"><input type="checkbox" name="noContent" title="正文缺失" checked></c:if>

                                        <c:if test="${params.get('noFile') == null}"><input type="checkbox" name="noFile" title="附件缺失"></c:if>
                                        <c:if test="${params.get('noFile') != null}"><input type="checkbox" name="noFile" title="附件缺失" checked></c:if>

                                        <c:if test="${params.get('noFileNum') == null}"><input type="checkbox" name="noFileNum" title="文号不完整"></c:if>
                                        <c:if test="${params.get('noFileNum') != null}"><input type="checkbox" name="noFileNum" title="文号不完整" checked></c:if>--%>


                                    </div>
                                    </div>

                                    <div class="layui-form-item" style="display: none">
                                    <label class="layui-form-label" style="width: 100px">已选择：</label>
                                    <div class="AD">
                                        <c:if test="${params.get('title') != null && params.get('title') != ''}">
                                            <a href="javascript:;" class="label1" target="_self"><span lay-value="64">标题:${params.get('title')}</span><i class="layui-icon close">x</i></a>
                                        </c:if>
                                        <c:if test="${params.get('releaseDate') != null && params.get('releaseDate') != ''}">
                                            <a href="javascript:;" class="label1" target="_self"><span lay-value="64">发布日期:${params.get('releaseDate')}</span><i class="layui-icon close">x</i></a>
                                        </c:if>


                                        <c:if test="${params.get('dept') != null && params.get('dept') != ''}">
                                            <a href="javascript:;" class="label1" target="_self"><span lay-value="64">部门:${params.get('dept')}</span><i class="layui-icon close">x</i></a>
                                        </c:if>
                                        <c:if test="${params.get('fileNum') != null && params.get('fileNum') != ''}">
                                            <a href="javascript:;" class="label1" target="_self"><span lay-value="64">文号:${params.get('fileNum')}</span><i class="layui-icon close">x</i></a>
                                        </c:if>
                                        <c:if test="${params.get('fileName') != null && params.get('fileName') != ''}">
                                            <a href="javascript:;" class="label1" target="_self"><span lay-value="64">文件名:${params.get('fileName')}</span><i class="layui-icon close">x</i></a>
                                        </c:if>
                                        <c:if test="${params.get('appdate') != null && params.get('appdate') != ''}">
                                            <a href="javascript:;" class="label1" target="_self"><span lay-value="64">入库时间:${params.get('appdate')}</span><i class="layui-icon close">x</i></a>
                                        </c:if>

                                    </div>
                                    </div>

                                </div>

                                <div class="modal-footer" style="text-align: center;">
                                      <button class="layui-btn" lay-submit lay-filter="formDemo">查询</button>
                                      <button type="reset" class="layui-btn layui-btn-primary">重置</button>

                                </div>
</form>
                            </div>
                        </div>


</div>
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


                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${mainList}" var="main" varStatus="xb">
                            <tr class="gradeX">
                                <td class="hide_column">${main.linksource}</td>
                                <td class="center">
                                    <input type="checkbox" name="mycheckbox" value="${main.rid}">
                                </td>
                                <td class="center">
                                    <a onclick="openDetail('${main.rid}')">${main.rjs0}</a>
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
<!-- layui -->
<script src="<%=basePath%>js/plugins/layui/layui.js" charset="utf-8"></script>


<!-- Page-Level Scripts -->
<script>
    $(document).ready(function () {
        //查询条件初始化
        if($(".AD").children('a').length>0){
            $(".AD").parent().show();
        }

        //DataTable 插件初始化
        $('.dataTables-example').dataTable();



    });

</script>

<script>


    function openSource(source) {
        window.open(source,'_blank');
    }

    function openDetail(data) {

        window.location.href="<%=path%>/main/detail/"+data;
    }

</script>
<!-- 隐藏url列 -->
<style>
    .hide_column{
        display: none;
    }
</style>

<!-- layui -->
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){

            $(".AD").children('a').each(function(){

                var field = $(this).text().split(':');
                var kind = '';
                switch (field[0]){
                    case "标题":
                        kind = "title"
                        break;
                    case "发布日期":
                        kind = "releaseDate"
                        break;
                    case "部门":
                        kind = "dept"
                        break;
                    case "文号":
                        kind = "fileNum"
                        break;
                    case "文件名":
                        kind = "fileName"
                        break;
                    case "入库时间":
                        kind = "appdate"
                        break;
                }

                $("input[name="+kind+"]")[0].value = field[1].substring(0,field[1].length-1)


            });

        });

        //监听select
        form.on('select()', function(data){

            $("div[name = 'selectBar']").each(function(){
                console.log($(this).attr('id'))
                if ($(this).attr('id') == data.value){
                    $(this).show();
                }else {
                    $(this).hide();
                }
            });
        });
    });

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#test1' //指定元素
            ,range: true
        });
    });

    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#test2' //指定元素
            ,range: true
        });
    });


    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#test3' //指定元素
            ,range: true
        });
    });

    //滑块
    layui.use('slider', function(){
        var $ = layui.$
            ,slider = layui.slider;

        //定义初始值
        slider.render({
            elem: '#slideTest2'
            ,value: ${params.get('slide')==null?20:params.get('slide')} //初始值
            ,setTips: function(value){ //自定义提示文本
                return value + '%';
            }
            ,change: function(value){
                console.log(value) //动态获取滑块数值
                $('#slide').val(value.replace('%',''))
            }
        });

    });
    function addCondition(_this) {
        console.log($(_this).prev().val());
        var kind = "";
        switch ($(_this).parent().attr("id")){
            case "title":
                kind = "标题"
                break;
            case "releaseDate":
                kind = "发布日期"
                break;
            case "dept":
                kind = "部门"
                break;
            case "fileNum":
                kind = "文号"
                break;
            case "fileName":
                kind = "文件名"
                break;
            case "appdate":
                kind = "入库时间"
                break;
        }


            $(".AD").append('<a href="javascript:;" class="label1" target="_self"><span lay-value="64">' + kind + ':' + $(_this).prev().val() + '</span><i class="layui-icon close">x</i></a>')
            $(".AD").parent().show();



    }

    $(".AD").on("click", ".close", function () {
        if($(this).parent().parent().children('a').length==1){
            $(this).parent().parent().parent().hide();
        }
        $(this).parent().remove();
    })

</script>

</html>
