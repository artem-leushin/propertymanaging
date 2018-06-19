package com.panda.materialproperty.data.repository

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.panda.materialproperty.data.entity.toDomain
import com.panda.materialproperty.domain.entity.Enterprise
import com.panda.materialproperty.domain.repository.EnterprisesRepository
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */

class EnterprisesRepositoryImpl(
    private val dao: EnterprisesDao
) : EnterprisesRepository {

    override fun getAllEnterprises(): Flowable<List<Enterprise>> =
        dao.getAllEnterprises().map { it.map { it.toDomain() } }

    override fun getEnterprisesForLocation(where: String): Flowable<List<Enterprise>> =
        dao.getEnterprisesForLocationMatch(where).map {
            it.map {
                it.toDomain()
            }
        }
}