<%--
  Created by IntelliJ IDEA.
  User: guanzhenxing
  Date: 2014-06-09
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单权限管理</title>
    <link rel="shortcut icon" href="../../../images/icon/logo.png"/>
    <link rel="stylesheet" href="../../../plug/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../../css/main.css"/>
    <script type="text/javascript" src="../../../javascript/jquery/1.11.1/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="../../../plug/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../../javascript/myJS/main.js"></script>
</head>
<body>
<!-- head -->
<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">首页</a>
        </div>

        <!-- center -->
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="">主菜单</a></li>
                <li><a href="/group/manage">部门管理</a></li>
                <li><a href="#">人员管理</a></li>
                <li><a href="#">角色管理</a></li>
                <li><a href="#">菜单管理</a></li>
                <li><a href="#">操作管理</a></li>
                <li><a href="#">流程管理</a></li>
            </ul>

            <!-- right -->
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">test</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">设置<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">修改密码</a></li>
                        <li><a href="#">切换用户</a></li>
                        <li class="divider"></li>
                        <li><a href="#">退出</a></li>
                    </ul>
                </li>
                <li><a href="#">zhaozb</a></li>
            </ul>

        </div>
    </div>
</nav>

<!-- body -->
<div class="container">
    <div class="row row-offcanvas row-offcanvas-right">
        <%--<iframe src="/index/frame" frameborder="0"></iframe>--%>
        <%@include file="frame.jsp"  %>
        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
            <div class="list-group">
                <a href="#" class="list-group-item active">历史记录</a>
                <a href="#" class="list-group-item">历史记录1</a>
                <a href="#" class="list-group-item">历史记录2</a>
                <a href="#" class="list-group-item">历史记录3</a>
                <a href="#" class="list-group-item">历史记录4</a>
                <a href="#" class="list-group-item">历史记录5</a>
                <a href="#" class="list-group-item">历史记录6</a>
                <a href="#" class="list-group-item">历史记录7</a>
                <a href="#" class="list-group-item">历史记录8</a>
            </div>
        </div>

    </div>

    <hr>
    <footer>
        <p>© CopyRight by zhaozb at 2014</p>
    </footer>
</div>
</body>
</html>
