<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- Topbar header - style you can find in pages.scss -->
<!-- ============================================================== -->
<nav class="navbar navbar-default navbar-static-top m-b-0">
<div class="navbar-header">
	<div class="top-left-part">
		<!-- Logo -->
		<a class="logo" href="index.jsp"> <!-- Logo icon image, you can use font-icon also -->
			<b> <!--This is dark logo icon-->
				<img src="../plugins/images/admin-logo.png" alt="home"
				class="dark-logo" />
			<!--This is light logo icon-->
				<img src="../plugins/images/admin-logo-dark.png" alt="home"
				class="light-logo" />
		</b> <!-- Logo text image you can use text also -->
			<span class="hidden-xs"> <!--This is dark logo text-->
				<img src="../plugins/images/admin-text.png" alt="home"
				class="dark-logo" />
			<!--This is light logo text-->
				<img src="../plugins/images/admin-text-dark.png" alt="home"
				class="light-logo" />
		</span>
		</a>
	</div>
	<!-- /Logo -->
	<!-- Search input and Toggle icon -->
	<ul class="nav navbar-top-links navbar-left">
		<li><a href="javascript:void(0)"
			class="open-close waves-effect waves-light visible-xs"><i
				class="ti-close ti-menu"></i></a></li>
		<li class="dropdown"><a
			class="dropdown-toggle waves-effect waves-light"
			data-toggle="dropdown" href="#"> <i class="mdi mdi-gmail"></i>
				<div class="notify">
					<span class="heartbit"></span> <span class="point"></span>
				</div>
		</a>
			<ul class="dropdown-menu mailbox">
				<li>
					<div class="drop-title">You have 4 new messages</div>
				</li>
				<li>
					<div class="message-center">
						<a href="#">
							<div class="user-img">
								<img src="../plugins/images/users/pawandeep.jpg" alt="user"
									class="img-circle"> <span
									class="profile-status online pull-right"></span>
							</div>
							<div class="mail-contnet">
								<h5>Pavan kumar</h5>
								<span class="mail-desc">Just see the my admin!</span> <span
									class="time">9:30 AM</span>
							</div>
						</a> <a href="#">
							<div class="user-img">
								<img src="../plugins/images/users/sonu.jpg" alt="user"
									class="img-circle"> <span
									class="profile-status busy pull-right"></span>
							</div>
							<div class="mail-contnet">
								<h5>Sonu Nigam</h5>
								<span class="mail-desc">I've sung a song! See you at</span> <span
									class="time">9:10 AM</span>
							</div>
						</a> <a href="#">
							<div class="user-img">
								<img src="../plugins/images/users/arijit.jpg" alt="user"
									class="img-circle"> <span
									class="profile-status away pull-right"></span>
							</div>
							<div class="mail-contnet">
								<h5>Arijit Sinh</h5>
								<span class="mail-desc">I am a singer!</span> <span class="time">9:08
									AM</span>
							</div>
						</a> <a href="#">
							<div class="user-img">
								<img src="../plugins/images/users/pawandeep.jpg" alt="user"
									class="img-circle"> <span
									class="profile-status offline pull-right"></span>
							</div>
							<div class="mail-contnet">
								<h5>Pavan kumar</h5>
								<span class="mail-desc">Just see the my admin!</span> <span
									class="time">9:02 AM</span>
							</div>
						</a>
					</div>
				</li>
				<li><a class="text-center" href="javascript:void(0);"> <strong>See
							all notifications</strong> <i class="fa fa-angle-right"></i>
				</a></li>
			</ul> <!-- /.dropdown-messages --></li>
		<!-- .Task dropdown -->
		<li class="dropdown"><a
			class="dropdown-toggle waves-effect waves-light"
			data-toggle="dropdown" href="#"> <i class="mdi mdi-check-circle"></i>
				<div class="notify">
					<span class="heartbit"></span><span class="point"></span>
				</div>
		</a>
			<ul class="dropdown-menu dropdown-tasks">
				<li><a href="#">
						<div>
							<p>
								<strong>Task 1</strong> <span class="pull-right text-muted">40%
									Complete</span>
							</p>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-success"
									role="progressbar" aria-valuenow="40" aria-valuemin="0"
									aria-valuemax="100" style="width: 40%">
									<span class="sr-only">40% Complete (success)</span>
								</div>
							</div>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<p>
								<strong>Task 2</strong> <span class="pull-right text-muted">20%
									Complete</span>
							</p>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-info" role="progressbar"
									aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
									style="width: 20%">
									<span class="sr-only">20% Complete</span>
								</div>
							</div>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<p>
								<strong>Task 3</strong> <span class="pull-right text-muted">60%
									Complete</span>
							</p>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-warning"
									role="progressbar" aria-valuenow="60" aria-valuemin="0"
									aria-valuemax="100" style="width: 60%">
									<span class="sr-only">60% Complete (warning)</span>
								</div>
							</div>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a href="#">
						<div>
							<p>
								<strong>Task 4</strong> <span class="pull-right text-muted">80%
									Complete</span>
							</p>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
									style="width: 80%">
									<span class="sr-only">80% Complete (danger)</span>
								</div>
							</div>
						</div>
				</a></li>
				<li class="divider"></li>
				<li><a class="text-center" href="#"> <strong>See
							All Tasks</strong> <i class="fa fa-angle-right"></i>
				</a></li>
			</ul></li>
		<!-- .Megamenu -->
		<li class="mega-dropdown"><a
			class="dropdown-toggle waves-effect waves-light"
			data-toggle="dropdown" href="#"><span class="hidden-xs">云产品</span>
				<i class="icon-options-vertical"></i></a>
			<ul class="dropdown-menu mega-dropdown-menu">
				<li class="col-sm-3">
					<ul>
						<li class="dropdown-header">云计算与网络</li>
						<li><a href="form-basic.html">云服务器</a></li>
						<li><a href="form-layout.html">负载均衡</a></li>
						<li><a href="form-advanced.html">私有网络</a></li>
						<li><a href="form-material-elements.html">弹性伸缩</a></li>
						<li><a href="form-float-input.html">专线接入</a></li>
						<li><a href="form-upload.html">容器服务</a></li>
						<li><a href="form-mask.html">无服务器云函数</a></li>
						<li><a href="form-img-cropper.html">批量计算</a></li>
					</ul>
				</li>
				<li class="col-sm-3">
					<ul>
						<li class="dropdown-header">数据处理</li>
						<li><a href="form-dropzone.html">视频处理</a></li>
						<li><a href="form-pickers.html">万象优图</a></li>
						<li><a href="form-wizard.html">双螺旋</a></li>
					</ul>
				</li>
				<li class="col-sm-3">
					<ul>
						<li class="dropdown-header">存储</li>
						<li><a href="basic-table.html">对象存储</a></li>
						<li><a href="table-layouts.html">文件存储</a></li>
						<li><a href="data-table.html">归档存储</a></li>
						<li><a href="bootstrap-tables.html">日志服务</a></li>
					</ul>
				</li>
				<li class="col-sm-3">
					<ul>
						<li class="dropdown-header">CDN与加速</li>
						<li><a href="flot.html">CDN</a></li>
						<li><a href="morris-chart.html">海外加速</a></li>
						<li><a href="chart-js.html">动态加速</a></li>
					</ul>
				</li>
				<li class="col-sm-3">
					<ul>
						<li class="dropdown-header">互联网中间件</li>
						<li><a href="flot.html">消息队列CMQ</a></li>
						<li><a href="morris-chart.html">消息队列CKafka</a></li>
						<li><a href="chart-js.html">消息队列IoTMQ</a></li>
						<li><a href="chart-js.html">API网关</a></li>
					</ul>
				</li>
				<li class="col-sm-3">
					<ul>
						<li class="dropdown-header">安全</li>
						<li><a href="flot.html">主机安全</a></li>
						<li><a href="morris-chart.html">网络安全</a></li>
						<li><a href="chart-js.html">移动安全</a></li>
						<li><a href="chart-js.html">数据加密服务</a></li>
					</ul>
				</li>
				<li class="col-sm-3">
					<ul>
						<li class="dropdown-header">大数据基础服务</li>
						<li><a href="flot.html">弹性MapReduce</a></li>
						<li><a href="morris-chart.html">数据工坊</a></li>
						<li><a href="chart-js.html">云数据管道</a></li>
					</ul>
				</li>
				<li class="col-sm-3">
					<ul>
						<li class="dropdown-header">数据库</li>
						<li><a href="flot.html">关系型数据库</a></li>
						<li><a href="morris-chart.html">弹性缓存Redis</a></li>
						<li><a href="chart-js.html">文档数据库MongoDB</a></li>
						<li><a href="chart-js.html">弹性缓存Memcached</a></li>
						<li><a href="chart-js.html">列式数据库HBase</a></li>
						<li><a href="chart-js.html">HTAP数据库</a></li>
						<li><a href="chart-js.html">分布式数据库</a></li>
						<li><a href="chart-js.html">时序数据库CTSDB</a></li>
						<li><a href="chart-js.html">数据传输服务DTS</a></li>
					</ul>
				</li>
			</ul></li>
		<!-- /.Megamenu -->
	</ul>
	<ul class="nav navbar-top-links navbar-right pull-right">
		<li>
			<form role="search" class="app-search hidden-sm hidden-xs m-r-10">
				<input type="text" placeholder="搜索..." class="form-control">
				<a href=""><i class="fa fa-search"></i></a>
			</form>
		</li>
		<li class="dropdown"><a class="dropdown-toggle profile-pic"
			data-toggle="dropdown" href="#"> <img
				src="../plugins/images/users/wangteng.jpg" alt="user-img" width="36"
				class="img-circle"><b class="hidden-xs">王腾</b><span
				class="caret"></span>
		</a>
			<ul class="dropdown-menu dropdown-user animated flipInY">
				<li>
					<div class="dw-user-box">
						<div class="u-img">
							<img src="../plugins/images/users/wangteng.jpg" alt="user" />
						</div>
						<div class="u-text">
							<h4> 王腾</h4>
							<p class="text-muted"> chwangteng@gmail.com</p>
							<a href="profile.html" class="btn btn-rounded btn-danger btn-sm">  查看个人资料</a>
						</div>
					</div>
				</li>
				<li role="separator" class="divider"></li>
				<li><a href="#"><i class="ti-user"></i>   我的账户</a></li>
				<li><a href="#"><i class="ti-wallet"></i>   我的钱包</a></li>
				<li><a href="#"><i class="ti-email"></i>   我的消息</a></li>
				<li role="separator" class="divider"></li>
				<li><a href="#"><i class="ti-settings"></i>   设置</a></li>
				<li role="separator" class="divider"></li>
				<li><a href="#"><i class="fa fa-power-off"></i>   注销</a></li>
			</ul> <!-- /.dropdown-user --></li>
		<!-- /.dropdown -->
	</ul>
</div>
<!-- /.navbar-header --> <!-- /.navbar-top-links --> <!-- /.navbar-static-side -->
</nav>
<!-- End Top Navigation -->