package com.panda.materialproperty.presentation.login

import com.panda.materialproperty.domain.entity.Enterprise
import io.reactivex.disposables.Disposable

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */
interface LoginContract {

    interface View {

        data class State(
            val loading: Boolean = false,
            val showFailedAuthDialog: Boolean = false,
            val error: Throwable? = null,
            val transition: Transition = Transition.IDLE
        )

        sealed class StateChanges {
            object StartLoading : StateChanges()
            object Success : StateChanges()
            class Fail(val error: Throwable? = null) : StateChanges()
        }

        enum class Transition {
            IDLE, MAIN
        }

        fun render(viewState: State)

    }

    interface Presenter {

        var disposable: Disposable

        fun loginWithCreds(email: String, password: String)

        fun reduce(changes: Any)
    }
}