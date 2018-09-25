package com.malsato.rest.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author Jan Calanog, jan.calanog@iteratec.at
 */
@Configuration
class RestModelMapperConfiguration {
    @Bean
    fun getMapper(): ModelMapper {
        return ModelMapper()
    }
}