package org.example.studentgrademanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.studentgrademanagementsystem.model.entity.Student;
import org.example.studentgrademanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student createStudent(String name) {
        Student student = new Student();
        student.setName(name);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found"));
    }


}
