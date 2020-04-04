package com.styl.testautomationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), ISecondContact.View, View.OnClickListener {
    private val presenter = SecondPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        btn_login.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.btn_login -> {
                presenter.login(edt_username.text.toString())
            }
        }
    }

    override fun onLoginSuccess() {
        tv_status.text = "Success"
    }

    override fun onLoginFail() {
        tv_status.text = "Fail"
    }

}
