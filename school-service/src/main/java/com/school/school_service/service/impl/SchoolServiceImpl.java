package com.school.school_service.service.impl;

import com.school.school_service.model.School;
import com.school.school_service.repository.SchoolRepository;
import com.school.school_service.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.List;
@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;
    //save employee in database
    @Override
    public School saveSchool(School school){
        return schoolRepository.save(school);
    }

    //get all employee form database
    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    //get employee using id
    @Override
    public School getSchoolById(long id) {
        Optional<School> school =  schoolRepository.findById(id);
        if(school.isPresent()){
            return school.get();
        }else {
            throw new RuntimeException();
        }
    }

    //update employee
    @Override
    public School updateSchool(School school, long id) {
        School existingSchool = schoolRepository.findById(id).orElseThrow(
                ()-> new RuntimeException()
        );
        existingSchool.setSchoolName(school.getSchoolName());
        existingSchool.setLocation(school.getLocation());
        existingSchool.setPrincipalName(school.getPrincipalName());
        // save
        schoolRepository.save(existingSchool);
        return existingSchool;
    }

    //delete employee
    @Override
    public void deleteSchool(long id) {
        //check
        schoolRepository.findById(id).orElseThrow(()-> new RuntimeException());
        //delete
        schoolRepository.deleteById(id);
    }
}
