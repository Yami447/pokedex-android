package com.example.pokedex.di

import com.example.pokedex.data.remote.PokeApi
import com.example.pokedex.repository.PokemonRepository
import com.example.pokedex.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//defining how to construct dependencies for dagger to use
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Singleton means dagger will create only one instance of this field (PokemonRepository here)
    //Dagger will provided PokemonRepository wherever it is needed from here
    @Provides
    @Singleton
    fun providePokemonRepository(
        api: PokeApi
    ) = PokemonRepository(api)

    @Provides
    @Singleton
    fun providePokeApi() : PokeApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }
}