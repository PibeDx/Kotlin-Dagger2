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

    override fun provideUserList(): List<User> {
            addUser(userJuan())
            addUser(userJose())
            return mUserList
    }

    private fun userJuan(): User
        = User("Juan", "Perez", 18)

    private fun userJose(): User
        = User("Jose", "Cuentas", 23)

    private fun addUser(user:User)
        = mUserList.add(user)


}
