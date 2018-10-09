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

class Person(
        @Json(name = "__typeName") val typeName: String = "this is a type",
        @Json(name = "first_name") val firstName: String,
        val lastName: String,
        val weight: Weight,
        @Transient var sensitiveInformation: String?)