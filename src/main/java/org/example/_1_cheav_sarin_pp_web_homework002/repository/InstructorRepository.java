package org.example._1_cheav_sarin_pp_web_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example._1_cheav_sarin_pp_web_homework002.model.entity.Instructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.InstructorRequest;

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

    @Select("""
        SELECT * FROM instructors
        WHERE instructor_id = #{instructorId}
        """)
    @Results({
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
            @Result(property = "phoneNumber", column = "phone_number")
    })
    Instructor getInstructorById(@Param("instructorId") Integer instructorId);
    @ResultMap("instructorMapper")
    @Select("""
        INSERT INTO instructors (instructor_name, email)
        VALUES (#{instructorName}, #{email})
        RETURNING *;
        """)
    Instructor saveINstructor(InstructorRequest instructorRequest);

    @Delete("""
    DELETE FROM instructors
   WHERE instructor_id = #{id}
""")
    void deleteInstructorById(@Param("id") Integer instructorId);
    @Select("""
    UPDATE instructors
    SET instructor_name = #{req.instructorName},
        email = #{req.email}
    WHERE instructor_id = #{id}
    RETURNING *;
""")
    @ResultMap("instructorMapper")
    Instructor updateInstructor(@Param("id") Integer instructorId,
                                @Param("req") InstructorRequest instructorRequest);
}



