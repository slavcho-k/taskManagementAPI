package com.taskmanagement.demo.repository

import com.taskmanagement.demo.domain.User
import org.springframework.data.jpa.repository.JpaRepository


interface UserRepository: JpaRepository<User, Int> {
}