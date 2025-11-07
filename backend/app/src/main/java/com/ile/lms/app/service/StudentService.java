package com.ile.lms.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ile.lms.app.model.Classroom;
import com.ile.lms.app.model.Student;
import com.ile.lms.app.repository.ClassroomRepo;
import com.ile.lms.app.repository.StudentRepo;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ClassroomRepo classroomRepo;

    public List<Student> getStudents() {
        // TODO Auto-generated method stub
        return studentRepo.findAll();
    }

    public List<Student> getStudentsByClassId(String classId) {
        // TODO Auto-generated method stub
        Optional<Classroom> c = classroomRepo.findById(classId);
        System.out.println(c.isPresent());
        if (!c.isPresent()) {
            return null;
        }
        return studentRepo.findByClassroom(c.get());
    }

}
