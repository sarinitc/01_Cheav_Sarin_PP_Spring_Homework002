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


    @Override
    public Instructor updateInstructor(Integer instructorId, InstructorRequest instructorRequest) {
        instructorRepository.updateInstructor(instructorId, instructorRequest);
        return instructorRepository.getInstructorById(instructorId);
    }

    @Override
    public boolean deleteInstructorById(Integer instructorId) {
        System.out.println("Delete Instructor ID: " + instructorId);
        Instructor instructor = instructorRepository.getInstructorById(instructorId);
        if (instructor == null){return false;}
        instructorRepository.deleteInstructorById(instructorId);
        return true;
    }

    @Override
    public Instructor updateInstructor(InstructorService instructorService) {
        return null;
    }




//    @Override
//    public Instructor updateInstructor(Integer instructorId, InstructorRequest instructorRequest) {
//        instructorRepository.updateInstructor(instructorId, instructorRequest);
//        return instructorRepository.getInstructorById(instructorId);
//    }


}




