<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC >
<html>
<head>
    <!-- 包含公共的JSP代码片段 -->

    <title>餐馆王平台</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${ctx}/static/admin/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/static/admin/js/page_common.js"></script>
    <link href="${ctx}/static/admin/css/common_style_blue.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/admin/css/index_1.css" />
    <script type="text/javascript">
        setInterval(function(){
            window.location.href = "${ctx}/orderController?op=list";
        },1000 * 50);
    </script>
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
    <div id="TitleArea_Head"></div>
    <div id="TitleArea_Title">
        <div id="TitleArea_Title_Content">
            <img border="0" width="13" height="13"
                 src="${ctx}/static/admin/images/title_arrow.gif" /> 餐厅订单详情列表
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <td>菜名</td>
            <td>小计</td>
            <td>数量</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="TableData">
        <c:forEach var="item" items="${orderDetailList}">
        <tr height="60">
            <td>
                <c:forEach items="${allFoods}" var="food">
                    <c:if test="${item.food_id == food.food_id}">
                        ${food.food_name}
                    </c:if>
                </c:forEach>
            </td>
            <td>${item.food_total_price}</td>
            <td>${item.num}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- 其他功能超链接 -->
    <div id="TableTail" align="center">
        <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
    </div>
</div>
</body>
</html>
