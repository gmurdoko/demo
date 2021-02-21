package com.springtest.api.demo.services

import com.springtest.api.demo.entities.Student
import com.springtest.api.demo.utils.ListDataPagination

interface StudentService {
    fun create(student: Student): Student
    fun get(id: String): Student
    fun update(id: String, updateStudent: Student): Student
    fun delete(id: String)
    fun list(listDataPagination: ListDataPagination):List<Student>
}