package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        routing {
            get("/") {
                call.respondText("Hello Ktor!")
            }
        }
    }.start(wait = true)
}

fun Application.module(testing: Boolean = false) {
    routing {
        get("/") {
            call.respondText("Hello Ktor!")
        }
    }
}
