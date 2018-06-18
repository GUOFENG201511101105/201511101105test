<%@ page language="java" import="java.util.*,info.*"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

<title>My JSP 'infoListBySTAG.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<base href="<%=basePath%>">
<script src="<%=basePath%>scripts/xheditor/jquery-1.4.2.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>scripts/xheditor/xheditor-zh-cn.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
		$(document).ready(function(){
			//初始化xhEditor编辑器插件
			$('#info.contents').xheditor({
				tools:'full',
				skin:'default',
				upMultiple:false,
				upImgUrl: "<%=basePath %>servlet/UploadFileServlet",
				upImgExt: "jpg,jpeg,gif,bmp,png",
				upLinkUrl: "<%=basePath %>servlet/UploadFileServlet",
				upLinkExt:"doc,txt,pdf,xls,ppt,rar,zip",
				onUpload:insertUpload
			});
			//xbhEditor编辑器图片上传回调函数
			function insertUpload(msg) {
				var _msg = msg.toString();
				var _picture_name = _msg.substring(_msg.lastIndexOf("/")+1);
				var _picture_path = Substring(_msg);
				var _str = "<input type='checkbox' name='_pictures' value='"+_picture_path+"' checked='checked' onclick='return false'/><label>"+_picture_name+"</label><br/>";
				$("#contents").append(_msg);
				$("#uploadList").append(_str);
			}
			//处理服务器返回到回调函数的字符串内容,格式是JSON的数据格式.
			function Substring(s){
				return s.substring(s.substring(0,s.lastIndexOf("/")).lastIndexOf("/"),s.length);
			}
		});
		</script>
<script type="text/javascript" language="javasript">
	function updateInfo(form) {
		// $("#update").submit();
		form.action = "<%=basePath %>infoUpdate/infoAction!updateInfo.action";
		form.submit();

		return false;
	}
</script>
</head>

<body>
	<s:form id="update" theme="simple" method="post">
		<table align="left" style="border: #005892 0px solid; width: 500">
			<tr>
				<td colspan="3">信息名称：&nbsp;&nbsp; <input type="hidden"
					name="info.id" value="${requestScope.info.id}"></input> <input
					type="text" name="info.title" value="${requestScope.info.title}"
					maxlength="60"></input>
				</td>
			</tr>
			<tr>
				<td colspan="3">信息内容：&nbsp;&nbsp; <textarea id="info.contents"
						name="info.contents" rows="25" form="update"
						style="width: 100%; border: 1px">${requestScope.info.contents}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="3">信息发布时间： <input type="text" name="info.ts"
					id="info.ts" value="${requestScope.info.ts}" maxlength="30"></input>
				</td>
			</tr>
			<tr>
				<td height="20" align="left" valign="middle" colspan="3"><s:submit
						value="修改" theme="simple" onclick="return updateInfo(this.form);">
					</s:submit> &nbsp;&nbsp;&nbsp; <input type="button" name="back"
					onclick="javascript:history.back()" value="返回" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
