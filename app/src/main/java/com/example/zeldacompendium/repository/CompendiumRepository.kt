package com.example.zeldacompendium.repository

import com.example.zeldacompendium.data.remote.CompendiumApi
import com.example.zeldacompendium.data.remote.responses.CompendiumList
import com.example.zeldacompendium.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CompendiumRepository @Inject constructor(
    private val api: CompendiumApi
){
    suspend fun getAllEntries(): Resource<CompendiumList> {
        val response = try {
            api.getAllEntries()
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }
}