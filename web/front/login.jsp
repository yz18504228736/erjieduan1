<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- 包含公共的JSP代码片段 -->
  <title>餐馆王平台</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type="text/javascript" src="${ctx}/static/js/jquery.js"></script>
  <script type="text/javascript" src="${ctx}/static/js/page_common.js"></script>
  <link href="${ctx}/static/css/common_style_blue.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" type="text/css" href="${ctx}/static/css/index_1.css" />
  <style type="text/css">
    * {
      margin: 0px;
      padding: 0px
    }
    #dish_2 a{
      text-decoration:none;
      font-size:36px;
      color:#000;
    }
    #dish_2 ul {
      list-style:none;
    }
    #dish_2 li{
      background:url(${ctx}/static/images/img/btn.gif);
      width:164px;
      height:47px;
      text-align:center;
      padding-top:5px;
    }
    #login-form {
      height: 400px;
      display: flex;
      align-items: center;
      justify-content: center;
    }
    #login-form input {
      height: 30px;border: 0.5px solid #ccc;border-radius: 5px;
    }
  </style>
</head>
<body style="text-align: center">
<!--外部的大层-->
<div class="index_all" style="text-align:center;">
  <!--上面的背景层-->
  <div>
    <img src="${ctx}/static/images/flower.gif" />
  </div>
  <!--中间层-->
  <div id="index_center">
      <h3>餐馆王平台登录</h3>
      <div id="login-form">
        <form action="${ctx}/userController?op=login" method="post">
          <input name="username" type="text" style="height: 30px;border: 0.5px solid #ccc;border-radius: 5px;"/>
          <input name="password" type="password" style="height: 30px;border: 0.5px solid #ccc;border-radius: 5px;"/>
          <input type="submit" value="登录" style="padding: 0 10px;height: 30px;border: 0.5px solid #ccc;border-radius: 5px;"/>
        </form><br/>
        <span style="color: red">${login}</span>
      </div>
  </div>

  <!--下面的背景层-->
  <div>
    <img src="${ctx}/static/images/flower.gif" />
  </div>
</div>
</body>
</html>
