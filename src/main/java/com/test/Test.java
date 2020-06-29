package com.test;

import com.util.GetConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

    public static void main(String[] args) throws Exception {
        String sql = "select * from student";
        PreparedStatement statement = GetConnection.getConnection().prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id")+" "+resultSet.getString("name")
            +" "+resultSet.getInt("age")+" "+resultSet.getString("sex"));
        }
        resultSet.close();
        GetConnection.getConnection().close();
    }
}
