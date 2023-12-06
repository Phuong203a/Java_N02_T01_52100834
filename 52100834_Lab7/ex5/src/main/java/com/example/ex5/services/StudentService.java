package com.example.ex5.services;


import com.example.ex5.models.Student;
import com.example.ex5.repository.StudentRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface StudentService extends StudentRepository {
    @Query(value = "select s from Student s where s.age >=:x")
    public Iterable<Student> ex5a(Integer x);
    @Query(value = "select count(*) from Student s where s.ieltsScore = :x")
    public  Iterable<Student> ex5b (Double x);
    @Query(value = "select s from Student s where s.name like %:x%")
    public  Iterable<Student> ex5c (String x);
}
