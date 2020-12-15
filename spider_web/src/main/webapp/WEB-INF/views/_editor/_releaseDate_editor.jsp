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


    <title>适配网站 - 发布日期脚本</title>
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
    <link href="<%=basePath%>css/plugins/codemirror/codemirror.css" rel="stylesheet">
    <link href="<%=basePath%>css/plugins/codemirror/ambiance.css" rel="stylesheet">
    <link href="<%=basePath%>css/style.css?v=2.2.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="row wrapper border-bottom white-bg page-heading">

    <div class="col-lg-7">
        <h2>发布日期脚本</h2>
        <ol class="breadcrumb">
            <li>
                <a>网站列表</a>
            </li>
            <li>
                <a>添加脚本</a>
            </li>
            <li>
                <strong>发布日期脚本</strong>
            </li>
        </ol>
    </div>
    <div class="col-lg-5">


        <button type="button" class="btn btn-primary btn-sm" onclick="loadSession()">加载已收藏</button>
        <button type="button" class="btn btn-primary btn-sm" onclick="saveToSession()">收藏到session</button>
        <button type="button" class="btn btn-primary btn-sm" onclick="reg()">点击验证</button>
        <button type="button" class="btn btn-primary btn-sm" onclick="lastPage(2)">上一步</button>
        <button type="button" class="btn btn-primary btn-sm" onclick="nextPage(4)">下一步</button>

        <div class="btn-group">
            <button data-toggle="dropdown" class="btn btn-warning dropdown-toggle">脚本列表 <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="<%=basePath%>nextPage/1/${information.id}" target="_self">标题</a>
                </li>
                <li><a href="<%=basePath%>nextPage/2/${information.id}" target="_self">正文</a>
                </li>
                <li><a href="<%=basePath%>nextPage/3/${information.id}" target="_self">发布日期</a>
                </li>
                <li><a href="<%=basePath%>nextPage/4/${information.id}" target="_self">文号</a>
                </li>
                <li><a href="<%=basePath%>nextPage/6/${information.id}" target="_self">附件</a>
                </li>
                <li><a href="<%=basePath%>regsinglenews/${information.id}" target="_self">新闻适配结果预览</a>
                </li>
                <li><a href="<%=basePath%>regten/${information.websiteid}/${information.id}" target="_self">网站适配结果预览</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-lg-6">
            <form id="myform" action="<%=basePath%>regsinglecode" method="post">
                <input type="hidden" id="informationid" name="informationid" value="${information.id}">
                <input type="hidden" id="codetype" name="codetype" value="3">

                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>脚本代码&nbsp;&nbsp;&nbsp;&nbsp;</h5>
                        ${result}
                    </div>
                    <div class="ibox-content">
                        <div class="textarea">
                            <c:choose>
                                <c:when test="${adapter.releasedate == null||adapter.releasedate.equals('')}">
                                    <%--<textarea id="code1" name="title" >
                                        //v1.25 lawstar getAppdate branch  2019-10-18  by yjs
//入口函数,全部使用小写字母
function entry(str) {
    str =getAppdate_sfb(str)
    return str;
}
function getAppdate(str) {
    start_token = "发布日期：</li>";
    end_token = "</li>";
    idx = str.indexOf(start_token)
    idx_2 = str.indexOf(end_token, idx+start_token.length)
    var dateStr="";
    if(idx>-1 && idx_2>-1 ){
        dateStr = str.substring(idx + start_token.length, idx_2)
        dateStr = replaceAllHtlm(dateStr);
        dateStr = formatDateStr(dateStr);
    }


    return dateStr.trim();
}
//发布日期 商务部
function getAppdate_sfb(str) {
    start_token = "<p ";
    start_token_atrrib=" align=\"right\"";
    end_token = "</p>";
    str = str.toLowerCase();
    idx = str.lastIndexOf_lawstar(start_token,start_token_atrrib)
    idx_2 = str.indexOf(end_token, idx);
    str = str.substring(idx, idx_2)
    //console.log("sss"+str)
    str = replaceAllHtlm(str);
    var datestr ="";
    if(str.indexOf("年")>-1 && str.indexOf("月")>-1 && str.indexOf("日")>-1  ){
        var dateArr  = getDigit(str);

        if(dateArr[1].length==1) dateArr[1] = "0"+dateArr[1];
        if(dateArr[2].length==1) dateArr[2] = "0"+dateArr[2];
        datestr =  dateArr[0]+dateArr[1]+dateArr[2];
       // return datestr;
    }


    datestr = datestr.replace("年", "");
    datestr = datestr.replace("月", "");
    datestr = datestr.replace("日", "");
    datestr = datestr.replaceAll("-", "");
    return datestr.trim();
}

//发布日期 trs编辑器
function getAppdate_trs(str) {
    str = getContent_trs_NoDealtxt(str);
    start_token = "<p ";
    start_token_atrrib="right";
    end_token = "</p>";
    str = str.toLowerCase();
    idx = str.lastIndexOf_lawstar(start_token,start_token_atrrib)
    idx_2 = str.indexOf(end_token, idx);
    str = str.substring(idx, idx_2)

    str = replaceAllHtlm(str);
    var datestr ="";
    if(str.indexOf("年")>-1 && str.indexOf("月")>-1 && str.indexOf("日")>-1  ){
        var dateArr  = getDigit(str);
        if(dateArr[1].length==1) dateArr[1] = "0"+dateArr[1];
        if(dateArr[2].length==1) dateArr[2] = "0"+dateArr[2];
        datestr =  dateArr[0]+dateArr[1]+dateArr[2];
       // return datestr;
    }


    datestr = datestr.replace("年", "");
    datestr = datestr.replace("月", "");
    datestr = datestr.replace("日", "");
    datestr = datestr.replaceAll("-", "");
    return datestr.trim();
}
//发布日期 财政部
function getAppdate_czb(str) {
    start_token = "<p align=\"right\"";
                      end_token = "</p>";
                      str = str.toLowerCase();
                      idx = str.lastIndexOf(start_token)
                      idx_2 = str.indexOf(end_token, idx)
                      str = str.substring(idx + start_token.length, idx_2)
                      str = replaceAllHtlm(str);
                      var datestr ="";
                      if(str.indexOf("年")>-1 && str.indexOf("月")>-1 && str.indexOf("日")>-1  ){
        var dateArr  = getDigit(str);

        if(dateArr[1].length==1) dateArr[1] = "0"+dateArr[1];
        if(dateArr[2].length==1) dateArr[2] = "0"+dateArr[2];
        datestr =  dateArr[0]+dateArr[1]+dateArr[2];
       // return datestr;
    }


    datestr = datestr.replace("年", "");
    datestr = datestr.replace("月", "");
    datestr = datestr.replace("日", "");
    datestr = datestr.replaceAll("-", "");
    return datestr.trim();
}
                                    </textarea>--%>
                                    <textarea id="code1" name="title" >
                                            ${lawstar_releaseDate}
                                    </textarea>
                                </c:when>
                                <c:otherwise>

                                    <textarea id="code1" name="title" >
                                            ${adapter.releasedate}
                                    </textarea>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
                <input type="hidden" name="title">
            </form>
        </div>
        <div class="col-lg-6">
            <div class="ibox ">
                <div class="ibox-title">
                    <h5>网站源代码&nbsp;&nbsp;&nbsp;&nbsp;</h5>
                    <a href="${information.source}" target="_blank">${information.source}</a>
                </div>
                <div class="ibox-content">
                                <textarea id="code2" style="margin: 0px; height: 693px; width: 770px;">
                                    ${information.newscontentnotupdate}
                                </textarea>
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


<!-- Peity -->
<script src="<%=basePath%>js/plugins/peity/jquery.peity.min.js"></script>

<!-- CodeMirror -->
<script src="<%=basePath%>js/plugins/codemirror/codemirror.js"></script>
<script src="<%=basePath%>js/plugins/codemirror/mode/javascript/javascript.js"></script>

<script type="text/javascript">


    var editor = CodeMirror.fromTextArea(document
        .getElementById("code1"), {
        lineNumbers : true,
        matchBrackets : true,
        styleActiveLine : true,
        theme: "ambiance"
    });

    function reg() {


        var targetUrl = $("#myform").attr("action");

        var title = editor.getValue();
        var informationid = $("#informationid").val();
        var codetype = $("#codetype").val();
        if (!isQuery) {
            $.ajax({
                type: 'post',
                url: targetUrl,
                cache: false,
                data: {"releasedate": title, "informationid": informationid, "codetype": codetype},
                beforeSend: function (XMLHttpRequest) {
                    isQuery = true;
                    this;//调用本次ajax请求时配置的options参数，下面每个回调方法都适应。
                },
                success: function (data) {
                    alert(data);
                    isQuery = false;//本次请求成功完成时，重置激活按钮
                },
                error: function () {
                    alert("请求失败")
                    isQuery = false;//本次请求失败时，重置激活按钮
                }
            })
        } else {
            alert("代码上传中...");
        }
    }

    function lastPage(page) {
        var informationid = $("#informationid").val();
        window.location.href = "<%=basePath%>nextPage/"+page+"/"+informationid;
    }
    function nextPage(page) {
        var informationid = $("#informationid").val();
        window.location.href = "<%=basePath%>/nextPage/"+page+"/"+informationid;
    }
    function saveToSession() {
        var title = editor.getValue();
        $.ajax({
            type:'post',
            url:"<%=basePath%>saveToSession",
            cache: false,
            data:{"title":title,"codeType":1},
            success:function(){
                alert("收藏成功");
            },
            error:function(){
                alert("请求失败")
            }
        })
    }
    function loadSession() {
        $.ajax({
            type:'post',
            url:"<%=basePath%>loadSession",
            cache: false,
            data:{"codeType":1},
            success:function(data){
                editor.setValue(data)
            },
            error:function(){
                alert("请求失败")
            }
        })
    }
</script>


</html>
