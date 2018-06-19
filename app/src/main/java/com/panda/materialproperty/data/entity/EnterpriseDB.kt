package com.panda.materialproperty.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.panda.materialproperty.domain.entity.Enterprise

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */

data class EnterpriseDB(

    val id: Int = Int.MIN_VALUE,

    val cardStatus: String,

    val objectAccountingName: String,

    val rnfi: String,

    val dateRnfi: String,

    val totalSquare: Int? = null,

    val length: Int? = null,

    val ownershipRegistrationNumberRf: String? = null,

    val dateOwnershipRf: String? = null,

    val ownershipRegistrationNumberOther: String? = null,

    val dateOwnershipOther: String? = null,

    val cadasrtalNumber: String? = null,

    val dateCadastral: String? = null,

    val address: String,

    val propertyObjectType: String,

    val objectPurpose: String,
    val inventoryNumber: Int,
    val implementationYear: Int,
    val initialPriceRub: Int,
    val remainingPriceRub: Int,
    val systemNumber: Int,

    val requestNumber: Int,

    val order: String,
    val commentary: String? = null

)

fun EnterpriseDB.toDomain() =
    Enterprise(
        id,
        cardStatus,
        objectAccountingName,
        rnfi,
        dateRnfi,
        totalSquare ?: Int.MIN_VALUE,
        length ?: Int.MIN_VALUE,
        ownershipRegistrationNumberRf ?: "",
        dateOwnershipRf ?: "",
        ownershipRegistrationNumberOther ?: "",
        dateOwnershipOther ?: "",
        cadasrtalNumber ?: "",
        dateCadastral ?: "",
        address,
        propertyObjectType,
        objectPurpose,
        inventoryNumber,
        implementationYear,
        initialPriceRub,
        remainingPriceRub,
        systemNumber,
        requestNumber,
        order,
        commentary ?: ""
    )