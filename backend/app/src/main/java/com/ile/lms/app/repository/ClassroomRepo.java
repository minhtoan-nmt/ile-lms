package com.ile.lms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ile.lms.app.model.Classroom;
import java.util.List;


@Repository
public interface ClassroomRepo extends JpaRepository<Classroom, String> {

}
