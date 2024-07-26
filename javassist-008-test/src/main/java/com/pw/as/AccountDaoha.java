package com.pw.as;

/**
 * @author 杜嘉豪
 * @create 2024/4/6 12:44
 * @description:
 */
public interface AccountDaoha {
    void delete();
    int insert(String actno);
    int update(String actno,Double balance);
    String selectByActno(String actno);
}
