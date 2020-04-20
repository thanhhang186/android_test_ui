package com.styl.testautomationdemo

import com.styl.testautomationdemo.entity.User

/**
 * Created by NguyenHang on 4/20/2020.
 */
class Service {
    fun getFriendList(userId: Int): ArrayList<User> {
        val result = ArrayList<User>()
        for (i in 0 .. 9) {
            result.add(User(i, "name $i", (i%2==0)))
        }
        return result
    }
}