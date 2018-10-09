package com.example.mvbrenes.moshiresearch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mvbrenes.moshiresearch.ext.adapter
import com.example.mvbrenes.moshiresearch.models.Person
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val json = """
        {
            "__typeName" : "child",
            "first_name" : "John",
            "lastName" : "Doe",
            "weight" : {
                "value" : 75.5,
                "unitType" : "KG"
            },
            "dob" : "08/12/1980"
        }
    """.trimIndent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moshi = Moshi.Builder()
                .add(WeightAdapter())
                .add(DateAdapter())
                .build()
        val personAdapter: JsonAdapter<Person> = moshi.adapter()

        var person: Person? = null
        try {
            person = personAdapter.fromJson(json)
        } catch (e: IOException) {
            // this is a checked exception
        }
        person?.sensitiveInformation = "this is sensitive"
        val result = personAdapter.toJson(person)
        Log.d("done", result)
    }
}
