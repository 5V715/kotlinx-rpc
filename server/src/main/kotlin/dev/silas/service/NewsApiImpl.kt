package dev.silas.service

import dev.silas.News
import dev.silas.NewsApi
import dev.silas.RandomNumberProducer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.CoroutineContext

class NewsApiImpl(override val coroutineContext: CoroutineContext) : NewsApi {

    override suspend fun getNews(topic: String): Flow<News> = flow {
        RandomNumberProducer.collect { (index, random) ->
            emit(News(title = "News #$index", content = "the current random number is $random"))
        }
    }
}