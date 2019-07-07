package interfaces

import models.Deck
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


}