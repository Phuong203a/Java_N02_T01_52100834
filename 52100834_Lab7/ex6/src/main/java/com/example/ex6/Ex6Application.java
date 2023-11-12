package com.example.ex6;



import com.example.ex6.models.Student;
import com.example.ex6.repository.StudentRepository;
import com.example.ex6.services.StudentService;
import com.example.ex6.services.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootApplication
public class Ex6Application implements CommandLineRunner {
    @Autowired
    private StudentServiceImp studentServiceImp;
    private StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(Ex6Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Student student1 = Student.builder()
                .name("Huynh Hong Son")
                .age(22)
                .email("hhongson5011@gmail.com")
                .ieltsScore(5.0)
                .build();
        studentServiceImp.save(student1);
        Student student2 = Student.builder()
                .name("Thanh Loi")
                .age(23)
                .email("hailoitv@gmail.com")
                .ieltsScore(6.0)
                .build();
        studentServiceImp.save(student2);
        Student student3 = Student.builder()
                .name("Tuan Kiet")
                .age(22)
                .email("tuankiet@gmail.com")
                .ieltsScore(6.0)
                .build();
        studentServiceImp.save(student3);
        Student student4 = Student.builder()
                .name("Minh Nhat")
                .age(18)
                .email("minhnhat@gmail.com")
                .ieltsScore(6.5)
                .build();
        studentServiceImp.save(student4);
        Student student5 = Student.builder()
                .name("Nhu Y")
                .age(16)
                .email("nhuy@gmail.com")
                .ieltsScore(4.5)
                .build();
        studentServiceImp.save(student5);
        Student student6 = Student.builder()
                .name("Quoc An")
                .age(21)
                .email("quocan@gmail.com")
                .ieltsScore(5.0)
                .build();
        studentServiceImp.save(student6);
        Student student7 = Student.builder()
                .name("Minh Phuong")
                .age(22)
                .email("minhphuong@gmail.com")
                .ieltsScore(6.0)
                .build();
        studentServiceImp.save(student7);
        System.out.println("Sort");
        System.out.println("            ===================================================");
        Iterable<Student> students = studentServiceImp.findAllDescByAge();
        students.forEach(System.out::println);
        System.out.println("            ===================================================");
        Page<Student> page = studentServiceImp.findAll(PageRequest.of(1,3));
        Iterable<Student> students456 = page.getContent();
        students456.forEach(System.out::println);




    }
}

