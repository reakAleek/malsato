package com.malsato.web.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Profile
import org.springframework.context.annotation.PropertySource

@Configuration
@EntityScan("com.malsato.data")
@PropertySource(value = [
    "classpath:data.properties",
    "classpath:web.properties"
])
class Base

@Profile("staging")
@Configuration
@PropertySource(value = [
    "classpath:data-staging.properties"
])
@Import(Base::class)
class Staging

@Profile("production")
@Configuration
@PropertySource(value = [
    "classpath:data-production.properties"
])
class Production