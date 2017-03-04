package com.josecuentas.kotlin_dagger2.data

import com.josecuentas.kotlin_dagger2.domain.model.User
import java.util.*

/**
 * Created by iPibeDx on 4/03/17.
 */

class UserDataSource :DataSource {
    var mUserList:MutableList<User>

    init {
        mUserList = ArrayList<User>()
    }

    override val provideUserList: List<User>
        get() {
            addUser(userJuan)
            addUser(userJose)
            return mUserList
        }

    private val userJuan: User
        get() = User("Juan", "Perez", 18)

    private val userJose: User
        get() = User("Jose", "Cuentas", 23)

    private fun addUser(user:User) {
        mUserList.add(user)
    }

}
