package com.ile.lms.app.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Teacher {
    @Id String teacherId;
    String cidCardNum;
    String fullName;
    String sex;
    String phoneNum;
    Date dob;
    String placeOfBirth;
    String education;
    String address;
    @OneToMany
    List<Classroom> teachingClass;
}
