package com.example.ex2;

import com.example.ex2.models.Student;
import com.example.ex2.services.StudentService;
import com.example.ex2.services.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex2Application implements CommandLineRunner {
    @Autowired
    private StudentServiceImp studentServiceImp;
    public static void main(String[] args) {
        SpringApplication.run(Ex2Application.class, args);
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
                .ieltsScore(7.0)
                .build();
        studentServiceImp.save(student2);
        Student student3 = Student.builder()
                .name("Tuan Kiet")
                .age(22)
                .email("tuankiet@gmail.com")
                .ieltsScore(6.0)
                .build();
        studentServiceImp.save(student3);
        //read all student
        Iterable<Student> students = studentServiceImp.findAll();
        students.forEach(System.out::println);
        //update student
        Student studentUpdate = studentServiceImp.findById(student1.getId()).orElse(null);
        if(studentUpdate != null){
            studentUpdate.setName("Gia Hoang");
            studentServiceImp.update(studentUpdate);
        }
        System.out.println("            ===================================================");
        System.out.println("After update");
        students = studentServiceImp.findAll();
        students.forEach(System.out::println);
        //delete student
        studentServiceImp.deleteById(student2.getId());
        System.out.println("            ===================================================");
        System.out.println("After delete");
        students = studentServiceImp.findAll();
        students.forEach(System.out::println);

    }
}
