package com.josecuentas.kotlin_dagger2.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.josecuentas.kotlin_dagger2.R
import com.josecuentas.kotlin_dagger2.domain.model.User
import com.josecuentas.kotlin_dagger2.presenter.UserPresenter
import com.josecuentas.kotlin_dagger2.view.DIApplication
import com.josecuentas.kotlin_dagger2.view.adapter.ItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), UserPresenter.View {

    var TAG = "MainActivity"
    @Inject lateinit var mUserPresenter: UserPresenter
    var mItemAdapter = ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycler()
        injectPresenter()
    }

    private fun setupRecycler() {
        var llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        rviContainer.layoutManager = llm
        rviContainer.setHasFixedSize(true)
        rviContainer.itemAnimator = DefaultItemAnimator()
        rviContainer.adapter = mItemAdapter
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
        user.forEach{mItemAdapter.addItem(it)}
        //TODO: show in TextView
        tviMessage.text = user.toString()
    }

    override fun hideLoading() {
        Log.d(TAG, "hideLoading() called")
    }
}
