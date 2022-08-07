package com.example.grpc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GrpcApplication

fun main(args: Array<String>) {
	runApplication<GrpcApplication>(*args)
}
