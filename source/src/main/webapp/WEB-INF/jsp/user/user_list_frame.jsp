<%--
  Created by IntelliJ IDEA.
  User: guanzhenxing
  Date: 2014-08-21
  Time: 14:36
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
        <th>账号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>出生日期</th>
        <th>电话</th>
        <th>是否可用</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users.content}">
        <tr >
            <td><input type="checkbox" data="${user.id}"></td>
            <td>${user.loginName}</td>
            <td>${user.name}</td>
            <td>
                <c:choose>
                    <c:when test="${user.sex == 'm'}">
                        男
                    </c:when>
                    <c:when test="${user.sex == 'f'}">
                        女
                    </c:when>
                    <c:otherwise>

                    </c:otherwise>
                </c:choose>
            </td>
            <td><fmt:formatDate value="${user.birthday}" type="date"/></td>
            <td>${user.phone}</td>
            <td>
                <c:choose>
                    <c:when test="${user.useFlag == true}">
                        可用
                    </c:when>
                    <c:otherwise>
                        不可用
                    </c:otherwise>
                </c:choose>
            </td>
            <td><a op-type="view" mdata='${user}'>查看</a>&nbsp;&nbsp;
                <a op-type="modify" mdata='${user}'>修改</a></td>
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
                <li><a href="searchJson?curPage=${page.cur-1}&login=${login}&name=${name}">&laquo;</a></li>
            </c:otherwise>
            </c:choose>

            <c:forEach var="pos" begin="${page.start}" end="${page.last}" varStatus="status">
                <li <c:if test="${page.cur == pos}"> class="active" </c:if>> <a href="searchJson?curPage=${pos}&login=${login}&name=${name}" >${pos}</a></li>
            </c:forEach>

            <c:choose>
                <c:when test="${page.cur == page.totalPages}">
                    <li><a>&raquo;</a></li>
                </c:when><c:otherwise>
                <li><a href="searchJson?curPage=${page.cur+1}&login=${login}&name=${name}">&raquo;</a></li>
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
<script type="text/javascript" src="${contextPath}/javascript/myJS/user/user_detail.js"></script>
</html>
