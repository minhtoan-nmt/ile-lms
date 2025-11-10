package com.ile.lms.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ile.lms.app.model.Session;

@Repository
public interface SessionRepo extends JpaRepository<Session, Integer> {
    @Query("select s from Session s where classroom.classId = ?1")
    List<Session> findAllSessionsByClassId(String classId);
}
