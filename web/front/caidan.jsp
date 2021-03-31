<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <!-- 包含公共的JSP代码片段 -->
    <title>餐馆王平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${ctx}/static/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/page_common.js"></script>
    <link href="${ctx}/static/css/common_style_blue.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/index_1.css" />
    <link href="${ctx}/static/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body style="text-align: center">
<div id="all">
    <div id="menu">
        <!-- 显示菜品的div -->
        <div id="top">
            <ul>
                <!-- 循环列出餐品 -->
                <c:forEach var="item" items="${allFoods.pageDatas}">
                <li>
                    <dl>
                        <dt>
                            <a href="${ctx}/foodController?op=food_detail&foodId=${item.food_id}&typeId=${typeId}&tableId=${tableId}">
                                <img width="214px" height="145px" src="${ctx}/${item.food_image}" />
                            </a>
                        </dt>
                        <dd class="f1">
                            <a href="${ctx}/foodController?op=food_detail&foodId=${item.food_id}&typeId=${typeId}&tableId=${tableId}" >${item.food_name}</a>
                        </dd>
                        <dd class="f2">
                            <c:if test="${sessionScope.user.is_member == 1}">
                                <a href="${ctx}/foodController?op=food_detail&foodId=${item.food_id}&typeId=${typeId}&tableId=${tableId}">&yen; ${item.food_mprice}（会员价）</a>
                            </c:if>
                            <c:if test="${sessionScope.user.is_member == 0}">
                                <a href="${ctx}/foodController?op=food_detail&foodId=${item.food_id}&typeId=${typeId}&tableId=${tableId}">&yen; ${item.food_price}</a>
                            </c:if>
                        </dd>
                    </dl>
                </li>
                </c:forEach>
            </ul>
        </div>
        <!-- 底部分页导航条div -->
        <div id="foot">
            <span
                    style="float:left; line-height:53PX; margin-left:-50px; font-weight:bold; ">
                <span style="font-weight:bold"><c:if test="${allFoods.pageNum != 1}" ><a
                        href="${ctx}/foodController?op=page_list&pageNum=${allFoods.pageNum-1}&typeId=${typeId}&tableId=${tableId}"
                        style=" text-decoration:none;color:#000000; font-weight:bold">&gt;&gt;</a></c:if>
                </span>
            </span>
            <div id="btn">
                <ul>
                    <!-- 参看 百度, 谷歌是 左 5 右 4 -->
                    <c:forEach begin="1" end="${allFoods.totalPages}" step="1" varStatus="status">
                        <li><a href="${ctx}/foodController?op=page_list&pageNum=${status.index}&typeId=${typeId}&tableId=${tableId}" <c:if test="${allFoods.pageNum == (status.index)}">style="background: #E01417;border-radius: 50%" </c:if>>${status.index}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <span style="float:right; line-height:53px; margin-right:10px;  ">
                <c:if test="${allFoods.pageNum < allFoods.totalPages}" ><a
                                    href="${ctx}/foodController?op=page_list&pageNum=${allFoods.pageNum+1}&typeId=${typeId}&tableId=${tableId}"
                                    style=" text-decoration:none;color:#000000; font-weight:bold">&gt;&gt;</a></c:if>
						</span>



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

