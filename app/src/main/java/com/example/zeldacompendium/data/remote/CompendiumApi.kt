package com.example.zeldacompendium.data.remote

import com.example.zeldacompendium.data.remote.responses.CompendiumList
import com.example.zeldacompendium.data.remote.responses.Data
import retrofit2.http.GET
import retrofit2.http.Path

interface CompendiumApi {

    @GET("all?game=2")
    suspend fun getTearsAllEntries(): CompendiumList

    @GET("all?game=1")
    suspend fun getBreathAllEntries(): CompendiumList

    @GET("category/{categoryName}?game=2")
    suspend fun getCategoriesTears(
        @Path("categoryName") categoryName: String
    ): Data

    @GET("category/{categoryName}?game=1")
    suspend fun getCategoriesBreath(
        @Path("categoryName") categoryName: String
    ): Data
}