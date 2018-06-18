<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script src="<%=basePath%>scripts/xheditor/jquery-1.4.2.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>scripts/xheditor/xheditor-zh-cn.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//初始化xhEditor编辑器插件
		$('#xh_editor').xheditor({
			tools : 'simple',
			skin : 'default',
			upMultiple : false,
			upImgUrl : "<%=basePath %>servlet/UploadFileServlet",
			upImgExt : "jpg,jpeg,gif,bmp,png",
			upLinkUrl : "<%=basePath %>servlet/UploadFileServlet",
			upLinkExt : "doc,txt,pdf,xls,ppt,rar,zip",
			onUpload : insertUpload
		});
		//xbhEditor编辑器图片上传回调函数
		function insertUpload(msg) {
			var _msg = msg.toString();
			var _picture_name = _msg.substring(_msg.lastIndexOf("/") + 1);
			var _picture_path = Substring(_msg);
			var _str = "<input type='checkbox' name='_pictures' value='" + _picture_path + "' checked='checked' onclick='return false'/><label>" + _picture_name + "</label><br/>";
			$("#xh_editor").append(_msg);
			$("#uploadList").append(_str);
		}
		//处理服务器返回到回调函数的字符串内容,格式是JSON的数据格式.
		function Substring(s) {
			return s.substring(s.substring(0, s.lastIndexOf("/")).lastIndexOf("/"), s.length);
		}
	});
</script>

</head>

<body>
	<form action="infoEdit/infoActionAdd.action" method="post">
		信息名称：<input name="title" type="text"><BR> 信息内容：
		<textarea id="xh_editor" name="contents" rows="25"
			style="width: 100%; border: 1px"></textarea>
		编辑：<input name="editor" type="text"><BR> <input
			type="submit" value="发布">
	</form>
</body>
</html>
