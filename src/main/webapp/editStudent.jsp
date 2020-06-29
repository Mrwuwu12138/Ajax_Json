<%--
  Created by IntelliJ IDEA.
  User: 吴健义
  Date: 2020/6/27
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="editServlet">
    <table align="center" width="60%" border="1">
        <tr align="center">
            <td>ID:<input type="text" name="id" value=<%=request.getParameter("id")%>></td>
        </tr>
        <tr align="center">
            <td>姓名:<input type="text" name="name" value=<%=request.getParameter("name")%>></td>
        </tr>
        <tr align="center">
            <td>年龄:<input type="text" name="age" value=<%=request.getParameter("age")%>></td>
        </tr>
        <tr align="center">
            <td>性别:<input type="text" name="sex" value=<%=request.getParameter("sex")%>></td>
        </tr>
        <tr align="center">
            <td><input type="submit" name="修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
