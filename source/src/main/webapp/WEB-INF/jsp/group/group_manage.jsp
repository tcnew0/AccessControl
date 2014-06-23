<%--
  Created by IntelliJ IDEA.
  User: guanzhenxing
  Date: 2014-06-10
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../index/header.jsp"%>
<html>
<head>
    <script type="text/javascript" src="${contextPath}/javascript/myJS/groupMng.js"></script>
    <title>部门管理</title>
</head>
<body>
<div>
    <div class="page-header">
        <h1>部门管理</h1>
        <%--<small>&nbsp;部门信息维护</small>--%>
        <div class="text-right">
            <button type="button" class="btn btn-default " id="group_add_btn">
                <span class="glyphicon glyphicon-plus"></span>&nbsp;新增
            </button>
            <button type="button" class="btn btn-default ">
                <span class="glyphicon glyphicon-floppy-remove"></span>&nbsp;删除
            </button>
        </div>
    </div>

    <div class="panel panel-info">
        <div class="panel-heading">
            部门信息维护
        </div>
        <div class="panel-body" style="padding-bottom: 0">
            <p>注意：部门管理主要是对部门信息进行维护，增加、修改、删除等。</p>
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
            <tr class="active">
                <th><input type="checkbox" id="chk_all">&nbsp;全选</th>
                <th>部门编号</th>
                <th>部门名称</th>
                <th>负责人</th>
                <th>联系方式</th>
                <th>操作</th>
            </tr>
            <tbody>
            <tr>
                <td><input type="checkbox" ></td>
                <td>y1</td>
                <td>研发一部</td>
                <td>hhb</td>
                <td>123</td>
                <td><a>Add</a></td>
            </tr>
            <tr>
                <td><input type="checkbox" ></td>
                <td>y1</td>
                <td>研发一部</td>
                <td>hhb</td>
                <td>123</td>
                <td><a>Add</a></td>
            </tr>
            <tr>
                <td><input type="checkbox" ></td>
                <td>y1</td>
                <td>研发一部</td>
                <td>hhb</td>
                <td>123</td>
                <td><a>Add</a></td>
            </tr>
            <tr>
                <td><input type="checkbox"></td>
                <td>y1</td>
                <td>研发一部</td>
                <td>hhb</td>
                <td>123</td>
                <td><a onclick="parent.test()">Add</a></td>
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

<!-- dialog -->
<div id="group_add_view" title="新建部门">
    <p class="validateTips">所有选项必填。</p>
    <form class="form-horizontal" role="form">
    <%--<fieldset>--%>
        <%--<label for="grpNum">部门编号</label>--%>
        <%--<input type="text" name="grpNum" id="grpNum" class="text ui-widget-content ui-corner-all"><br>--%>
        <%--<label for="grpName">部门名称</label>--%>
        <%--<input type="text" name="grpName" id="grpName" class="text ui-widget-content ui-corner-all"><br>--%>
        <%--<label for="description">描&nbsp;&nbsp;&nbsp;&nbsp;述</label>--%>
        <%--<textarea name="description" id="description" class="ui-widget-content ui-corner-all">--%>
        <%--</textarea>--%>
    <%--</fieldset>--%>
        <div class="form-group">
            <label for="grpNum" class="col-sm-2 control-label">部门编号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="grpNum" name="grpNum" placeholder="部门编号">
            </div>
        </div>

        <div class="form-group">
            <label for="grpName" class="col-sm-2 control-label">部门名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="grpName" name="grpName" placeholder="部门名称">
            </div>
        </div>

        <div class="form-group">
            <label for="description" class="col-sm-2 control-label">部门描述</label>
            <div class="col-sm-10">
                <textarea id="description" style="resize: none;" name="description" class="form-control" rows="3" placeholder="部门描述"></textarea>
            </div>
        </div>
    </form>
</div>
</body>
</html>
