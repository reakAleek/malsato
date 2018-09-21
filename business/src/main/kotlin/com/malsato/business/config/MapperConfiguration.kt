package com.malsato.business.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MapperConfiguration {
    @Bean
    fun getMapper(): ModelMapper {
        return ModelMapper()
    }
}