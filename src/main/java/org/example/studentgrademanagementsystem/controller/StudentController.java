package org.example.studentgrademanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.studentgrademanagementsystem.model.entity.Student;
import org.example.studentgrademanagementsystem.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody String name) {
        return studentService.createStudent(name);

    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
}
