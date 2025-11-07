package com.ile.lms.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ile.lms.app.model.Student;
import com.ile.lms.app.service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DataController {
    @Autowired
    private StudentService studentService;

    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }
    
}
