package com.malsato.rest

import com.malsato.business.config.EnableBusinessModule
import org.modelmapper.ModelMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableBusinessModule
class RestApplication

fun main(args: Array<String>) {
    runApplication<RestApplication>(*args)
}