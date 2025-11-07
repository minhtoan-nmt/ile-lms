package com.ile.lms.app.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Component
public class Student {
    @Id String studentId;
    String fullName;
    Date dob;
    String address;
    String sex;
    String phoneNum;
    String engName;
}
