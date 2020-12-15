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


    <title>适配网站 - 正文脚本</title>
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
        <h2>正文脚本</h2>
        <ol class="breadcrumb">
            <li>
                <a>网站列表</a>
            </li>
            <li>
                <a>添加脚本</a>
            </li>
            <li>
                <strong>正文脚本</strong>
            </li>
        </ol>
    </div>
    <div class="col-lg-5">

        <a data-toggle="modal" class="btn btn-primary" href="form_basic.html#modal-form">标题、文号</a>

        <div id="modal-form" class="modal fade" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="row">

                            <div class="form-group">
                                <label class="col-sm-2 control-label" style="top: 3px;">标题:

                                </label>

                                <div class="col-sm-10">
                                    <label style="color: #999999"><input type="radio" value="1"  name="title">存在&nbsp;&nbsp;&nbsp;</label>
                                    <label style="color: #999999"><input type="radio" value="2"  name="title">不存在&nbsp;&nbsp;&nbsp;</label>
                                    <label style="color: #999999"><input type="radio" value="0"  name="title">不确定&nbsp;&nbsp;&nbsp;</label>
                                </div>
                            </div>
                            <div class="form-group" >
                                <label class="col-sm-2 control-label" style="top: 3px;">文号:

                                </label>

                                <div class="col-sm-10">
                                    <label style="color: #999999"><input type="radio" value="1"  name="newsnum">存在&nbsp;&nbsp;&nbsp;</label>
                                    <label style="color: #999999"><input type="radio" value="2"  name="newsnum">不存在&nbsp;&nbsp;&nbsp;</label>
                                    <label style="color: #999999"><input type="radio" value="0"  name="newsnum">不确定&nbsp;&nbsp;&nbsp;</label>
                                </div>
                            </div>
                            <div>
                                <button class="btn btn-sm btn-primary pull-right m-t-n-xs" onclick="saveToWebsite()"><strong>保存</strong>
                                </button>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>


        <button type="button" class="btn btn-primary btn-sm" onclick="loadSession()">加载已收藏</button>
        <button type="button" class="btn btn-primary btn-sm" onclick="saveToSession()">收藏到session</button>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal5" onclick="reg()">
            点击验证
        </button>
        <div class="modal inmodal fade" id="myModal5" tabindex="-1" role="dialog"  aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">正文</h4>

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

        <button type="button" class="btn btn-primary btn-sm" onclick="lastPage(1)">上一步</button>
        <button type="button" class="btn btn-primary btn-sm" onclick="nextPage(3)">下一步</button>

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
                <input type="hidden" id="codetype" name="codetype" value="2">

                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>脚本代码</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="textarea">
                            <c:choose>
                                <c:when test="${adapter.composetext == null||adapter.composetext.equals('')}">
                                    <%--
                                    <textarea id="code1" name="title" >
                                    //v1.25 lawstar getContent_jtb branch  2019-10-18  by yjs
                                    //入口函数,全部使用小写字母
                                    function entry(str) {
                                        str =getContent_jtb(str)
                                        return str;
                                    }//正文 发改委
                                    function getContent(str) {
                                        start_token ="<p id=\"xxgk_content_fwzh_bottom\" style=\"display: none;\"></p>";
                                        end_token = "<!--添加微信附件打开提示-->";
                                        idx = str.indexOf(start_token)
                                        idx_2 = str.indexOf(end_token, idx + start_token.length)
                                        //console.log("2222"+idx_2);
                                        str = str.substring(idx, idx_2)


                                        return deal_all_text(str);
                                    }

                                    //正文，交通部，标签区间方法
                                    function getContent_jtb(str) {
                                        var start_token ="<div";
                                        var attach_str="Three_xilan_07";
                                        var end_token = "</div>";
                                    var idx_arr = str.findTagPostion(start_token,attach_str,end_token);
                                    idx = idx_arr[0];
                                    idx_2 = idx_arr[1];
                                    // console.log("idx=" + idx_arr[0]);
                                    // console.log("idx _end=" + idx_arr[1]);
                                    str = str.substring(idx, idx_2);
                                    // console.log("bbbb="+str)
                                    return deal_all_text(str);
                                    }

                                    //正文，交通部，标签区间方法 使用trs编辑器
                                    function getContent_trs(str) {
                                    var start_token ="<div";
                                    var attach_str="arc_body";
                                    var end_token = "</div>";
                                    var idx_arr = str.findTagPostion(start_token,attach_str,end_token);
                                    idx = idx_arr[0];
                                    idx_2 = idx_arr[1];
                                    // console.log("idx=" + idx_arr[0]);
                                    // console.log("idx _end=" + idx_arr[1]);
                                    str = str.substring(idx, idx_2);
                                    return deal_all_text(str);
                                    }
                                    //正文，交通部，标签区间方法 使用trs编辑器,未排版
                                    function getContent_trs_NoDealtxt(str) {
                                    var start_token ="<div";
                                    var attach_str="TRS_Editor";
                                    var end_token = "</div>";
                                    var idx_arr = str.findTagPostion(start_token,attach_str,end_token);
                                    idx = idx_arr[0];
                                    idx_2 = idx_arr[1];
                                    // console.log("idx=" + idx_arr[0]);
                                    // console.log("idx _end=" + idx_arr[1]);
                                    str = str.substring(idx, idx_2);
                                    return str;
                                    }


                                    //正文预处理
                                    function deal_prepared(txt){
                                    //  txt = txt.toLowerCase();
                                    // txt = txt.replaceAll("四川省人民政府<br>"+br_str+"<br>"+br_str, "四川省人民政府");
                                    txt = txt.replaceAll("　", "  ");
                                    txt = txt.replaceAll("   ", "    ");
                                    txt = txt.replaceAll(" ", " ");
                                    //  txt = txt.replaceAll("    ", "");
                                    txt = txt.replaceAll("\n", br_str);
                                    txt = txt.replaceAll("&nbsp;", " ");

                                    txt = txt.replaceAll(hex2str("0x09"), "    ");
                                    txt = replaceBlock(txt,"<p style=","</p>",br_str,false);// p 前面增加回车换行
                                    txt = replaceBlock(txt,"<div ","</div>",br_str,false);// p 前面增加回车换行
                                    return txt;
                                    }
                                    //居中标签适配
                                    //<p style="text-align: center">
                                    function align_center(txt){

                                    txt = align_center_moreLine(txt,"<p align=\"center\">","</p>");//多行居右处理
                                    txt = align_center_moreLineAll(txt,"<p style=\"TEXT-ALIGN: center\">","</p>");//多行居右处理
                                    txt = txt.replaceAll("<p align=center>", space_6);
                                    txt = txt.replaceAll("<p align='center>'", space_6);
                                    txt = txt.replaceAll("<h3 style=\"margin-bottom:14px;\">", space_6);//自然资源部

                                    txt = txt.replaceAll("<p align=\"center\">", space_6);
                                    txt = txt.replaceAll("<div align=center>", space_6);
                                    txt = txt.replaceAll("<div align=center>", space_6);
                                    txt = txt.replaceAll("<p style=\"text-align: center\">", "<p style=\"text-align:center\">");
                                    txt = txt.replaceAll("<p style=\"text-align:center\">",space_6);
                                    txt = replaceBlock(txt,"<p align=\"center\"","</p>",space_6);
                                    txt = txt.replaceAll_lawstar("<p ","center",space_6);
                                    txt = txt.replaceAll_lawstar("<div ","center",space_6);
                                    txt = txt.replaceAll_lawstar("<p ","mso-char-indent-count",space_4);
                                    return txt;
                                    }
                                    //段落开头标签适配 一般空四个
                                    //<p style="text-align: center">
                                        function align_left(txt){
                                        txt = txt.replaceAll_lawstar("<p ","mso-char-indent-count",space_4);
                                    txt = txt.replaceAll_lawstar("<p ","text-indent",space_4);
                                    txt = replaceBlock(txt,"<p align=\"justify\">","</p>",br_str);
                                    // console.log("txt==========="+txt)
                                    txt = replaceBlock(txt,"<p class","</p>",br_str);
                                    txt = replaceBlock(txt,"<p style=","</p>",br_str);
                                    return txt;
                                    }
                                    // 居右标签适配
                                    //<p style="text-align: center">
                                        function align_right(txt){
                                    txt = align_right_moreLineAll_TAG(txt,"<p ","</p>","align=[\"']?right[\"']?");//多行居右处理
                                    txt = align_right_moreLineAll_TAG(txt,"<P ","</P>","align=[\"']?right[\"']?");//多行居右处理
                                    txt = align_right_moreLineAll_TAG(txt,"<div ","</div>","right");//多行居右处理
                                    //txt = align_right_moreLineAll_TAG(txt,"<P ","</P>","right");//多行居右处理
                                    txt = align_right_moreLineAll_TAG(txt,"<DIV ","</DIV>","right");//多行居右处理
                                    return txt;
                                            }

                                            //正文后处理
                                            function deal_last(txt){

                                            txt = removeBlock(txt,"抄送：",br_str,"");
                                            txt = removeBlock(txt,"分送：",br_str,"");
                                            txt = removeBlock(txt,"链接：",br_str,"");
                                            txt = removeBlock(txt,"网站纠错",br_str,"");
                                            txt = removeBlock(txt,"附件.pdf",br_str,"");
                                            txt = txt.replaceAll("（此件主动公开）","");
                                            txt = txt.replaceAll("（此件公开发布）","");
                                            txt = txt.replaceAll(".此件公开发布.","");
                                            txt = txt.replaceAll(".此件主动公开.","");

                                            //txt = txt.replaceAll("四川省人民政府办公厅"+br_str+br_str,"四川省人民政府办公厅");

                                            return txt;
                                            }
                                            function deal_all_text(txt) {//国家税务局
                                            //1、替换标签，居中 空6个，居右 空36个，行首加4个空格。替换br 正则表达式
                                            //先找居中的标题，文号，空6格
                                            //接着找居右的 36格
                                            if (txt==null || txt.length==0) return "";
                                            //正文预处理
                                            txt = deal_prepared(txt);
                                            //附件处理，包括排版
                                            txt = deal_attach_titles(txt);
                                            //居中标签处理P
                                            txt = align_center(txt);
                                            //居右标签处理
                                            //   console.log("bbbb="+txt)
                                            txt = align_right(txt);
                                            //居左
                                            txt = align_left(txt);
                                            //替换网页标签
                                            txt = replaceAllHtlm(txt);

                                            //删除空行以及根据空格补充回车换行

                                            //发改委正文特殊处理 ，部门居中，从后面排版
                                            txt = deal_special_department(txt);
                                            // 处理空行，以及针对空格处理换行
                                            txt = deal_lines(txt);
                                            //console.log("bbbb="+txt)
                                            //处理开头三行居中，合并标题问题，四川省政府模式
                                            txt = deal_titles(txt);
                                            //处理章节，条的格式（参考VB）
                                            txt = deal_paragraph(txt);
                                            //处理空行36个格的日期问题，由原来的数字年份转换为一般的中文数字年份。2015年1月2日    二零一五年二月十一日
                                            txt = deal_appDate(txt);
                                            //删除开头空格
                                            txt = deal_firstLineNull(txt);
                                            //处理部门日期换行问题，36格子换行
                                            txt = deal_space36_lines(txt);
                                            //处理部门中间空格问题，如果单个字，合并
                                            txt = deal_department_space(txt);
                                            txt = deal_last(txt);
                                            return txt;
                                            }</textarea>--%>
                                    <textarea id="code1" name="title" >
                                            ${lawstar_newsContent}
                                    </textarea>
                                </c:when>
                                <c:otherwise>

                                    <textarea id="code1" name="title" >
                                            ${adapter.composetext}
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

    //初始化 radio
    function initradio(rName,rValue){
        var rObj = document.getElementsByName(rName);

        for(var i = 0;i < rObj.length;i++){
            if(rObj[i].value == rValue){
                rObj[i].checked =  'checked';
            }
        }
    }

    initradio("title",${website.titlestatus})
    initradio("newsnum",${website.newsnumstatus})


    function reg() {


        var targetUrl = $("#myform").attr("action");

        var title = editor.getValue();
        var informationid = $("#informationid").val();
        var codetype = $("#codetype").val();

        $.ajax({
            type:'post',
            url:targetUrl,
            cache: false,
            data:{"composetext":title,"informationid":informationid,"codetype":codetype},
            success:function(data){
                $("#p").text(data);
            },
            error:function(){
                alert("请求失败")
            }
        })
    }


    //保存 标题、文号存在状态
    function saveToWebsite() {
        var title=$("input[name='title']:checked").val();
        var newsnum=$("input[name='newsnum']:checked").val();
        $.ajax({
            type:'post',
            url:'/saveTitleAndNewsnumStatus',
            cache: false,
            data:{"title":title,"newsnum":newsnum,"id":${information.websiteid}},
            success:function(data){
                alert(data);
                window.location.reload();
            },
            error:function(){
                alert("请求失败")
            }
        })

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
