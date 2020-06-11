<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>加载框</title>
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" type="text/css"/> --%>
<style type="text/css">

.loadingDialog{width:360px;height:200px;background-color:#fff;border-radius:4px;display:none;z-index: 99998}
.loadingDialog i{width:49px;height:49px;background:url(${ctx }/front/images/loading.gif) no-repeat center center scroll;display:inline-block;margin-right:10px;float:left;background-size:contain;position:absolute;top:50%;left:50%;margin-top:-25px;margin-left:-25px;z-index:9;}


</style>
</head>
<body>
	<!-- 加载框 -->
	<div class="loadingDialog" id="loadingDialog">
		<i></i>
	</div>
	
</body>

<script type="text/javascript">
var loading;
function jiazai(){
	loading = dialog({
		 content:document.getElementById('loadingDialog'),
		 ok:function(){
			 this.close();
			 return false;
		 },
		 cancel:function(){
			 this.close();
			 return false;
		 },
	});
	//将自定义弹窗显示，d.showModal()是带灰色遮罩层的，d.show()是不带灰色遮罩层的
	loading.showModal();
};
</script>
</html>