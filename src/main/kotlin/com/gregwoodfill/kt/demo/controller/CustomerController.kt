package com.gregwoodfill.kt.demo.controller

import com.gregwoodfill.kt.demo.domain.Customer
import com.gregwoodfill.kt.demo.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant


@RestController
class CustomerController {

    @Autowired
    lateinit var customerService: CustomerService

    @GetMapping("/api/v1.0/customer/{customerId}")
    fun getCustomer(customerId: Int): Customer {
        return customerService.lookupCustomer(customerId)
    }

}
