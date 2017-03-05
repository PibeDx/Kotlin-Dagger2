package com.josecuentas.kotlin_dagger2.data

import com.josecuentas.kotlin_dagger2.domain.model.User
import javax.inject.Inject

/**
 * Created by iPibeDx on 4/03/17.
 */

class UserRepository @Inject constructor(dataSource: DataSource) : Repository {
    private var mUserList: List<User>

    init {
        mUserList = dataSource.provideUserList()
    }

    override fun all(): List<User> = mUserList
}
