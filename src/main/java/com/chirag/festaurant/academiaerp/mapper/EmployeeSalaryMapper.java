package com.chirag.festaurant.academiaerp.mapper;

import com.chirag.festaurant.academiaerp.Entity.EmployeesSalary;
import com.chirag.festaurant.academiaerp.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployeeSalaryMapper {

    public static EmployeesSalary toEntity(EmployeeDTO request) {
        return EmployeesSalary.builder()
                .employee_Id(request.getEmployee_id())
                .amount(request .getAmount())
                .paymentDate(LocalDate.now())
                .description(request.getDescription())
                   .build();
    }
}
