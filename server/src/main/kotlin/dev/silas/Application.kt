package dev.silas

import dev.silas.plugins.configureRouting
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.rpc.transport.ktor.server.RPC
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random

fun main() {
    CoroutineScope(Dispatchers.IO).launch {
        val counter = AtomicInteger(0)
        while (true) {
            delay(1000)
            RandomNumberProducer.emit(counter.incrementAndGet() to Random.nextInt())
        }
    }
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(RPC)
    configureRouting()
}

val RandomNumberProducer = MutableSharedFlow<Pair<Int, Int>>()
