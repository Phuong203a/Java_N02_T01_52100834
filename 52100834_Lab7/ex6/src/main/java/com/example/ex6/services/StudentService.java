package com.example.ex6.services;


import com.example.ex6.models.Student;
import com.example.ex6.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    Student save(Student student);
    Iterable <Student> findAllDescByAge();

    Page<Student> findAll(PageRequest of);

}
