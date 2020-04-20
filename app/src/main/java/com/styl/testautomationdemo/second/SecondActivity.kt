package com.styl.testautomationdemo.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.styl.testautomationdemo.R
import com.styl.testautomationdemo.Service
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), ISecondContact.View, View.OnClickListener {
    private lateinit var presenter: SecondPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        presenter = SecondPresenter(this, Service())
        btn_login.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.btn_login -> {
                presenter.login(edt_username.text.toString())
            }
        }
    }

    override fun showError(message: String) {
        tv_status.text = message
    }
}
