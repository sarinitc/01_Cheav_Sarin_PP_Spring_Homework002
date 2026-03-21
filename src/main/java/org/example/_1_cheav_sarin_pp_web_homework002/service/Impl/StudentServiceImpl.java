package org.example._1_cheav_sarin_pp_web_homework002.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.Student;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.StudentRequest;
import org.example._1_cheav_sarin_pp_web_homework002.repository.StudentRepository;
import org.example._1_cheav_sarin_pp_web_homework002.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;


    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findStudentById(studentId);
    }


    @Override
    public List<Student> getAllStudents(Integer page, Integer size) {
        return studentRepository.findAllStudentsWithPagination(page, size);
    }

    @Override
    public Student createStudent(StudentRequest studentRequest) {

        return studentRepository.saveStudent(studentRequest);
    }
}
