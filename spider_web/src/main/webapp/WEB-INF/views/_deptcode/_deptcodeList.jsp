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


    <title>部门代码维护</title>
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
    <link href="http://yanshi.sucaihuo.com/modals/40/4078/demo/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <!-- layui -->
    <link href="<%=basePath%>js/plugins/layui/css/layui.css" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="row wrapper border-bottom white-bg page-heading">

    <div class="col-lg-10">
        <h2>部门代码维护</h2>
    </div>
    <div class="col-lg-2">
        <div class="text-center" style="padding-top: 30px">
            <a data-toggle="modal" class="btn btn-primary" href="form_basic.html#modal-form" onclick="test001()">添加</a>
        </div>
        <div id="modal-form" class="modal fade" aria-hidden="true">
            <div class="modal-dialog" style="width: 60%">
                <div class="modal-content">
                    <div class="modal-body" style="height: 200px;">
                        <div class="row">

                            <form class="layui-form">
                                <div class="layui-form-item" style="margin-top: 50px">
                                    <label class="layui-form-label"></label>
                                    <div class="layui-input-inline">
                                        <select id="select1" name="modules1"  lay-search="">
                                            <option value="">-省-</option>

                                        </select>
                                    </div>
                                    <div class="layui-input-inline">
                                        <select id="select2" name="newDeptcode"  lay-search="">
                                            <option value="">-市-</option>
                                        </select>
                                    </div>
                                    <div class="layui-input-inline">
                                        <input type="text" id="newDeptName" name="newDeptName" class="layui-input" placeholder="部门全称" lay-verify="required">
                                    </div>
                                    <div class="layui-input-inline">
                                        <input type="text" id="alisName" name="alisName" class="layui-input" placeholder="部门简称" lay-verify="required">
                                    </div>

                                </div>
                                <div style="text-align: center;">
                                    <button lay-submit style="margin-left: 50px;" class="layui-btn">立即提交</button>
                                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                </div>
                            </form>

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
                    <input id="searchtest" type="search" class="form-control input-sm" style="width: 10%;float: right" placeholder="查询：xx市 xx xx" oninput="searchData(this)">

                    <table class="table table-bordered dataTables-example" id="dataTables-example"><!-- 无分页查询功能：table table-bordered -->
                        <thead>
                        <tr>

                            <th>部门代码</th>
                            <th>部门名称</th>
                            <th>部门简称</th>
                            <th>操作</th>


                        </tr>
                        </thead>

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

        $('.dataTables-example').DataTable({//绑定要遍历数据的 table 的 id

            pageLength : 25,/* 页大小，同时当前页每次加 10，不明白为什么每次增加 10 */

            serverSide : true,/* 启用服务端分页，如果前端分页，这里为 false */
            searching : false,
            ajax : {
                url : "<%=basePath%>deptcodeList",
                type : "post",
                data : {},
                dataFilter : function(json){
                    return json;
                }
            },

            /* 中间遍历的数据 */
            columns : [
                {data:"depNumber",render:function(data){return ("<input type='text' style=\"border: none;width: 100%;\" value='"+data+"'>");}},//0 这里可以 {title:"Id编码",data:"id"} //title 列头标题，则可以省略前面 html 代码里面 <table></table> 内的 <tr></tr> 标签！
                {data:"depName",render:function(data){return ("<input type='text' style=\"border: none;width: 100%;\" value='"+data+"'>");}},//1 这里的 header_title 对应后台返回的 bean 的属性值即可自动赋值显示
                {data:"alisName",render:function(data){return ("<input type='text' style=\"border: none;width: 100%;\" value='"+data+"'>");}},
                {defaultContent:"<button type=\"button\" class=\"btn btn-warning btn-sm\" onclick=\"updateConfirm(this)\">修改</button>&nbsp;&nbsp;<button type=\"button\" class=\"btn btn-warning btn-sm\" onclick=\"deleteConfirm(this)\">删除</button>"}
            ]
        });

    });

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

    function deleteConfirm(_this)
    {
        var number = $(_this).parent().prev().prev().prev().find('input').val();
        $.ajax('<%=basePath%>deptcode/delete', {
            dataType : 'json',
            data: {
                ids:number
            },
            success: function(data)
            {
                if (data==true)
                {
                    alert('删除成功!');
                    window.location.reload();

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
    function updateConfirm(_this)
    {
        var name1 = $(_this).parent().prev().prev().find('input').val();
        var name2 = $(_this).parent().prev().find('input').val();
        var number = $(_this).parent().prev().prev().prev().find('input').val();
        $.ajax('<%=basePath%>deptcode/update', {
            dataType : 'json',
            data: {
                name1:name1,
                name2:name2,
                number:number

            },
            success: function(data)
            {
                if (data==true)
                {
                    alert('修改成功!');
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
                    alert('修改失败，数据重复!');
                }
            },
            error: function()
            {
                alert('修改发生错误，请联系管理员!');
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

</script>
<!-- 隐藏url列 -->
<style>
    .hide_column{
        display: none;
    }
</style>
<script src="<%=basePath%>js/plugins/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form;

        form.on('select()', function(data){
            if (data.elem.id == 'select1'){
                var code = data.value;
                $.ajax({
                    url: "<%=basePath%>deptcode/deptTwoLevel",
                    data: {
                        "deptcode":code
                    },
                    success: function(data){

                        //区
                        var deptOneLevel = data.deptOneLevel;
                        $("#select2").empty();
                        $("#select2").append(new Option('-区-',code+'00'));
                        jQuery.each(deptOneLevel, function(i,item){
                            var option = new Option(item.depName, item.depNumber);
                            $("#select2").append(option);

                        });

                        layui.form.render("select");
                    }
                });
            }
        });

        form.on('submit()', function(data){

            $.ajax({
                url: '<%=basePath%>deptcode/insert',
                data: {
                    newDeptcode:data.field.newDeptcode,
                    newDeptName:data.field.newDeptName,
                    alisName:data.field.alisName
                },
                async:false,
                success: function(data){
                    if (data==true)
                    {
                        alert('添加成功!');
                        window.location.reload();

                    }
                    else
                    {
                        alert('添加失败，添加重复!');
                    }
                }
            });
            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。

        });
    });

    function test001() {
        $.ajax({
            url: "<%=basePath%>deptcode/deptOneLevel",
            success: function(data){

                jQuery.each(data, function(i,item){
                    var option = new Option(item.depName, item.depNumber);
                    $("#select1").append(option);

                });
                layui.form.render("select");
                /*            $("#select1").append("<option value='"+value+"'>"+text+"</option>");


                            console.log($("#select1")[1]);*/
            }
        });
    }
</script>

<script>
    function searchData(_this) {
        //try
        $('#dataTables-example').dataTable().fnDestroy();

        var keyword = $('#searchtest').val();
        keyword = keyword.replaceAll("\'","");
        console.log(keyword);

        $('.dataTables-example').DataTable({//绑定要遍历数据的 table 的 id

            pageLength : 25,/* 页大小，同时当前页每次加 10，不明白为什么每次增加 10 */

            serverSide : true,/* 启用服务端分页，如果前端分页，这里为 false */
            searching : false,
            ajax : {
                url : "<%=basePath%>deptcodeList",
                type : "post",
                data : {"keyword":keyword},
                dataFilter : function(json){
                    return json;
                }
            },

            /* 中间遍历的数据 */
            columns : [
                {data:"depNumber",render:function(data){return ("<input type='text' style=\"border: none;width: 100%;\" value='"+data+"'>");}},//0 这里可以 {title:"Id编码",data:"id"} //title 列头标题，则可以省略前面 html 代码里面 <table></table> 内的 <tr></tr> 标签！
                {data:"depName",render:function(data){return ("<input type='text' style=\"border: none;width: 100%;\" value='"+data+"'>");}},//1 这里的 header_title 对应后台返回的 bean 的属性值即可自动赋值显示
                {data:"alisName",render:function(data){return ("<input type='text' style=\"border: none;width: 100%;\" value='"+data+"'>");}},
                {defaultContent:"<button type=\"button\" class=\"btn btn-warning btn-sm\" onclick=\"updateConfirm(this)\">修改</button>&nbsp;&nbsp;<button type=\"button\" class=\"btn btn-warning btn-sm\" onclick=\"deleteConfirm(this)\">删除</button>"}
            ]
        });

    }
</script>
</html>
