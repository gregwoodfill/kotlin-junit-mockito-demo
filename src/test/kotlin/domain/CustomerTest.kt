package domain

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.gregwoodfill.kt.demo.domain.Customer
import org.amshove.kluent.shouldEqual
import org.junit.Test
import shouldEqualJson
import java.time.*

class CustomerTest {

    val objectMapper = ObjectMapper().registerModule(JavaTimeModule())
            .registerModule(KotlinModule())

    @Test
    fun `serializes`() {
        // given

        val customer = Customer(firstName = "greg", lastName = "woodfill", birthDate = LocalDate.of(2017, Month.AUGUST, 10))

        // when
        val serialized = objectMapper.writeValueAsString(customer)

        // then
        serialized shouldEqualJson """{"firstName": "greg","lastName":"woodfill","dateTime":"2017-08-10"}"""
    }
}