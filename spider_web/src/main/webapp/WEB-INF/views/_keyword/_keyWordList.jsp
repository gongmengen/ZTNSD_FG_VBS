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

    <link href="<%=basePath%>css2/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="<%=basePath%>font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="<%=basePath%>css2/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <link href="<%=basePath%>css2/animate.css" rel="stylesheet">
    <link href="<%=basePath%>css2/style.css?v=2.2.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div id="wrapper">
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
            </span>
                <h2>关键字维护</h2>
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
                            <table  class="table table-striped table-bordered table-hover dataTables-example" ><!-- 无分页查询功能：table table-bordered -->
                                <thead>
                                <tr>
                                    <th class="hide_column">隐藏列</th>
                                    <th >code</th>
                                    <th >名称</th>
                                    <th>关键字</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${mainList}" var="main" varStatus="xb">
                                    <tr class="gradeX">
                                        <td  class="hide_column" style="width:60px"></td>            
                                        <td  class="center"style="min-width:40px">${main.code}</td>
                                        <td class="center" style="min-width:60px">${main.name}</td>
                                        <td class="center" style="overflow:visible;" >
                                            <a id="code" class="btn" data-toggle="modal" data-target="#myModal${main.code}" onclick="reg2('${main.code}')">${main.kword}</a>
                                            <div class="modal inmodal fade" id="myModal${main.code}" tabindex="-1" role="dialog"  aria-hidden="true">
                                                <div class="modal-dialog modal-lg">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                                            <h4 class="modal-title">关键字维护</h4>

                                                        </div>
                                                        <div class="modal-body">
                                                            <textarea id="p${main.code}" style="height: 300px;width: 840px"></textarea>
                                                                           
                                                        </div>
                                                        <div  class="modal-footer">
                                                            <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="toupdate('${main.code}')">修改</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
     
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


   function reg2(id) {
	 // alert(id);
       var targetUrl = "<%=basePath%>/toUpdateKey";
       //var code = $("#code").val();
       $.ajax({
           type:'post',
           url:targetUrl,
           cache: false,
           data:{"code":id},
           success:function(data){
        	   $("#p"+id).text(data);
           },
           error:function(){
               alert("请求失败")
           }
       })
   }

   function toupdate(id) {
//   alert("aaa");
       var targetUrl = "<%=basePath%>/UpdateKey";
       var cod = $("#p"+id).val();
     // alert(id);
       $.ajax({
           type:'post',
           url:targetUrl,
           cache: false,
           data:{"code":id,"information":cod},
           success:function(data){
        	   window.location.reload();
        	   //$("#p").text(data);
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
