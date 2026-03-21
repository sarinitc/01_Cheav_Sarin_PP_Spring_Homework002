package org.example._1_cheav_sarin_pp_web_homework002.controller;

import lombok.RequiredArgsConstructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.Course;
import org.example._1_cheav_sarin_pp_web_homework002.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private  final CourseService courseService;
    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourse();

    }

}
