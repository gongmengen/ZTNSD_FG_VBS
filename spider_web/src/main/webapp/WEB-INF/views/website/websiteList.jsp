<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>网站管理</title>
<%@ include file="/WEB-INF/views/include/nav.jsp"%>


<!--导入首页启动时需要的相应资源文件(首页相应功能的 js 库、css样式以及渲染首页界面的 js 文件)-->
<link rel="stylesheet" href="${ctx}/front/css/newsOp.css" type="text/css" />

</head>

<body>
	<!-- leftMenu -->
	<ul class="breadNav">
		<li><a href="${ctx}/page/website/websitecolumn?leftMenu=2" title="" target="_self">网站管理</a></li>
		<li style="min-width: 13px;">>></li>
		<li><a href="" title="" target="_self">${xwColumnName }</a></li>
		<li class="front_page_web"><a href="javascript:void(0)" onclick="backPage()" >返回</a></li>
	</ul>
	<!-- newsList -->
	<div class="editorList">
		<input value="${xwColumn}" type="hidden" id="xwColumn" />
		<div class="searchArea">
			<input type="hidden" name="xwColumn" value="${xwColumn }" /> <b>网站查询：</b>
			<span>栏目选择：</span> <select class="lanmu" id="columnName"
				name="lanmu01">
				<option value="0">请选择</option>
				<c:forEach var="stu" items="${columns}">
					<option value="${stu.id }">${stu.columnName }</option>
				</c:forEach>
			</select>
			<a class="submitBtn" href="#" onclick="chaxun()" title="查询" target="_self">查询</a>
			<a class="submitBtn" onclick="addForm()" href="javascript:void(0)" title="添加" target="_self" style="    margin-left: 20px;">添加</a>
			<a class="addBtn" href="#" onclick="zhuaqu()" title="抓取" 	target="_self" >抓取</a>
		</div>	
		<div class="listTitWrap">
			<ul>
				<li><span class="td01">序号</span>
				    <span class="td02">所属栏目</span>
					<span class="td03">网站名称</span>
					<span class="td04">栏目网址</span>
					<span class="td02">cron表达式</span>
					<span class="td05">添加人</span>
					<span class="td06">操作</span>
					<span class="td08">
						<label><input class="checkBtnAll" id="selectAll" type="checkbox"/></label>
                		<label>选择</label>
					</span>
			</ul>
		</div>
		<div class="djbzMain">
			<ul class="djbz" id="WebsiteList">

			</ul>
			<div id="pager"></div>
			<div id="clonWebsiteList" style="display: none;">
				<li>
					<span class="td01">#序号#</span>
					<span class="td02">#所属栏目#</span>
					<span class="td03">#网站名称#</span> 
					<span class="td04"><a class="" href="#栏目网站#" title="#栏目网站#" target="view_window">#栏目网站#</a></span>
					<span class="td02">#cron表达式#</span>
					<span class="td05">#添加人#</span>
					<span class="td06"> 
						<a style="<c:if test='${ !(roletype gt 1)}'>display:none</c:if>" onclick="grabOnce('#主键#','#网站名称#')" href="javscript:void(0)" title="抓取" target="_self">抓取</a>
						<a style="<c:if test='${ !(roletype gt 1)}'>display:none</c:if>" class="updateBtn" onclick="valDialog('#主键#')" id="update" href="javscript:void(0)" title="修改" target="_self">修改</a>
						<a style="<c:if test='${ !(roletype gt 1)}'>display:none</c:if>" class="delEditor" onclick="delConfirm('#主键#','#网站名称#')" href="javascript:void(0)" title="删除" target="_self">删除</a> 
					</span>
					<span class="td08">
					    <label>
		                      <input value="#主键#:#网站名称#" class="checkBtn" type="checkbox"/>
		                </label>
					</span>
				</li>
			</div>
		</div>
	</div>

	<!-- 网址添加弹窗 -->
	<div class="siteAddDialog" id="siteAddDialog">
		<h3>添加网址</h3>
		<span class="closeBtn" data-id="cancel">x</span>
		<form class="demoform" id="mainform">
			<div class="editPower">
				<i>栏目选择：</i> <select name="columnId" id="columnId1">
					<option value="">请选择</option>
					<c:forEach var="stu" items="${columns}">
						<option value="${stu.id }">${stu.columnName }</option>
					</c:forEach>
				</select>
			</div>
			<div class="editName">
				<i>网站名称：</i> <input type="text" name="websiteName" id="websiteName1" placeholder="请输入网站名称" />
			</div>
			<div class="editName">
				<i>网站地址：</i> <input type="text" name="websiteAddress" id="websiteAddress1" placeholder="请输入网站地址" />
			</div>
			<div class="editName">
				<i>cron表达式：</i> <input type="text" name="websiteCron" id="websiteCron1" placeholder="请输入cron表达式" />
				<a href="http://cron.qqe2.com/" target="_blank" style="color: #4b96ea;">在线生成</a>
			</div>
<!-- 			<div class="editPower"> -->
<!-- 				<i>更新周期：</i> <select name="updateCycle" id="updateCycle1"> -->
<!-- 					<option value="0">请选择</option> -->
<!-- 					<option value="1">10分钟/次</option> -->
<!-- 					<option value="2">20分钟/次</option> -->
<!-- 					<option value="3">30分钟/次</option> -->
<!-- 					<option value="4">1小时/次</option> -->
<!-- 					<option value="5">2小时/次</option> -->
<!-- 					<option value="6">3小时/次</option> -->
<!-- 					<option value="7">4小时/次</option> -->
<!-- 					<option value="8">5小时/次</option> -->
<!-- 					<option value="9">6小时/次</option> -->
<!-- 					<option value="10">7小时/次</option> -->
<!-- 					<option value="11">8小时/次</option> -->
<!-- 					<option value="12">9小时/次</option> -->
<!-- 					<option value="13">10小时/次</option> -->
<!-- 					<option value="14">11小时/次</option> -->
<!-- 					<option value="15">12小时/次</option> -->
<!-- 					<option value="16">24小时/次</option> -->
<!-- 					<option value="17">48小时/次</option> -->
<!-- 					<option value="18">72小时/次</option> -->
<!-- 				</select> -->
<!-- 			</div> -->
			<div class="editName">
				<i>新闻列表：</i> <input type="text" name="grabList" id="grabList1" placeholder="请输入主页新闻列表标签" />
			</div>
			<div class="editName">
				<i>新闻网址：</i> <input type="text" name="grabsonwebsite" id="grabsonwebsite1" placeholder="请输入详情页新闻网址" />
			</div>
			<div class="editName">
				<i>新闻标题：</i> <input type="text" name="grabTitle" id="grabTitle1" placeholder="请输入新闻标题标签" />
			</div>
			<div class="editName">
				<i>编码格式：</i> <input type="text" name="webCharset" id="webCharset1" placeholder="请输入网站编码格式" />
			</div>
			<c:if test="${xwColumn !=8 }">
				<div class="editName">
					<i>新闻内容：</i> <input type="text" name="grabContent" id="grabContent1" placeholder="请输入新闻内容标签" />
				</div>
				<div class="editName">
					<i>新闻图片：</i> <input type="text" name="grabPic" id="grabPic1" placeholder="请输入新闻图片标签" />
				</div>
			</c:if>
			<div class="editName">
					<i>发布时间：</i> <input type="text" name="grabTime" id="grabTime1" placeholder="请输入新闻发布时间标签" />
				</div>
				<div class="editName">
					<i>发布来源：</i> <input type="text" name="grabSource" id="grabSource1" placeholder="请输入新闻发布来源标签" />
				</div>
			<div class="editName">
				<i>动态查询：</i> <input type="text" name="dynamicQuery" id="dynamicQuery1" placeholder="请输入动态查询字段" />
			</div>
			<div class="editName">
				<i>对应栏目：</i> <input type="text" name="dyColumn" id="dyColumn1" placeholder="请输入对应栏目字段" />
			</div>
			<div class="editName">
				<i>去除文字：</i> <input type="text" name="removeString" id="removeString1" placeholder="请输入需要去除的正文字段" />
			</div>
			<div class="editName">
				<i>去除段落：</i> <input type="text" name="removeSection" id="removeSection1" placeholder="请输入需要去除的正文段落" />
			</div>
			<div class="removeStringCue">请输入需要去除的正文字段，如果有多个需要去除文字，以英文“,”分割</div>
			<div class="removeSectionCue">请输入需要去除的正文段落，格式（开始@结束），多个需要去除段落，以英文“,”分割 格式（开始@结束,开始@结束）</div>
			<div class="dialogBtn">
				<input type="submit" value="确定" /> <input id="reset" class="cancel" data-id="cancel" type="button" value="取消" />
			</div>
		</form>
	</div>

	<script>
		/* 网站添加 */
		function addForm() {
			$.cachedScript('${ctx }/front/js/artDialog.js').done(function() {
				var d = dialog({
					content : document.getElementById('siteAddDialog'),
					ok : function() {

						this.close().remove();
						return false;
					},
					okValue : "确定",
					cancel : function() {
						this.close();
						return false;
					},
				});
				//将自定义弹窗显示，d.showModal()是带灰色遮罩层的，d.show()是不带灰色遮罩层的
				d.showModal();
			});
			//});
		}

		function add() {
			var columnId1 = $("#columnId1").val();
			var websiteName1 = $("#websiteName1").val();
			var websiteAddress1 = $("#websiteAddress1").val();
			var websiteCron1 = $("#websiteCron1").val();
			var updateCycle1 = $("#updateCycle1").val();
			var grabList1 = $("#grabList1").val();
			var grabsonwebsite1 = $("#grabsonwebsite1").val();
			var grabContent1 = $("#grabContent1").val();
			var grabPic1 = $("#grabPic1").val();
			var grabTitle1 = $("#grabTitle1").val();
			var grabTime1 = $("#grabTime1").val();
			var grabSource1 = $("#grabSource1").val();
			var webCharset1 = $("#webCharset1").val();
			var dynamicQuery1 = $("#dynamicQuery1").val();
			var removeString1 = $("#removeString1").val();
			var removeSection1 = $("#removeSection1").val();
			var dyColumn1 = $("#dyColumn1").val();
			$.ajax({
				type : "post",
				url : '${ctx }/website/add',
				data : {
					columnId : columnId1,
					websiteName : websiteName1,
					websiteAddress : websiteAddress1,
					websiteCron : websiteCron1,
					updateCycle : updateCycle1,
					grabList : grabList1,
					grabsonwebsite : grabsonwebsite1,
					grabContent : grabContent1,
					grabPic : grabPic1,
					grabTitle : grabTitle1,
					grabTime : grabTime1,
					grabSource : grabSource1,
					dynamicQuery : dynamicQuery1,
					webCharset : webCharset1,
					removeString : removeString1,
					removeSection:removeSection1,
					dyColumn:dyColumn1,
				},
				success : function(data) {
					if (data.success) {
						$(".cancel").click();
						successDialog(data.msg);
						setTimeout("findwebsiteList()", "200"); //延迟加载
					} else {
						falseDialog(data.msg);
					}
					//        	loading.close();
				},
				error : function() {
					//        	loading.close();
					falseDialog("未知错误，请重试！");
				}
			});

		}
	</script>
	<script>
		function chaxun() {
			var columnId = $("#columnName").val();
			pageind=1;
			findwebsiteList(columnId)
		}

		//表单填充
		var xwColumn = $("#xwColumn").val();
		
		var pageind =1;
		function findwebsiteList(columnId) {

			$('#pager').sjAjaxPager(
					{
						url : '${ctx}/website/findwebsiteList',
						pageIndex : pageind,
						pageSize : 10,
						searchParam : {
							/*
							 * 如果有其他的查询条件，直接在这里传入即可
							 */
							xwColumn : xwColumn,
							columnId : columnId
						},
						beforeSend : function() {
						},
						success : function(data) {
							pageind=data.pageIndex;
							$("#WebsiteList").html("");
							var tempa = $("#clonWebsiteList").clone().html();
							var tempStr = tempa;
							$("#pager").html("");
							$.each(data.websites, function(index, obj) {
								tempStr = tempStr.replace("#序号#", (data.pageIndex - 1)* 10 + (index + 1));
								tempStr = tempStr.replace("#所属栏目#",obj.columnName);
								tempStr = tempStr.replace("#网站名称#",obj.websiteName);
								tempStr = tempStr.replace("#栏目网站#",obj.websiteAddress);
								tempStr = tempStr.replace("#栏目网站#",obj.websiteAddress);
								tempStr = tempStr.replace("#栏目网站#",obj.websiteAddress);
								tempStr = tempStr.replace("#添加人#", obj.nickName);
								tempStr = tempStr.replace("#主键#", obj.id);
								tempStr = tempStr.replace("#cron表达式#", obj.websiteCron);
								tempStr = tempStr.replace("#主键#", obj.id);
								tempStr = tempStr.replace("#主键#", obj.id);
								tempStr = tempStr.replace("#主键#", obj.id);
								tempStr = tempStr.replace("#网站名称#",obj.websiteName);
								tempStr = tempStr.replace("#主键#", obj.id);
								tempStr = tempStr.replace("#网站名称#",obj.websiteName);
								$("#WebsiteList").append(tempStr);
								tempStr = tempa;
							});
						},
						complete : function() {
							//切换页数后，选择框置空
							$("#selectAll").prop("checked",false);
						}
					});

		}
		//删除确认
		function delConfirm(id, websiteName) {
			$.cachedScript('${ctx }/front/js/artDialog.js').done(function() {
				var d = dialog({
					content : document.getElementById('delDialog'),
					ok : function() {
						del(id, websiteName);
						this.close().remove();
						return false;
					},
					okValue : "确定",
					cancel : function() {
						this.close();
						return false;
					},
				});
				//将自定义弹窗显示，d.showModal()是带灰色遮罩层的，d.show()是不带灰色遮罩层的
				d.showModal();
			});
		}
		function del(id, websiteName) {
			$.ajax({
				type : "post",
				url : '${ctx }/website/delete?id=' + id + '&websiteName='
						+ websiteName,
				success : function(data) {
					if (data) {
						successDialog(data.msg);
						setTimeout("findwebsiteList()", "200"); //延迟加载
					} else {
						falseDialog(data.msg);
					}
				},
				error : function() {
					falseDialog("未知错误，请重试！");
				}
			});
		}
	</script>

	<script>
		$(function() {
			findwebsiteList();
			//表格样式
			$(".djbz li:even").addClass("bg");

			//下拉框样式
			$(".lanmu").cssSelect();
		});
	</script>
 <script>

$(function(){
    //全选操作
    $("#selectAll").click(function(){
        if(this.checked){
            $("#WebsiteList .checkBtn,#selectAll").prop("checked",true);
        }else{
            $("#WebsiteList .checkBtn,#selectAll").prop("checked",false);
        }
    });
});
</script>
	<!-- 网址修改弹窗-->
	<div class="siteAddDialog" id="siteUpdateDialog">
		<h3>修改网址</h3>
		<span class="closeBtn" data-id="cancel">x</span>
		<form id="updateform" class="demoform">
			<input type="hidden" id="id" name="id" value="" />
			<div class="editPower">
				<i>栏目选择：</i> <select name="columnName" id="columnNameUpdate"  >
					<option value="">请选择</option>
					<c:forEach var="stu" items="${columns}">
						<option id="${ stu.id}" value="${stu.id }">${stu.columnName }</option>
					</c:forEach>
				</select>
			</div>
			<div class="editName">
				<i>网站名称：</i> <input type="text" id="websiteName" name="websiteName" placeholder="请输入网站名称"  />
			</div>
			<div class="editName">
				<i>网站地址：</i> <input type="text" id="websiteAddress" name="websiteAddress" placeholder="请输入网站地址" />
			</div>
			<div class="editName">
				<i>cron表达式：</i> <input type="text" name="websiteCron" id="websiteCron" placeholder="请输入cron表达式" />
				<a href="http://cron.qqe2.com/" target="_blank" style="color: #4b96ea;">在线生成</a>
			</div>
<!-- 			<div class="editPower"> -->
<!-- 				<i>更新周期：</i> <select name="updateCycle" id="updateCycle"> -->
<!-- 					<option value="0">请选择</option> -->
<!-- 					<option value="1">10分钟/次</option> -->
<!-- 					<option value="2">20分钟/次</option> -->
<!-- 					<option value="3">30分钟/次</option> -->
<!-- 					<option value="4">1小时/次</option> -->
<!-- 					<option value="5">2小时/次</option> -->
<!-- 					<option value="6">3小时/次</option> -->
<!-- 					<option value="7">4小时/次</option> -->
<!-- 					<option value="8">5小时/次</option> -->
<!-- 					<option value="9">6小时/次</option> -->
<!-- 					<option value="10">7小时/次</option> -->
<!-- 					<option value="11">8小时/次</option> -->
<!-- 					<option value="12">9小时/次</option> -->
<!-- 					<option value="13">10小时/次</option> -->
<!-- 					<option value="14">11小时/次</option> -->
<!-- 					<option value="15">12小时/次</option> -->
<!-- 					<option value="16">24小时/次</option> -->
<!-- 					<option value="17">48小时/次</option> -->
<!-- 					<option value="18">72小时/次</option> -->
<!-- 				</select> -->
<!-- 			</div> -->
			<div class="editName">
				<i>新闻列表：</i> <input type="text" name="grabList" id="grabList" />
			</div>
			<div class="editName">
				<i>新闻网址：</i> <input type="text" name="grabsonwebsite" id="grabsonwebsite"   />
			</div>
			<div class="editName">
				<i>新闻标题：</i> <input type="text" name="grabTitle" id="grabTitle" />
			</div>
			<div class="editName">
				<i>编码格式：</i> <input type="text" name="webCharset" id="webCharset" />
			</div>
			<c:if test="${xwColumn !=8 }">
				<div class="editName">
					<i>新闻内容：</i> <input type="text" name="grabContent" id="grabContent" />
				</div>
				<div class="editName">
					<i>新闻图片：</i> <input type="text" name="grabPic" id="grabPic" />
				</div>
			</c:if>
			<div class="editName">
					<i>发布时间：</i> <input type="text" name="grabTime" id="grabTime" />
				</div>
				<div class="editName">
					<i>发布来源：</i> <input type="text" name="grabSource" id="grabSource" />
				</div>
			<div class="editName">
				<i>动态查询：</i> <input type="text" name="dynamicQuery" id="dynamicQuery"  />
			</div>
			<div class="editName">
				<i>对应栏目：</i> <input type="text" name="dyColumn" id="dyColumn"  />
			</div>
			<div class="editName">
				<i>去除文字：</i> <input type="text" name="removeString" id="removeString" />
			</div>
			<div class="editName">
				<i>去除段落：</i> <input type="text" name="removeSection" id="removeSection" />
			</div>
			<div class="removeStringCue">请输入需要去除的正文字段，如果有多个需要去除文字，以英文“,”分割</div>
			<div class="removeSectionCue">请输入需要去除的正文段落，格式（开始@结束），多个需要去除段落，以英文“,”分割 格式（开始@结束,开始@结束）</div>
			<div class="dialogBtn">
				<input class="ok" type="submit" value="确定" /> <input class="cancel" data-id="cancel" type="button" value="取消" />
			</div>
		</form>
	</div>

	<script>
		/* 网站修改弹窗 */
		function valDialog(id) {
			val(id);
			$.cachedScript('${ctx }/front/js/artDialog.js').done(function() {
				var d = dialog({
					content : document.getElementById('siteUpdateDialog'),
					ok : function() {

						this.close().remove();
						return false;
					},
					okValue : "确定",
					cancel : function() {
						this.close();
						return false;
					},
				});
				//将自定义弹窗显示，d.showModal()是带灰色遮罩层的，d.show()是不带灰色遮罩层的
				d.showModal();
			});
		}

		/* 根据id查询网站信息 */
		function val(id) {
			$("#id").val(id);

			$.ajax({
				type : 'GET',
				url : '${ctx }/website/websiteListId',
				dataType : 'json',
				data : {
					"id" : id
				},
				success : function(data) {

					var all_options = document.getElementById("columnNameUpdate").options;
					for (i=0; i<all_options.length; i++){
					      if (all_options[i].id == data.columnId)  // 根据option标签的ID来进行判断  测试的代码这里是两个等号
					      {
					         all_options[i].selected = true;
					      }
					}
					$("#websiteName").val(data.websiteName);
					$("#websiteAddress").val(data.websiteAddress);
					$("#websiteCron").val(data.websiteCron);
// 					 document.getElementById('updateCycle').value=data.updateCycle;
					$("#grabList").val(data.GrabList);
					$("#grabsonwebsite").val(data.Grabsonwebsite);
					$("#grabContent").val(data.GrabContent);
					$("#grabPic").val(data.GrabPic);
					$("#grabTitle").val(data.GrabTitle);
					$("#grabTime").val(data.GrabTime);
					$("#grabSource").val(data.GrabSource);
					$("#webCharset").val(data.webCharset);
					$("#dynamicQuery").val(data.dynamicQuery);
					$("#removeString").val(data.removeString);
					$("#removeSection").val(data.removeSection);
					$("#dyColumn").val(data.dycolumn);
				}
			});
		}

		/* 网站修改 */
		function update() {
			debugger;
			var id = $("#id").val();
			var columnId = $("#columnId").val();
			var websiteName = $("#websiteName").val();
			var websiteAddress = $("#websiteAddress").val();
			var websiteCron = $("#websiteCron").val();
			var updateCycle = $("#updateCycle").val();
			var grabList = $("#grabList").val();
			var grabsonwebsite = $("#grabsonwebsite").val();
			var grabContent = $("#grabContent").val();
			var grabPic = $("#grabPic").val();
			var grabTitle = $("#grabTitle").val();
			var grabTime = $("#grabTime").val();
			var grabSource = $("#grabSource").val();
			var webCharset = $("#webCharset").val();
			var dynamicQuery = $("#dynamicQuery").val();
			var removeString = $("#removeString").val();
			var removeSection = $("#removeSection").val();
			var dyColumn = $("#dyColumn").val();
			
			$.ajax({
				type : "post",
				url : '${ctx }/website/update',
				data : {
					id : id,
					columnId : columnId,
					websiteName : websiteName,
					websiteAddress : websiteAddress,
					websiteCron : websiteCron,
					updateCycle : updateCycle,
					grabList : grabList,
					grabsonwebsite : grabsonwebsite,
					grabContent : grabContent,
					grabPic : grabPic,
					grabTitle : grabTitle,
					grabTime : grabTime,
					grabSource : grabSource,
					dynamicQuery : dynamicQuery,
					webCharset : webCharset,
					removeString : removeString,
					removeSection:removeSection,
					dyColumn:dyColumn
				},
				success : function(data) {
					if (data.success) {
						$(".cancel").click();
						successDialog(data.msg);
						setTimeout("findwebsiteList()", "200"); //延迟加载
					} else {
						falseDialog(data.msg);
					}
					//        	loading.close();
				},
				error : function() {
					//        	loading.close();
					falseDialog("未知错误，请重试！");
				}
			});

		}

		//抓取一次
		function grabOnce(id,websiteName){
			stratNow(id,websiteName);
			successDialog("网站开始抓取");
		}
		
		// 		网站抓取
		function zhuaqu(){
			var shuliang = 0;
			$(".checkBtn").each(function(){
				if(this.checked){
					var idwz = $(this).val()
					var id = idwz.split(":")[0];
					var websiteName = idwz.split(":")[1];
					if(id && websiteName){
						stratNow(id,websiteName);
				   		 shuliang++;
					}
				}
			});
			if(shuliang==0){
			  	falseDialog("请选择要抓取的网站");
			 }else{
				 successDialog(shuliang+"个网站开始抓取");
			 }
	
		}
		//网站立即抓取一次
		function stratNow(id, websiteName) { 
			$('#' + id).removeAttr('onclick');//移除点击事件
			$('#' + id).css("color", "#ccc");
			$.ajax({
				type : "post",
				url : '${ctx }/scheduleJob/' + id + '/' + id
						+ '/startNow',
				success : function(data) {
					if (data.success) {
						//2000毫秒后选择框置空
						setTimeout("$(\"#WebsiteList .checkBtn,#selectAll\").prop(\"checked\",false)", "2000");
					} else {
						falseDialog(data.msg);
					}
				},
				error : function() {
					falseDialog("未知错误，请重试！");
				}
			});
		}
		
//文本框信息提示
$().ready(function(){
  $("[name='removeString']").mouseover(function(){
    $(".removeStringCue").show();
  });
  $("[name='removeString']").mouseout(function(){
    $(".removeStringCue").hide();
  });
  $("[name='removeSection']").mouseover(function(){
    $(".removeSectionCue").show();
  });
  $("[name='removeSection']").mouseout(function(){
    $(".removeSectionCue").hide();
  });
});

	</script>
	<script>

		$().ready(function() {

			/* 表单验证 */
			$("#mainform").validate({
				rules : {
					websiteAddress : {
						required : true,
						minlength : 2,
						maxlength : 255
					},
					websiteName : {
						required : true,
						minlength : 2,
						maxlength : 255
					},
					columnId : {
						required : true,
						maxlength : 11
					},
					grabList : {
						required : true,
						maxlength : 500
					},
					grabsonwebsite : {
						required : true,
						maxlength : 500
					},
					grabContent : {
						required : true,
						maxlength : 500
					},
					grabPic : {
						required : true,
						maxlength : 500
					},
					grabTitle : {
						required : true,
						maxlength : 500
					},
					webCharset : {
						required : true,
						maxlength : 500
					},
					dynamicQuery : {
						maxlength : 500
					},
					removeString : {
						maxlength : 500
					},
					
				},
				messages : {
					websiteAddress : {
						required : "网址地址不能为空",
						minlength : "长度不能少于2",
						maxlength : "长度不能超过255"
					},
					websiteName : {
						required : "网站名称不能为空",
						minlength : "长度不能少于2",
						maxlength : "长度不能超过255"
					},
					columnId : {
						required : "请选择栏目",
						maxlength : "长度不能超过11"
					},
					grabList : {
						required : "新闻列表不能为空",
						maxlength : "长度不能超过500"
					},
					grabsonwebsite : {
						required : "新闻网址不能为空",
						maxlength : "长度不能超过500"
					},
					grabContent : {
						required : "新闻内容不能为空",
						maxlength : "长度不能超过500"
					},
					grabPic : {
						required : "新闻图片不能为空",
						maxlength : "长度不能超过500"
					},
					grabTitle : {
						required : "新闻标题不能为空",
						maxlength : "长度不能超过500"
					},
					webCharset : {
						required : "网站编码不能为空",
						maxlength : "长度不能超过500"
					},
					dynamicQuery : {
						maxlength : "长度不能超过500"
					},
					removeString : {
						maxlength : "长度不能超过255"
					},
				},
				submitHandler : function() {
					add();
				}

			});

			$("#updateform").validate({
				rules : {
					websiteAddress : {
						required : true,
						minlength : 2,
						maxlength : 255
					},
					grabList : {
						required : true,
						maxlength : 500
					},
					grabsonwebsite : {
						required : true,
						maxlength : 500
					},
					grabContent : {
						required : true,
						maxlength : 500
					},
					grabPic : {
						required : true,
						maxlength : 500
					},
					grabTitle : {
						required : true,
						maxlength : 500
					},
					webCharset : {
						required : true,
						maxlength : 500
					},
					dynamicQuery : {
						maxlength : 500
					},
					removeString : {
						maxlength : 255
					},
				},
				messages : {
					websiteAddress : {
						required : "网址地址不能为空",
						minlength : "长度不能少于2",
						maxlength : "长度不能超过255"
					},
					grabList : {
						required : "新闻列表不能为空",
						maxlength : "长度不能超过500"
					},
					grabsonwebsite : {
						required : "新闻网址不能为空",
						maxlength : "长度不能超过500"
					},
					grabContent : {
						required : "新闻内容不能为空",
						maxlength : "长度不能超过500"
					},
					grabPic : {
						required : "新闻图片不能为空",
						maxlength : "长度不能超过500"
					},
					grabTitle : {
						required : "新闻标题不能为空",
						maxlength : "长度不能超过500"
					},
					webCharset : {
						required : "网站编码不能为空",
						maxlength : "长度不能超过500"
					},
					dynamicQuery : {
						maxlength : "长度不能超过500"
					},
					removeString : {
						maxlength : "长度不能超过255"
					},
				},
				submitHandler : function() {
					update();
				}
			});

			/* 表单重置 */
			$(".cancel").click(function() {
				$("#mainform").validate().resetForm();
				$("#updateform").validate().resetForm();
				$("select").val("");
				$("input[type=text]").val("");
			});
			$(".closeBtn").click(function() {
				$("#mainform").validate().resetForm();
				$("#updateform").validate().resetForm();
				$("select").val("");
				$("input[type=text]").val("");
			});

		});
	</script>
</body>
</html>