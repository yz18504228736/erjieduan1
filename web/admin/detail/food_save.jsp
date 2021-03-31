<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>

<!-- 页面标题 -->
<div id="TitleArea">
    <div id="TitleArea_Head"></div>
    <div id="TitleArea_Title">
        <div id="TitleArea_Title_Content">


            <img border="0" width="13" height="13" src="${ctx}/static/admin/images/title_arrow.gif"/>
            <c:if test="${food != null}">更新</c:if>
            <c:if test="${food == null}">添加</c:if>
            新菜品
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <!-- 表单内容 -->
    <form action="${ctx}/foodController" method="post" enctype="multipart/form-data">
        <!-- 本段标题（分段标题） -->
        <div class="ItemBlock_Title">
            <img width="4" height="7" border="0" src="${ctx}/static/admin/images/item_point.gif"> 菜品信息&nbsp;
        </div>
        <!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <div class="ItemBlock2">
                    <table cellpadding="0" cellspacing="0" class="mainForm">
                        <tr>
                            <td width="80px">菜系</td>
                            <td>
                                <select name="typeId" style="width:80px">
                                    <c:forEach var="item" items="${types}">
                                        <option value="${item.type_id}" <c:if test="${item.type_id == food.type_id}">selected</c:if>>${item.type_name}</option>
                                    </c:forEach>
                                </select>
                                *<input type="hidden" name="foodId" value="${food.food_id}" /><input type="hidden" name="op" value="food_save" /></td>
                        </tr>
                        <tr>
                            <td width="80px">菜名</td>
                            <td><input type="text" name="foodName" class="InputStyle" value="${food.food_name}"/> *</td>
                        </tr>
                        <tr>
                            <td>价格</td>
                            <td><input type="text" name="foodPrice" class="InputStyle" value="${food.food_price}"/> *</td>
                        </tr>
                        <tr>
                            <td>会员价格</td>
                            <td><input type="text" name="foodMPrice" class="InputStyle" value="${food.food_mprice}"/> *</td>
                        </tr>

                        <tr>
                            <td>简介</td>
                            <td><textarea name="foodDesc" class="TextareaStyle">${food.food_desc}</textarea></td>
                        </tr>
                        <tr>
                            <td width="80px">菜品图片</td>
                            <td>
                                <c:if test="${food.food_image != null}">
                                    <img style='max-width:68px;width:68px;width:expression(width>68?"68px":width "px");max-width: 68px;'
                                         src="${ctx}/${food.food_image}">
                                </c:if>

                                <input type="file" name="imageUrl"/> *
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <span style="color: red">${msg}</span>
        </div>


        <!-- 表单操作 -->
        <div id="InputDetailBar">

            <input type="submit" value="保存" class="FunctionButtonInput">

            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
    </form>
</div>
</body>
</html>

