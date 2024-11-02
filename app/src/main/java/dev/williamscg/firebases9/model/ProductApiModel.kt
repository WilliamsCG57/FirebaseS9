package dev.williamscg.firebases9.model

data class ProductApiModel(
    val id: String ="",
    val description: String ="",
    val imageUrl: String = "",
    val stock: Int,
    val price: Double,
    val discount: Double,
    val categoryId: Int
)
