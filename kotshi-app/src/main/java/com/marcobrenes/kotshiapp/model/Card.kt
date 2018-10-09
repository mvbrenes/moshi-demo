/**
 * Created by Marco Brenes on 10/9/18.
 *
 * Copyright (C) 2018 Lowe's Companies Inc.
 *
 * This application is the private property of Lowe's Companies Inc.
 * Any distribution of this software is unlawful and prohibited.
 */
package com.marcobrenes.kotshiapp.model

import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class Card(
        val rank: String,
        val suit: Suit) {

    enum class Suit {
        CLUBS, HEARTS, SPADES, DIAMONDS
    }
}