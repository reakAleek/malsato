package com.malsato.data.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.*
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@ComponentScan("com.malsato.data")
@EntityScan("com.malsato.data")
@EnableJpaRepositories("com.malsato.data")
class DataModuleConfiguration {

    @Configuration
    @PropertySource("classpath:data.properties")
    class Base

    @Configuration
    @Profile("staging")
    @Import(Base::class)
    @PropertySource("classpath:data-staging.properties")
    class Staging

    @Configuration
    @Profile("production")
    @Import(Base::class)
    @PropertySource("classpath:data-production.properties")
    class Production
}

@Configuration
@Import(DataModuleConfiguration::class)
annotation class EnableDataModule