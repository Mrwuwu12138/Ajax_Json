package com.servlet;

import com.util.GetConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;

public class deleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from student where id = ?";
        try {
            PreparedStatement statement = GetConnection.getStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("listServlet");
    }
}
