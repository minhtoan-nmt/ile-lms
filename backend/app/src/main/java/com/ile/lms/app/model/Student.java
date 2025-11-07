package com.ile.lms.app.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id String studentId;
    private String fullName;
    private Date dob;
    private String address;
    private String sex;
    private String phoneNum;
    private String engName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private Classroom classroom;
}
