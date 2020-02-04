<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="cn">
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>crm_cus_list.jsp</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<jsp:include page="/media/ui_css.jsp"></jsp:include>
	<!-- BEGIN PAGE LEVEL STYLES -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/select2_metro.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/DT_bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/datepicker.css" />
	<link href="<%=basePath%>media/css/jquery.fancybox.css" rel="stylesheet" />
	<link href="<%=basePath%>media/css/search.css" rel="stylesheet" type="text/css"/>
	<!-- END PAGE LEVEL STYLES -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<jsp:include page="/main_pages/top.jsp"></jsp:include>
	<!-- BEGIN 容器 -->
	<div class="page-container row-fluid">
		<jsp:include page="/main_pages/left.jsp"></jsp:include>
		<!-- BEGIN 开始页面-->
		<div class="page-content">
			<!-- ---------------------------------------------- -->
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
							CRM客户管理 <small>我的客户管理页</small>
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="">CRM客户管理</a> 
								<i class="icon-angle-right"></i>
								<a href="">客户管理</a> 
								<i class="icon-angle-right"></i>
								<a href="">客户列表</a>
							</li>
						</ul>
						<!-- END 网页的标题和面包屑-->
					</div>
				</div>
				<!-- END 页面标题-->
				<!-- BEGIN 智能搜索 -->
				<div class="row-fluid">
					<div class="span12" >
						<!-- BEGIN SAMPLE TABLE PORTLET-->
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption"><i class="icon-search"></i>搜索范围</div>
								<div class="tools">
									<a href="javascript:;" class="collapse"></a>
									<a href="javascript:;" class="remove"></a>
								</div>
							</div>
							<div class="portlet-body" id="mysearch">
								<div id="tab_2_2" class="tab-pane active">
								<div class="row-fluid">
									<div class="span12">
										<form action="hr_CheckWork!findList2" method="post">
											<div class="input-append date date-picker"  data-date-format="yyyy-mm-dd" data-date-viewmode="years">
														<input placeholder="请选择" name="checkWork.check_Time" class="m-wrap m-ctrl-medium date-picker" size="16" type="text" value="" /><span class="add-on"><i class="icon-calendar"></i></span>
											</div>
											<div class="input-append date date-picker"  data-date-format="yyyy-mm-dd" data-date-viewmode="years">
														<input placeholder="请选择" name="checkWork.isLeave" class="m-wrap m-ctrl-medium date-picker" size="16" type="text" value="" /><span class="add-on"><i class="icon-calendar"></i></span>
											</div>
																							
											<!--/row-->
										
											<div class="row-fluid">
											<button class="btn green span6" type="submit">搜索 <i class="m-icon-swapright m-icon-white"></i></button>
											<button class="btn blue span6 " type="reset">重置 <i class="m-icon-swapright icon-refresh"></i></button>
											</div>
										</form>
									</div>
									<!--end booking-search-->
								</div>
								<!--end row-fluid-->
								</div>
							</div>
						<!-- END SAMPLE TABLE PORTLET-->
					</div>
				</div>
				</div>
				<!-- END 智能搜索 -->
				<!-- BEGIN 示例表portlet-->
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="icon-globe"></i>客户列表
						</div>
						<div class="actions">
							<div class="btn-group">
								<a class="btn black" href="#" data-toggle="dropdown"> 改变显示列 <i class="icon-angle-down"></i> </a>
								<div id="sample_2_column_toggler"
									class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
									<label><input type="checkbox" checked data-column="0">员工号</label>
									<label><input type="checkbox" checked data-column="1">员工姓名</label>
									<label><input type="checkbox" checked data-column="2">日期</label>
									<label><input type="checkbox" checked data-column="3">上午上班</label>
									<label><input type="checkbox" checked data-column="4">上午下班</label>
									<label><input type="checkbox" checked data-column="5">下午上班</label>
									<label><input type="checkbox" checked data-column="6">下午下班</label>
									<label><input type="checkbox" checked data-column="7">考勤状况</label>
									<label><input type="checkbox" checked data-column="8">是否迟到</label>
									<label><input type="checkbox" checked data-column="9">是否早退</label>
									<label><input type="checkbox" checked data-column="10">是否旷工</label>
									<label><input type="checkbox" checked data-column="11">是否请假</label>
									<label><input type="checkbox" checked data-column="12">备注</label>
								</div>
							</div>
							
								<div class="btn-group">
								<button class="btn dropdown-toggle" data-toggle="dropdown">工具 <i class="icon-angle-down"></i></button>
								<ul class="dropdown-menu pull-right">
									<li><a href="hr_CheckWork!exportGWDataManageList">导出到Excel</a></li>
								</ul>
							</div>
							
						</div>
					</div>
					<div class="portlet-body">
						<table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">
							<thead>
								<tr>
									<th>员工号</th>
									<th>员工姓名</th>
									<th>日期</th>
									<th>上午上班</th>
									<th>上午下班</th>
									<th>下午上班</th>
									<th>下午下班</th>
									<th>考勤状况</th>
									<th>是否迟到</th>
									<th>是否早退</th>
									<th>是否旷工</th>
									<th>是否请假</th>
									<th>备注</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>									
										<s:iterator value="#findList" var="p">
										<tr>
											<td><s:property value="#p.hr_id" /></td>
											<td><s:property value="#p.hr_Name" /></td>
											<td><s:property value="#p.check_Time" /></td>
											<td><s:property value="#p.m_work" /></td>
											<td><s:property value="#p.m_offwork" /></td>
											<td><s:property value="#p.a_work" /></td>
											<td><s:property value="#p.a_offwork" /></td>
											<td><s:property value="#p.iswork_State" /></td>
											<td><s:property value="#p.isLate" /></td>
											<td><s:property value="#p.isLateEarly" /></td>
											<td><s:property value="#p.isAbsenteeism" /></td>
											<td><s:property value="#p.isLeave" /></td>
											<td><s:property value="#p.check_remarks" /></td>
											<td>
												<!-- begin操作按钮 -->
												<div class="btn-group" style="margin-bottom: 0px !important;">
													<a class="btn mini green" href="#" data-toggle="dropdown">
														<i class="icon-user"></i>操作<i class="icon-angle-down"></i>
													</a>
													<ul class="dropdown-menu">
														<!-- editRow(传入当前行ID 0开始)  -->
														<li><a onclick="return confirm('确定删除该条考勤记录吗?');" href="hr_CheckWork!deleteCheck?idd=<s:property value="#p.id" />">
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
				<!-- END 示例表portlet-->
			</div>
			<!-- END 页面容器-->
			<!-- --------------------------------------------------------- -->
		</div>
		<!-- END 页面 -->
	</div>
	<!-- END 容器 -->
	<jsp:include page="/main_pages/foot.jsp"></jsp:include>
	<jsp:include page="/media/ui_js.jsp"></jsp:include>
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript" src="<%=basePath%>media/js/select2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>media/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="<%=basePath%>media/js/DT_bootstrap.js"></script>
	<script type="text/javascript" src="<%=basePath%>media/js/search.js"></script>
	<script type="text/javascript" src="<%=basePath%>media/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="<%=basePath%>media/js/jquery.fancybox.pack.js"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<script src="<%=basePath%>media/js/app.js"></script>
 	<script src="<%=basePath%>media/js/form-samples.js"></script> 
	<script src="<%=basePath%>media/js/table-advanced.js"></script>
	<script type="text/javascript" src="<%=basePath%>main_pages/selectparam.js"></script> 
	<script>
		jQuery(document).ready(function() {
			App.init();
			TableAdvanced.init();
			FormSamples.init();
			Search.init();
			$(".collapse").click();
		});
		$(function(){
			var custype = $("#select2_sample_custype");
			ajaxLoadParam(custype,1);
			var type=$("#select2_sample_type");
			ajaxLoadParam(type,2);
		});
	</script>
	<script type="text/javascript" src="<%=basePath%>main_pages/selectcustomer.js"></script>
	<script type="text/javascript" src="<%=basePath%>main_pages/selectdepsemps.js"></script>
	<script type="text/javascript" src="<%=basePath%>main_pages/selectcitys.js"></script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
