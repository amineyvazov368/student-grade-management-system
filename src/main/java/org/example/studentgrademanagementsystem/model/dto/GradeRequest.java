package org.example.studentgrademanagementsystem.model.dto;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class GradeRequest {

    public Long studentId;
    public int score;


}

