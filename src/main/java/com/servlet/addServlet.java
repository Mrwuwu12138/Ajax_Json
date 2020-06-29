package com.servlet;

import com.util.GetConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;

public class addServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql = "insert into student(id,name,age,sex） values(?,?,?,?)";
        req.setCharacterEncoding("utf-8");
        try {
            PreparedStatement statement = GetConnection.getStatement(sql);
            statement.setInt(1, Integer.valueOf(req.getParameter("id")));
            statement.setString(2, req.getParameter("name"));
            statement.setInt(3, Integer.parseInt(req.getParameter("age")));
            statement.setString(4, req.getParameter("sex"));
            System.out.println(req.getParameter("id"));
            System.out.println(req.getParameter("name"));
            System.out.println(req.getParameter("age"));
            System.out.println(req.getParameter("sex"));
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("listServlet");
    }
}
