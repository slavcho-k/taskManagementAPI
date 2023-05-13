package com.taskmanagement.demo.domain

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 1,
    val name: String,
    val email: String,
)
