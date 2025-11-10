package com.ile.lms.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ile.lms.app.model.Session;
import com.ile.lms.app.repository.SessionRepo;

@Service
public class ClassService {
    @Autowired
    private SessionRepo sessionRepo;

    public void addNewSession(Session newSession) {
        // TODO Auto-generated method stub
        sessionRepo.save(newSession);
    }

    public List<Session> getAllSession(String classId) {
        // TODO Auto-generated method stub
        return sessionRepo.findAllSessionsByClassId(classId);
    }

}
