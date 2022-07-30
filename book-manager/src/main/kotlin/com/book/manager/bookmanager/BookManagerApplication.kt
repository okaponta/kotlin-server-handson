package com.book.manager.bookmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookManagerApplication

fun main(args: Array<String>) {
	runApplication<BookManagerApplication>(*args)
}
