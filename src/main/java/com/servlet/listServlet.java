package com.servlet;

import com.pojo.Student;
import com.util.GetConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class listServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String sql = "select * from student order by id asc";
            PreparedStatement statement = GetConnection.getStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Student> list = new ArrayList<>();
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setSex(resultSet.getString("sex"));
                list.add(student);
            }
            req.setAttribute("list", list);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("listStudent.jsp").forward(req, resp);
    }
}
