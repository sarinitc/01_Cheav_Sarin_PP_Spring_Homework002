package org.example._1_cheav_sarin_pp_web_homework002.controller;

import lombok.RequiredArgsConstructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.entity.Student;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.StudentRequest;
import org.example._1_cheav_sarin_pp_web_homework002.model.response.ApiResponse;
import org.example._1_cheav_sarin_pp_web_homework002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

     @GetMapping
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
    @GetMapping("/{student-id}")
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
    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody StudentRequest studentRequest) {
        Student student = studentService.createStudent(studentRequest);

        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .success(true)
                .status("201")
                .message("Student created successfully")
                .payload(student)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(
            @PathVariable("student-id") Integer studentId,
            @RequestBody StudentRequest studentRequest) {
        Student student = studentService.updateStudent(studentId, studentRequest);
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .success(true)
                .status("200")
                .message("Student updated successfully")
                .payload(student)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/{student-id}")
    public ResponseEntity<ApiResponse<String>> deleteStudent(
            @PathVariable("student-id") Integer studentId) {
        Boolean isSuccess = studentService.deleteStudentById(studentId);
        String statusCode = isSuccess? "200": "404";
        String msg = isSuccess? "Student deleted successfully":"Student  not found";
        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(isSuccess)
                .status(statusCode)
                .message(msg)
                .payload("Deleted ID: " + studentId)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
