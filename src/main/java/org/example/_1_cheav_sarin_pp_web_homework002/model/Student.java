package org.example._1_cheav_sarin_pp_web_homework002.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private  int studentId;
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Course> courses ;

}
