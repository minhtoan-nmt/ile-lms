package com.ile.lms.app.model.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentPenaltyRequestObject {
    private int id;
    private Date commitDate;
    private String description;
    private String punishment;
    private String studentId;
}
