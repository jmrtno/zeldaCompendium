package com.example.zeldacompendium.data.remote

import com.example.zeldacompendium.data.remote.responses.CompendiumList
import com.example.zeldacompendium.data.remote.responses.Data
import retrofit2.http.GET
import retrofit2.http.Path

interface CompendiumApi {

    @GET("all?game=2")
    suspend fun getAllEntries(): CompendiumList

    @GET("category/{categoryName}?game=2")
    suspend fun getCategories(
        @Path("categoryName") category: String
    ): Data
}