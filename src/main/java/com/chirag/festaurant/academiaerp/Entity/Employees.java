package com.chirag.festaurant.academiaerp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employees {

    @Id
    private Long employee_Id;

    private String first_name;

    private String last_name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;


    @Column(name = "department", nullable = false)
    private String department;

    private String title;

    @Column(name = "photograph_path")
    private String photographPath;
}