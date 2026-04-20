package org.example.studentgrademanagementsystem.repository;

import org.example.studentgrademanagementsystem.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
