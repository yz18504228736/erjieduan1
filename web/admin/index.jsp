<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>餐馆王后台管理</title>
    <script type="text/javascript">
        function adminPage(url) {
            console.log(url)
            document.getElementById('rightFrame').src=url;
        }
    </script>
</head>
<frameset rows="100px,*,19px" framespacing="0" border="0" frameborder="0">
    <frame src="admin/detail/top.jsp" scrolling="no" noresize />
    <frameset cols="178px,*">
        <frame noresize src="admin/detail/left.jsp" scrolling="yes" />
        <frame id="rightFrame" noresize name="right" src="admin/detail/right.jsp" scrolling="yes" />
    </frameset>
    <frame noresize name="status_bar" scrolling="no" src="admin/detail/bottom.jsp" />
</frameset>
<noframes>
    <body>
    你的浏览器不支持框架布局，推荐你使用<a href="http://www.firefox.com.cn/download/" style="text-decoration: none;">火狐浏览器</a>,
    <a href="http://www.google.cn/intl/zh-CN/chrome/" style="text-decoration: none;">谷歌浏览器</a>
    </body>
</noframes>
</html>
