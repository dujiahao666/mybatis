package org.god.ibatis.core;

/**
 * @author 杜嘉豪
 * @create 2024/4/16 22:09
 * @description:
 *              普通的java类。pojo,封装了一个SQL标签
 *              一个MappedStatement对象对应一个SQL标签
 *              一个SQL标签中的所有信息封装到MappedStatement对象当中
 */
public class MappedStatement {
    /**
     * sql语句
     */
    private String sql;

    /**
     * 要封装的结果集类型，有的时候resultType是null
     * 比如说 insert/delete/update语句的时候resultType是null
     * 只有当sql语句是select语句的时候，resultType才有值
     */
    private String resultType;

    public MappedStatement() {
    }

    public MappedStatement(String sql, String resultType) {
        this.sql = sql;
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    @Override
    public String toString() {
        return "MappedStatement{" +
                "sql='" + sql + '\'' +
                ", resultType='" + resultType + '\'' +
                '}';
    }
}
