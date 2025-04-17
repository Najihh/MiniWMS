package dev.najihhome.miniwms.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("name")
    val name: String,
) : Parcelable