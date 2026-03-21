package org.example._1_cheav_sarin_pp_web_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example._1_cheav_sarin_pp_web_homework002.model.Instructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.entity.Course;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.CourseRequest;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.InstructorRequest;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Results(id = "courseMapper", value = {
            @Result(property = "courseID", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "instructor", column = "instructor_id",
            one = @One(select = "org.example._1_cheav_sarin_pp_web_homework002.repository.InstructorRepository.getInstructorById"))
    })
    @Select("SELECT * FROM courses LIMIT #{size} OFFSET (#{page} - 1) * #{size}")
    List<Course> findAllCourseWithPagination(
            @Param("page") Integer page,
            @Param("size") Integer size
    );
    @ResultMap("courseMapper")
    @Select("""
        SELECT * FROM courses
        WHERE course_id = #{courseId}
        """)
    Course getCourseById(Integer CourseId );

    Course createCourse(CourseRequest courseRequest);
}
