package com.josecuentas.kotlin_dagger2.di

import com.josecuentas.kotlin_dagger2.data.DataSource
import com.josecuentas.kotlin_dagger2.data.Repository
import com.josecuentas.kotlin_dagger2.data.UserDataSource
import com.josecuentas.kotlin_dagger2.data.UserRepository
import com.josecuentas.kotlin_dagger2.presenter.UserPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by iPibeDx on 4/03/17.
 */
@Module class UserModule {

    @Provides fun provideDataSource():DataSource {
        return UserDataSource()
    }

    @Provides fun provideUserRepository(userDataSource: UserDataSource):Repository {
        return UserRepository(userDataSource)
    }

    @Provides fun provideUserPresenter(userRepository: UserRepository): UserPresenter {
        return UserPresenter(userRepository)
    }
}