package com.example.mvbrenes.moshiresearch

import com.example.mvbrenes.moshiresearch.ext.adapter
import com.example.mvbrenes.moshiresearch.models.Adult
import com.example.mvbrenes.moshiresearch.models.Child
import com.example.mvbrenes.moshiresearch.models.Person
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.reflect.Type

class PersonAdapterFactory : JsonAdapter.Factory {
    override fun create(type: Type, annotations: MutableSet<out Annotation>, moshi: Moshi): JsonAdapter<Person>? {
        if (type == Person::class.java) {
            val childJsonAdapter = moshi.adapter<Child>()
            val adultJsonAdapter = moshi.adapter<Adult>()
            moshi.nextAdapter<Person>(this, type, annotations)
            return object : JsonAdapter<Person>() {
                override fun fromJson(reader: JsonReader): Person? {
                    val o = reader.readJsonValue() as? Map<String, Any?>
                    return when ((o?.get("__typeName") as? String?)?.toLowerCase()) {
                        "child" -> childJsonAdapter.fromJsonValue(o)
                        "adult" -> adultJsonAdapter.fromJsonValue(o)
                        else -> null
                    }
                }

                override fun toJson(writer: JsonWriter, value: Person?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }
        }
        return null
    }
}
