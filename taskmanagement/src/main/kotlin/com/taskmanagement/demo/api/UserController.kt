package com.taskmanagement.demo.api

import com.taskmanagement.demo.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UserController(
    private val userService: UserService,
) {
    @PostMapping("/addUser")
    fun addUser(): String {
        TODO()
    }
}