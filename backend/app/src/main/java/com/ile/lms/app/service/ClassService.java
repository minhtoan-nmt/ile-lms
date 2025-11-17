package com.ile.lms.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ile.lms.app.model.Session;
import com.ile.lms.app.model.Student;
import com.ile.lms.app.model.dto.SessionRequestObject;
import com.ile.lms.app.repository.ClassroomRepo;
import com.ile.lms.app.repository.SessionRepo;
import com.ile.lms.app.repository.StudentRepo;

@Service
public class ClassService {
    @Autowired
    private SessionRepo sessionRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ClassroomRepo classroomRepo;

    public Session addNewSession(SessionRequestObject newSession) {
        // TODO Auto-generated method stub
        
        Session saveSession;
        int newSessionId = newSession.getSessionId();
        if (sessionRepo.existsById(newSessionId)) {
            saveSession = sessionRepo.findById(newSessionId).orElseThrow();
            for (Student student : saveSession.getStudentsParticipated()) {
                student.getParticipatedSessions().remove(saveSession);
            }
            saveSession.getStudentsParticipated().clear();
        } else {
            saveSession = new Session();
        }
        if (newSessionId != 0) {
            saveSession.setSessionId(newSessionId);
        }
        saveSession.setContent(newSession.getContent());
        saveSession.setDate(newSession.getDate());
        saveSession.setStudentsParticipated(new ArrayList<>(newSession.getStudentsParticipated().size()));
        for (String studentId : newSession.getStudentsParticipated()) {
            Student student = studentRepo.findById(studentId).orElseThrow();
            saveSession.getStudentsParticipated().add(student);
            System.out.println(saveSession.getStudentsParticipated().size());
            student.getParticipatedSessions().add(saveSession); 
        }
        saveSession.setClassroom(classroomRepo.findById(newSession.getClassroom()).orElse(null));
        sessionRepo.save(saveSession);
        
        return saveSession;
    }

    public List<Session> getAllSession(String classId) {
        // TODO Auto-generated method stub
        return sessionRepo.findAllSessionsByClassId(classId);
    }

}
