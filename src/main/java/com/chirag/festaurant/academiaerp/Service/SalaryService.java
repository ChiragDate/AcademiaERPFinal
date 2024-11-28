package com.chirag.festaurant.academiaerp.Service;

import com.chirag.festaurant.academiaerp.Entity.Employees;
import com.chirag.festaurant.academiaerp.Entity.EmployeesSalary;
import com.chirag.festaurant.academiaerp.Exception.EmployeeNotFoundException;
import com.chirag.festaurant.academiaerp.Exception.MissingTokenException;
import com.chirag.festaurant.academiaerp.Helper.EncryptionService;
import com.chirag.festaurant.academiaerp.Helper.JWTHelper;
import com.chirag.festaurant.academiaerp.Repository.EmployeeRepo;
import com.chirag.festaurant.academiaerp.Repository.EmployeeSalaryRepo;
import com.chirag.festaurant.academiaerp.dto.EmployeeDTO;
import com.chirag.festaurant.academiaerp.dto.LoginRequest;
import com.chirag.festaurant.academiaerp.mapper.EmployeeSalaryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class SalaryService {

    private final EmployeeRepo employeeRepo;
    private final EmployeeSalaryRepo salaryRepo;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;


    public String loginApi(LoginRequest request) {
        Employees employee = getEmployee(request.email());
        System.out.println("Password "+encryptionService.encode(request.password()));
        if (!encryptionService.validatePassword(request.password(), employee.getPassword())) {
            return "Wrong Email or Password";
        }

        return jwtHelper.generateToken(getEmployee(request.email()));
    }

    public void disburseSalary(List<EmployeeDTO> request) {
        List<EmployeesSalary> salaryEntities = request.stream()
                .map(EmployeeSalaryMapper :: toEntity) // Use the mapper's toEntity method
                .toList();
        System.out.println("Service reached");
        System.out.println("List: "+ salaryEntities);

        salaryRepo.saveAll(salaryEntities);
    }

    public Employees getEmployee(String email) {
        return employeeRepo.findEmployeeByEmail(email)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        format("Cannot find Employee:: No employee found with the provided email:: %s", email)
                ));
    }

    public List<?> getEmployeesWithLastSalary(String authHeader) {

        String token = "";
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // Extract the token
            token = authHeader.substring(7); // Remove "Bearer " prefix

        } else {
            // Handle cases where the Authorization header is missing or incorrect
            throw new MissingTokenException("Authorization header is missing or invalid.");
        }
        String curr = jwtHelper.extractEmail(token);
        String title = getEmployee(curr).getTitle();
        // Check the title to determine access level
        if ("Admin".equalsIgnoreCase(title) ||
                "Accounts Manager".equalsIgnoreCase(title)) {

            System.out.println("Admin return executed");
            // Admin or Accounts Manager can access all salaries
            return salaryRepo.findEmployeesWithLastDisbursedSalary(getEmployee(curr).getEmployee_Id());
        } else {
            System.out.println("employee return executed");
            // Other employees can only access their own salary
            return employeeRepo.getAllEmployees(getEmployee(curr).getEmployee_Id());
        }
    }
//    public List<EmployeeDTO> getEmployeesWithLastSalary(String authHeader) {
//        try {
//
//            String token = "";
//            if (authHeader != null && authHeader.startsWith("Bearer ")) {
//                // Extract the token
//                 token = authHeader.substring(7); // Remove "Bearer " prefix
//
//                // Now you can use this token, e.g., for validation or processing
//                // You can validate or decode the token her
//            } else {
//                // Handle cases where the Authorization header is missing or incorrect
//                throw new MissingTokenException("Authorization header is missing or invalid.");
//            }
//            String curr = jwtHelper.extractEmail(token);
//            Long id2 = getEmployee(curr).getEmployee_Id();
//            //Long currentUserId = authService.getCurrentEmployeeId();
//            System.out.println(id2);
//            // Directly fetch the DTO objects using the repository method
//            List<EmployeeDTO> employeeDTOs = salaryRepo.findEmployeesWithLastDisbursedSalary(id2);
//
//            if (employeeDTOs.isEmpty()) {
//                throw new RuntimeException("No employee salary data found");
//            }
//            System.out.println("Called Salary Service get employees");
//            System.out.println(employeeDTOs);
//            return employeeDTOs;
//
//        } catch (Exception e) {
//            throw new RuntimeException("Error fetching employee salary data: " + e.getMessage());
//        }
//    }
}
