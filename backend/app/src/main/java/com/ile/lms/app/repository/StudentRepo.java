package com.ile.lms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ile.lms.app.model.Classroom;
import com.ile.lms.app.model.Student;
import java.util.List;


@Repository
public interface StudentRepo extends JpaRepository<Student, String> {
    @Query("select s from Student s where classroom.classId = ?1")
    List<Student> findByClassroomId(String classId);
}
