<%--
  Created by IntelliJ IDEA.
  User: guanzhenxing
  Date: 2014-06-10
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="<%=request.getContextPath()%>" var="contextPath" scope="session"/>
<html>
<head>
    <script type="text/javascript" language="JavaScript">
        // contextPath
        var contextPath = '${contextPath}';
    </script>

    <link rel="shortcut icon" href="../../../images/icon/logo.png"/>
    <link rel="stylesheet" href="${contextPath}/plug/bootstrap/css/bootstrap.min.css" media="screen"/>
    <%--<link rel="stylesheet" href="${contextPath}/plug/zTree_v3/css/demo.css"/>--%>
    <link rel="stylesheet" href="${contextPath}/plug/zTree_v3/css/zTreeStyle/zTreeStyle.css"/>
    <%--<link rel="stylesheet" href="${contextPath}/plug/jquery-ui/css/cupertino/jquery-ui-1.10.4.custom.css"/>--%>
    <link rel="stylesheet" href="${contextPath}/css/base.css"/>
    <script type="text/javascript" src="${contextPath}/javascript/jquery/1.11.1/jquery-1.11.1.js" charset="utf-8"></script>
    <%--<script type="text/javascript" src="${contextPath}/plug/jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>--%>
    <script type="text/javascript" src="${contextPath}/plug/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${contextPath}/plug/i18n/js/jquery.i18n.properties-1.0.9.js"></script>
    <script type="text/javascript" src="${contextPath}/plug/zTree_v3/js/jquery.ztree.core-3.5.min.js"></script>
    <script type="text/javascript" src="${contextPath}/plug/zTree_v3/js/jquery.ztree.excheck-3.5.min.js"></script>
    <script type="text/javascript" src="${contextPath}/javascript/myJS/Base.js"></script>
</head>
</html>
