package com.ile.lms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ile.lms.app.model.StudentPenalty;

public interface StudentPenaltyRepo extends JpaRepository<StudentPenalty, Integer> {

}
