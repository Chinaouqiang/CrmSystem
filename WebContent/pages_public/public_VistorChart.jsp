<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>

<html lang="cn">

<head>
<meta charset="utf-8" />
<title>统计报表</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<jsp:include page="/media/ui_css.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/select2_metro.css" />
<link rel="stylesheet" href="<%=basePath%>media/css/DT_bootstrap.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/datepicker.css" />
<link href="<%=basePath%>media/css/search.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>Highcharts-7.1.1/code/highcharts.js"></script>
 <script src="<%=basePath%>Highcharts-7.1.1/code/highcharts-3d.js"></script>
 <script src="<%=basePath%>Highcharts-7.1.1/code/modules/exporting.js"></script>
 <script src="<%=basePath%>Highcharts-7.1.1/code/highcharts-zh_CN.js"></script>
 <script src="<%=basePath%>Highcharts-7.1.1/code/themes/dark-unica.js"></script>
 
<!--  圆柱形 -->
 <script src="<%=basePath%>Highcharts-7.1.1/code/modules/oldie.js"></script>
 <script src="<%=basePath%>Highcharts-7.1.1/code/modules/cylinder.js"></script>
 <script src="<%=basePath%>Highcharts-7.1.1/code/themes/dark-unica.js"></script>
 
<!--  饼图 -->
 <script src="<%=basePath%>Highcharts-7.1.1/code/modules/variable-pie.js"></script>
 
 <script src="<%=basePath%>media/js/jquery-1.10.1.min.js"></script>
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
		<div id="container"></div>
				<script type="text/javascript" src="<%=basePath%>pages_public/media/js/3DPIE.js"></script>
				<!-- 男女比例图 -->
				<div id="3D"></div>
				<!-- 时间段人数图 -->
				<div id="DayVistor"></div>
				<!-- 每日人数图 -->
				<div id="daynum"></div>
				<!-- 年龄比例图 -->
				<div id="AgeRatio"></div>
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
		
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>