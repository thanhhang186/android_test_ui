package com.styl.testautomationdemo.entity

/**
 * Created by NguyenHang on 4/20/2020.
 */
class User {
    var id: Int? = null
    var name: String? = null
    var isMale: Boolean? = null

    constructor(id: Int?, name: String?, isMale: Boolean?) {
        this.id = id
        this.name = name
        this.isMale = isMale
    }
}