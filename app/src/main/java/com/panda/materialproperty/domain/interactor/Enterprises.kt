package com.panda.materialproperty.domain.interactor

import com.panda.materialproperty.domain.entity.Enterprise
import com.panda.materialproperty.domain.repository.EnterprisesRepository
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by A.Olkinitskaya on 19.06.2018.
 */

class LoadAllEnterprisesUseCase(
    private val repository: EnterprisesRepository
) {

    fun load(): Observable<List<Enterprise>> = repository.getAllEnterprises()
}

class LoadEnterprisesAtLocationUseCase(
    private val repository: EnterprisesRepository
) {
    fun load(address: String): Observable<List<Enterprise>> =
        repository.getEnterprisesForLocation(address)
}