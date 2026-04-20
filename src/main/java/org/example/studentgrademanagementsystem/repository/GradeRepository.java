package org.example.studentgrademanagementsystem.repository;

import org.example.studentgrademanagementsystem.model.entity.Grade;
import org.example.studentgrademanagementsystem.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
    List<Grade> findByStudentId(Long studentId);
}
