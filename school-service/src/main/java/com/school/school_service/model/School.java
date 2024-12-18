package com.school.school_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "school_name", nullable = false)
    private String schoolName;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "principal_name", nullable = false)
    private String principalName;


    // Getters
    public long getId() {
        return id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getLocation() {
        return location;
    }

    public String getPrincipalName() {
        return principalName;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }
}
