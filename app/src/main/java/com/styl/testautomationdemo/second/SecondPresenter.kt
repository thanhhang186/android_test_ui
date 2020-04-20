package com.styl.testautomationdemo.second

import com.styl.testautomationdemo.Service
import com.styl.testautomationdemo.entity.User
import java.util.stream.Collectors

/**
 * Created by NguyenHang on 4/3/2020.
 */
class SecondPresenter(var view: ISecondContact.View, var service: Service) : ISecondContact.Presenter {

    override fun login(userName: String) {
        if (isValidUserName(userName)) {
            view.showError("Fail")
        } else {
            view.showError("Success")
        }
    }

    fun isValidUserName(userName: String): Boolean {
        if (userName.trim().isNullOrEmpty() || userName.trim().length < 4) {
            return false
        }
        return true
    }

    fun getFriendListByFilter(isOddId: Boolean): List<User> {
        return service.getFriendList(1).stream().filter { user -> (user.id?.rem(2) == 0) }
            .collect(Collectors.toList());
    }
}