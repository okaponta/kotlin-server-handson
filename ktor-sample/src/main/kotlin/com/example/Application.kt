package com.example

import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.locations.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(Locations)
        install(ContentNegotiation) {
            jackson()
        }
        routing {
            greetingRoute()
            userRoute()
            bookRoute()
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

fun Routing.greetingRoute() {
    route("greeting") {
        get("/hello") {
            call.respondText("Hello!")
        }
        get("/goodmorning") {
            call.respondText("Good morning!")
        }
    }
}

fun Routing.userRoute() {
    get<UserLocation.GetUserLocation> { param ->
        val id = param.id
        call.respondText("id=$id")
    }
    get<UserLocation.GetDetailLocation> { param ->
        val id = param.id
        call.respondText("getDetail id=$id")
    }
}

@Location("/user")
class UserLocation {
    @Location("/{id}")
    data class GetUserLocation(val id: Long)

    @Location("/detail/{id}")
    data class GetDetailLocation(val id: Long)
}

fun Routing.bookRoute() {
    route("/book") {
        @Location("detail/{bookId}")
        data class BookLocation(val bookId: Long)
        get<BookLocation> { request ->
            val response = BookResponse(request.bookId, "Kotlin入門", "Kotlin太郎")
            call.respond(response)
        }

        post("/register") {
            val request = call.receive<RegisterRequest>()
            call.respondText("registered id =${request.id}")
        }
    }
}

data class BookResponse(
    val id: Long,
    val title: String,
    val author: String
)

data class RegisterRequest(
    val id: Long
)
