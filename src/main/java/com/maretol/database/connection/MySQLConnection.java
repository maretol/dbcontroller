package com.maretol.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import com.maretol.database.DBInfo;




public class MySQLConnection implements DatabaseConnection{
    private Connection cnct;
    private Statement stmt;
    private String sql;

    public MySQLConnection(){
        cnct = null;
        stmt = null;
    }

    @Override
    public void setSQL(String sql){
        this.sql = sql;
    }

    @Override
    public void createStatement(){
        try{
            Class.forName(DBInfo.jdbcName);

            String url = DBInfo.databaseUrl;
            url += DBInfo.databaseAddress;
            url += DBInfo.databaseName;
            cnct = DriverManager.getConnection(
                url, DBInfo.databaseUsername, DBInfo.databasePassword);
        
            stmt = cnct.createStatement();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection(){
        try{
            if(cnct!=null){
                cnct.close();
            }
            if(stmt!=null){
                stmt.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet executeQuery(){
        try{
            return stmt.executeQuery(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public int executeUpdate(){
        try{
            return stmt.executeUpdate(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean execute(){
        try{
            return stmt.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}