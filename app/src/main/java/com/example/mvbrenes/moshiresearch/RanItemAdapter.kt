/**
 * Created by Marco Brenes on 10/8/18.
 *
 * Copyright (C) 2018 Lowe's Companies Inc.
 *
 * This application is the private property of Lowe's Companies Inc.
 * Any distribution of this software is unlawful and prohibited.
 */
package com.example.mvbrenes.moshiresearch

import com.example.mvbrenes.moshiresearch.models.RanItem
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class RanItemAdapter : JsonAdapter<RanItem>() {

    override fun fromJson(reader: JsonReader): RanItem? {
        reader.beginObject()
        return RanItem().apply {
            while (reader.hasNext()) {
                if (reader.nextName() == "value") {
                    value = reader.nextString()
                }
            }
            random = (Math.random() * 300).toInt()
        }
    }

    override fun toJson(writer: JsonWriter, value: RanItem?) {
        writer.beginObject()
                .name("value")
                .value(value?.value)
                .name("random")
                .value(value?.random)
                .endObject()
    }
}