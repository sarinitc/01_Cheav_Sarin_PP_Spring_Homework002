package org.example._1_cheav_sarin_pp_web_homework002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.Instructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer courseID;
    private String courseName;
    private String description;
    private Instructor instructor;
}
