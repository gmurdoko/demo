package com.springtest.api.demo.repositories

import com.springtest.api.demo.entities.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository: JpaRepository<Student,String> {
}