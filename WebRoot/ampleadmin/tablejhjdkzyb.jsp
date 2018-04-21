<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/ampleadmin/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>设备状态表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="32x32" href="images/idcms_logo.png">

<style type="text/css"> 
	td {
		word-wrap:break-word; 
		word-break:break-all;
	}  
</style>
    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Editable CSS -->
    <link type="text/css" rel="stylesheet" href="../plugins/bower_components/jsgrid/dist/jsgrid.min.css" />
    <link type="text/css" rel="stylesheet" href="../plugins/bower_components/jsgrid/dist/jsgrid-theme.min.css" />
    <!-- Menu CSS -->
    <link href="../plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="css/colors/blue-dark.css" id="theme" rel="stylesheet">
    <!-- toast CSS -->
    <link href="../plugins/bower_components/toast-master/css/jquery.toast.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
  </head>
  
<body class="fix-header">
    <!-- ============================================================== -->
    <!-- Preloader -->
    <!-- ============================================================== -->
    <div class="preloader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" />
        </svg>
    </div>
    <!-- ============================================================== -->
    <!-- Wrapper -->
    <!-- ============================================================== -->
    <div id="wrapper">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<%@ include file="TopNavigation.jsp"%>
		<!-- End Top Navigation -->
		<!-- ============================================================== -->
		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<%@ include file="LeftSlidebar.jsp"%>
		<!-- ============================================================== -->
		<!-- End Left Sidebar -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page Content -->
		<!-- ============================================================== -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">设备状态表</h4> </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="white-box">
                            <h3 class="box-title">设备状态表</h3> 
                            <div id="topPager" class="external-pager jsgrid-pager-container"></div>
                            <label class="form-inline">每页
                                <select id="showEntries" class="form-control input-sm">
                                    <option value="5">5</option>
                                    <option value="10">10</option>
                                    <option value="15" selected="">15</option>
                                    <option value="20">20</option>
                                    <option value="50">50</option>
                                </select>条 
                            </label>
                            <label>&nbsp;</label>
                            <label>&nbsp;</label>
                            <label class="form-inline">跳转到
                                <input type="number" id="aimPage" class="form-control" placeholder="请输入您要跳转的页码">页
                                <a id="goPage" class="btn btn-rounded btn-success pull-right">跳转</a>
                            </label>
                            <a id="refreshtable" class="btn btn-rounded btn-info  pull-right" ><i class="fa fa-spin fa-refresh"></i>  刷新表格</a>
                            <div id="jsgrid"></div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->
            <footer class="footer text-center"> 2018 &copy; ZJUT.chwangteng </footer>
        </div>
        <!-- ============================================================== -->
        <!-- End Page Content -->
        <!-- ============================================================== -->
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="../plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="../plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
    <!--slimscroll JavaScript -->
    <script src="js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="js/waves.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="js/custom.min.js"></script>
    <!-- Editable -->
    <script type="text/javascript" src="../plugins/bower_components/jsgrid/dist/jsgrid.min.js"></script>
    <script src="../plugins/bower_components/jsgrid/db-jhjdkzyb.js"></script>
    <script src="js/jsgrid-init-jhjdkzyb.js"></script>
    <!--Style Switcher -->
    <script src="../plugins/bower_components/styleswitcher/jQuery.style.switcher.js"></script>
    <script src="../plugins/bower_components/toast-master/js/jquery.toast.js"></script>
    <script type="text/javascript">
    	$("#showEntries").change(function(){
    		var size = $("#showEntries").val();
    		$("#jsgrid").jsGrid("option", "pageSize", size);
    	});
    	$("#goPage").click(function(){
    		var pagerText=$(".jsgrid-pager").text();
    		var left=pagerText.indexOf('共');
    		var right=pagerText.lastIndexOf('页');
    		var pageCount=pagerText.substring(left+1,right).trim();

    		var pageIndexToGo=$("#aimPage").val();
    		if(parseInt(pageIndexToGo)<=parseInt(pageCount))
    		{
    			$("#jsgrid").jsGrid("openPage",pageIndexToGo);
    			$.toast({
			         heading: '已打开第'+pageIndexToGo+'页',
			         position: 'top-right',
			         icon: 'success'
			     });
    		}
    		else
    			$.toast({
			         heading: '您输入了一个不存在的页面',
			         position: 'top-right',
			         icon: 'error',
			     });
    	});
    	$("#refreshtable").click(function(){
    		// get current page index
			var pageIndex = $("#jsgrid").jsGrid("option", "pageIndex");
			$("#jsgrid").jsGrid("openPage",pageIndex);
			$.toast({
			         heading: '已刷新表格',
			         text: '通过改按钮您可以刷新表格，而无需重新载入页面',
			         position: 'top-right',
			         icon: 'info',
			         textColor: '#fff'
			     });
    	});
    </script>
</body>
</html>
