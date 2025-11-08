package com.ile.lms.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ile.lms.app.model.Student;
import com.ile.lms.app.service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class DataController {
    @Autowired
    private StudentService studentService;

    // @GetMapping("students")
    // public ResponseEntity<List<Student>> getStudents() {
    //     return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    // }

    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudentsByClassId(@RequestParam String classId) {
        List<Student> students = studentService.getStudentsByClassId(classId);
        if (students == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    
    @GetMapping("student")
    public ResponseEntity<Student> getStudentById(@RequestParam String studentId) {
        Student s = studentService.getStudentById(studentId);
        if (s == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(s, HttpStatus.OK);
    }
    
}
