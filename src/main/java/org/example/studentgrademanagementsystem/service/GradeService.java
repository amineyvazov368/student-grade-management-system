package org.example.studentgrademanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.studentgrademanagementsystem.model.entity.Grade;
import org.example.studentgrademanagementsystem.model.entity.Student;
import org.example.studentgrademanagementsystem.repository.GradeRepository;
import org.example.studentgrademanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;

    public Grade addGrade(Long studentId, int score) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new RuntimeException("Student not found"));
        Grade grade = new Grade();
        grade.setStudent(student);
        grade.setScore(score);
        gradeRepository.save(grade);
        return grade;
    }

   List<Grade> getGradeByStudent(Long studentId) {
       return gradeRepository.findByStudentId(studentId);
   }

   public double getAverage(Long studentId) {
        List<Grade> grades = getGradeByStudent(studentId);
        return grades.stream().mapToDouble(g -> g.getScore()).average().getAsDouble();
   }

   public int getMax(Long studentId) {
        return getGradeByStudent(studentId)
                .stream()
                .mapToInt(g -> g.getScore()).max().getAsInt();

   }

   public int getMin(Long studentId) {
        return getGradeByStudent(studentId)
                .stream().mapToInt(g -> g.getScore()).min().getAsInt();
   }







}
