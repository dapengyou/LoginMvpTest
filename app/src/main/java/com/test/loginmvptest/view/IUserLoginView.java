package com.test.loginmvptest.view;

import com.test.loginmvptest.bean.User;

/**
 * Created by lady_zhou on 2017/10/18.
 */

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
