package org.god.ibatis.core;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 杜嘉豪
 * @create 2024/4/16 23:02
 * @description: JDBC事务管理器
 */
public class JdbcTransction implements Transaction {

    /**
     * 数据源属性【去获取】
     * 经典的设计：面向接口编程
     */
    private DataSource dataSource;


    /**
     * 自动提交标志
     * true表示自动提交
     * false表示不采用自动提交
     */
    private boolean autoCommit;


    /**
     * 连接对象
     */
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    //创建事务管理器对象
    public JdbcTransction(DataSource dataSource, boolean autoCommit) {
        this.dataSource = dataSource;
        this.autoCommit = autoCommit;
    }


    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void openConnection() {
        if(connection==null){
            try {
                connection=dataSource.getConnection();
                connection.setAutoCommit(autoCommit);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
