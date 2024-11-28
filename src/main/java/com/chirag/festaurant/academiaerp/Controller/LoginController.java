package com.chirag.festaurant.academiaerp.Controller;


import com.chirag.festaurant.academiaerp.Service.SalaryService;
import com.chirag.festaurant.academiaerp.dto.LoginRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class LoginController {

    private final SalaryService service;

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "Authorization")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String token = service.loginApi(request);
        System.out.println(token);

        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + token)
                .body("Login successful");

    }
}
