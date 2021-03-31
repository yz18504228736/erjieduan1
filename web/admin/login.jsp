<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台登录</title>

<link href="${ctx}/static/admin/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
</script>

</head>
<body>


<div class="login" style="background: #f8f8f8">
    <div class="box png">
		<div class="logo png"></div>
		<div class="input">
			<div class="log">
				<form action="${ctx}/adminController?op=login" method="post">
					<div class="name">
						<label>用户名</label><input type="text" class="text" id="value_1" placeholder="用户名" name="name" tabindex="1">
					</div>
					<div class="pwd">
						<label>密　码</label><input type="password" class="text" id="value_2" placeholder="密码" name="password" tabindex="2">
						<input type="submit" class="submit" tabindex="3" value="登录">
						<div class="check"></div>
					</div>
				</form>	
				<div id="tishi" style="margin-left:100px;">
					<span style="color:red;">${login }</span>
				</div>
				<div class="tip"></div>
			</div>
		</div>
	</div>
    <div class="air-balloon ab-1 png"></div>
	<div class="air-balloon ab-2 png"></div>
</div>

<script type="text/javascript" src="${ctx}/static/admin/js/jquery.js"></script>


<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>
</body>
</html>