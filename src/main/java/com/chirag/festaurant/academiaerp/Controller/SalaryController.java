package com.chirag.festaurant.academiaerp.Controller;

import com.chirag.festaurant.academiaerp.Exception.MissingTokenException;
import com.chirag.festaurant.academiaerp.Service.SalaryService;
import com.chirag.festaurant.academiaerp.dto.EmployeeDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;
import java.util.List;

@RestController
@RequestMapping("/api/salary")
@RequiredArgsConstructor
public class SalaryController {

    private final SalaryService salaryService;
    @CrossOrigin(
            origins = "http://localhost:3000",
            allowCredentials = "true",
            allowedHeaders = "*",
            methods = {RequestMethod.POST, RequestMethod.OPTIONS}
    )
  @PostMapping("/disburse")
    public ResponseEntity<String> disburseSalaries(@RequestBody List<EmployeeDTO> request) {
        System.out.println("Disburse Salaries function called");
        salaryService.disburseSalary(request);
        return ResponseEntity.ok("Salaries disbursed successfully.");

    }

    @CrossOrigin(
            origins = "http://localhost:3000",
            allowCredentials = "true",
            allowedHeaders = "*",
            methods = {RequestMethod.POST, RequestMethod.OPTIONS}
    )
        @GetMapping("/employees")
    public ResponseEntity<List<?>> getEmployeeDetailsWithLastSalary(@RequestHeader(value = "Authorization") String authHeader) {


        System.out.println("GET employees details with last salary called");
        return ResponseEntity.ok(salaryService.getEmployeesWithLastSalary(authHeader));
    }


}
