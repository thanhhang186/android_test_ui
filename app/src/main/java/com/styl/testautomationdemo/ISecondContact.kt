package com.styl.testautomationdemo

/**
 * Created by NguyenHang on 4/3/2020.
 */
interface ISecondContact {
    interface View {
        fun onLoginSuccess()
        fun onLoginFail()
    }

    interface Presenter {
        fun login(userName: String)
    }
}