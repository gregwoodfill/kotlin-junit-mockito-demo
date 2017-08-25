package com.gregwoodfill.kt.demo.controller

import com.gregwoodfill.kt.demo.domain.Customer
import com.gregwoodfill.kt.demo.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class CustomerController {

    @Autowired
    lateinit var customerService: CustomerService

    @GetMapping("/api/v1.0/customer/{customerId}",
            produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE)
    )
    fun getCustomer(@PathVariable("customerId") customerId: Int): Customer {
        return customerService.lookupCustomer(customerId)
    }

}
