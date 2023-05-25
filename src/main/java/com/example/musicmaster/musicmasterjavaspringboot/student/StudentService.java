package com.example.musicmaster.musicmasterjavaspringboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
//        return List.of(
//                new Student(
//                        1L,
//                        "Jahan abc",
//                        "jahan.ara@reviante.com",
//                        LocalDate.of(1998, Month.JANUARY, 17),
//                        25
//                )
//        );

        return studentRepository.findAll();
    }

    public Student createStudent(String name, String email, LocalDate dob) {
        Student student = new Student(name, email, dob);
        studentRepository.save(student);

        return student;
    }

    public Student addNewStudent(Student student) {
        Student s = studentRepository.findStudentByEmail(student.getEmail());
        if (s != null) {
            return s;
        }

        studentRepository.save(student);
        return student;
    }
}
