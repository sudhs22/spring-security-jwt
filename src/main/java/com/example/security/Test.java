package com.example.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
    public static void main(String... args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("Encoded password : " + encoder.encode("password"));
        //$2a$10$RY8haxpRkS4qfmEEI4FW/Ol.h0AXiSSf58XoGeYjZWL/MRnZCAJku
    }
}
