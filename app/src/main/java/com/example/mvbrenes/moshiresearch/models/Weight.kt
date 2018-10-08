/**
 * Created by Marco Brenes on 10/8/18.
 *
 * Copyright (C) 2018 Lowe's Companies Inc.
 *
 * This application is the private property of Lowe's Companies Inc.
 * Any distribution of this software is unlawful and prohibited.
 */
package com.example.mvbrenes.moshiresearch.models

class Weight(
        val value: Double,
        val unitType: WeightType
) {

    enum class WeightType {
        KG, LBS
    }
}
