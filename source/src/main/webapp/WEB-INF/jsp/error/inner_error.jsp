<%--
  Created by IntelliJ IDEA.
  User: guanzhenxing
  Date: 2014-08-18
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../index/header.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>

<div class="panel panel-danger"  style="margin-top: 30px;">
    <div class="panel-heading">
        <h3 class="panel-title">错误信息</h3>
    </div>
    <div class="panel-body">
        <p>${exception}</p>
        <p>
            <a class="btn btn-danger" onclick="refresh()    " role="button">重试</a>
            <a class="btn btn-default"  onclick="toIndex()" role="button">返回首页</a>
        </p>
    </div>

</div>

</body>
</html>
