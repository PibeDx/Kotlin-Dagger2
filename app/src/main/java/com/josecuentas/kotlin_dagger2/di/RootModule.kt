package com.josecuentas.kotlin_dagger2.di

import android.content.Context
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides

/**
 * Created by iPibeDx on 4/03/17.
 */

@Module class RootModule constructor(val context: Context){

    @Provides internal fun provideApplicationContext(): Context {
        return context
    }

    @Provides internal fun provideLayoutInflater(): LayoutInflater {
        return LayoutInflater.from(context)
    }
}