package com.example.musicmaster.musicmasterjavaspringboot;

import com.example.musicmaster.musicmasterjavaspringboot.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class MusicMasterJavaSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicMasterJavaSpringbootApplication.class, args);
	}

	@GetMapping("/api/v1/students")
	public List<Student> hello() {
		return List.of(
				new Student(
						1L,
						"Jahan",
						"jahan.ara@reviante.com",
						LocalDate.of(1998, Month.JANUARY, 17),
						25
				)
		);
	}
}
