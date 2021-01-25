package com.bh.dproject.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class C3p0DBPool {
    private static ComboPooledDataSource dataSource = null;

    /**
     * 直接配置连接池
     *
     * @throws PropertyVetoException
     * @throws SQLException
     */
    public static void getC3p0ConnectionPool() throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //设置连接池属性
        //数据库驱动
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        //url
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/cuisine?serverTimezone=UTC&characterEncoding=utf-8&useSSL=FALSE");
        //user
        dataSource.setUser("root");
        //password
        dataSource.setPassword("151476");
        //当数据库连接池中没有空闲的连接时，一次性创建的连接数量
        dataSource.setAcquireIncrement(5);
        //初始化时获取的连接数
        dataSource.setInitialPoolSize(20);
        //连接池中保留的最小连接数
        dataSource.setMinPoolSize(2);
        //连接池中保留的最大连接数
        dataSource.setMaxPoolSize(50);

        Connection connection = dataSource.getConnection();       //获取一个池连接
        System.out.println(connection);

        connection.close();     //将连接还给池
    }

    /**
     * 通过配置文件获取数据库连接池
     *
     * @return
     */
    public static Connection getConnectionPool() throws SQLException {
        dataSource = new ComboPooledDataSource("mysql-config");     //读取配置文件
        Connection connection = dataSource.getConnection();      //获取一个池连接并返回
        return connection;
    }

    /**
     * 获取数据源连接(通过c3p0连接池)
     * @return
     */
    public static DataSource getDataSource() {
        dataSource = new ComboPooledDataSource("mysql-config");     //读取配置文件
        return dataSource;
    }

}
