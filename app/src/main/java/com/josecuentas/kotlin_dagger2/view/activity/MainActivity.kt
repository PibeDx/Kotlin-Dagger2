package com.josecuentas.kotlin_dagger2.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.josecuentas.kotlin_dagger2.R
import com.josecuentas.kotlin_dagger2.data.UserDataSource
import com.josecuentas.kotlin_dagger2.data.UserRepository
import com.josecuentas.kotlin_dagger2.domain.model.User
import com.josecuentas.kotlin_dagger2.presenter.UserPresenter

class MainActivity : AppCompatActivity(), UserPresenter.View {

    var TAG = "MainActivity"
    var mUserPresenter: UserPresenter? = null
    var mTviMessage: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectView()
        injectPresenter()
    }

    private fun injectView() {
        mTviMessage = findViewById(R.id.tviMessage) as TextView
    }

    private fun injectPresenter() {
        var userDataSource = UserDataSource()
        var userRepository = UserRepository(userDataSource)
        mUserPresenter = UserPresenter(userRepository)
        mUserPresenter!!.view = this
        mUserPresenter!!.initialize()
    }

    override fun showUsers(user: List<User>) {
        Log.d(TAG, "showUsers() called: user: " + user)
        mTviMessage!!.text = user.toString()
    }

    override fun hideLoading() {
        Log.d(TAG, "hideLoading() called")

    }
}
