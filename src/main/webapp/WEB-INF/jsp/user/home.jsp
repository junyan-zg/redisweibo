<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
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
<div id="postform">
<form method="POST" action="post">
${user.username}, 有啥感想?
<br>
<table>
<tr><td><textarea cols="70" rows="3" name="content"></textarea></td></tr>
<tr><td align="right"><input type="submit" name="doit" value="Update"></td></tr>
</table>
</form>
<div id="homeinfobox">
0 粉丝<br>
0 关注<br>
</div>
</div>
<div class="post">
<a class="username" href="toProfile">test</a> hello<br>
<i>11 分钟前 通过 web发布</i>
</div>

<div id="footer">redis版本的仿微博项目 <a href="http://redis.io">Redis key-value database</a></div>
</div>
</body>
</html>
