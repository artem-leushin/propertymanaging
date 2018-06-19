package com.panda.materialproperty.presentation.enterprises

import com.panda.materialproperty.domain.entity.Enterprise
import com.panda.materialproperty.domain.interactor.LoadAllEnterprisesUseCase
import com.panda.materialproperty.domain.interactor.LoadEnterprisesAtLocationUseCase
import com.panda.materialproperty.presentation.enterprises.EnterprisesContract.View.DisplayableItem.EnterpriseRow
import com.panda.materialproperty.presentation.enterprises.EnterprisesContract.View.DisplayableItem.HeaderRow
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by A.Olkinitskaya on 18.06.2018.
 */
class EnterprisesPresenter(
    private val view: EnterprisesContract.View,
    private val loadAllEnterprisesUseCase: LoadAllEnterprisesUseCase,
    private val loadEnterprisesAtLocationUseCase: LoadEnterprisesAtLocationUseCase
) : EnterprisesContract.Presenter {

    private var curState: EnterprisesContract.View.State = EnterprisesContract.View.State()

    override val disposables = CompositeDisposable()


    override fun loadAllEnterprises() {
        disposables.add(
            loadAllEnterprisesUseCase.load()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { reduce(EnterprisesContract.View.StateChanges.StartLoading) }
                .subscribe(
                    { reduce(EnterprisesContract.View.StateChanges.LoadSuccess(mapToAdapterItems(it))) },
                    { reduce(EnterprisesContract.View.StateChanges.Error(error = it)) }
                )
        )
    }

    // TODO refactor composite disposable
    override fun loadEnterprisesAt(address: String) {
        disposables.add(
            loadEnterprisesAtLocationUseCase.load(address)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { reduce(EnterprisesContract.View.StateChanges.StartLoading) }
                .subscribe(
                    { reduce(EnterprisesContract.View.StateChanges.LoadSuccess(mapToAdapterItems(it))) },
                    { reduce(EnterprisesContract.View.StateChanges.Error(error = it)) }
                )
        )
    }

    private fun mapToAdapterItems(items: List<Enterprise>): List<EnterprisesContract.View.DisplayableItem> {
        if (items.isEmpty()) return emptyList()

        val adapterItems: MutableList<EnterprisesContract.View.DisplayableItem> = mutableListOf()

        adapterItems += HeaderRow(
            firstColumn = "Наименование объекта учета",
            secondColumn = "Тип объекта недвижимости",
            thirdColumn = "Номер регистрации иного вещ-го права"
        )

        adapterItems += items.map {
            EnterpriseRow(
                id = it.id,
                firstColumn = it.objectAccountingName,
                secondColumn = it.propertyObjectType,
                thirdColumn = it.ownershipRegistrationNumberOther
            )
        }

        return adapterItems
    }

    override fun reduce(changes: Any) {
        curState = when (changes) {

            is EnterprisesContract.View.StateChanges.StartLoading ->
                curState.copy(
                    loading = true,
                    error = null
                )


            is EnterprisesContract.View.StateChanges.LoadSuccess ->
                curState.copy(
                    noContent = changes.enterprises.isEmpty(),
                    enterprises = changes.enterprises,
                    loading = false,
                    error = null
                )


            is EnterprisesContract.View.StateChanges.Error ->
                curState.copy(
                    loading = false,
                    error = changes.error
                )

            else -> curState
        }

        view.render(curState)
    }
}