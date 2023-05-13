package com.taskmanagement.demo.domain

import jakarta.persistence.*

@Entity
@Table(name = "tasks")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    var name: String,
    var description: String,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinColumn(name = "user_id")
    val user: User
) : Comparable<Task> {
    override fun compareTo(other: Task): Int {
        return this.id.compareTo(other.id)
    }
}
