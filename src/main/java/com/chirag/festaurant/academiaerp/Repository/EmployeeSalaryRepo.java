package com.chirag.festaurant.academiaerp.Repository;

import com.chirag.festaurant.academiaerp.Entity.EmployeesSalary;
import com.chirag.festaurant.academiaerp.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeSalaryRepo extends JpaRepository<EmployeesSalary, Long> {

    @Query("SELECT new com.chirag.festaurant.academiaerp.dto.EmployeeDTO(" +
            "e.employee_Id, " +
            "e.first_name, " +
            "e.last_name, " +
            "e.email, " +
            "e.department, " +
            "e.title, " +
            "es.description, " +
            "es.amount) " +
            "FROM Employees e " +
            "LEFT JOIN EmployeesSalary es ON e.employee_Id = es.employee_Id " +
            "WHERE es.id = (" +
            "    SELECT MAX(es2.id) " +
            "    FROM EmployeesSalary es2 " +
            "    WHERE es2.employee_Id = e.employee_Id" +
            ")" +
            "AND e.employee_Id != :currentUserId")
    List<EmployeeDTO> findEmployeesWithLastDisbursedSalary(@Param("currentUserId") Long currentUserId);

}