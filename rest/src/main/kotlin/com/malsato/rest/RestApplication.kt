package com.malsato.rest

import com.malsato.business.config.EnableBusinessModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableBusinessModule
class RestApplication

fun main(args: Array<String>) {
    runApplication<RestApplication>(*args)
}