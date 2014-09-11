<%--
  Created by IntelliJ IDEA.
  User: guanzhenxing
  Date: 2014-09-10
  Time: 17:27
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
        <th>操作编号</th>
        <th>操作名称</th>
        <th>描述</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="op" items="${ops.content}">
        <tr >
            <td><input type="checkbox" data="${op.id}"></td>
            <td>${op.opNum}</td>
            <td>${op.opName}</td>
            <td>${op.description}</td>
            <td><a op-type="view" mdata='${op}'>查看</a>&nbsp;&nbsp;
                <a op-type="modify" mdata='${op}'>修改</a></td>
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
                <li><a href="searchJson?curPage=${page.cur-1}&opNum=${opNum}&opName=${opName}">&laquo;</a></li>
            </c:otherwise>
            </c:choose>

            <c:forEach var="pos" begin="${page.start}" end="${page.last}" varStatus="status">
                <li <c:if test="${page.cur == pos}"> class="active" </c:if>> <a href="searchJson?curPage=${pos}&opNum=${opNum}&opName=${opName}" >${pos}</a></li>
            </c:forEach>

            <c:choose>
                <c:when test="${page.cur == page.totalPages}">
                    <li><a>&raquo;</a></li>
                </c:when><c:otherwise>
                <li><a href="searchJson?curPage=${page.cur+1}&opNum=${opNum}&opName=${opName}">&raquo;</a></li>
            </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>
</div>
</body>
<script type="text/javascript" src="${contextPath}/javascript/myJS/operator/operator_detail.js"></script>
</html>
