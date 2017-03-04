package com.josecuentas.kotlin_dagger2.presenter

/**
 * Created by jcuentas on 6/02/17.
 */

open class Presenter<T : Presenter.View> {

    var view: T? = null

    open fun initialize() {

    }

    open fun terminate() {

    }

    interface View
}
