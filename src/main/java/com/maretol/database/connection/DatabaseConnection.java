package com.maretol.database.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;




public interface DatabaseConnection{
    public void setSQL(String sql);

    public void createStatement();

    public void closeConnection();

    public ResultSet executeQuery();

    public int executeUpdate();

    public boolean execute();
}