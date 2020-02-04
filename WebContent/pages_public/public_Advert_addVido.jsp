<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="cn">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>广告添加</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<jsp:include page="/media/ui_css.jsp"></jsp:include>
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/select2_metro.css" />
<link rel="stylesheet" href="<%=basePath%>media/css/DT_bootstrap.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/datepicker.css" />
<link href="<%=basePath%>media/css/search.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	.file input {
  position: absolute;
  right: 0;
  top: 0;
  opacity: 0;/*关键点*/
  filter: alpha(opacity=0);/*兼容ie*/
  font-size: 100px;/* 增大不同浏览器的可点击区域 */
  cursor: pointer;
}
</style>
<!-- END PAGE LEVEL STYLES -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<jsp:include page="/main_pages/top.jsp"></jsp:include>
	<!-- BEGIN 容器 -->
	<div class="page-container row-fluid">
		<jsp:include page="/main_pages/left.jsp"></jsp:include>
		<!-- BEGIN 开始页面 -->
		<div class="page-content">
			<!-- BEGIN 页面容器-->
			<div class="container-fluid">
				<!-- BEGIN 页面标题-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN 风格定制 -->
						<jsp:include page="/main_pages/styleset.jsp"></jsp:include>
						<!-- END 风格定制 -->
						<!-- BEGIN 网页的标题和面包屑-->
						<h3 class="page-title">广告<small>添加广告</small></h3>
						<ul class="breadcrumb">
							<li><i class="icon-home"></i> <a href="#">CRM部门管理</a>
								<i class="icon-angle-right"></i> <a href="#">信息中心</a> 
								<i class="icon-angle-right"></i> <a href="pub_Ad!findAllAdvert">广告播放</a>
								<i class="icon-angle-right"></i><a href="#">广告添加</a></li>
						</ul>
						<!-- END 网页的标题和面包屑-->
					</div>
				</div>
				<!-- END 页面标题-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN SAMPLE FORM PORTLET-->
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="icon-reorder"></i>添加广告信息(视频)
								</div>
							</div>
							<div class="portlet-body form">
								<!-- BEGIN FORM-->
								<form action="pub_Ad!addVidoAdvert" method="post" class="form-horizontal" enctype="multipart/form-data">
									<h3 class="form-section">广告信息</h3>
									<div class="row-fluid">
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">广告标题：</label>
												<div class="controls">
												<input type="hidden" name="publicAdvert.Device_only" value="<s:property value="#OnlyVido" />">
												<input name="publicAdvert.ad_Title" type="text" width="200px" />
												</div>
											</div>
										</div>
										<!--/span-->
									</div>
									<div class="row-fluid">
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">广告详情：</label>
												<div class="controls">
														<textarea cols="40" rows="5" id="note" name=publicAdvert.ad_Content maxlength="30" value="" onkeyup="this.value=this.value.substring(0, 30)" placeholder="最多可输入30个字"></textarea>
														<span id="text-count" value="">0</span>/30
												</div>
											</div>
										</div>
										<!--/span-->
									</div>
									<div class="row-fluid">
										<div class="span6 ">
											<div class="control-group">
												<label class="control-label">文件：</label>
												<div class="controls">
    												<input type="file" name="upload" id="movie_tv" onchange="checkTv()"/>
												</div>
											</div>
										</div>
									</div>
									<div class="form-actions">
										<button type="submit" id="submit-button" class="btn green"><i class="icon-ok"></i>保存</button>
										<button type="reset" class="btn">重置</button>
										<button type="button" onclick="history.back()" class="btn blue">返回</button>
									</div>
								</form>
								<!-- END FORM-->
							</div>
						</div>
						<!-- END SAMPLE FORM PORTLET-->
					</div>
				</div>
				<!-- END PAGE CONTENT-->
			</div>
			<!-- END 页面容器-->
		</div>
		<!-- END 页面 -->
	</div>
	<!-- END 容器 -->
	<jsp:include page="/main_pages/foot.jsp"></jsp:include>
	<jsp:include page="/media/ui_js.jsp"></jsp:include>
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript" src="<%=basePath%>media/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="<%=basePath%>media/js/DT_bootstrap.js"></script>
	<script type="text/javascript" src="<%=basePath%>media/js/select2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>media/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="<%=basePath%>media/js/search.js"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="<%=basePath%>media/js/app.js"></script>
	<script src="<%=basePath%>main_pages/crm_table_editable.js"></script>
	<script src="<%=basePath%>main_pages/selectdepsemps.js"></script>
	<script src="<%=basePath%>main_pages/selectposition.js"></script>
	<script>
		jQuery(document).ready(function() {
			App.init();
			TableEditable.init();
			Search.init();
			var position = $("#select2_sample_posi");
			ajaxLoadPosition(position);
		});
		
		 window.onload = function() {
		        document.getElementById('note').onkeyup = function() {        
		            document.getElementById('text-count').innerHTML=this.value.length;
		        }
		        $('#note2').keyup(function() {
		        var len=this.value.length
		                    $('#text-count2').text(len);

		        })
		    }
		 
			//2、这个函数是，判断视频格式---------------------------------------------------------------
			function checkTv(){
			 var tv_id =document.getElementById('movie_tv').value;//根据id得到值
			 var index= tv_id.indexOf("."); //（考虑严谨用lastIndexOf(".")得到）得到"."在第几位
			 tv_id=tv_id.substring(index); //截断"."之前的，得到后缀
			     if(tv_id!=".mp4"&&tv_id!=".rmvb"&&tv_id!=".avi"&&tv_id!=".ts"){ //根据后缀，判断是否符合视频格式
			         alert("不是指定视频格式,重新选择"); 
			       document.getElementById('movie_tv').value="";   // 不符合，就清除，重新选择
			     }
			}
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>