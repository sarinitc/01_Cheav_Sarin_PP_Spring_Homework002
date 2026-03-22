package org.example._1_cheav_sarin_pp_web_homework002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private  Integer studentId;
    private String studentName;
    private String email;
    private String phoneNumber;
//    private Course course;
  private List<Course> courses ;


}
