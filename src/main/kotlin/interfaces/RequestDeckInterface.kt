package interfaces

import models.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface RequestDeckInterface
{
    @GET("deck/new/shuffle/")
    fun getNewDeck(@Query("deck_count ") deckCount: Int) : retrofit2.Call<Deck>

    @GET("deck/{deckId}/draw/")
    fun getCardsFromDeck(@Path("deckId") deckId: String, @Query("count") cardsNum: Int)
            :retrofit2.Call<Deck>

    @GET ("deck/{deckId}/shuffle/")
    fun reshuffleDeck(@Path("deckId") deckId: String) : retrofit2.Call<Deck>

    @GET("deck/{deckId}/pile/{pileName}/add/")
    fun addCardsToPiles(@Path("deckId") deckId: String, @Path("pileName")pileName: String,
                        @Query("cards") cards: String):
            retrofit2.Call<Pile>

}