package com.example.firstapp;

import com.example.firstapp.Entities.Student;
import com.example.firstapp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        studentRepository.save(new Student(null, "1","Anass",new Date(),true,null));
        studentRepository.save(new Student(null, "2","Ahmade",new Date(),true,null));

        System.out.println("Count : "+ studentRepository.count());

        List<Student> students = studentRepository.findAll();
        students.forEach(student -> {
            System.out.println(student.toString());
        });

        Student student = studentRepository.findById(3).orElse(null);
        System.out.println(student.toString());

        student.setRegistrationNumber("S3");
        studentRepository.save(student);

        studentRepository.delete(student);
        System.out.println("Count : "+ studentRepository.count());

        studentRepository.deleteById(5);
        System.out.println("Count : "+ studentRepository.count());
    }
}