package org.god.ibatis.core;

import java.sql.Connection;

/**
 * @author 杜嘉豪
 * @create 2024/4/16 22:51
 * @description:   事务管理器接口
 *                      所有的事物管理器都应该遵循该规范
 *                      JDBC事务管理器，MANAGED事务管理器都应该实现这个接口
 *                      Transaction事物管理器：提供管理事物方法
 */
public interface Transaction {

    /**
     * 提交事务
     */
    void commit();

    /**
     * 回滚事务
     */
    void rollback();;


    /**
     * 关闭事物
     */
    void close();


    /**
     * 如果需要后续的在继续添加
     */


    /**
     * 真正的开启数据库连接
     */
    void openConnection();

    /**
     * 获取数据库连接对象
     * @return
     */
    Connection getConnection();
}
