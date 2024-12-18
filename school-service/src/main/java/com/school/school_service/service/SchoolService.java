package com.school.school_service.service;

import com.school.school_service.model.School;
import java.util.List;

public interface SchoolService {

    School saveSchool(School school);
    List<School> getAllSchools();
    School getSchoolById(long id);
    School updateSchool(School school,long id);
    void deleteSchool(long id);


}
