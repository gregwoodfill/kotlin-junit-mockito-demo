package com.gregwoodfill.kt.demo.controller

import com.gregwoodfill.kt.demo.domain.Customer
import com.gregwoodfill.kt.demo.service.CustomerService
import com.nhaarman.mockito_kotlin.whenever
import org.amshove.kluent.itReturns
import org.amshove.kluent.shouldEqual
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner::class)
class CustomerControllerWebTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @MockBean
    lateinit var customerService: CustomerService

    @Test
    fun `gets customer data`() {
        // given
        val expectedCustomer = Customer(firstName = "greg", lastName = "woodfill")
        whenever(customerService.lookupCustomer(100)).itReturns(expectedCustomer)

        // when
        val response = testRestTemplate.getForObject("/api/v1.0/customer/100", Customer::class.java)

        // then
        response shouldEqual expectedCustomer
    }
}