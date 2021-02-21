package com.springtest.api.demo.controllers

import com.springtest.api.demo.entities.Student
import com.springtest.api.demo.services.StudentService
import com.springtest.api.demo.utils.APIRensponse
import com.springtest.api.demo.utils.ListDataPagination
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/student"])
class StudentController {
    @Autowired
    lateinit var studentService: StudentService
    @PostMapping(
            value = [""],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun create(@RequestBody body: Student): APIRensponse<Student>{
        val studentResponse = studentService.create(body)
        return APIRensponse(
                code = 200,
                status = HttpStatus.OK,
                data = studentResponse
        )
    }
    @GetMapping(
            value = ["/{id}"],
            produces = ["application/json"]
    )
    fun get(@PathVariable("id")id:String): APIRensponse<Student>{
        val studentResponse = studentService.get(id)
        return APIRensponse(
                code = 200,
                status = HttpStatus.OK,
                data = studentResponse
        )
    }
    @PutMapping(
            value = ["/{id}"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun update(@PathVariable("id")id: String,
        @RequestBody body: Student):APIRensponse<Student>{
        val studentResponse = studentService.update(id,body)
        return APIRensponse(
                code = 200,
                status = HttpStatus.OK,
                data = studentResponse
        )
    }
    @DeleteMapping(
            value = ["/{id}"],
            produces = ["application/json"]
    )
    fun delete(@PathVariable("id")id: String):APIRensponse<String>{
        studentService.delete(id)
        return APIRensponse(
                code = 200,
                status = HttpStatus.OK,
//                data = studentResponse
                data = "Sucess"
        )
    }
    @GetMapping(
            value = [""],
            produces = ["application/json"]
    )
    fun list(
            @RequestParam(value = "size", defaultValue = "10") size:Int,
            @RequestParam(value = "page", defaultValue = "0")page: Int
    ):APIRensponse<List<Student>>{
        val request = ListDataPagination(page=page,size=size)
        val response = studentService.list(request)
        return APIRensponse(
                code = 200,
                status = HttpStatus.OK,
                data = response
        )
    }

}