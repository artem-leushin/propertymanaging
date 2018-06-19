package com.panda.materialproperty.presentation

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.panda.materialproperty.domain.interactor.AutoLoginUseCase
import com.panda.materialproperty.presentation.login.LoginActivity
import com.panda.materialproperty.presentation.main.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.intentFor

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */
class LaunchActivity : AppCompatActivity() {

    private val autoLoginUseCase: AutoLoginUseCase by lazy {
        AutoLoginUseCase(getSharedPreferences("USER_STORE", Context.MODE_PRIVATE))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        autoLoginUseCase.tryAutoLogin()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableCompletableObserver() {

                override fun onComplete() {
                    startActivity(intentFor<MainActivity>())
                    finish()
                }

                override fun onError(e: Throwable) {
                    startActivity(intentFor<LoginActivity>())
                    finish()
                }
            })
    }
}