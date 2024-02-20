package com.example.zeldacompendium.domain.repository

import android.util.Log
import com.example.zeldacompendium.data.remote.CompendiumApi
import com.example.zeldacompendium.data.remote.responses.CompendiumList
import com.example.zeldacompendium.data.remote.responses.Data
import com.example.zeldacompendium.data.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CompendiumRepository @Inject constructor(
   private val api: CompendiumApi
){
   suspend fun getTearsAllEntries(): Resource<CompendiumList> {
      val response = try {
         api.getTearsAllEntries()
      } catch (e: Exception) {
         return Resource.Error("An unknown error occurred.")
      }
      return Resource.Success(response)
   }

   suspend fun getBreathAllEntries(): Resource<CompendiumList> {
      val response = try {
         api.getBreathAllEntries()
      } catch (e: Exception) {
         return Resource.Error("An unknown error occurred.")
      }
      return Resource.Success(response)
   }

   suspend fun getItemInfo(id: Int) : Resource<Data> {
      val response = try {
         Log.d("getItemInfo",api.getItemInfo(id).toString())
         api.getItemInfo(id)
      } catch (e: Exception) {
         return Resource.Error("An unknow error ocurred.")
      }
      return Resource.Success(response)
   }
}