package com.chirag.festaurant.academiaerp.Helper;


import com.chirag.festaurant.academiaerp.Entity.Employees;
import com.chirag.festaurant.academiaerp.Service.SalaryService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Base64;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTHelper {

    private static final String SECRET = "cr666N7wIV+KJ2xOQpWtcfAekL4YXd9gbnJMs8SJ9sI=";
    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET));
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour;

    public String generateToken(Employees employee) {
        return Jwts.builder()
                .setSubject(employee.getEmail())
                .claim("title", employee.getTitle()) // Add title as a claim
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token); // Parse and validate the token
            return true; // Token is valid
        } catch (Exception e) {
            return false; // Token is invalid or expired
        }
    }

    public String getRole(String token){
        return extractClaimFromToken(token,"title");
    }

    public String extractClaimFromToken(String token, String claimKey) {
        return extractAllClaims(token).get(claimKey, String.class);
    }


    public boolean isTokenValid(String token, String email) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);  // Remove the "Bearer " part
        }
        token = token.trim();  // Remove any extra spaces
        final String extractedEmail = extractEmail(token);
        return (extractedEmail.equals(email) && !isTokenExpired(token));
    }

    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

}
