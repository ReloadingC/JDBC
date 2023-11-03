package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.JDBCConnection.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        System.out.printf("Connection to the PostgreSQL established.");











        connection.close();


    }
}