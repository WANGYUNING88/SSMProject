package com.wang.dao;

import com.wang.domain.Account;

import java.util.List;

/**
 * 账户dao接口
 */
public interface AccountDao {

    //查询所有
    public List<Account> findAll();
    //保存用户信息
    public void saveAccount(Account account);

}
