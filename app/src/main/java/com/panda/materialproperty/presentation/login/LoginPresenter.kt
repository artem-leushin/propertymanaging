package com.panda.materialproperty.presentation.login

import com.panda.materialproperty.domain.interactor.LoginUseCase
import com.panda.materialproperty.presentation.login.LoginContract.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */
class LoginPresenter(
    private val view: LoginContract.View,
    private val loginUseCase: LoginUseCase
) : LoginContract.Presenter {

    private var curState: View.State = View.State()

    override lateinit var disposable: Disposable

    override fun loginWithCreds(email: String, password: String) {
        disposable = loginUseCase.login(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { reduce(View.StateChanges.StartLoading) }
            .subscribe(
                { reduce(View.StateChanges.Success) },
                { reduce(View.StateChanges.Fail(error = it)) }
            )

    }

    override fun reduce(changes: Any) {
        curState = when (changes) {

            is View.StateChanges.StartLoading ->
                curState.copy(
                    loading = true,
                    error = null,
                    showFailedAuthDialog = false
                )


            is View.StateChanges.Success ->
                curState.copy(
                    loading = false,
                    error = null,
                    showFailedAuthDialog = false,
                    transition = View.Transition.MAIN
                )


            is View.StateChanges.Fail ->
                curState.copy(
                    loading = false,
                    error = changes.error,
                    showFailedAuthDialog = true
                )

            else -> curState
        }

        view.render(curState)
    }
}


