package com.example.ex5;



import com.example.ex5.models.Student;
import com.example.ex5.services.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex5Application implements CommandLineRunner {
    @Autowired
    private StudentServiceImp studentServiceImp;
    public static void main(String[] args) {
        SpringApplication.run(Ex5Application.class, args);
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


        System.out.println("            ===================================================");
        int age = 22;
        studentServiceImp.findAllByAgeGreater(age).forEach(System.out::println);
        System.out.println("            ===================================================");
        double score = 6.0;
        System.out.println("count = " + studentServiceImp.countAllIeltsScore(score));
        System.out.println("            ===================================================");
        String x = "t";
        studentServiceImp.findAllByNameContainWord(x).forEach(System.out::println);

    }
}

