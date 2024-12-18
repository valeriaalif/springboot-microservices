package com.student.student_service.service;

import com.student.student_service.dto.School;
import com.student.student_service.dto.StudentResponse;
import com.student.student_service.model.Student;
import com.student.student_service.repository.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> createStudent(Student student){
        try{
            return new ResponseEntity<Student>(studentRepository.save(student), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchStudentById(String id){

        if (!ObjectId.isValid(id)) {
            return new ResponseEntity<>("Invalid ID format", HttpStatus.BAD_REQUEST);
        }
        Optional<Student> student =  studentRepository.findById(id);

        if(student.isPresent()){
            School school = null;
            try {
                // Fetch school data using schoolId
                String schoolApiUrl = "http://SCHOOL-SERVICE/school/" + student.get().getSchoolId();
                school = restTemplate.getForObject(schoolApiUrl, School.class);
            } catch (Exception e) {
                // Handle API errors (e.g., timeout, 404, etc.)
                return new ResponseEntity<>("Failed to fetch school data: " + e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
            }

            StudentResponse studentResponse = new StudentResponse(
                    student.get().getId(),
                    student.get().getName(),
                    student.get().getAge(),
                    student.get().getGender(),
                    school
            );
            return new ResponseEntity<>(studentResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Student Found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> fetchStudents(){
        List<Student> students = studentRepository.findAll();
        if(students.size() > 0){
            return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Students",HttpStatus.NOT_FOUND);
        }
    }
}
