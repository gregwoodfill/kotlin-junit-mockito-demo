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
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
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

        val expectedCustomer = Customer(
                firstName = "greg",
                lastName = "woodfill",
                birthDate = LocalDate.now())

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