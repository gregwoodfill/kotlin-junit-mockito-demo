package com.gregwoodfill.kt.demo.controller

import com.gregwoodfill.kt.demo.domain.Customer
import com.gregwoodfill.kt.demo.service.CustomerService
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.whenever
import org.amshove.kluent.itReturns
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldNotBeNull
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.time.Instant
import java.time.ZonedDateTime

class CustomerControllerTest {

    val customerController = CustomerController()
    val customerService: CustomerService = mock()

    @Before
    fun setup() {
        customerController.customerService = customerService
    }

    @Test
    fun `gets customer data`() {
        // given
        val now = ZonedDateTime.now()

        val expectedCustomer = Customer(
                firstName = "greg",
                lastName = "woodfill",
                dateTime = now)

        whenever(customerService.lookupCustomer(100))
                .itReturns(expectedCustomer)

        // when
        val response = customerController.getCustomer(100)

        // then
        response.shouldNotBeNull()
        response shouldEqual expectedCustomer

        verify(customerService).lookupCustomer(100)
        verifyNoMoreInteractions(customerService)

    }
}