package dev.silas.plugins

import dev.silas.NewsApi
import dev.silas.service.NewsApiImpl
import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import kotlinx.rpc.serialization.json
import kotlinx.rpc.transport.ktor.server.rpc

fun Application.configureRouting() {
    routing {
        rpc("/news") {
            rpcConfig {
                serialization {
                    json()
                }
            }

            registerService<NewsApi> { ctx -> NewsApiImpl(ctx) }

        }
    }
}
