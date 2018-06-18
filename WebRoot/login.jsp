<%@ page language="java" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<form action="/testStruts/front/login.action" method="post">
		请您输入账号：<input name="account" type="text"><BR> 请您输入密码：<input
			name="password" type="password"> <input type="submit"
			value="登录"> <input type="button" value="注册"> <a
			href="AddUser.jsp" type="button"> 添加</a>
	</form>
	<form action="/testStruts/gf/login.action" method="post">
		请您输入账号：<input name="account" type="text"><BR> 请您输入密码：<input
			name="password" type="password"> <input type="submit"
			value="登录">
	</form>
</body>
</html>
