package dev.najihhome.miniwms.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("status")
    val status: Int,
    
    @SerializedName("status_message")
    val statusMessage: String,
    
    @SerializedName("data")
    val data: T
)
