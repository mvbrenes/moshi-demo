package com.marcobrenes.kotshiapp.model

import com.squareup.moshi.Json
import se.ansman.kotshi.GetterName
import se.ansman.kotshi.JsonDefaultValueString
import se.ansman.kotshi.JsonSerializable
import java.util.*

@JsonSerializable
data class Person(
        val name: String,
        val email: String?,
        // This property uses a custom getter name which requires two annotations.
        @get:JvmName("hasVerifiedAccount") @GetterName("hasVerifiedAccount")
        val hasVerifiedAccount: Boolean,
        // This property has a different name in the Json than here so @Json must be applied.
        @Json(name = "created_at") val signUpDate: Date,
        @JsonDefaultValueString("") val jobTitle: String
)
