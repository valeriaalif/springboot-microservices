package com.student.student_service.repository;

import com.student.student_service.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends MongoRepository<Student, String>{

}
