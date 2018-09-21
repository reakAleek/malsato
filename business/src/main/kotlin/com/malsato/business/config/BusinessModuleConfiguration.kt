package com.malsato.business.config
import com.malsato.data.config.EnableDataModule
import org.springframework.context.annotation.*

@Configuration
@EnableDataModule
@ComponentScan("com.malsato.business")
class BusinessModuleConfiguration {

    @Configuration
    @PropertySource("classpath:business.properties")
    class Base

    @Configuration
    @Profile("staging")
    @Import(Base::class)
    @PropertySource("classpath:business-staging.properties")
    class Staging

    @Configuration
    @Profile("production")
    @Import(Base::class)
    @PropertySource("classpath:business-production.properties")
    class Production
}

@Configuration
@Import(BusinessModuleConfiguration::class)
annotation class EnableBusinessModule