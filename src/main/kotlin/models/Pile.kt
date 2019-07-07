package models

data class Pile(
    val deck_id: String,
    val piles: Piles,
    val remaining: Int,
    val success: Boolean
)