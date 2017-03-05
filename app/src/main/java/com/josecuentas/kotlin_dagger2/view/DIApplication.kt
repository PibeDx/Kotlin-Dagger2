package com.josecuentas.kotlin_dagger2.view

import android.app.Application
import com.josecuentas.kotlin_dagger2.di.DaggerUserComponent
import com.josecuentas.kotlin_dagger2.di.RootModule
import com.josecuentas.kotlin_dagger2.di.UserComponent

/**
 * Created by iPibeDx on 4/03/17.
 */

class DIApplication: Application() {
    lateinit var component: UserComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerUserComponent.builder().rootModule(RootModule(this)).build()
    }
}
