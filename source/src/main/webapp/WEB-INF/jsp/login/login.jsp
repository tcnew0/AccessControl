<%--
  Created by IntelliJ IDEA.
  User: zhaozb
  Date: 14-6-3
  Time: 下午10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" href="../../../images/icon/logo.png"/>
    <link rel="stylesheet" href="../../../css/signin.css"/>
    <link rel="stylesheet" href="../../../plug/bootstrap/css/bootstrap.min.css"/>
    <title></title>
</head>
<body>
    <div class="container">
        <form class="form-signin" action="/login/login.do">
            <h2 class="form-signin-heading">请登录</h2>
            <input class="form-control" type="text" autofocus="" required="" placeholder="Email address"/>
            <input class="form-control" type="password" required="" placeholder="Password"/>
            <label class="checkbox">
                <input type="checkbox" value="remember-me"/>
                记住我
            </label>
            <button class="btn btn-lg btn-primary btn-block" type="submit">
                登录
            </button>
        </form>
    </div>
</body>
</html>
