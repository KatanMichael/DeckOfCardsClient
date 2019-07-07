package models

data class Deck(
    val cards: List<Card>,
    val deck_id: String,
    val remaining: Int,
    val success: Boolean
)