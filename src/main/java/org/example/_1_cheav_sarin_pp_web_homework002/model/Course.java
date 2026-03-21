package org.example._1_cheav_sarin_pp_web_homework002.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private  String course_name;
    private String description;
    private Integer instructor_id;
}
