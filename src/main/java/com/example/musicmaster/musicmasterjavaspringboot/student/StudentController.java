package com.example.musicmaster.musicmasterjavaspringboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    @GetMapping("/create")
    public Student createStudent() {
        return studentService.createStudent("Jahan", "jahan.ara@gmail.com", LocalDate.of(2000, Month.JUNE, 12));
    }

    @PostMapping
    public Student registerStudent(@RequestBody Student student) {
        return studentService.addNewStudent(student);
    }
}
