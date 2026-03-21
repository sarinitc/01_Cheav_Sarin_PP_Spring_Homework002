package org.example._1_cheav_sarin_pp_web_homework002.controller;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.example._1_cheav_sarin_pp_web_homework002.model.Instructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.InstructorRequest;
import org.example._1_cheav_sarin_pp_web_homework002.model.response.ApiResponse;
import org.example._1_cheav_sarin_pp_web_homework002.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors(
            @RequestParam Integer page,
            @RequestParam Integer size) {

        ApiResponse<List<Instructor>> response = ApiResponse.<List<Instructor>>builder()
                .success(true)
                .status("200")
                .message("Instructors fetched successfully")
                .payload(instructorService.getAllInstructor(page, size))
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable(name = "instructor-id") Integer instructorId) {
        Instructor instructor = instructorService.getInstructorById(instructorId);

        if (instructor != null) {
            ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                    .success(true)
                    .status("200")
                    .message("Instructor fetch by ID " + instructorId + " Successfully")
                    .payload(instructor)
                    .timestamp(LocalDateTime.now())
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .success(false)
                .status("404")
                .message("Instructor fetch by ID -" + instructorId + " not found")
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> createInstructor(@RequestBody InstructorRequest instructorRequest) {
        Instructor instructor = instructorService.createInstructor(instructorRequest);

        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .success(true)
                .status("201")
                .message("Instructor created successfully")
                .payload(instructor)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}


