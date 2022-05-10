package com.example.demo.api;



import java.sql.*;

public class MariaDBConnetor {
    public static void main(String[] args) {
        Connection con = null;

        String server = "59.10.254.110:3306";
        String database = "test";
        String user_name = "root";
        String password = "735560";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("driver loading error : " + e.getMessage());
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://" +
                    server + "/" +
                    database +
                    "?useSSL=false", user_name, password); // SSL 실행 확인
            System.out.println("Connected!");
        } catch(SQLException e) {
            System.err.println("error message :" + e.getMessage());
            e.printStackTrace();
        }

        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {}
    }
}