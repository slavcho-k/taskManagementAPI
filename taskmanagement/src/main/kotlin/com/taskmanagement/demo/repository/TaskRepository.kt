package com.taskmanagement.demo.repository

import com.taskmanagement.demo.domain.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository: JpaRepository<Task, Long> {
}