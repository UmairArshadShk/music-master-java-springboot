package com.example.musicmaster.musicmasterjavaspringboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

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
        Optional<Student> s = studentRepository.findStudentByEmail(student.getEmail());
        if (s.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }

        studentRepository.save(student);
        return student;
    }

    public void deleteStudentById(Long studentId) {
        boolean exits = studentRepository.existsById(studentId);

        if (!exits) {
            throw new IllegalStateException("User with ID " + studentId + " does not exits");
        }

        studentRepository.deleteById(studentId);
    }
}
