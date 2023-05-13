package com.taskmanagement.demo.service

import com.taskmanagement.demo.domain.User
import com.taskmanagement.demo.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun addUser() {
        userRepository.save(User(name = "Slavco", email = "slavco@slavco"))
    }
}