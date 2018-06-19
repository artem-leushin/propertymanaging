package com.panda.materialproperty.presentation.login

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.panda.materialproperty.R
import com.panda.materialproperty.data.SP_STORE
import com.panda.materialproperty.databinding.ActivityLoginBinding
import com.panda.materialproperty.databinding.DialogWrongCredsBinding
import com.panda.materialproperty.domain.interactor.LoginUseCase
import com.panda.materialproperty.presentation.main.MainActivity
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var binding: ActivityLoginBinding
    private var presenter: LoginContract.Presenter? = null
    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter(
            this,
            LoginUseCase(getSharedPreferences(SP_STORE, Context.MODE_PRIVATE))
        )

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        with(binding) {

            val dialogView: DialogWrongCredsBinding = DataBindingUtil.inflate(
                LayoutInflater.from(this@LoginActivity),
                R.layout.dialog_wrong_creds,
                null,
                false
            )

            with(dialogView) {
                dialog = AlertDialog.Builder(this@LoginActivity)
                    .setView(dialogView.root)
                    .setCancelable(true)
                    .create()
                tvGotIt.setOnClickListener { dialog.dismiss() }
            }


            btnLogin.setOnClickListener {
                val email = etEmail.text.toString()
                val pass = etPass.text.toString()

                presenter?.loginWithCreds(email, pass)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.disposable?.dispose()
        presenter = null
    }

    override fun render(viewState: LoginContract.View.State) {

        binding.pbProgress.visibility =
                if (viewState.loading) View.VISIBLE
                else View.INVISIBLE

        if (viewState.showFailedAuthDialog)
            dialog.show()

        if (viewState.transition == LoginContract.View.Transition.MAIN)
            startActivity(intentFor<MainActivity>())

    }
}