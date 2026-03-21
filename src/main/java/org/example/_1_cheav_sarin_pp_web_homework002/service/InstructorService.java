package org.example._1_cheav_sarin_pp_web_homework002.service;

import org.example._1_cheav_sarin_pp_web_homework002.model.Instructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.Student;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.InstructorRequest;

import java.util.List;

public interface InstructorService {

     List<Instructor> findAllInstructorWithPagination(Integer page, Integer size);

     Instructor getInstructorById(Integer studentId);

    List<Instructor> getAllInstructor(Integer page, Integer size);


    List<Instructor> getAllStudents(Integer page, Integer size);

    Instructor createInstructor(InstructorRequest instructorRequest);
}
