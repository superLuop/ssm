<%--
  Created by IntelliJ IDEA.
  User: gyf
  Date: 2018/5/25
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加商品</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
    <script>
        function submitImage() {
            //封装请求数据
            var options = {
                type:'post',
                dataType:'json',
                url:'${pageContext.request.contextPath}/upload/itemspic.do',
                success:function (respData) {
                    $('#pic').attr('src',respData.imgUrl);
                    $('#hiddenPic').val(respData.imgUrl)
                }
            }

            //提交表单
            $('#itemsForm').ajaxSubmit(options)
        }
    </script>
</head>
<body>
<form id="itemsForm" action="${pageContext.request.contextPath}/items/save.do" method="post">
<table border="1">
    <tr>
        <td>名称</td>
        <td>
            <input type="text" name="name"></td>
    </tr>
    <tr>
        <td>价格</td>
        <td><input type="text" name="price"></td>
    </tr>
    <tr>
        <td>描述</td>
        <td><textarea cols="20" rows="5" name="detail"></textarea> </td>
    </tr>
    <tr>
        <td>图片</td>
        <td>
            <img id="pic" width="100px" height="100px">
            <input type="file" name="itemsPic" onchange="submitImage();">
            <input id="hiddenPic" type="hidden" name="pic" value="${items.pic}">
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="提交">
        </td>
    </tr>
</table>

</form>
</body>
</html>
