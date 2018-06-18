package com.panda.materialproperty.presentation.enterprises

import com.panda.materialproperty.domain.interactor.LoadAllEnterprisesUseCase
import com.panda.materialproperty.presentation.login.LoginContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by A.Olkinitskaya on 18.06.2018.
 */
class EnterprisesPresenter(
    private val view: EnterprisesContract.View,
    private val loadAllEnterprisesUseCase: LoadAllEnterprisesUseCase
) : EnterprisesContract.Presenter {

    private var curState: EnterprisesContract.View.State = EnterprisesContract.View.State()

    override lateinit var disposable: Disposable

    override fun loadAllEnterprises() {

        disposable = loadAllEnterprisesUseCase.load()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { reduce(EnterprisesContract.View.StateChanges.StartLoading) }
            .subscribe(
                { reduce(EnterprisesContract.View.StateChanges.LoadSuccess(it)) },
                { reduce(EnterprisesContract.View.StateChanges.Error(error = it)) }
            )
    }

    override fun reduce(changes: Any) {
        curState = when (changes) {

            is LoginContract.View.StateChanges.StartLoading ->
                curState.copy(
                    loading = true,
                    error = null
                )


            is LoginContract.View.StateChanges.Success ->
                curState.copy(
                    loading = false,
                    error = null
                )


            is LoginContract.View.StateChanges.Fail ->
                curState.copy(
                    loading = false,
                    error = changes.error
                )

            else -> curState
        }

        view.render(curState)
    }
}