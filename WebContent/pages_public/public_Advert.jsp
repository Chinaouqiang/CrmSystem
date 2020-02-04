<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="cn">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
	<meta charset="utf-8" />
	<title>crm_productcate_list.jsp</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<jsp:include page="/media/ui_css.jsp"></jsp:include>
	<!-- BEGIN PAGE LEVEL STYLES -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/select2_metro.css" />
	<link rel="stylesheet" href="<%=basePath%>media/css/DT_bootstrap.css" />
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
						<h3 class="page-title">
							岗位<small>查看岗位</small>
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a>CRM部门管理</a> 
								<i class="icon-angle-right"></i>
								<a>信息中心</a> 
								<i class="icon-angle-right"></i>
								<a>广告播放</a>
								<i class="icon-angle-right"></i>
								<a>广告视频播放</a> 
							</li>
						</ul>
						<!-- END 网页的标题和面包屑-->
					</div>
				</div>
				<!-- END 页面标题-->
				<!-- ---------------------------------------------- -->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="btn-group" style="margin-bottom: 0px !important;">
									<a class="btn mini green" href="#" data-toggle="dropdown">
										<i class="icon-user"></i>操作<i class="icon-angle-down"></i>
									</a>
									<ul class="dropdown-menu">
										<!-- editRow(传入当前行ID 0开始)  -->
										<li><a data-toggle="modal" href="pub_Ad!findAllAdvertVido">
											<i class="icon-edit"></i>横屏视频广告</a></li>
										<li><a href="pub_Ad!findAllAdvertPic">
											<i class="icon-trash"></i>横屏图片广告</a></li>
										<li><a href="pub_Ad!findAllAdvertPic">
											<i class="icon-trash"></i>竖屏图片广告</a></li>
									</ul>
								</div>
								<!-- <div class="actions">
									<button id="sample_editable_1_new" onclick="location.href='public_Advert_add.jsp'" class="btn red">
									图片广告 <i class="icon-plus"></i>
									</button>
									<button id="sample_editable_1_new" onclick="location.href='public_Advert_addVido.jsp'" class="btn red">
									视频广告<i class="icon-plus"></i>
									</button>
								</div> -->
							</div>
							<div class="portlet-body">
								
								<table class="table table-striped table-hover table-bordered" id="sample_2">
									<thead>
										<tr>
											<th>序号</th>
											<th>广告标题</th>
											<th>广告详情</th>
											<th>视频</th>
											<th>广告状态</th>
											<th>添加时间</th>
										</tr>
									</thead>
									<tbody>									
										<s:iterator value="#listdata" var="p">
										<tr class="">
											<td><s:property value="#p.ad_Id" /></td>
											<td><s:property value="#p.ad_Title" /></td>
											<td width="200px" height="100px"><s:property value="#p.ad_Content" /></td>
											
											<td>
												<embed src="<s:property value="#p.ad_Vido" />" loop="true" width="100" height="100">
											</td>
											<td>
												<s:if test="#p.ad_State==0">
													<a onclick="return confirm('是否要禁用该广告?');" data-toggle="modal" href="pub_Ad!updateAdvertVidoState?publicAdvert.ad_Id=<s:property value="#p.ad_Id" />&&publicAdvert.ad_State=1 "><i class="icon-adjust"></i>运行中</a>
												</s:if>
												<s:if test="#p.ad_State==1">
	                                               <a onclick="return confirm('是否要重新启用该广告?');" data-toggle="modal" href="pub_Ad!updateAdvertVidoState?publicAdvert.ad_Id=<s:property value="#p.ad_Id" />&&publicAdvert.ad_State=0"><i class="icon-remove"></i>已禁用</a>
												</s:if>
											</td>
											<td><s:property value="#p.create_Time"/></td>
											<%-- <td>
												<!-- begin操作按钮 -->
												<div class="btn-group" style="margin-bottom: 0px !important;">
													<a class="btn mini green" href="#" data-toggle="dropdown">
														<i class="icon-user"></i>操作<i class="icon-angle-down"></i>
													</a>
													<ul class="dropdown-menu">
														<!-- editRow(传入当前行ID 0开始)  -->
														<li><a data-toggle="modal"
															href="pub_Ad!findOneAdvertVido?id=<s:property value="#p.ad_Id" />">
															<i class="icon-edit"></i>编辑</a></li>
														<li><a onclick="return confirm('确定删除该条广告吗?');" href="pub_Ad!deleteAdvertVido?id=<s:property value="#p.ad_Id" />">
															<i class="icon-trash"></i>删除</a></li>
													</ul>
												</div>
												<!-- end操作按钮 -->
											</td> --%>
										</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
						</div>
						<!-- END EXAMPLE TABLE PORTLET-->
					</div>
				</div>
				<!-- ---------------------------------------------- -->
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
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="<%=basePath%>media/js/app.js"></script>
	<script src="<%=basePath%>media/js/table-advanced.js"></script>
	<script>
		jQuery(document).ready(function() {
			App.init();
			TableAdvanced.init();
		});
		
		//1、这个函数是，判断图片格式--------------------------------------------------------------------
		function checkImg(){
		var img_id=document.getElementById('movie_img').value; //根据id得到值
		var index= img_id.indexOf("."); //（考虑严谨用lastIndexOf(".")得到）得到"."在第几位
		img_id=img_id.substring(index); //截断"."之前的，得到后缀
		    if(img_id!=".bmp"&&img_id!=".png"&&img_id!=".gif"&&img_id!=".jpg"&&img_id!=".jpeg"){  //根据后缀，判断是否符合图片格式
		         document.getElementById('movie_img').value="";  // 不符合，就清除，重新选择
		      }
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