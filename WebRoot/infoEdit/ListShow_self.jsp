<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="MyFontTagLib" prefix="mytag"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">s
	-->
</head>

<body>
	<mytag:myfont color="red" border="8" bgColor="white"
		tableName="product">
	</mytag:myfont>
	</br>------------
	</br>
	<mytag:myfont color="Black" border="3" bgColor="white"
		tableName="category">
	</mytag:myfont>
</body>
</html>




