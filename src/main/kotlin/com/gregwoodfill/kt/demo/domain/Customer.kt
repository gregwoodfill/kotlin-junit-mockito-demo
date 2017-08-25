package com.gregwoodfill.kt.demo.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.util.ISO8601DateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

data class Customer(
        @get:JsonProperty("firstName")
        val firstName: String,
        @get:JsonProperty("lastName")
        val lastName: String,
        @get:JsonFormat(pattern = "yyyy-MM-dd")
        @get:JsonProperty("dateTime")
        val birthDate: LocalDate? = null)