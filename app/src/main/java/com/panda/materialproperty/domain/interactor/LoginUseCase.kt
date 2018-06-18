package com.panda.materialproperty.domain.interactor

import android.content.SharedPreferences
import androidx.core.content.edit
import com.panda.materialproperty.data.testEmail
import com.panda.materialproperty.data.testPass
import io.reactivex.Completable

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */
class LoginUseCase(
    private val sharedPreferences: SharedPreferences
) {
    fun login(email: String, pass: String): Completable =
        Completable.create {
            if (credsValid(email, pass)) {
                persistCreds(email, pass)
                it.onComplete()
            } else it.onError(NoSuchElementException("Нет пользователя с такими данными"))
        }


    private fun persistCreds(email: String, pass: String) {
        sharedPreferences.edit {
            putString("email", email)
            putString("pass", pass)
            commit()
        }
    }

    private fun credsValid(email: String, pass: String): Boolean =
        email == testEmail && pass == testPass
}