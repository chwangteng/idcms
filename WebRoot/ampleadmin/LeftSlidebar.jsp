<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav slimscrollsidebar">
                <div class="sidebar-head">
                    <h3><span class="fa-fw open-close"><i class="ti-menu hidden-xs"></i><i class="ti-close visible-xs"></i></span> <span class="hide-menu">导航</span></h3> </div>
                <ul class="nav" id="side-menu">
                    <li> <a href="index.jsp" class="waves-effect"><i class="mdi mdi-av-timer fa-fw" data-icon="v"></i> <span class="hide-menu">控制台<span class="label label-rouded label-inverse pull-right">4</span></span></a>
                    </li>
                    <li class="devider"></li>
                    <li> <a href="javascript:void(0)" class="waves-effect"><i class="mdi mdi-format-color-fill fa-fw"></i> <span class="hide-menu">网络攻击展示<span class="fa arrow"></span> <span class="label label-rouded label-info pull-right">20</span> </span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="tableattackinfoes.jsp"><i data-icon="&#xe026;" class="linea-icon linea-basic fa-fw"></i> <span class="hide-menu">攻击统计表</span></a></li>
                        </ul>
                    </li>
                    <li> <a href="javascript:void(0)" class="waves-effect"><i class="mdi mdi-content-copy fa-fw"></i> <span class="hide-menu">IP池资源管理<span class="fa arrow"></span><span class="label label-rouded label-warning pull-right">30</span></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="javascript:void(0)"><i class="ti-layout-width-default fa-fw"></i> <span class="hide-menu">大块地址管理</span></a></li>
                            <li><a href="javascript:void(0)"><i class="ti-layout-sidebar-left fa-fw"></i> <span class="hide-menu">专线地址管理</span></a></li>
                            <li><a href="javascript:void(0)" class="waves-effect"><i class="ti-email fa-fw"></i> <span class="hide-menu">网管地址管理</span></span></a></li>
                            <li><a href="javascript:void(0)" class="waves-effect"><i class="ti-lock fa-fw"></i><span class="hide-menu">地址分配管理</span></span></a></li>
                            <li><a href="javascript:void(0)" class="waves-effect"><i class="ti-info-alt fa-fw"></i><span class="hide-menu">地址使用情况管理</span></span></a></li>
                            <li><a href="javascript:void(0)"><i class="fa-fw">维</i> <span class="hide-menu">系统维护</span></a></li>
                            <li><a href="javascript:void(0)"><i class="fa-fw">管</i> <span class="hide-menu">日志管理</span></a></li>
                        </ul>
                    </li>
                    <li><a href="javascript:void(0)" class="waves-effect"><i class="mdi mdi-apps fa-fw"></i> <span class="hide-menu">网络流量统计<span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="tableswitchsnmp.jsp"><i class="fa-fw">X</i><span class="hide-menu">需采集设备</span></a></li>
                            <li><a href="tabledataflow.jsp"><i class="fa-fw">D</i><span class="hide-menu">流量数据</span></a></li>
                        </ul>
                    </li>
                    
                    <li> <a href="javascript:void(0)" class="waves-effect"><i class="mdi mdi-clipboard-text fa-fw"></i> <span class="hide-menu">网络设备信息管理<span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="javascript:void(0)"  class="waves-effect"><i class="fa-fw">S</i><span class="hide-menu">设备信息管理</span><span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li> <a href="tablejfb.jsp"><i class=" fa-fw">J</i><span class="hide-menu">机房</span></a> </li>
                                    <li> <a href="tablejgb.jsp"><i class=" fa-fw">J</i><span class="hide-menu">机柜</span></a> </li>
                                    <li> <a href="tablesblxb.jsp"><i class=" fa-fw">S</i><span class="hide-menu">设备类型</span></a> </li>
                                    <li> <a href="tablesbztb.jsp"><i class=" fa-fw">S</i><span class="hide-menu">设备状态</span></a> </li>
                                    <li> <a href="tablecqb.jsp"><i class=" fa-fw">C</i><span class="hide-menu">产权</span></a> </li>
                                    <li> <a href="tablesbsylxb.jsp"><i class=" fa-fw">S</i><span class="hide-menu">设备使用类型</span></a> </li>
                                    <li> <a href="tablesbxxb.jsp"><i class=" fa-fw">S</i><span class="hide-menu">设备信息</span></a> </li>
                                    <li> <a href="tablekhxxb.jsp"><i class=" fa-fw">K</i><span class="hide-menu">客户信息</span></a> </li>
                                    <li> <a href="tablejhjdkzyb.jsp"><i class=" fa-fw">J</i><span class="hide-menu">交换机端口资源</span></a> </li>
                                </ul>
                            </li>
                            <li><a href="javascript:void(0)"><i class="fa-fw">L</i><span class="hide-menu">设备模块管理</span></a></li>
                            <li><a href="javascript:void(0)"><i class="fa-fw">A</i><span class="hide-menu">设备帐号管理</span></a></li>
                            <li><a href="javascript:void(0)"><i class="fa-fw">M</i><span class="hide-menu">设备测试信息管理</span></a></li>
                            <li><a href="javascript:void(0)"><i class="fa-fw">F</i><span class="hide-menu">设备配置信息管理</span></a></li>
                            <li><a href="javascript:void(0)"><i class="fa-fw">U</i><span class="hide-menu">设备运行管理</span></a></li>
                            <li><a href="javascript:void(0)"><i class="fa-fw">M</i><span class="hide-menu">设备维护日志管理</span></a></li>
                        </ul>
                    </li>
                    <li> <a href="javascript:void(0)" class="waves-effect"><i class="mdi mdi-table fa-fw"></i> <span class="hide-menu">网络监控<span class="fa arrow"></span><span class="label label-rouded label-danger pull-right">9</span></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="netlatency.jsp"><i class="fa-fw">W</i><span class="hide-menu">网络时延</span></a></li>
                            <li><a href="javascript:void(0)"><i class="fa-fw">N</i><span class="hide-menu">内存告警信息</span></a></li>
                            <li><a href="javascript:void(0)"><i class="fa-fw">C</i><span class="hide-menu">CPU告警信息</span></a></li>
                        </ul>
                    </li>
                    <li> <a href="javascript:void(0)" class="waves-effect"><i class="mdi mdi-chart-bar fa-fw"></i> <span class="hide-menu">网络设备运维<span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level">
                            <li> <a href="javascript:void(0)"><i class="fa-fw">F</i><span class="hide-menu">综合监控子系统</span></a> </li>
                            <li><a href="javascript:void(0)"><i class="fa-fw">M</i><span class="hide-menu">设备管理子系统</span></a></li>
                            <li><a href="javascript:void(0)"><i class="fa-fw">P</i><span class="hide-menu">设备运行子系统</span></a></li>
                            <li><a href="javascript:void(0)"><i class="fa-fw">P</i><span class="hide-menu">流程管理子系统</span></a></li>
                            <li><a href="javascript:void(0)"><i class="fa-fw">C</i><span class="hide-menu">工单管理子系统</span></a></li>
                        </ul>
                    </li>
                    <li class="devider"></li>
                    <li> <a href="javascript:void(0)" class="waves-effect"><i  class="mdi mdi-settings fa-fw"></i> <span class="hide-menu">设置</span></a> </li>
                    <li><a href="javascript:void(0)" class="waves-effect"><i class="mdi mdi-logout fa-fw"></i> <span class="hide-menu">注销</span></a></li>
                    <li class="devider"></li>
                    <li><a href="guide.jsp" class="waves-effect"><i class="fa fa-circle-o text-success"></i> <span class="hide-menu">使用指南</span></a></li>
                </ul>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- End Left Sidebar -->
        <!-- ============================================================== -->
