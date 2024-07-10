import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.help
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.int
import dev.silas.NewsApi
import io.ktor.client.HttpClient
import io.ktor.client.request.url
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlinx.rpc.client.withService
import kotlinx.rpc.serialization.json
import kotlinx.rpc.streamScoped
import kotlinx.rpc.transport.ktor.client.installRPC
import kotlinx.rpc.transport.ktor.client.rpc
import kotlinx.rpc.transport.ktor.client.rpcConfig
import mu.KotlinLogging

class CliKlient : CliktCommand() {

    private val logger = KotlinLogging.logger { }

    private val host: String by option().default("localhost").help("host to use default is localhost")
    private val port: Int by option().int().default(8080).help("port to use default is 8080")
    private val count: Int by option().int().default(5).help("Number of news to fetch")
    private val topic: String by option().default("news").help("The topic you are looking for")

    override fun run(): Unit = runBlocking {
        val client = HttpClient { installRPC() }.rpc {
            url("ws://$host:$port/$topic")
            rpcConfig {
                serialization {
                    json()
                }
            }
        }
        streamScoped {

            val topicStream = runCatching {
                client.withService<NewsApi>().getNews(topic)
            }.getOrElse { _ ->
                logger.error { "the topic was not found" }
                emptyFlow()
            }

            topicStream.take(count).collect { news ->
                with(news) {
                    println(buildString {
                        appendLine("Topic: $title")
                        appendLine("-----")
                        appendLine(content)
                        appendLine("-----")
                    })
                }
            }
        }
    }
}