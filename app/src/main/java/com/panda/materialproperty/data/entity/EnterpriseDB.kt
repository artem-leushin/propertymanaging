package com.panda.materialproperty.data.entity

import com.panda.materialproperty.domain.entity.Enterprise

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */

data class EnterpriseDB(

    val id: Int = Int.MIN_VALUE,

    val cardStatus: String? = null,

    val objectAccountingName: String? = null,

    val rnfi: String? = null,

    val dateRnfi: String? = null,

    val totalSquare: Int? = null,

    val length: Int? = null,

    val ownershipRegistrationNumberRf: String? = null,

    val dateOwnershipRf: String? = null,

    val ownershipRegistrationNumberOther: String? = null,

    val dateOwnershipOther: String? = null,

    val cadasrtalNumber: String? = null,

    val dateCadastral: String? = null,

    val address: String? = null,

    val propertyObjectType: String? = null,

    val objectPurpose: String? = null,
    val inventoryNumber: Int? = null,
    val implementationYear: Int? = null,
    val initialPriceRub: Int? = null,
    val remainingPriceRub: Int? = null,
    val systemNumber: Int? = null,

    val requestNumber: Int? = null,

    val order: String? = null,
    val commentary: String? = null

)

fun EnterpriseDB.toDomain() =
    Enterprise(
        id,
        cardStatus ?: "",
        objectAccountingName ?: "",
        rnfi ?: "",
        dateRnfi ?: "",
        totalSquare ?: Int.MIN_VALUE,
        length ?: Int.MIN_VALUE,
        ownershipRegistrationNumberRf ?: "",
        dateOwnershipRf ?: "",
        ownershipRegistrationNumberOther ?: "",
        dateOwnershipOther ?: "",
        cadasrtalNumber ?: "",
        dateCadastral ?: "",
        address ?: "",
        propertyObjectType ?: "",
        objectPurpose ?: "",
        inventoryNumber ?: Int.MIN_VALUE,
        implementationYear ?: Int.MIN_VALUE,
        initialPriceRub ?: Int.MIN_VALUE,
        remainingPriceRub ?: Int.MIN_VALUE,
        systemNumber ?: Int.MIN_VALUE,
        requestNumber ?: Int.MIN_VALUE,
        order ?: "",
        commentary ?: ""
    )