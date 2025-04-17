package dev.najihhome.miniwms.data.model

import com.google.gson.annotations.SerializedName

data class ProductDetail(
    @SerializedName("product_id")
    val productId: Int,
    
    @SerializedName("name")
    val name: String,
    
    @SerializedName("image")
    val image: String,
    
    @SerializedName("category")
    val category: Category,
    
    @SerializedName("attribute1")
    val attribute1: Attribute,
    
    @SerializedName("attribute2")
    val attribute2: Attribute,
    
    @SerializedName("attribute3")
    val attribute3: Attribute,
    
    @SerializedName("qty_min")
    val qtyMin: Int,
    
    @SerializedName("qty_max")
    val qtyMax: Int,
    
    @SerializedName("unit_base")
    val unitBase: Unit,
    
    @SerializedName("unit_sub")
    val unitSub: Unit,
    
    @SerializedName("convertion_factor")
    val convertionFactor: Int,
    
    @SerializedName("rfid")
    val rfid: List<String>
)