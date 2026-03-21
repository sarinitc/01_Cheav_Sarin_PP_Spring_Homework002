package org.example._1_cheav_sarin_pp_web_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example._1_cheav_sarin_pp_web_homework002.model.Student;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.StudentRequest;
import java.util.List;
@Mapper
public interface StudentRepository {
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number")
    })
    @Select("SELECT* FROM students LIMIT #{size} OFFSET (#{page} -1 )* #{size}")
    List<Student> findAllStudentsWithPagination(Integer page, Integer size);

    @ResultMap("studentMapper")
    @Select("""
            SELECT * FROM students
            WHERE student_id = #{studentId}
            """)
    Student findStudentById(Integer studentId);
    @Select("""
    INSERT INTO students (student_name, email, phone_number)
    VALUES(#{student.studentName}, #{student.email}, #{student.phoneNumber})
    RETURNING * ;
""")
    @ResultMap("studentMapper")
    Student saveStudent(@Param("student") StudentRequest studentRequest);
}

