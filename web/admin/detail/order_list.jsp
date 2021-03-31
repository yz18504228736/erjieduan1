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
                 src="${ctx}/static/admin/images/title_arrow.gif" /> 餐厅订单列表
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
            <td>订单编号</td>
            <td>餐桌名</td>
            <td>下单日期</td>
            <td>总金额</td>
            <td>状态</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="TableData">
        <c:forEach var="item" items="${orderList}">
            <tr height="60">
                <td>${item.order_id}</td>
                <td>
                    <c:forEach var="table" items="${tableList}">
                        <c:if test="${table.table_id == item.table_id}">
                            ${table.table_name}
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <fmt:formatDate value="${item.order_create_time}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                </td>
                <td>${item.order_total_price}</td>
                <td>
                    <c:if test="${item.order_status == 1}">
                        已结账
                    </c:if>
                    <c:if test="${item.order_status == 0}">
                        未结账
                    </c:if>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td>
                    <a href="${ctx}/orderController?op=order_detail&orderId=${item.order_id}" class="FunctionButton">详细</a>
                    <a href="${ctx}/orderController?op=update&orderId=${item.order_id}&orderStatus=1" class="FunctionButton">结账</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <span style="color: red">${msg}</span>
    <!-- 其他功能超链接 -->
    <div id="TableTail" align="center">
    </div>
</div>
</body>
</html>
