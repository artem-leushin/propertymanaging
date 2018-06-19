package com.panda.materialproperty.domain.interactor

import android.content.SharedPreferences
import androidx.core.content.edit

/**
 * Created by A.Olkinitskaya on 20.06.2018.
 */

class LogoutUseCase(
    private val preferences: SharedPreferences
) {
    fun logout() {
        preferences.edit {
            clear()
            commit()
        }
    }
}