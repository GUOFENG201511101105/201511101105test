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

	<%
		// 可以改写成重数据库中取得数据显示
		List<Info> test = new ArrayList<Info>(6);

		for (int i = 0; i < 6; i++) {
			Info ui = new Info();
			ui.setTitle("titile"+i);
			ui.setContents("contents"+i);
			ui.setEditor("editor"+i);
			//ui.setTime("time"+i);
			test.add(ui);
		}

		// 本页中可以实现翻页，因为每次都会调用此段代码，如从数据库中取数据，则此方法翻页要多次访问数据库，不好的方法
		request.setAttribute("test", test);
	%>

	<display:table name="requestScope.test" id="item" export="true"
		pagesize="5">
			class="simple">
		<display:column property="title" title="标题" sortable="true" />
		<display:column property="contents" title="内容" sortable="true" />
		<display:column property="editor" title="编辑" />
		<display:column property="time" title="时间" />
		<display:column title="操作1">
			<a href="index.jsp"><img
				src="<%=basePath%>images/edit.gif" border="0">編輯</a>
		</display:column>
		<display:column title="操作2">
			<a href="index.jsp"><img
				src="<%=basePath%>images/delete.gif" border="0">刪除</a>
		</display:column>
		<display:column title="操作3">
			<a href="index.jsp"><img
				src="<%=basePath%>images/upload.gif" border="0">上传</a>
		</display:column>
	</display:table>
	<a href="<%=basePath%>/servlet/InfoPageServlet"><font size="30">点击通过数据库查询实现真分页</font></a>
</body>
</html>
