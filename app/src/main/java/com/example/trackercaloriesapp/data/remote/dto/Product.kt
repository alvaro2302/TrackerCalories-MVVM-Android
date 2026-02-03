package com.example.trackercaloriesapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(
    @Json(name = "image_front_thumb_url")
    val imageFromThumbUrl: String?,
    val nutriments: Nutriments,
    @Json(name = "product_name")
    val productName: String?

)
