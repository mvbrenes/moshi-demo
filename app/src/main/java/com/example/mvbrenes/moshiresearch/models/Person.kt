/**
 * Created by Marco Brenes on 10/8/18.
 *
 * Copyright (C) 2018 Lowe's Companies Inc.
 *
 * This application is the private property of Lowe's Companies Inc.
 * Any distribution of this software is unlawful and prohibited.
 */
package com.example.mvbrenes.moshiresearch.models

import com.squareup.moshi.Json

open class Person(
        @Json(name = "__typeName") val typeName: String,
        @Json(name = "first_name") val firstName: String,
        val lastName: String,
        val weight: Weight,
        @Transient var sensitiveInformation: String?)

class Child(typeName: String, firstName: String, lastName: String, weight: Weight, sensitiveInformation: String?) :
        Person(typeName = typeName,
                firstName = firstName,
                lastName = lastName,
                weight = weight,
                sensitiveInformation = sensitiveInformation) {
    override fun toString(): String {
        return "isChild"
    }
}

class Adult(typeName: String, firstName: String, lastName: String, weight: Weight, sensitiveInformation: String?) :
        Person(typeName = typeName,
                firstName = firstName,
                lastName = lastName,
                weight = weight,
                sensitiveInformation = sensitiveInformation) {
    override fun toString(): String {
        return "isAdult"
    }
}