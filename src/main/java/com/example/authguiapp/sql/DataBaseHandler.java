package com.example.authguiapp.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHandler extends Configs {
    Connection dbConnection;
    public Connection getDbConnection() throws SQLException, ClassNotFoundException {
        String connection = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connection, dbUser, dbPass);

        return dbConnection;
    }
}
