package com.chirag.festaurant.academiaerp.Repository;

import com.chirag.festaurant.academiaerp.Entity.Employees;
import com.chirag.festaurant.academiaerp.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees,Long> {

    @Query("SELECT e FROM Employees e WHERE e.email = :email")
    Optional<Employees> findEmployeeByEmail(@Param("email") String email);

    @Query("SELECT e FROM Employees e WHERE e.employee_Id != :employee_Id")
    List<Employees> getAllEmployees(Long employee_Id);

}
