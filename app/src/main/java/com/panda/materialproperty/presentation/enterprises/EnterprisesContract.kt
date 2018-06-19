package com.panda.materialproperty.presentation.enterprises

import com.panda.materialproperty.domain.entity.Enterprise
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by A.Olkinitskaya on 18.06.2018.
 */
interface EnterprisesContract {

    interface View {

        data class State(
            val loading: Boolean = false,
            val error: Throwable? = null,
            val noContent: Boolean = false,
            val enterprises: List<DisplayableItem> = emptyList()
        )

        sealed class StateChanges {
            object StartLoading : StateChanges()
            class LoadSuccess(val enterprises: List<DisplayableItem> = emptyList()) : StateChanges()
            class Error(val error: Throwable? = null) : StateChanges()
        }

        sealed class DisplayableItem {
            class HeaderRow(
                val firstColumn: String = "",
                val secondColumn: String = "",
                val thirdColumn: String = ""
            ) : DisplayableItem()

            class EnterpriseRow(
                val id: Int,
                val firstColumn: String = "",
                val secondColumn: String = "",
                val thirdColumn: String = ""
            ) : DisplayableItem()
        }

        fun render(viewState: EnterprisesContract.View.State)
    }

    interface Presenter {
        val disposables: CompositeDisposable

        fun loadAllEnterprises()

        fun loadEnterprisesAt(address: String)

        fun reduce(changes: Any)
    }
}