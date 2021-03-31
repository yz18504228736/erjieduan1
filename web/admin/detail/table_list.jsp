<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="${pageContext.request.contextPath}" var="ctx"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <!-- 包含公共的JSP代码片段 -->

    <title>餐馆王平台</title>



    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${ctx}/static/admin/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/static/admin/js/page_common.js"></script>
    <link href="${ctx}/static/admin/css/common_style_blue.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/admin/css/index_1.css" />
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
    <div id="TitleArea_Head"></div>
    <div id="TitleArea_Title">
        <div id="TitleArea_Title_Content">
            <img border="0" width="13" height="13" src="${ctx}/static/admin/images/title_arrow.gif"/> 餐桌列表
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>


<!-- 过滤条件 -->
<div id="QueryArea">
    <form action="${ctx}/tableController" method="get">
        <input type="hidden" name="op" value="list">
        <input type="text" name="tableName" title="请输入餐桌名称">
        <input type="submit" value="搜索">
    </form>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <td>编号</td>
            <td>桌名</td>
            <td>状态</td>
            <td>预定时间</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="TableData">
            <c:forEach var="item" items="${dinnerTables}" varStatus="status">
                <tr class="TableDetail1">
                    <td align="center">${status.index + 1}&nbsp;</td>
                    <td align="center"> ${item.table_name}&nbsp;</td>
                    <td align="center">
                        <c:if test="${item.table_status == 0}">
                            空闲
                        </c:if>
                        <c:if test="${item.table_status == 1}">
                            预订
                        </c:if>
                    </td>
                    <td align="center">${item.reservation_time}</td>
                    <td>
                        <c:if test="${item.table_status == 1}"><a href="${ctx}/tableController?op=update&tableId=${item.table_id}&tableStatus=0" class="FunctionButton">退桌</a></c:if>
                        <c:if test="${item.table_status == 0}"><a href="${ctx}/tableController?op=delete&tableId=${item.table_id}" class="FunctionButton">删除</a></c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- 其他功能超链接 -->
    <div id="TableTail" align="center">
        <div class="FunctionButton"><a href="${ctx}/tableController?op=goto_add">添加</a></div>
    </div>
</div>
</body>
</html>

