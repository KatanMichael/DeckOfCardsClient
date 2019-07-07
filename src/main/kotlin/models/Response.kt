package models

data class Response(
    val deck_id: String,
    val remaining: Int,
    val shuffled: Boolean,
    val success: Boolean
)