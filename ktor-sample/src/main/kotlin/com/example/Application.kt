package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.locations.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(Locations)
        routing {
            greetingRoute()
            userRoute()
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
