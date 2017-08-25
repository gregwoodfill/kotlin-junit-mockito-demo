package domain

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.gregwoodfill.kt.demo.domain.Customer
import org.amshove.kluent.shouldEqual
import org.junit.Test
import shouldEqualJson
import java.time.Instant
import java.time.Month
import java.time.ZoneId
import java.time.ZonedDateTime

class CustomerTest {

    val objectMapper = ObjectMapper().registerModule(JavaTimeModule())
            .registerModule(KotlinModule())

    @Test
    fun `serializes`() {
        // given

        val customer = Customer(firstName = "greg", lastName = "woodfill", dateTime = ZonedDateTime.of(2017, Month.AUGUST.value, 8, 10, 55, 34, 0, ZoneId.systemDefault()))

        // when
        val serialized = objectMapper.writeValueAsString(customer)

        // then
        serialized shouldEqualJson """{"firstName": "greg","lastName":"woodfill","dateTime":"2017-08-08T10:55:34"}"""
    }
}