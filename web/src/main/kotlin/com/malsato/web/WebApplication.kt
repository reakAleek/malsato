package com.malsato.web

import com.malsato.business.config.EnableBusinessModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
@EnableBusinessModule
class WebApplication

fun main(args: Array<String>) {
    runApplication<WebApplication>(*args)
}
