package com.example.ex4.services;


import com.example.ex4.models.Student;
import com.example.ex4.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public interface StudentService extends StudentRepository {
    Iterable<Student> findByAgeGreaterThanEqual(Integer age);
    Iterable<Student> countStudentByIeltsScoreEquals(Double score);
    Iterable<Student> findAllByNameContaining(String xxx);

}
