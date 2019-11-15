<%--
  Created by IntelliJ IDEA.
  User: gyf
  Date: 2018/5/28
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
</head>
<body>

<h1>${sessionScope.user.username},欢迎来到主页面！</h1>
<h1><a href="${pageContext.request.contextPath}/items/list.do">点击跳转到商品展示页面</a></h1>
</body>
</html>
