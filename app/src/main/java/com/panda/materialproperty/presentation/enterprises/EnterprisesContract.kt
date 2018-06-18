package com.panda.materialproperty.presentation.enterprises

import com.panda.materialproperty.domain.entity.Enterprise
import io.reactivex.disposables.Disposable

/**
 * Created by A.Olkinitskaya on 18.06.2018.
 */
interface EnterprisesContract {

    interface View {

        data class State(
            val loading: Boolean = false,
            val error: Throwable? = null,
            val enterprises: List<Enterprise> = emptyList()
        )

        sealed class StateChanges {
            object StartLoading : StateChanges()
            class LoadSuccess(val enterprises: List<Enterprise> = emptyList()) : StateChanges()
            class Error(val error: Throwable? = null) : StateChanges()
        }

        fun render(viewState: EnterprisesContract.View.State)
    }

    interface Presenter {
        val disposable: Disposable

        fun loadAllEnterprises()

        fun reduce(changes: Any)
    }
}