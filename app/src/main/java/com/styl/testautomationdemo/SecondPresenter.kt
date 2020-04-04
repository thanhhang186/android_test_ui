package com.styl.testautomationdemo

/**
 * Created by NguyenHang on 4/3/2020.
 */
class SecondPresenter(var view: ISecondContact.View): ISecondContact.Presenter{
    override fun login(userName: String) {
        if (userName.isNullOrEmpty()) {
            view.onLoginFail()
        } else {
            view.onLoginSuccess()
        }
    }
}