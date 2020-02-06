package com.wang.service.impl;

import com.wang.domain.Account;
import com.wang.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountImpl implements AccountService {
    @Override
    public List<Account> findAll() {
        System.out.println("【业务层】查询所有");
        return null;
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("【业务层】保存用户信息");
    }
}
