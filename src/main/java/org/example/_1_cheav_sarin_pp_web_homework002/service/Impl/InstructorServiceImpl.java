package org.example._1_cheav_sarin_pp_web_homework002.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.Instructor;
import org.example._1_cheav_sarin_pp_web_homework002.model.request.InstructorRequest;
import org.example._1_cheav_sarin_pp_web_homework002.repository.InstructorRepository;
import org.example._1_cheav_sarin_pp_web_homework002.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    @Override
    public List<Instructor> findAllInstructorWithPagination(Integer page, Integer size) {
        return List.of();
    }

    @Override
    public Instructor getInstructorById(Integer instructorId) {
        return instructorRepository.getInstructorById(instructorId);
    }

    @Override
    public List<Instructor> getAllInstructor(Integer page, Integer size) {
        return instructorRepository.findAllInstructorWithPagination(page, size);
    }

    @Override
    public List<Instructor> getAllStudents(Integer page, Integer size) {
        return null;
//        return instructorRepository.findInstructorById(instructor);
    }

    @Override
    public Instructor createInstructor(InstructorRequest instructorRequest) {
        return  instructorRepository.saveINstructor(instructorRequest);
    }


}
