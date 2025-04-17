package dev.najihhome.miniwms.data.model

import com.google.gson.annotations.SerializedName

data class Attribute(
    @SerializedName("attribute_id")
    val attributeId: Int,
    
    @SerializedName("name")
    val name: String,
    
    @SerializedName("type")
    val type: String,
    
    @SerializedName("list")
    val list: String
)