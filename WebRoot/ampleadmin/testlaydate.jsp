<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/ampleadmin/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'testlaydate.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<input type="text" id="abc">
	<input type="text">
    <!-- jQuery -->
    <script src="../plugins/bower_components/jquery/dist/jquery.min.js"></script>
    
    
    <script src="../plugins/jQuery-Timepicker/jquery-ui-sliderAccess.js"></script>
<script src="../plugins/jQuery-Timepicker/jquery-ui.js"></script>
<link href="../plugins/jQuery-Timepicker/jquery-ui.css" rel="stylesheet" />
<script src="../plugins/jQuery-Timepicker/jquery-ui-timepicker-addon.js"></script>
<link href="../plugins/jQuery-Timepicker/jquery-ui-timepicker-addon.css" rel="stylesheet" />
<script type="text/javascript" src="../plugins/jQuery-Timepicker/i18n/jquery-ui-timepicker-zh-CN.js"></script>



    <script type="text/javascript">
    $("#abc").datetimepicker({
                        showSecond: true, //显示秒  
                        timeFormat: 'HH:mm:ss' //格式化时间  
                    });
    </script>

</body>
</html>
