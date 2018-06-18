package com.panda.materialproperty.presentation.enterprises

import io.reactivex.disposables.Disposable

/**
 * Created by A.Olkinitskaya on 18.06.2018.
 */
interface EnterprisesContract {

    interface View {

        data class State(
            val success: Boolean = false
        )

        sealed class StateChanges {

        }
    }

    interface Presenter {
        val disposable: Disposable

    }

}