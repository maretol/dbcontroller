package com.maretol.database;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;;

public class DBInfo{
    public static String jdbcName;
    public static String databaseUrl;
    public static String databaseAddress;
    public static String databaseName;
    public static String databaseUsername;
    public static String databasePassword;
    private static Properties propertyFile;

    public DBInfo(){
        init();
    }

    public static void init(){
        try{
            InputStream input = new FileInputStream(
                new File("dbinfo.properties")
            );
            propertyFile.load(input);
        }catch(IOException e){
            e.printStackTrace();
        }
        jdbcName = propertyFile.getProperty("jdbc_name");
        databaseUrl = propertyFile.getProperty("database_url");
        databaseAddress = propertyFile.getProperty("database_address");
        databaseName = propertyFile.getProperty("database_name");
        databaseUsername = propertyFile.getProperty("database_username");
        databasePassword = propertyFile.getProperty("database_password");
    }

    // 何かプロパティファイルに書き込んだデータを取り出したいとき
    public Object getByPropertyFile(String key){
        return propertyFile.getProperty(key);
    }

    // JDBCアドレスを別のものにしたいとき
    public void changeJdbc(String key){
        jdbcName = propertyFile.getProperty(key);
    }

    // 違うDatabaseURLにしたいとき
    public void changeDatabaseUrl(String key){
        databaseUrl = propertyFile.getProperty(key);
    }

    // 違うDatabaseのアドレスにアクセスしたいとき
    public void changeDatabaseAddress(String key){
        databaseAddress = propertyFile.getProperty(key);
    }

    // 違うDatabase名にアクセスしたいとき
    public void changeDatabaseName(String key){
        databaseName = propertyFile.getProperty(key);
    }
    
    // 違うユーザー名でアクセスしたいとき
    public void changeDatabaseUsername(String key){
        databaseUsername = propertyFile.getProperty(key);
    }

    // 違うパスワードを用いるとき
    public void changeDatabasePassword(String key){
        databasePassword = propertyFile.getProperty(key);
    }
}