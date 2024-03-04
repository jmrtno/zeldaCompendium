package com.example.zeldacompendium.data.remote

import com.example.zeldacompendium.data.remote.responses.CompendiumList
import com.example.zeldacompendium.data.remote.responses.Data
import com.example.zeldacompendium.data.remote.responses.ItemDetailModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CompendiumApi {

    @GET("all?game=1")
    suspend fun getBreathAllEntries(): CompendiumList

    @GET("all?game=2")
    suspend fun getTearsAllEntries(): CompendiumList

    @GET("entry/{id}")
    suspend fun getItemInfo(
        @Path("id") itemId: Int,
        @Query("game") game: Int
    ): ItemDetailModel
}