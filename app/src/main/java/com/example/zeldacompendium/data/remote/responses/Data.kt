package com.example.zeldacompendium.data.remote.responses

import com.google.gson.annotations.SerializedName

data class Data(
    val category: String,
    @SerializedName("common_locations") val commonLocations: List<String>?,
    @SerializedName("cooking_effect") val cookingEffect: String,
    val description: String,
    val dlc: Boolean,
    val drops: List<String>,
    val edible: Boolean,
    @SerializedName("fuse_attack_power") val fuseAttackPower: Int,
    @SerializedName("hearts_recovered")val heartsRecovered: Double,
    val id: Int,
    val image: String,
    val name: String,
    val properties: Properties
)