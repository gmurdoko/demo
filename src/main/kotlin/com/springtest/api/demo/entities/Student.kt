package com.springtest.api.demo.entities

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

//entitas data
@Entity
@Table(name = "students")
data class Student(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(
                name = "UUID",
                strategy = "org.hibernate.id.UUIDGenerator"
        )
        @Column(name = "id", updatable = false, nullable =  false, length = 64)
        val id: String?,
        @Column(name = "name", length = 30)
        var name: String,
        @Column(name="npm",length = 10)
        var npm: String,
        @Column(name = "email", length = 60)
        var email: String
)
