package org.example._1_cheav_sarin_pp_web_homework002.controller;

import lombok.RequiredArgsConstructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.entity.Instructor;
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
    @DeleteMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<String>> deleteInstructor(
            @PathVariable("instructor-id") Integer instructorId) {

        Boolean isSuccess = instructorService.deleteInstructorById(instructorId);
        String statusCode = isSuccess? "200": "404";
        String msg = isSuccess? "Instructor deleted successfully":"Instructor not found";
        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(isSuccess)
                .status(statusCode)
                .message(msg)
                .payload("Deleted ID: " + instructorId)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructor(
            @PathVariable("instructor-id") Integer instructorId,
            @RequestBody InstructorRequest instructorRequest) {

        Instructor instructor = instructorService.updateInstructor(instructorId, instructorRequest);

        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .success(true)
                .status("200")
                .message("Instructor updated successfully")
                .payload(instructor)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    }




