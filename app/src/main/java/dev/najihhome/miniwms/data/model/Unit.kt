package dev.najihhome.miniwms.data.model

import com.google.gson.annotations.SerializedName

data class Unit(
    @SerializedName("unit_id")
    val unitId: Int,
    
    @SerializedName("name")
    val name: String,
    
    @SerializedName("symbol")
    val symbol: String,
    
    @SerializedName("created_at")
    val createdAt: String
)