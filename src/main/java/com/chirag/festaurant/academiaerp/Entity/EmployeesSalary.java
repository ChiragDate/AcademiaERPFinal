package com.chirag.festaurant.academiaerp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees_salary")// Lombok annotation for generating getters, setters, toString, equals, and hashCode
public class EmployeesSalary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_Id", nullable = false)
    private Long employee_Id; // Changed to Long as per request


    private LocalDate paymentDate;

    @Column(nullable = false)
    private Long amount;

    private String description;
}