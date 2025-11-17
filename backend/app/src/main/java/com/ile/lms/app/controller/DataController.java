package com.ile.lms.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ile.lms.app.model.Session;
import com.ile.lms.app.model.Student;
import com.ile.lms.app.model.StudentPenalty;
import com.ile.lms.app.model.dto.SessionRequestObject;
import com.ile.lms.app.model.dto.StudentPenaltyRequestObject;
import com.ile.lms.app.service.ClassService;
import com.ile.lms.app.service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class DataController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;

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

    @GetMapping("sessions")
    public ResponseEntity<List<Session>> getAllSession(@RequestParam String classId) {
        return new ResponseEntity<List<Session>>(classService.getAllSession(classId), HttpStatus.OK);
    }
    

    @PostMapping("session")
    public ResponseEntity<Session> addSession(@RequestBody SessionRequestObject newSession) {
        //TODO: process POST request
        return new ResponseEntity<Session>(classService.addOrUpdateSession(newSession), HttpStatus.CREATED);
    }
    
    @PostMapping("student_penalty")
    public ResponseEntity<StudentPenalty> postMethodName(@RequestBody StudentPenaltyRequestObject sObject) {
        //TODO: process POST request
        return new ResponseEntity<StudentPenalty>(studentService.addOrUpdatePenalty(sObject), HttpStatus.CREATED);
    }
    
}
