package com.marcobrenes.kotshiapp

import com.squareup.moshi.JsonAdapter
import se.ansman.kotshi.KotshiJsonAdapterFactory

@KotshiJsonAdapterFactory
abstract class TestFactory : JsonAdapter.Factory {
    companion object {
        val INSTANCE: TestFactory = KotshiTestFactory()
    }
}
