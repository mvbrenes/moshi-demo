package com.marcobrenes.kotshiapp

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson
import java.io.IOException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateAdapter {

    private val simpleDateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)

    @ToJson
    @Throws(IOException::class)
    fun toJson(jsonWriter: JsonWriter, date: Date) {
        jsonWriter.value(simpleDateFormat.format(date))
    }

    @FromJson
    fun toDate(json: String): Date? {
        return try {
            simpleDateFormat.parse(json)
        } catch (e: ParseException) {
            null
        }
    }
}
