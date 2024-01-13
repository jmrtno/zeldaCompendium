package com.example.zeldacompendium.di

import com.example.zeldacompendium.data.remote.CompendiumApi
import com.example.zeldacompendium.repository.CompendiumRepository
import com.example.zeldacompendium.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: CompendiumApi
    ) = CompendiumRepository(api)

    @Singleton
    @Provides
    fun providePokeApi(): CompendiumApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(CompendiumApi:: class.java)
    }
}