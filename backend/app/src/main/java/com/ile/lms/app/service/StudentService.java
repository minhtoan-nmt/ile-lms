package com.ile.lms.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ile.lms.app.model.Student;
import com.ile.lms.app.repository.StudentRepo;

@Service
public class StudentService {
    StudentRepo studentRepo;

    public List<Student> getStudents() {
        // TODO Auto-generated method stub
        return studentRepo.findAll();
    }

}
