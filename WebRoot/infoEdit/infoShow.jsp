<%@ page language="java" import="java.util.*,info.*"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'infoShow.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
添加成功；显示添加信息。</br>
	<%
		Info info = (Info) request.getAttribute("info");
	%>
	标题：<%=  info.getTitle()%>
	</br>
	添加时间：<%=info.getTime()%>
	</br>
	编辑：<%=info.getEditor()%>
	</br>
	内容：<%=info.getContents()%>
	request.setAttribute('info1',info)
	</br>
	<a href='infoEdit/infoShowBySTAG.jsp'><font size="30">修改</font></a> 
	</br>
	<a href='infoEdit/infoQuery.jsp'><font size="30">增加</font></a> 
	</br>
	<a href='infoEdit/infoDelete.jsp'><font size="30">删除</font></a> 
	</br>
	<a href="<%=basePath%>/servlet/InfoPageServlet_display"><font size="30">点击通过数据库查询display显示</font></a>
	
</body>
</html>
