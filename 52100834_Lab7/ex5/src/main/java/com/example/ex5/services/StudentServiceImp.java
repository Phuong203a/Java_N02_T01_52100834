package com.example.ex5.services;


import com.example.ex5.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Service
public class StudentServiceImp {
    @Autowired
    private StudentService studentService;
    public Iterable<Student> findAll(){
        return studentService.findAll();
    }

    public void save(Student student){
        studentService.save(student);
    }

    public void deleteById(Long id){
        studentService.deleteById(id);
    }

    public void update(Student student){
        studentService.save(student);
    }

    public Optional<Student> findById(Long id){
        return studentService.findById(id);
    }

    public Iterable<Student> findAllByAgeGreater(Integer age){
        return studentService.ex5a(age);
    }
    public Iterable<Student> countAllIeltsScore(Double score){
        return studentService.ex5b(score);
    }
    public Iterable<Student> findAllByNameContainWord(String x){
        return studentService.ex5c(x);
    }
}
