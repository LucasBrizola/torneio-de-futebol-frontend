package com.brizola.torneiofut.team.domain.data

import com.brizola.torneiofut.player.Player
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Team(
    val name: String,
    val players: ArrayList<Player>
)