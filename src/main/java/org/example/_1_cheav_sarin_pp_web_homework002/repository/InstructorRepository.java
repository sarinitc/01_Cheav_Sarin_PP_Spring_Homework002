package org.example._1_cheav_sarin_pp_web_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example._1_cheav_sarin_pp_web_homework002.model.Instructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.Student;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.InstructorRequest;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.StudentRequest;

import java.util.List;

@Mapper
public interface InstructorRepository {
    @Results(id = "instructorMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
            @Result(property = "phoneNumber", column = "phone_number"),

    })
    @Select("SELECT * FROM instructors LIMIT #{size} OFFSET (#{page} -1 )* #{size}")
    List<Instructor> findAllInstructorWithPagination(Integer page, Integer size);

    @ResultMap("instructorMapper")
    @Select("""
            SELECT * FROM instructors
            WHERE instructor_id = #{instructorId}
            """)
    Instructor getInstructorById(Integer instructorId);


    @ResultMap("instructorMapper")
    @Select("""
        INSERT INTO instructors (instructor_name, email)
        VALUES (#{instructorName}, #{email})
        RETURNING *;
        """)
    Instructor saveINstructor(InstructorRequest instructorRequest);
}


