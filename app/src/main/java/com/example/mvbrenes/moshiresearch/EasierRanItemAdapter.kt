package com.example.mvbrenes.moshiresearch

import com.example.mvbrenes.moshiresearch.models.RanItem
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class EasierRanItemAdapter {

    @FromJson
    fun ranItem(ranUnwrap: Map<String, Any?>): RanItem {
        return RanItem(ranUnwrap["value"] as? String, (Math.random() * 300).toInt())
    }

    @ToJson
    fun serialize(ranItem: RanItem): String {
        return "{}"
    }
}
