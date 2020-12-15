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


    <title>人工审核-标记新闻详情</title>
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
    <link href="<%=basePath%>css/plugins/iCheck/custom.css" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">

        <h2>标记新闻详情</h2>
        <ol class="breadcrumb">
            <li>
                <a>临时库列表（已标记/中央）</a>
            </li>
            <li>
                <strong>标记新闻详情</strong>
            </li>
        </ol>
    </div>
    <div class="col-lg-2">
             <span style="float: right;margin-top: 30px;">

                    <a onclick="virtualDelete('${mainMark.number}')" class="btn btn-primary">逻辑删除</a>
                    <a onclick="deleteAll('${mainMark.number}')" class="btn btn-primary">物理删除</a>
                    <a href="${mainMark.linksource}" target="_blank" class="btn btn-primary">来源</a>
            </span>
    </div>

</div>
<div class="wrapper wrapper-content">
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
                    <form class="form-horizontal m-t" id="commentForm" action="<%=basePath%>manCheck/markUpdate" method="post">
                        <input id="extend2" name="extend2" value="${mainMark.number}" type="hidden">
                        <input id="filename" name="filename" value="${mainMark.rjs8}" type="hidden">
                        <input id="extend3" name="extend3" value="${mainMark.appuser}" type="hidden">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">标题：</label>
                            <div class="col-sm-8">

                                <input  oninput="myChange(this)" id="newstitle" name="newstitle" value="${mainMark.rjs0}" type="text" class="form-control" required="" aria-required="true">

                            </div>
                            <div class="checkbox i-checks" style="float: right;margin-right: 60px;">
                                <c:if test="${mainMark.markTitle > 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_title" checked=""> </label>
                                </c:if>
                                <c:if test="${mainMark.markTitle == 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_title" > </label>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">文号：</label>
                            <div class="col-sm-8">

                                <input oninput="myChange(this)" id="filenum" name="filenum"  value="${mainMark.rjs12}" type="text" class="form-control" required="" aria-required="true">

                            </div>
                            <div class="checkbox i-checks" style="float: right;margin-right: 60px;">

                                <c:if test="${mainMark.markFilenum > 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_filenum" checked=""> </label>
                                </c:if>
                                <c:if test="${mainMark.markFilenum == 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_filenum"> </label>
                                </c:if>

                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">部门代码：</label>
                            <div class="col-sm-8">

                                <input oninput="myChange(this)" id="deptcode" name="deptcode"  value="${mainMark.rjs4}" type="text" class="form-control" required="" aria-required="true">
                            </div>
                            <div class="checkbox i-checks" style="float: right;margin-right: 60px;">

                                <c:if test="${mainMark.markDeptcode > 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_deptcode" checked=""> </label>
                                </c:if>
                                <c:if test="${mainMark.markDeptcode == 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_deptcode"> </label>
                                </c:if>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">部门名称：</label>
                            <div class="col-sm-8">

                                <input oninput="myChange(this)" id="deptname" name="deptname"  value="${mainMark.rjs10}" type="text" class="form-control" required="" aria-required="true">
                            </div>
                            <div class="checkbox i-checks" style="float: right;margin-right: 60px;">

                                <c:if test="${mainMark.markDeptname > 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_deptname" checked=""> </label>
                                </c:if>
                                <c:if test="${mainMark.markDeptname == 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_deptname"> </label>
                                </c:if>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">实时日期：</label>
                            <div class="col-sm-8">

                                <input oninput="myChange(this)" id="imptime" name="imptime"  value="${mainMark.rjs6}" type="text" class="form-control" required="" aria-required="true">
                            </div>
                            <div class="checkbox i-checks" style="float: right;margin-right: 60px;">

                                <c:if test="${mainMark.markRelease > 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_release" checked=""> </label>
                                </c:if>
                                <c:if test="${mainMark.markRelease == 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_release"> </label>
                                </c:if>

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">发布日期：</label>
                            <div class="col-sm-8">

                                <input oninput="myChange(this)" id="releasetime" name="releasetime"  value="${mainMark.rjs5}" type="text" class="form-control" required="" aria-required="true" >
                            </div>
                            <div class="checkbox i-checks" style="float: right;margin-right: 60px;">

                                <c:if test="${mainMark.markImp > 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_imp" checked=""> </label>
                                </c:if>
                                <c:if test="${mainMark.markImp == 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_imp"> </label>
                                </c:if>

                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">所属分类：</label>
                            <div class="col-sm-8">

                                <input oninput="myChange(this)" id="kind" name="kind"  value="${mainMark.rjs1}" type="text" class="form-control" required="" aria-required="true" >
                            </div>
                            <div class="checkbox i-checks" style="float: right;margin-right: 60px;">
                                <c:if test="${mainMark.markKind > 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_kind" checked=""> </label>
                                </c:if>
                                <c:if test="${mainMark.markKind == 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_kind"> </label>
                                </c:if>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">关键字：</label>
                            <div class="col-sm-8">

                                <input oninput="myChange(this)" id="keyword" name="keyword"  value="${mainMark.kword}" type="text" class="form-control" required="" aria-required="true" >
                            </div>
                            <div class="checkbox i-checks" style="float: right;margin-right: 60px;">
                                <c:if test="${mainMark.markKeyword > 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_keyword" checked=""> </label>
                                </c:if>
                                <c:if test="${mainMark.markKeyword == 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_keyword"> </label>
                                </c:if>
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
                                                        <button type="button" class="layui-btn layui-btn-xs layui-btn-danger my-delete" onclick="myDelButten('${mainMark.number}',this)">删除</button>
                                                        <button type="button" class="layui-btn layui-btn-xs layui-btn-danger my-download" onclick="myDownloadButten('${mainMark.number}',this)">下载</button>
                                                    </td>
                                                </tr>

                                            </c:forEach>
                                        </table>
                                    </div>
                                    <button type="button" class="layui-btn" id="testListAction">开始上传</button>
                                </div>

                            </div>
                            <div class="checkbox i-checks" style="float: right;margin-right: 60px;">

                                <c:if test="${mainMark.markAttachment > 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_attachment" checked=""> </label>
                                </c:if>
                                <c:if test="${mainMark.markAttachment == 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_attachment"> </label>
                                </c:if>

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label"></label>
                            <div class="col-sm-8">
                                <div class="checkbox i-checks">


                                    <c:if test="${mainMark.markContentTitle > 0}">
                                        <label style="margin-left: -20px;"><input type="checkbox" name="mycheckbox" value="mark_content_title" checked="">正文标题</label>
                                    </c:if>
                                    <c:if test="${mainMark.markContentTitle == 0}">
                                        <label style="margin-left: -20px;"><input type="checkbox" name="mycheckbox" value="mark_content_title">正文标题</label>
                                    </c:if>


                                    <c:if test="${mainMark.markContentFilenum > 0}">
                                        <label style="margin-left: 10px;"><input type="checkbox" name="mycheckbox" value="mark_content_filenum" checked="">正文文号</label>
                                    </c:if>
                                    <c:if test="${mainMark.markContentFilenum == 0}">
                                        <label style="margin-left: 10px;"><input type="checkbox" name="mycheckbox" value="mark_content_filenum">正文文号</label>
                                    </c:if>

                                    <c:if test="${mainMark.markContentContent > 0}">
                                        <label style="margin-left: 10px;"><input type="checkbox" name="mycheckbox" value="mark_content_content" checked="">正文</label>
                                    </c:if>
                                    <c:if test="${mainMark.markContentContent == 0}">
                                        <label style="margin-left: 10px;"><input type="checkbox" name="mycheckbox" value="mark_content_content">正文</label>
                                    </c:if>

                                    <c:if test="${mainMark.markContentLk > 0}">
                                        <label style="margin-left: 10px;"><input type="checkbox" name="mycheckbox" value="mark_content_lk" checked="">正文落款</label>
                                    </c:if>
                                    <c:if test="${mainMark.markContentLk == 0}">
                                        <label style="margin-left: 10px;"><input type="checkbox" name="mycheckbox" value="mark_content_lk">正文落款</label>
                                    </c:if>

                                    <c:if test="${mainMark.markContentAttachment > 0}">
                                        <label style="margin-left: 10px;"><input type="checkbox" name="mycheckbox" value="mark_content_attachment" checked="">附件</label>
                                    </c:if>
                                    <c:if test="${mainMark.markContentAttachment == 0}">
                                        <label style="margin-left: 10px;"><input type="checkbox" name="mycheckbox" value="mark_content_attachment">附件</label>
                                    </c:if>



                                    <c:if test="${mainMark.markOther > 0}">
                                        <label style="margin-left: 10px;"><input type="checkbox" name="mycheckbox" value="mark_other" checked="">其他</label>
                                    </c:if>
                                    <c:if test="${mainMark.markOther == 0}">
                                        <label style="margin-left: 10px;"><input type="checkbox" name="mycheckbox" value="mark_other">其他</label>
                                    </c:if>
                                </div>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">正文：</label>
                            <div class="col-sm-8">

                                <textarea  oninput="myChange(this)" id="newscontent"   name="newscontent"  style="height: 1000px" class="form-control" required="" aria-required="true">${contentHistory}</textarea>
                            </div>
                            <div class="checkbox i-checks" style="float: right;margin-right: 60px;">

                                <c:if test="${mainMark.markContent > 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_content" checked=""> </label>
                                </c:if>
                                <c:if test="${mainMark.markContent == 0}">
                                    <label><input type="checkbox" name="mycheckbox" value="mark_content"> </label>
                                </c:if>
                            </div>
                        </div>
                        <%--                            <div class="form-group">
                                                        <div class="col-sm-4 col-sm-offset-3">
                                                            <button class="btn btn-primary" type="submit" style="float: right;">保存</button>
                                                        </div>

                                                    </div>--%>
                    </form>
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



<!-- 文件上传插件 -->
<script src="http://yanshi.sucaihuo.com/modals/40/4078/demo/js/plugins/prettyfile/bootstrap-prettyfile.js"></script>
<!-- 文本对比插件 -->
<script src="http://yanshi.sucaihuo.com/modals/40/4078/demo/js/plugins/diff_match_patch/diff_match_patch.js"></script>
<script src="<%=basePath%>js/jquery.pretty-text-diff.min.js"></script>




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
            ,data: {'number':'${mainMark.number}'}
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
                    tds.eq(3).html('<button class="layui-btn layui-btn-xs layui-btn-danger my-delete" onclick="myDelButten(\'${mainMark.number}\',this)">删除</button> <button type="button" class="layui-btn layui-btn-xs layui-btn-danger my-download" onclick="myDownloadButten(\'${mainMark.number}\',this)">下载</button>'); //如果还想删除则调用删除接口
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
        console.log(number)
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
        var num = $('#extend2').val();
        console.log("num="+num);
        console.log("filename="+filename);
        console.log("oldname="+oldname);
        $.ajax({
            async:false,
            url: "<%=basePath%>manCheck/resetFileName",
            data:{"filename":encodeURI(filename),"number":num,"oldname":encodeURI(oldname)},
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
<script type="text/javascript">

    //逻辑删除，删除后不可入库不可显示
    function virtualDelete(number) {
        $.ajax({
            url: "<%=basePath%>manCheck/virtualDelete",
            data:{"number":number},
            success: function(){
                alert("删除成功！")
                window.location.href="<%=path%>/manCheck/randomTwentyFive?informationIds=";
            }
        });
    }

    //物理删除
    function deleteAll(number) {

        $.ajax({
            data:{ids:number},
            url: "<%=basePath%>manCheck/delete",
            success: function(data){
                alert(data);
                window.location.href="<%=path%>/manCheck/randomTwentyFive?informationIds=";
            }});

    }
</script>

<!-- iCheck -->
<script src="<%=basePath%>js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>

<script>
    debugger;
    function myChange(_this) {
        var str = $(_this).val();
        $(_this).prev().prev().prev().val(str);

        var str_class = $(_this).prev("div").attr('class');


        $(".col-sm-8").prettyTextDiff({
            originalContent: $(_this).prev().prev().val(),
            changedContent: $(_this).prev().prev().prev().val(),
            diffContainer: '.'+str_class
        });
    }

</script>

</html>
