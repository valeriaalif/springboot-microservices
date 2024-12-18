package com.school.school_service.controller;

import com.school.school_service.model.School;
import com.school.school_service.service.SchoolService;
import com.school.school_service.service.impl.SchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/school")
@RestController
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public ResponseEntity<School> saveSchool(@RequestBody School school){
        return new ResponseEntity<School>(schoolService.saveSchool(school),  HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping
    public List<School> getAllSchools(){
        return schoolService.getAllSchools();
    }

    //Get by Id Rest Api
    @GetMapping("{id}")
    // localhost:8080/api/employees/1
    public ResponseEntity<School> getSchoolById(@PathVariable("id") long schoolID){
        return new ResponseEntity<School>(schoolService.getSchoolById(schoolID),HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<School> updateSchool(@PathVariable("id") long id,
                                                   @RequestBody School school){
        return new ResponseEntity<School>(schoolService.updateSchool(school,id),HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSchool(@PathVariable("id") long id){
        //delete employee from db
        schoolService.deleteSchool(id);
        return new ResponseEntity<String>("Employee deleted Successfully.",HttpStatus.OK);
    }
}
