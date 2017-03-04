package com.josecuentas.kotlin_dagger2.domain.model

/**
 * Created by iPibeDx on 4/03/17.
 */
data class User constructor(
        var name:String? = null,
        var lastName:String? = null,
        var age:Int? = null
) {
    override fun toString(): String {
        return "User(name=$name, lastName=$lastName, age=$age)"
    }
}