<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <!-- 包含公共的JSP代码片段 -->

    <title>餐馆王平台</title>



    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${ctx}/static/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/page_common.js"></script>
    <link href="${ctx}/static/css/common_style_blue.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/index_1.css" />
    <link href="${ctx}/static/css/index.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/dis_message.css" />
</head>
<body style="text-align: center">
<div id="all">
    <!--左边菜品详细信息 -->
    <div id="menu1">
        <div class="menu2" style="text-align:center;">
            <img src="${ctx}/static/images/order_detials_bg.png" />
        </div>
        <div class="menu3">
            <div class="menu3_left">
                <img src="${ctx}/${food.food_image}"
                     style="width:270px; height:290px;" />
            </div>
            <div class="menu3_right">
                <p>菜名:${food.food_name}</p>
                <c:if test="${sessionScope.user.is_member == 1}"><p>价格:${food.food_mprice}（会员价）</p></c:if>
                <c:if test="${sessionScope.user.is_member == 0}"><p>价格:${food.food_price}</p></c:if>
                <p>简介:${food.food_desc}</p>
            </div>
        </div>
        <div class="menu4">

            <a href="${ctx}/foodController?op=cart&foodId=${food.food_id}&tableId=${tableId}&typeId=${typeId}" style="background:url(${ctx}/static/images/img/order_left_corner_bg.png);">放入餐车</a>
            <a href="#" onclick="javascript:history.go(-1);" style="background:url(${ctx}/static/images/img/order_right_corner_bg.png);">返回</a>
        </div>
    </div>

    <!-- 右边菜系列表，菜品搜索框  -->
    <div id="dish_class">
        <div id="dish_top">
            <ul>
                <li class="dish_num"></li>
                <li>
                    <a href="${ctx}/orderController?op=save_order&typeId=${typeId}&tableId=${tableId}">
                        <img src="${ctx}/static/images/call2.gif" />
                    </a>
                </li>
            </ul>
        </div>

        <div id="dish_2">
            <ul>
                <c:forEach var="item" items="${allTypes}">
                    <li>
                        <a href="${ctx}/foodController?op=page_list&tableId=${tableId}&pageNum=1&typeId=${item.type_id}">${item.type_name}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div id="dish_3">
            <!-- 搜索菜品表单  -->
            <form action="${ctx}/foodController?op=page_list&tableId=${tableId}&pageNum=1&typeId=${typeId}" method="post">
                <table width="166px">
                    <tr>
                        <td>
                            <input type="text" id="dish_name" name="foodName" class="select_value" />
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" id="sub" value="" /></td>
                    </tr>
                    <tr>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>

