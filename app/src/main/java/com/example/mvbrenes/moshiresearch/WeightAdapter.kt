package com.example.mvbrenes.moshiresearch

import com.example.mvbrenes.moshiresearch.models.Weight
import com.squareup.moshi.FromJson
import java.util.*

private const val KG_TO_LBS = 2.20462

class WeightAdapter {

    @FromJson
    fun toWeight(map: Map<String, Any?>): Weight = Weight(
            map["value"] as Double,
            if (map["unitType"] == "LBS") Weight.WeightType.LBS
            else Weight.WeightType.KG
    ).apply {
        if (Locale.getDefault() == Locale.US && unitType == Weight.WeightType.KG) {
            unitType = Weight.WeightType.LBS
            value = KG_TO_LBS
        } else if (Locale.getDefault() != Locale.US && unitType == Weight.WeightType.LBS) {
            unitType = Weight.WeightType.KG
            value /= KG_TO_LBS
        }
    }
}
