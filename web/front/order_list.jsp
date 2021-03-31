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
    <div id="menu">
        <!-- 餐车div -->
        <div id="count">
            <table align="center" width="100%">
                <tr height="40">
                    <td align="center" width="20%">菜名</td>
                    <td align="center" width="20%">单价</td>
                    <td align="center" width="20%">数量</td>
                    <td align="center" width="20%">小计</td>
                </tr>

                <c:forEach var="item" items="${sessionScope.cart}">
                    <tr height="60">
                        <td align="center" width="20%">${item.value.name}</td>
                        <td align="center" width="20%">￥${item.value.price}<input id="foodId" type="hidden" value="${item.key}" /></td>
                        <td align="center" width="20%">
                            ${item.value.num}
                        </td>
                        <td align="center" width="20%">￥${item.value.price * item.value.num}</td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="6" align="right">总计:
                        <span style="font-size:36px;">&yen;</span>
                        <label
                                id="counter" style="font-size:36px">${totalMoney}</label>
                    </td>
                </tr>
                <tr>
                    <td colspan="6" style="margin-left: 100px; text-align: center;"align="right">
                        <input type="hidden" name="bId" value="">
                        <input type="button" value="结账" class="btn_next" lang="" onclick="callPay(this)" />
                    </td>
                </tr>
            </table>
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
<script>
    function removeSorder(obj) {
        let val = $("#foodId").val();
        window.location.href = '${ctx}/foodController?op=remove_cart&foodId='+val+'&typeId=${typeId}&tableId=${tableId}'
    }
    function alterSorder(obj) {
        let val = $("#foodId").val();
        let num = $(obj).val();
        if (num < 1) {
            return ;
        }
        window.location.href = '${ctx}/foodController?op=change_cart&foodId='+val+'&typeId=${typeId}&tableId=${tableId}&num='+num;
    }
    function genernateOrder() {
        window.location.href = '${ctx}/orderController?op=save_order&typeId=${typeId}&tableId=${tableId}';
    }
    function callPay() {
        window.location.href="${ctx}/orderController?op=jiezhang&typeId=${typeId}&tableId=${tableId}&orderId=${orderId}"
    }
</script>
</body>
</html>
