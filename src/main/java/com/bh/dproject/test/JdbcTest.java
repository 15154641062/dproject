package com.bh.dproject.test;

import com.bh.dproject.pojo.Branch;
import com.bh.dproject.utils.C3p0DBPool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JdbcTest {
    @Test
    public void jdbcTest() throws PropertyVetoException, SQLException {
        //getC3p0ConnectionPool();
        //System.out.println(getConnectionPool());
        //testUpdate();
        //testUpdateByQueryRunner();
        testQueryByQueryRunner();
    }

    /**
     * 通过连接池测试对数据库的操作
     */
    public void testUpdate() {
        Connection connection = null;
        try {
            connection = C3p0DBPool.getConnectionPool();       //获取池连接
            connection.setAutoCommit(false);    //关闭自动事务提交,手动开启事务

            String sql = "update branch set branch_name=? where id=?";        //sql语句
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "海淀店");
            preparedStatement.setInt(2, 2);
            System.out.println(preparedStatement.executeUpdate());

            connection.commit();      //提交事务
        } catch (SQLException throwables) {
            try {
                if (connection != null)
                    connection.rollback();      //回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();     //将连接还给池
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    /**
     * 测试QueryRunner的 update方法
     */
    public void testUpdateByQueryRunner() {
        DataSource dataSource = C3p0DBPool.getDataSource();      //获取数据源
        QueryRunner queryRunner = new QueryRunner(dataSource);      //创建QueryRunner对象

        //更新测试
        String updateSql = "update branch set branch_name=?,location=? where id=?";
        try {
            System.out.println("QueryRunner()--update():" + queryRunner.update(updateSql, "高薪店", "高薪区", "1"));   //执行更新
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 测试QueryRunner的 query方法
     */
    public void testQueryByQueryRunner() {
        DataSource dataSource = C3p0DBPool.getDataSource();      //获取数据源
        QueryRunner queryRunner = new QueryRunner(dataSource);      //创建QueryRunner对象

        //查询测试  ColumnListHandler   单行单列或多行单列
        String querySql = "select location from branch";
        try {
            List<String> locations = queryRunner.query(querySql, new ColumnListHandler<>());   //执行查询,返回多行单列的结果集
            for (String location : locations) {
                System.out.println(location);
            }

            //查询测试  MapListHandler   单行多列或多行多列
            //MapHandler   单行多列
            querySql = "select * from branch where id=?";
            Map data = queryRunner.query(querySql, new MapHandler(), 1);
            System.out.println(data.get("id") + "," + data.get("branch_name") + "," + data.get("location"));

            //MapListHandler   多行多列
            querySql = "select * from branch";
            List<Map<String, Object>> maps = queryRunner.query(querySql, new MapListHandler());
            for (Map map : maps) {
                System.out.println(map.get("id") + "," + map.get("branch_name") + "," + map.get("location"));
            }

            //获取实体类对象
            List<Branch> branches = queryRunner.query(querySql, new BeanListHandler<Branch>(Branch.class));
            for (Branch branch : branches) {
                System.out.println(branch.toString());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
