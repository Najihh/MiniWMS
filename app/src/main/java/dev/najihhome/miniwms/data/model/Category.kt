package dev.najihhome.miniwms.data.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("category_id")
    val categoryId: Int,
    
    @SerializedName("name")
    val name: String
)