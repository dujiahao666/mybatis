package org.god.ibatis.core;

import java.sql.Connection;

/**
 * @author 杜嘉豪
 * @create 2024/4/16 23:04
 * @description:  MANAGED事务管理器
 */
public class ManagedTransaction implements Transaction {
    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }

    @Override
    public void close() {

    }

    @Override
    public void openConnection() {

    }

    @Override
    public Connection getConnection() {
        return null;
    }
}
