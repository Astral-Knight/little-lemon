package com.example.littlelemoncapstone

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuNetwork(
    @SerialName("menu")
    val menuItems: List<MenuItemNetwork>
)
@Serializable
data class MenuItemNetwork(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("price")
    val price: String,
    @SerialName("image")
    val image: String,
    @SerialName("category")
    val category: String
) {
    fun toMenuItemRoom() = MenuItemRoom(
        id = id,
        title = title,
        price = price.toDouble(),
        description = description,
        image = image,
        category = category
    )
}


