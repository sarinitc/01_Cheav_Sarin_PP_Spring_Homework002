package org.example._1_cheav_sarin_pp_web_homework002.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.Course;
import org.example._1_cheav_sarin_pp_web_homework002.repository.CourseRepository;
import org.example._1_cheav_sarin_pp_web_homework002.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private  final CourseRepository courseRepository;
    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAllCourses();
    }
}
