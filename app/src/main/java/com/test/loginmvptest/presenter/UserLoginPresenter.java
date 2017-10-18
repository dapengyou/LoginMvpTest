package com.test.loginmvptest.presenter;

import android.os.Handler;

import com.test.loginmvptest.bean.User;
import com.test.loginmvptest.biz.IUserBiz;
import com.test.loginmvptest.biz.OnLoginLister;
import com.test.loginmvptest.biz.UserBiz;
import com.test.loginmvptest.view.IUserLoginView;

/**
 * Created by lady_zhou on 2017/10/18.
 */

public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login() {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginLister() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                userLoginView.showFailedError();
                userLoginView.hideLoading();
            }
        });
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
