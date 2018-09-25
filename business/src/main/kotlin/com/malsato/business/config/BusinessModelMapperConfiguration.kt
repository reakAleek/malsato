package com.malsato.business.config

import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author Jan Calanog, jan.calanog@iteratec.at
 */
@Configuration
class BusinessModelMapperConfiguration {
    @Bean
    fun getMapper(): ModelMapper {
        return ModelMapper()
    }
}