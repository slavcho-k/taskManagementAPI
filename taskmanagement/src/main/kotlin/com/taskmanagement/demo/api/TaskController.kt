package com.taskmanagement.demo.api

import com.taskmanagement.demo.domain.Task
import com.taskmanagement.demo.domain.TaskDto
import com.taskmanagement.demo.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class TaskController(private val taskService: TaskService) {

    @GetMapping("/getAll")
    fun getAll(): ResponseEntity<List<Task>> {
        return ResponseEntity.ok(taskService.getAllTasks())
    }

    @PostMapping("/add")
    fun add(@RequestBody taskDto: TaskDto): ResponseEntity<String> {
        return taskService.addTask(taskDto)
    }

    @PutMapping("/update/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody updatedTask: TaskDto): ResponseEntity<String> {
        return taskService.updateTask(id, updatedTask)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<String> {
        return taskService.deleteTask(id)
    }
}