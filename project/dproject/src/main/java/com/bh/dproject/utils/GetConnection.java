package com.bh.dproject.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnection {
    private static Properties properties;       //加载配置文件的对象
    static {
        InputStream in = null;      //文件输入流
        try {
            properties = new Properties();
            in = GetConnection.class.getResourceAsStream("/db.properties");     //获取配置文件到输入流
            properties.load(in);        //加载配置文件
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 根据key值获取配置文件的value
     * @param key
     * @return
     */
    public static String getProp(String key){
        return properties.getProperty(key);
    }


    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() {
        Connection connection=null;     //数据库连接对象
        try {
            Class.forName(getProp("jdbc.driver"));      //加载驱动
            //String url="com.bh.jdbc:mysql://localhost:3306/cuisine?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE";
            connection= DriverManager.getConnection(getProp("jdbc.url"),getProp("jdbc.username"),getProp("jdbc.password"));    //获取连接
        }catch (ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println("驱动加载异常");
        }catch (SQLException e) {
            System.out.println("获取连接异常");
        }
        if (connection!=null){
            return connection;      //返回连接对象
        }
        return null;
    }
}
