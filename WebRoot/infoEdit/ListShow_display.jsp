<%@ page language="java" import="java.util.*,info.*"
	pageEncoding="utf-8"%>
<%@ page import="org.displaytag.decorator.TotalTableDecorator"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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

<style type="text/css" media="all">
@import url("css/maven-base.css");

@import url("css/maven-theme.css");

@import url("css/site.css");

@import url("css/screen.css");
</style>
</head>


<body>
	<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>
	<display:table name="requestScope.test" id="item" export="true"
		pagesize="10" requestURI="/servlet/InfoPageServlet_display">
			class="simple"> 	
			<display:column property="title" title="标题" sortable="true" />
		<display:column property="contents" title="内容" sortable="true"
			total="false" />

		<display:column property="editor" title="编辑" sortable="true" />
		<display:column property="time" title="时间" sortable="true" />

		<display:column title="操作">
			<a href="index.jsp"><img src="<%=basePath%>images/edit.gif"
				border="0">編輯</a>
		</display:column>
		<display:column title="操作">
			<a href="index.jsp"><img src="<%=basePath%>images/delete.gif"
				border="0">刪除</a>
		</display:column>
		<display:column title="操作">
			<a href="index.jsp?"><img src="<%=basePath%>images/upload.gif"
				border="0">上传</a>
		</display:column>
	</display:table>
	<a href="infoEdit/infoAdd.jsp"><font size="30">点击返回主页</font> </a>
</body>
</html>
