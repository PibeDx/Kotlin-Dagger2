package com.josecuentas.kotlin_dagger2.data

import com.josecuentas.kotlin_dagger2.domain.model.User

/**
 * Created by iPibeDx on 4/03/17.
 */

interface Repository {
    val all: List<User>
}
