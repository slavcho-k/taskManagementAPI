package com.taskmanagement.demo.service

import com.taskmanagement.demo.domain.Task
import com.taskmanagement.demo.domain.TaskDto
import com.taskmanagement.demo.repository.TaskRepository
import com.taskmanagement.demo.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TaskService(
    private val taskRepository: TaskRepository,
    private val userRepository: UserRepository,
) {
    fun getAllTasks(): List<Task> {
        return taskRepository.findAll().sorted().toList()
    }

    fun addTask(taskDto: TaskDto): ResponseEntity<String> {
        val user = userRepository.findById(taskDto.userId)

        val response = user.map { foundUser ->
            val task = Task(
                id = 0,
                name = taskDto.name,
                description = taskDto.description,
                user = foundUser
            )

            taskRepository.save(task)
            ResponseEntity.ok("Saved a new task with id: ${task.id}")
        }.orElse(ResponseEntity.notFound().build())

        return response
    }

    fun deleteTask(id: Int): ResponseEntity<String> {
        val task = taskRepository.findById(id.toLong())

        return if (task.isPresent) {
            taskRepository.deleteById(id.toLong())
            ResponseEntity.ok("Deleted task with id $id")
        } else {
            ResponseEntity.notFound().build()
        }
    }

    fun updateTask(id: Long, updatedTask: TaskDto): ResponseEntity<String> {
        val task = taskRepository.findById(id)

        return if (task.isPresent) {
            val existingTask = task.get()
            existingTask.name = updatedTask.name
            existingTask.description = updatedTask.description
            taskRepository.save(existingTask)
            ResponseEntity.ok("Updated task wwith id $id")
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
