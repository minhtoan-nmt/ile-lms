package com.ile.lms.app.model;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
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
    @OneToMany(mappedBy = "teacher")
    List<Classroom> teachingClass;
}
