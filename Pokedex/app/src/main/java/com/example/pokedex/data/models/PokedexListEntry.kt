package com.example.pokedex.data.models

import dagger.hilt.android.lifecycle.HiltViewModel

data class PokedexListEntry(
    val pokemonName: String,
    val imageUrl: String,
    val number: Int
)

