package org.example.studentgrademanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.studentgrademanagementsystem.model.dto.GradeRequest;
import org.example.studentgrademanagementsystem.model.entity.Grade;
import org.example.studentgrademanagementsystem.service.GradeService;
import org.example.studentgrademanagementsystem.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @PostMapping
    public Grade addGrade(@RequestBody GradeRequest gradeRequest) {
        return gradeService.addGrade(gradeRequest.studentId, gradeRequest.score);
    }

    @GetMapping("/status/{studentId}")
    public Map<String, Object> getStatus(@PathVariable Long studentId) {
        Map<String, Object> map = new HashMap<>();
        map.put("average", Math.round(gradeService.getAverage(studentId) * 100.0) / 100.0);
        map.put("min", gradeService.getMin(studentId));
        map.put("max", gradeService.getMax(studentId));
        return map;
    }


}
