package com.styl.testautomationdemo.second

/**
 * Created by NguyenHang on 4/3/2020.
 */
interface ISecondContact {
    interface View {
        fun showError(message: String)
    }

    interface Presenter {
        fun login(userName: String)
    }

    interface Router {
        fun goToSecondView()
    }
}