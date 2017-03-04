package com.josecuentas.kotlin_dagger2.data

import com.josecuentas.kotlin_dagger2.domain.model.User

/**
 * Created by iPibeDx on 4/03/17.
 */

class UserRepository(dataSource: DataSource) : Repository {
    private var mUserList: List<User>

    init {
        mUserList = dataSource.provideUserList
    }

    override val all: List<User>
        get() = mUserList
}
