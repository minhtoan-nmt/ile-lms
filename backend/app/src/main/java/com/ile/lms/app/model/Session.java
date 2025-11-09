package com.ile.lms.app.model;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
@Component
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sessionId;
    private Date date;
    private String content;
    @ManyToMany(mappedBy = "participatedSessions") 
    List<Student> studentsParticipated;
    @ManyToOne
    private Classroom classroom;
}
