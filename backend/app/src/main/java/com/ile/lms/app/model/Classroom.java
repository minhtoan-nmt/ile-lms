package com.ile.lms.app.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
@Component
public class Classroom {
    @Id String classId;
    String className;
    String shift;
    String level;
    String textbookName;
    @OneToMany
    List<Student> studentList;
}
