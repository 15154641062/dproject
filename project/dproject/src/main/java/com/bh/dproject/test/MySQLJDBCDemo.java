package com.bh.dproject.test;

import com.bh.dproject.utils.GetConnection;
import org.junit.Test;

import java.sql.*;

public class MySQLJDBCDemo {
    @Test
    public void mySQLJDBCDemoTest(){
        queryData();
        //updateData();
    }

    /**
     * JDBC连接数据库
     * 加载数据库驱动     Class.forName("com.mysql.cj.com.bh.jdbc.Driver");
     * 通过DriverManager获取数据库连接   DriverManager.getConnection(url,user,password);
     * 创建语句连接器对象Statement     createStatement();
     * 执行SQL语句           增删改:executeUpdate(String sql)    查询:executeQuery(String sql)
     * 获取结果或结果集            对数据库改动的行数                       ResultSet对象
     * 遍历结果集            next()
     */

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() {
        Connection connection=null;     //数据库连接对象
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");      //加载驱动
            String url="com.bh.jdbc:mysql://localhost:3306/cuisine?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE";
            connection=DriverManager.getConnection(url,"root","151476");    //获取连接
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection!=null){
            return connection;      //返回连接对象
        }
        return null;
    }

    /**
     * 操作数据库查询数据
     */
    public void queryData(){
        Connection connection=null;     //数据库连接对象
        try {
            connection= GetConnection.getConnection();     //获取数据库连接
            Statement statement = connection.createStatement();     //创建一个执行SQL语句的Statement对象(语句发送器)
            String sql="select * from branch";
            ResultSet resultSet =statement.executeQuery(sql);       //执行SQL语句并返回一个ResultSet对象
            while (resultSet.next()){           //遍历结果集
                System.out.println("result:"+resultSet.getInt("id"));       //根据列名获取数据并打印
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();       //释放资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 操作数据库增删改数据
     */
    public void updateData(){
        Connection connection=null;     //数据库连接对象
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");       //加载驱动
            String url="com.bh.jdbc:mysql://localhost:3306/cuisine?serverTimezone=UTC&characterEncoding=utf-8&useSSL=FALSE";
            connection=DriverManager.getConnection(url,"user","123456");        //获取数据库连接
            Statement statement=connection.createStatement();       //创建一个执行SQL语句的Statement对象(语句发送器)
            String insertSql="insert into branch (branch_name,location) values('市中店','市中区')";
            int result=statement.executeUpdate(insertSql);      // 执行SQL语句返回受影响的行数
            System.out.println("result:"+result);

            String querySql="select * from branch";
            ResultSet resultSet=statement.executeQuery(querySql);       //执行SQL语句并返回一个ResultSet对象
            while (resultSet.next()){        //遍历结果集
                System.out.println("id="+resultSet.getInt("id")
                        +",branch_name="+resultSet.getString("branch_name")
                        +",location="+resultSet.getString("location"));
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();        //释放资源
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
