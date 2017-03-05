package com.josecuentas.kotlin_dagger2.di

import com.josecuentas.kotlin_dagger2.view.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by iPibeDx on 4/03/17.
 */

@Component(modules = arrayOf(RootModule::class, UserModule::class ))
interface UserComponent {
    fun inject(mainActivity: MainActivity)
}
