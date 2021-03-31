<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
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
        function openWin(){
            window.open('common_page_list.html');
            this.close();
        }
    </script>
</head>
<body>


<!-- 页面标题 -->
<div id="TitleArea">
    <div id="TitleArea_Head"></div>
    <div id="TitleArea_Title">
        <div id="TitleArea_Title_Content">
            <img border="0" width="13" height="13" src="${ctx}/static/admin/images/title_arrow.gif"/>  <c:if test="${type != null}">更新</c:if>
            <c:if test="${type == null}">添加</c:if>菜系
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <!-- 表单内容 -->
    <form action="${ctx}/typeController?op=type_save" method="post">
    <!-- 本段标题（分段标题） -->
    <div class="ItemBlock_Title">
        <img width="4" height="7" border="0" src="${ctx}/static/admin/images/item_point.gif"> 菜系信息&nbsp;
    </div>
    <!-- 本段表单字段 -->
    <div class="ItemBlockBorder">
        <div class="ItemBlock">
            <div class="ItemBlock2">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td width="80px">菜系名字</td>
                        <td><input type="text" name="typeName" value="${type.type_name}"class="InputStyle"/><input type="hidden" name="typeId" value="${type.type_id}" class="InputStyle"/>*</td>
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

