package com.marcobrenes.kotshiapp

import com.marcobrenes.kotshiapp.model.Person
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import okio.Buffer
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.text.SimpleDateFormat
import java.util.*

@RunWith(JUnit4::class)
class KotshiTests {

    private val moshi: Moshi = Moshi.Builder()
            .add(TestFactory.INSTANCE)
            .add(DateAdapter())
            .build()

    @Test fun initialTest() {
        val json = """
            | {
            |   "name": "marco",
            |   "hasVerifiedAccount": false,
            |   "created_at": "12/18/1992"
            | }
        """.trimMargin()

        val adapter = moshi.adapter<Person>()
        val actual = adapter.fromJson(json)
        val expected = Person(
                name = "marco",
                email = null,
                hasVerifiedAccount = false,
                signUpDate = SimpleDateFormat("MM/dd/yyyy", Locale.US).parse("12/18/1992"),
                jobTitle = ""
        )

        val jsonString = """
            |{
            |   "name": "marco",
            |   "hasVerifiedAccount": false,
            |   "created_at": "12/18/1992",
            |   "jobTitle": ""
            |}
        """.trimMargin()

        assertEquals(actual, expected)
        assertEquals(jsonString, Buffer()
                .apply {
                    JsonWriter.of(this).run {
                        indent = "   "
                        adapter.toJson(this, actual)
                    }
                }
                .readUtf8())
    }
}
