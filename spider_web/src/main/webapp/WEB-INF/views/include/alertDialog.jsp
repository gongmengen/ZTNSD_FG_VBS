<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>对话框</title>

<style>
/* .delDialog{width:360px;height:200px;background-color:#fff;border-radius:4px;display:none;}
.delDialog p{padding:30px 0px 28px 70px;font:18px/49px "\5FAE\8F6F\96C5\9ED1";color:#333;}
.delDialog p i{width:49px;height:49px;background:url(${ctx }/front/images/alertBg01.png) no-repeat center center scroll;display:inline-block;margin-right:10px;float:left;}
.dialogBtn{display:block;text-align:center;} */
/* .dialogBtn input[type="button"]{color:#19ba9e;border:#19ba9e solid 1px;margin:0px 5px;display:inline-block;height:30px;line-height:20px;padding:5px 20px;background-color:#fff;cursor:pointer} */
/* .dialogBtn input:hover{background-color:#19ba9e;color:#fff} */

.cancelBtn{background-color:#999;}
/* .cancelBtn:hover{background-color:#6e6e6e;} */
.stateDialog{width:360px;height:145px;background-color:#fff;border-radius:4px;display:none;}
.stateDialog p{padding:30px 0px 28px 60px;font:18px/49px "\5FAE\8F6F\96C5\9ED1";color:#333;}
.stateDialog p i{width:49px;height:49px;background:url(${ctx }/front/images/alertBg02.png) no-repeat center center scroll;display:inline-block;margin-right:10px;float:left;}
.stateDialog p i.state02{background:url(${ctx }/front/images/alertBg03.png) no-repeat center center scroll;}

</style>


</head>
<body>


<!---- 第二种弹窗 ---->
<div class="stateDialog" id="stateDialog01">
	<p><i></i><span class="tips1">保存成功！</span></p>
</div>

<!---- 第三种弹窗 ---->
<div class="stateDialog" id="stateDialog02">
	<p><i class="state02"></i><span class="tips2">保存失败！</span></p>
</div>

<script src="${ctx}/front/js/artDialog.js"></script>
<script>
function confirmDialog(obj){
	var aa = dialog({
		 content:document.getElementById('delDialog'),
		 ok:function(){
			 this.close();
		 },
		 cancel:function(){
			 this.close();
		 },
	});
	
	$("#delDialog p").html(obj);
	//将自定义弹窗显示，d.showModal()是带灰色遮罩层的，d.show()是不带灰色遮罩层的
	aa.showModal();
}

function successDialog(obj){
	var bb = dialog({
		 content:document.getElementById('stateDialog01'),
		 ok:function(){
			 this.close();
			 return false;
		 },
		 cancel:function(){
			 this.close();
			 return false;
		 },
	});
	$(".tips1").html(obj);
	//将自定义弹窗显示，d.showModal()是带灰色遮罩层的，d.show()是不带灰色遮罩层的
	bb.showModal();
	setTimeout(function () {
		bb.close();//2s执行自动关闭弹窗
	}, 2000);
}

function falseDialog(obj){
	var cc = dialog({
		 content:document.getElementById('stateDialog02'),
		 ok:function(){
			 this.close();
			 return false;
		 },
		 cancel:function(){
			 this.close();
			 return false;
		 },
	});
	$(".tips2").html(obj);
	//将自定义弹窗显示，d.showModal()是带灰色遮罩层的，d.show()是不带灰色遮罩层的
	cc.showModal();
	setTimeout(function () {
		cc.close();//2s执行自动关闭弹窗
	}, 2000);
}

</script>
</body>
</html>