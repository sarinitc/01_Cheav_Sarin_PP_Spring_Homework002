package org.example._1_cheav_sarin_pp_web_homework002.service;

import org.example._1_cheav_sarin_pp_web_homework002.model.Instructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.entity.Course;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.CourseRequest;

import java.util.List;

public interface CourseService {

    List<Course> getAllcoures(Integer page, Integer size);

    List<Course> getAllCourses(Integer page, Integer size);

    Course getCourseById(Integer courseId);

    Course createCourse(CourseRequest courseRequest);

    Course updateCourse(Integer courseId, CourseRequest courseRequest);

    void deleteCourseById(Integer courseId);
}
