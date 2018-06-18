package com.panda.materialproperty.domain.interactor

import android.content.SharedPreferences
import io.reactivex.Completable

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */
class AutoLoginUseCase(
    private val userStore: SharedPreferences
) {

    fun tryAutoLogin(): Completable = Completable.create {
        val email = userStore.getString("email", "")
        val pass = userStore.getString("pass", "")

        val userLoggedIn = email.isNotBlank() && pass.isNotBlank()

        if (userLoggedIn) it.onComplete()
        else it.onError(IllegalStateException("user is not logged in"))
    }

}