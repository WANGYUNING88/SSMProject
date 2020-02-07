package com.wang.service.impl;

import com.wang.dao.AccountDao;
import com.wang.domain.Account;
import com.wang.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("【业务层】查询所有");
        List<Account> list = accountDao.findAll();
        return list;
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("【业务层】保存用户信息");
    }
}
