package com.ile.lms.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ile.lms.app.model.Student;
import com.ile.lms.app.model.StudentPenalty;
import com.ile.lms.app.model.dto.StudentPenaltyRequestObject;
import com.ile.lms.app.repository.StudentPenaltyRepo;
import com.ile.lms.app.repository.StudentRepo;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentPenaltyRepo studentPenaltyRepo;

    public List<Student> getStudents() {
        // TODO Auto-generated method stub
        return studentRepo.findAll();
    }

    public List<Student> getStudentsByClassId(String classId) {
        // TODO Auto-generated method stub
        return studentRepo.findByClassroomId(classId);
    }

    public Student getStudentById(String studentId) {
        // TODO Auto-generated method stub
        return studentRepo.findById(studentId).orElse(null);
    }

    public StudentPenalty addOrUpdatePenalty(StudentPenaltyRequestObject sObject) {
        StudentPenalty penalty = new StudentPenalty();
        penalty.setCommitDate(sObject.getCommitDate());
        penalty.setDescription(sObject.getDescription());
        penalty.setPunishment(sObject.getPunishment());
        Student studentCommitted = studentRepo.findById(sObject.getStudentId()).orElseThrow();
        penalty.setStudentCommitted(studentCommitted);
        return studentPenaltyRepo.save(penalty);
    }

}
