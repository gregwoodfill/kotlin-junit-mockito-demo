package com.gregwoodfill.kt.demo

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

fun main(args: Array<String>) {
    SpringApplication.run(KotlinJunitDemoApp::class.java, *args)
}

@SpringBootApplication
class KotlinJunitDemoApp {


    @Bean
    fun objectMapperCustomizer(): Jackson2ObjectMapperBuilder {
        return Jackson2ObjectMapperBuilder().modulesToInstall(KotlinModule(),
                JavaTimeModule())
    }
}