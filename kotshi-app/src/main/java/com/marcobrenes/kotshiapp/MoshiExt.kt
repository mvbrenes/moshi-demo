/**
 * Created by Marco Brenes on 10/8/18.
 *
 * Copyright (C) 2018 Lowe's Companies Inc.
 *
 * This application is the private property of Lowe's Companies Inc.
 * Any distribution of this software is unlawful and prohibited.
 */
package com.marcobrenes.kotshiapp

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

inline fun <reified M> Moshi.adapter() : JsonAdapter<M> = this.adapter(M::class.java)