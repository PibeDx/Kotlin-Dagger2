package com.josecuentas.kotlin_dagger2.presenter

import com.josecuentas.kotlin_dagger2.data.UserRepository
import com.josecuentas.kotlin_dagger2.domain.model.User
import javax.inject.Inject

/**
 * Created by iPibeDx on 4/03/17.
 */

class UserPresenter @Inject constructor(val userRepository: UserRepository): Presenter<UserPresenter.View>(){

    fun all() {
        view?.hideLoading()
        view?.showUsers(userRepository.all())
    }

    override fun initialize() {
        super.initialize()
        all()
    }

    override fun terminate() {
        super.terminate()
        view = null
    }

    interface View: Presenter.View {
        fun showUsers(user: List<User>)
        fun hideLoading()
    }
}
