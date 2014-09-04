<%--
  Created by IntelliJ IDEA.
  User: guanzhenxing
  Date: 2014-08-11
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../index/header.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>

<table class="table table-hover">
    <thead>
    <tr class="active">
        <th><input type="checkbox" class="chk_all">&nbsp;全选</th>
        <th>部门编号</th>
        <th>部门名称</th>
        <th>负责人</th>
        <th>联系方式</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="group" items="${groups.content}">
        <tr >
            <td><input type="checkbox" data="${group.id}"></td>
            <td>${group.groupNum}</td>
            <td>${group.groupName}</td>
            <td>hhb</td>
            <td>123</td>
            <td><a op-type="view" mdata='${group}'>查看</a>&nbsp;&nbsp;
                <a op-type="modify" mdata='${group}'>修改</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="panel-footer">
    <%--<ul class="pager">--%>
    <%--<li class="previous"><a href="#">上一页</a></li>--%>
    <%--<li>--%>

    <div class="text-center">
        <ul class="pagination" style="margin: 0 0;" >
            <li><a>${page.totalElements}条&nbsp;共${page.totalPages}页</a></li>
            <c:choose>
                <c:when test="${page.cur == 1}">
                    <li><a>&laquo;</a></li>
                </c:when><c:otherwise>
                <li><a href="searchJson?curPage=${page.cur-1}&groupNum=${groupNum}&groupName=${groupName}">&laquo;</a></li>
            </c:otherwise>
            </c:choose>

            <c:forEach var="pos" begin="${page.start}" end="${page.last}" varStatus="status">
                <li <c:if test="${page.cur == pos}"> class="active" </c:if>> <a href="searchJson?curPage=${pos}&groupNum=${groupNum}&groupName=${groupName}" >${pos}</a></li>
            </c:forEach>

            <c:choose>
                <c:when test="${page.cur == page.totalPages}">
                    <li><a>&raquo;</a></li>
                </c:when><c:otherwise>
                <li><a href="searchJson?curPage=${page.cur+1}&groupNum=${groupNum}&groupName=${groupName}">&raquo;</a></li>
            </c:otherwise>
            </c:choose>
        </ul>
    </div>

    <%--</li>--%>
    <%--<li class="next"><a href="#">下一页</a></li>--%>
    <%--</ul>--%>
</div>
</div>
</body>
<script type="text/javascript" src="${contextPath}/javascript/myJS/group/group_detail.js"></script>
</html>
