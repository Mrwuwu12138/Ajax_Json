<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pojo.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: 吴健义
  Date: 2020/6/27
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%--<%
       Class.forName("oracle.jdbc.driver.OracleDriver");
       String url = "jdbc:oracle:thin:@localhost:1521:orcl";
       String name = "system";
       String password = "123456";
       Connection connection = DriverManager.getConnection(url, name, password);
       String sql = "select * from student";
       PreparedStatement statement = connection.prepareStatement(sql);
       ResultSet resultSet = statement.executeQuery();
       ArrayList<Student> list = new ArrayList();
       while (resultSet.next()){
           Student student = new Student();
           student.setId(resultSet.getInt("id"));
           student.setName(resultSet.getString("name"));
           student.setAge(resultSet.getInt("age"));
           student.setSex(resultSet.getString("sex"));
           list.add(student);
       }
       resultSet.close();
       connection.close();
   %>--%>
<table align="left" width="100%" border="2">
    <tr align="center">
        <td>ID</td>
        <td>名字</td>
        <td>年龄</td>
        <td>性别</td>
        <td>删除</td>
        <td>编辑</td>
    </tr>
    <%
        ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("list");
        for (Student student : list){
    %>
    <tr align="center">
        <td><%=student.getId()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getAge()%></td>
        <td><%=student.getSex()%></td>
        <td><a href="deleteServlet?id=<%=student.getId()%>">删除</a></td>
        <td><a href="editStudent.jsp?id=<%=student.getId()%>&name=<%=student.getName()%>&age=<%=student.getAge()%>&sex=<%=student.getSex()%>">编辑</a></td>
    </tr>
    <%
        }
    %>
    <tr>
        <td colspan="5" align="center">
            <a href="addStudent.jsp">添加</a>
        </td>
    </tr>
</table>
</body>
</html>
