package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        routing {
            get("/") {
                call.respondText("Hello Ktor!")
            }
            get("/hello/{name}") {
                val name = call.parameters["name"]
                call.respondText("Hello $name!")
            }
            get("/hello") {
                val name = call.request.queryParameters["name"]
                call.respondText("Hello $name!")
            }
        }
    }.start(wait = true)
}
