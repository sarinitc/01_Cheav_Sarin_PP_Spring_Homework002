package org.example._1_cheav_sarin_pp_web_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example._1_cheav_sarin_pp_web_homework002.model.entity.Course;
import org.example._1_cheav_sarin_pp_web_homework002.model.entity.Student;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.CourseRequest;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.StudentRequest;
import java.util.List;
@Mapper
public interface StudentRepository {
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "course", column = "course_id",
                    one = @One(select = "org.example._1_cheav_sarin_pp_web_homework002.repository.InstructorRepository.getCourseById"))
    })
    @Select("SELECT* FROM students LIMIT #{size} OFFSET (#{page} -1 )* #{size}")
    List<Student> findAllStudentsWithPagination(Integer page, Integer size);
    @ResultMap("studentMapper")
    @Select("""
        SELECT * FROM students
        WHERE student_id = #{studentId}
    """)
    Student getStudentById(@Param("studentId") Integer studentId);
    @Select("""
        INSERT INTO students (student_name, email, phone_number)
        VALUES (#{student.studentName}, #{student.email}, #{student.phoneNumber})
        RETURNING *;
    """)
    Course createCourse(@Param("course") CourseRequest courseRequest);
    @ResultMap("studentMapper")
    Student saveStudent(@Param("student") StudentRequest studentRequest);

    @Insert("""
        INSERT INTO student_course (student_id, course_id)
        VALUES (#{studentId}, #{courseId})
    """)
    void insertStudentCourse(@Param("studentId") Integer studentId,
                             @Param("courseId") Integer courseId);
    @Select("""
    UPDATE students
    SET course_name = #{student.studentName},
        email = #{student.email},
        phone_number = #{student.phoneNumber},
        course_id = #{student.courseId}
    WHERE student_id = #{id}
    RETURNING *;
    """)
    @ResultMap("studentMapper")
    Course updateStudent(@Param("id") Integer studentId,
                        @Param("course") StudentRequest studentRequest);
    @Delete("""
        DELETE FROM students
        WHERE student_id = #{studentId}
    """)
    void deleteStudentById(@Param("studentId") Integer studentId);

}


