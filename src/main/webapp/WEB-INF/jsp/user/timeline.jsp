<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="it">
<head>
    <meta content="text/html; charset=UTF-8" http-equiv="content-type">
    <title>Retwis - Example Twitter clone based on the Redis Key-Value DB</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="page">
    <div id="header">
        <a href="/"><img style="border:none" src="../logo.png" width="192" height="85" alt="Retwis"></a>
        <div id="navbar">
            <a href="../index.jsp">主页</a>
            | <a href="toTimeline">热点</a>
            | <a href="logout.jsp">退出</a>
        </div>
    </div>
    <h2>热点</h2>
    <i>最新注册用户(redis中的sort用法)</i><br><br>
    <div>
        <c:forEach items="${newusers}" var="u">
        <a class="username" href="toProfile?username=${u}" style="margin-right: 15px;">${u}</a> </c:forEach></div>

    <br><i>最新的50条微博!</i><br>
    <div class="post">
        <a class="username" href="profile.jsp?u=test">test</a>
        world<br>
        <i>22 分钟前 通过 web发布</i>
    </div>

    <div class="post">
        <a class="username" href="profile.jsp?u=test">test</a>
        hello<br>
        <i>22 分钟前 通过 web发布</i>
    </div>

    <div id="footer">redis版本的仿微博项目 <a href="http://redis.io">Redis key-value database</a></div>
</div>
</body>
</html>
