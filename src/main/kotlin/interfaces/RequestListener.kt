package interfaces

interface RequestListener
{
    fun <T> onComplete (t: T)
    fun onError(msg: String)
}