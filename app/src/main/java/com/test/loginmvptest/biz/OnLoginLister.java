package com.test.loginmvptest.biz;

import com.test.loginmvptest.bean.User;

/**
 * Created by lady_zhou on 2017/10/18.
 */

public interface OnLoginLister {
    void loginSuccess(User user);

    void loginFailed();
}
