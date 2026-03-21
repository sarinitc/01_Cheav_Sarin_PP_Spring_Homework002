package org.example._1_cheav_sarin_pp_web_homework002.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.Instructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.entity.Course;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.CourseRequest;
import org.example._1_cheav_sarin_pp_web_homework002.repository.CourseRepository;
import org.example._1_cheav_sarin_pp_web_homework002.service.CourseService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private  final CourseRepository courseRepository;
    @Override
    public List<Course> getAllcoures(Integer page, Integer size) {
        return List.of();
    }
    @Override
    public List<Course> getAllCourses(Integer page, Integer size) {
        return courseRepository.findAllCourseWithPagination(page,size);
    }
    @Override
    public Course getCourseById(Integer courseId) {
        return courseRepository.getCourseById(courseId);
    }
    @Override
    public Instructor createCourse(CourseRequest courseRequest) {
        return null;
    }
}
