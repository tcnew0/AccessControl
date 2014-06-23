<%--
  Created by IntelliJ IDEA.
  User: guanzhenxing
  Date: 2014-06-10
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../../../plug/bootstrap/css/bootstrap.min.css"/>
    <title>角色管理</title>
</head>
<body>
<div>
    <div class="page-header">
        <h1>角色管理</h1>
        <%--<small>&nbsp;角色信息维护</small>--%>
        <div class="text-right">
            <button type="button" class="btn btn-default ">
                <span class="glyphicon glyphicon-plus"></span>&nbsp;新增
            </button>
            <button type="button" class="btn btn-default ">
                <span class="glyphicon glyphicon-floppy-remove"></span>&nbsp;删除
            </button>
        </div>
    </div>

    <div class="panel panel-info">
        <div class="panel-heading">
            角色信息维护
        </div>
        <div class="panel-body" style="padding-bottom: 0">
            <p>注意：角色管理主要是对角色信息进行维护，增加、修改、删除等。</p>
            <div class="well well-lg">
                所有操作提示1s。
            </div>
            <hr style="margin: 0 0">
        </div>

        <!-- 搜索条件 -->
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="关键字">
            </div>
            <button type="submit" class="btn btn-default">搜索</button>
        </form>

        <table class="table">
            <tr>
                <th>角色编号</th>
                <th>角色名称</th>
                <th>负责人</th>
                <th>联系方式</th>
                <th>操作</th>
            </tr>
            <tbody>
            <tr>
                <td>y1</td>
                <td>研发一部</td>
                <td>hhb</td>
                <td>123</td>
                <td><a>Add</a></td>
            </tr>
            <tr>
                <td>y1</td>
                <td>研发一部</td>
                <td>hhb</td>
                <td>123</td>
                <td><a>Add</a></td>
            </tr>
            <tr>
                <td>y1</td>
                <td>研发一部</td>
                <td>hhb</td>
                <td>123</td>
                <td><a>Add</a></td>
            </tr>
            <tr>
                <td>y1</td>
                <td>研发一部</td>
                <td>hhb</td>
                <td>123</td>
                <td><a>Add</a></td>
            </tr>
            </tbody>
        </table>

        <div class="panel-footer">
            <%--<ul class="pager">--%>
                <%--<li class="previous"><a href="#">上一页</a></li>--%>
                <%--<li>--%>
                <div class="text-center">
                    <ul class="pagination" style="margin: 0 0;">
                        <li><a href="#">&laquo;</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">&raquo;</a></li>
                    </ul>
                </div>
                <%--</li>--%>
                <%--<li class="next"><a href="#">下一页</a></li>--%>
            <%--</ul>--%>
        </div>
    </div>


</div>
</body>
</html>
