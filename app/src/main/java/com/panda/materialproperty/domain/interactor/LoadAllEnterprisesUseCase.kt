package com.panda.materialproperty.domain.interactor

import com.panda.materialproperty.domain.entity.Enterprise
import com.panda.materialproperty.domain.repository.EnterprisesRepository
import io.reactivex.Flowable

/**
 * Created by A.Olkinitskaya on 19.06.2018.
 */
class LoadAllEnterprisesUseCase(
    private val repository: EnterprisesRepository
) {

    fun load(): Flowable<List<Enterprise>> = repository.getAllEnterprises()
}