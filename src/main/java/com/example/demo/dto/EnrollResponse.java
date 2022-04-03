package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EnrollResponse {
    private String name;
    private String teacherName;

//    public EnrollResponse(String name, String teacherName) {
//        this.name = name;
//        this.teacherName = teacherName;
//    }
}
