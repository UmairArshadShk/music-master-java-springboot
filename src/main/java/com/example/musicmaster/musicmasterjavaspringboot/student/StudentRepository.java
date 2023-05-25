package com.example.musicmaster.musicmasterjavaspringboot.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByEmail(String email);
}
