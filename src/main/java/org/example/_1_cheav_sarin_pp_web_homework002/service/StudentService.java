package org.example._1_cheav_sarin_pp_web_homework002.service;

import org.example._1_cheav_sarin_pp_web_homework002.model.Student;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.StudentRequest;

import java.util.List;

public interface StudentService {


    Student getStudentById(Integer studentId);


    List<Student> getAllStudents(Integer page, Integer size);

    Student createStudent(StudentRequest studentRequest);
}
