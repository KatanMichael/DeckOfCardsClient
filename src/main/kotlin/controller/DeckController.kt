package controller

import interfaces.RequestDeckInterface
import interfaces.RequestListener
import models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DeckController
{
    private val retrofitCards = Retrofit.Builder().baseUrl("https://deckofcardsapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    private val cardsClient = retrofitCards.create(RequestDeckInterface::class.java)

    fun getNewDeck(deckCount: Int, requestListener: RequestListener)
    {
        cardsClient.getNewDeck(deckCount).enqueue(object : Callback<Deck>
        {
            override fun onFailure(call: Call<Deck>, t: Throwable)
            {
                requestListener.onError(t.message.toString())

            }

            override fun onResponse(call: Call<Deck>, response: Response<Deck>)
            {
                val body = response.body()

                if(body != null)
                {
                    requestListener.onComplete(body)
                }
            }

        })
    }


    fun drawCardsFromDeck(deckId: String, numOfCards: Int, requestListener: RequestListener)
    {

        cardsClient.getCardsFromDeck(deckId,numOfCards)
            .enqueue(object : Callback<Deck>
            {
                override fun onFailure(call: Call<Deck>, t: Throwable)
                {
                    requestListener.onError(t.message.toString())
                }

                override fun onResponse(call: Call<Deck>, response: Response<Deck>)
                {
                    val body = response.body()
                    if(body != null)
                    {
                        requestListener.onComplete(body)
                    }
                }

            })


    }

    fun reshuffleDeck(deckId: String,requestListener: RequestListener)
    {
        cardsClient.reshuffleDeck(deckId)
            .enqueue(object : Callback<Deck>
            {
                override fun onResponse(call: Call<Deck>, response: Response<Deck>)
                {
                    val body = response.body()

                    if(body != null)
                    {
                        requestListener.onComplete(body)
                    }
                }

                override fun onFailure(call: Call<Deck>, t: Throwable)
                {
                    requestListener.onError(t.message.toString())
                }

            })
    }

    fun addCardsToPiles(deckId: String, pileName: String, cards: List<Card>
                            ,requestListener: RequestListener)
    {
        var cardForPiles = ""

        for(c in cards)
        {
            cardForPiles+=c.code+","
        }

        cardForPiles = cardForPiles.substring(0,cardForPiles.length-1)

        cardsClient.addCardsToPiles(deckId,pileName,cardForPiles)
            .enqueue(object : Callback<Pile>
            {
                override fun onFailure(call: Call<Pile>, t: Throwable)
                {
                    requestListener.onError(t.message.toString())
                }

                override fun onResponse(call: Call<Pile>, response: Response<Pile>)
                {
                    val body = response.body()
                    if(body != null)
                    {
                        requestListener.onComplete(body)
                    }
                }

            })
    }


}