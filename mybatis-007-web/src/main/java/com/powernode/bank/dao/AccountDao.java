package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;

/**
 * @author 杜嘉豪
 * @create 2024/4/5 16:01
 * @description: 账户的Dao对象，负责t_car表中数据的CRUD
 * 注意：dao对象中的任何一个方法和业务不挂钩，没有任何业务逻辑在里面
 *      dao中的方法就是CRUD。所以方法名大部分是：insertXXX,deleteXXX,updateXXX,serlectXXX
 */
public interface AccountDao {
    /**
     * 根据账号查询账户信息
     * @param actno 账户
     * @return 账户信息
     */
    Account selectByActno(String actno);

    /**
     * 更新账户信息
     * @param act 被更新的账户对象
     * @return 1表示更新成功，0表示更新失败
     */
    int updateByActno(Account act);

}
