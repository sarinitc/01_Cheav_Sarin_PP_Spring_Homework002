package org.example._1_cheav_sarin_pp_web_homework002.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.entity.Student;
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
        return studentRepository.getStudentById(studentId);
    }
    public List<Student> getAllStudents(Integer page, Integer size) {
        return studentRepository.findAllStudentsWithPagination(page, size);
    }
    @Override
    public Student createStudent(StudentRequest studentRequest) {
        Student student = studentRepository.saveStudent(studentRequest);

        if (studentRequest.getCourseId() != null) {
            for (Integer courseId : studentRequest.getCourseId()) {
                studentRepository.insertStudentCourse(student.getStudentId(), courseId);
            }
        }
        return studentRepository.getStudentById(student.getStudentId());
    }
    @Override
    public boolean deleteStudentById(Integer instructorId) {
        return false;
    }
    @Override
    public boolean deleteInstructorById(Integer studentId) {
        Student student = studentRepository.getStudentById(studentId);
        if (student == null){return false;}
        studentRepository.deleteStudentById(studentId);
        return true;
    }
    @Override
    public Student updateStudent(Integer studentId, StudentRequest studentRequest) {
        studentRepository.updateStudent(studentId, studentRequest);
        return studentRepository.getStudentById(studentId);
    }
}
