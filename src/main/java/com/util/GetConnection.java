package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class GetConnection {
    public static Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String name = "system";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, name, password);
        return connection;
    }
    public static PreparedStatement getStatement(String sql) throws Exception {
        PreparedStatement statement = getConnection().prepareStatement(sql);
        getConnection().close();
        return statement;
    }
}
