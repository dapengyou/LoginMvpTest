package com.test.loginmvptest.biz;

/**
 * Created by lady_zhou on 2017/10/18.
 */

public interface IUserBiz {
    public void login(String username, String password, OnLoginLister loginLister);
}
