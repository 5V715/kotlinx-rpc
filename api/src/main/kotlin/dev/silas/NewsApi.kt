package dev.silas

import kotlinx.coroutines.flow.Flow
import kotlinx.rpc.RPC
import kotlinx.serialization.Serializable

interface NewsApi : RPC {
    suspend fun getNews(topic: String): Flow<News>
}

@Serializable
data class News(
    val title: String,
    val content: String
)