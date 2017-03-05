package com.josecuentas.kotlin_dagger2.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.josecuentas.kotlin_dagger2.R
import com.josecuentas.kotlin_dagger2.domain.model.User
import com.josecuentas.kotlin_dagger2.presenter.UserPresenter
import com.josecuentas.kotlin_dagger2.view.DIApplication
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), UserPresenter.View {

    var TAG = "MainActivity"
    @Inject lateinit var mUserPresenter: UserPresenter
    //var mTviMessage: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectView()
        injectPresenter()
    }

    private fun injectView() {
        //mTviMessage = findViewById(R.id.tviMessage) as TextView
    }

    private fun injectPresenter() {
        /*var userDataSource = UserDataSource()
        var userRepository = UserRepository(userDataSource)
        mUserPresenter = UserPresenter(userRepository)
        mUserPresenter!!.view = this
        mUserPresenter!!.initialize()*/

        (application as DIApplication).component.inject(this)
        mUserPresenter.view = this
        mUserPresenter.initialize()
    }

    override fun showUsers(user: List<User>) {
        Log.d(TAG, "showUsers() called: user: " + user)
        //mTviMessage!!.text = user.toString()
        tviMessage.text = user.toString()
    }

    override fun hideLoading() {
        Log.d(TAG, "hideLoading() called")

    }
}
