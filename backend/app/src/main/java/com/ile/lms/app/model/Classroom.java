package com.ile.lms.app.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {
    @Id private String classId;
    private String className;
    private String shift;
    private String level;
    private String textbookName;
    @OneToMany(mappedBy = "classroom")
    @JsonManagedReference
    private List<Student> studentList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
