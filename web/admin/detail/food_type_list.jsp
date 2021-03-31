<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
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
            <img border="0" width="13" height="13"
                 src="${ctx}/static/admin/images/title_arrow.gif" /> 菜系列表
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>
<!-- 过滤条件 -->
<div id="QueryArea">
    <form action="${ctx}/typeController" method="get">
        <input type="hidden" name="op" value="list">
        &nbsp;&nbsp;菜系名称: <input type="text" name="typeName" placeholder="请输入菜系名称" title="请输入菜系名称">
        <input type="submit" value="搜索">
    </form>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <td>菜系编号</td>
            <td>菜系名称</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="TableData" align="center">
            <c:forEach var="item" items="${foodTypes}" varStatus="status">
                <tr class="TableDetail1">
                    <td>${status.index+1}</td>
                    <td>${item.type_name}</td>
                    <td>
                        <a href="${ctx}/typeController?op=goto_update&typeId=${item.type_id}" class="FunctionButton">更新</a>
                        <a href="${ctx}/typeController?op=delete&typeId=${item.type_id}" class="FunctionButton">删除</a>
                    </td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
    <!-- 其他功能超链接 -->
    <div id="TableTail" align="center">
        <div class="FunctionButton">
            <a href="${ctx}/typeController?op=goto_add">添加</a>
        </div>
    </div>
</div>
</body>
</html>

