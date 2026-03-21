package org.example._1_cheav_sarin_pp_web_homework002.controller;

import lombok.RequiredArgsConstructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.Student;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.StudentRequest;
import org.example._1_cheav_sarin_pp_web_homework002.model.response.ApiResponse;
import org.example._1_cheav_sarin_pp_web_homework002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    //@GetMapping
   // public List<Student> getAllStudents(){

      //  return studentService.getAllStudent();
     @GetMapping("/students")
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents(@RequestParam Integer page, @RequestParam Integer size){
         ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                 .success(true)
                 .status("200")
                 .message("Student fetches Successfully")
                 .payload(studentService.getAllStudents(page,size))
                 .timestamp(LocalDateTime.now())
                 .build();
         return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{student_id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable Integer student_id) {
        Student student = studentService.getStudentById(student_id);

        if (student != null) {
            ApiResponse<Student> response = ApiResponse.<Student>builder()
                    .success(true)
                    .status("200")
                    .message("Student fetch by ID " + student_id + " Successfully")
                    .payload(student)
                    .timestamp(LocalDateTime.now())
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .success(false)
                .status("404")
                .message("Student fetch by ID " + student_id + " not found")
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @PostMapping("/students")
    public Student createStudent( StudentRequest studentRequest){

         return studentService.createStudent(studentRequest);
    }

}
