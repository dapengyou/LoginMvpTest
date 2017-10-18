package com.test.loginmvptest.biz;

import com.test.loginmvptest.bean.User;

/**
 * Created by lady_zhou on 2017/10/18.
 */

public class UserBiz implements IUserBiz {

    @Override
    public void login(final String username, final String password, final OnLoginLister loginLister) {
        new Thread() {

            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (username.equals("zhou") && password.equals("123")) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginLister.loginSuccess(user);
                } else {
                    loginLister.loginFailed();
                }
            }
        }.start();
    }
}
