package com.example.security.security;

import com.example.security.model.User;
import com.example.security.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret ;


    public String generateJwtToken(String username) {
        HashMap<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }


    public String extractUsername(String authorizationHeader) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorizationHeader).getBody();
        return claims.getSubject();
    }

    public void validateJwtToken(String userName, UserDetails user) {

        if(!user.getUsername().equals(userName))
            throw new RuntimeException("Invalid JWT Token");
    }
}
