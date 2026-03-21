package org.example._1_cheav_sarin_pp_web_homework002.controller;

import lombok.RequiredArgsConstructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.Instructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.entity.Course;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.CourseRequest;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.InstructorRequest;
import org.example._1_cheav_sarin_pp_web_homework002.model.response.ApiResponse;
import org.example._1_cheav_sarin_pp_web_homework002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses(
            @RequestParam Integer page,
            @RequestParam Integer size) {

        ApiResponse<List<Course>> response = ApiResponse.<List<Course>>builder()
                .success(true)
                .status("200")
                .message("Courses fetched successfully")
                .payload(courseService.getAllCourses(page, size))
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable(name = "course-id") Integer courseId) {
        Course course = courseService.getCourseById(courseId);

        if (course != null) {
            ApiResponse<Course> response = ApiResponse.<Course>builder()
                    .success(true)
                    .status("200")
                    .message("Course fetch by ID " + courseId + " Successfully")
                    .payload(courseService.getCourseById(courseId))
                    .timestamp(LocalDateTime.now())
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .success(false)
                .status("404")
                .message("Instructor fetch by ID " + courseId + " not found")
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    }

