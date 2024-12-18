package com.school.school_service.repository;
import com.school.school_service.model.School;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface SchoolRepository extends JpaRepository<School,Long>{


}
