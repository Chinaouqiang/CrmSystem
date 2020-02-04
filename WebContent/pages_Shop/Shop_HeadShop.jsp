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
<html lang="cn">
<head>
	<meta charset="utf-8" />
	<title>总店</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<jsp:include page="/media/ui_css.jsp"></jsp:include>
	<!-- BEGIN PAGE LEVEL STYLES -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/select2_metro.css" />
	<link rel="stylesheet" href="<%=basePath%>media/css/DT_bootstrap.css" />
	<!-- END PAGE LEVEL STYLES -->
</head>
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
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a>产品管理</a> 
								<i class="icon-angle-right"></i>
								<a>总店数据管理</a> 
							</li>
						</ul>
					</div>
				</div>
				<!-- END 页面标题-->
				<!-- ---------------------------------------------- -->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="actions">
									<button id="sample_editable_1_new" onclick="location.href='HeadShop_Add.jsp'" class="btn red">
										数据添加<i class="icon-plus"></i>
									</button>
								</div>
							</div>
							<div class="portlet-body">
								
								<table class="table table-striped table-hover table-bordered" id="sample_2">
									<thead>
										<tr>
											<th>序号</th>
											<th>店铺名</th>
											<th>店铺地址</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>									
										<s:iterator value="#findList" var="p">
										<tr class="">
											<td><s:property value="#p.Shop_Id" /></td>
											<td><s:property value="#p.Shop_Name" /></td>
											<td><s:property value="#p.Shop_Adress" /></td>
											<td>
												<!-- begin操作按钮 -->
												<div class="btn-group" style="margin-bottom: 0px !important;">
													<a class="btn mini green" href="#" data-toggle="dropdown">
														<i class="icon-user"></i>操作<i class="icon-angle-down"></i>
													</a>
													<ul class="dropdown-menu">
														<!-- editRow(传入当前行ID 0开始)  -->
														<li><a data-toggle="modal"
															href="HeadShop!update?headShop.Shop_Id=<s:property value="#p.Shop_Id" />">
															<i class="icon-edit"></i>编辑</a></li>
														<li><a onclick="return confirm('确定删除该数据吗?');" href="HeadShop!deleteHeadShop?headShop.Shop_Id=<s:property value="#p.Shop_Id" />">
															<i class="icon-trash"></i>删除</a></li>
													</ul>
												</div>
												<!-- end操作按钮 -->
											</td>
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
		
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>