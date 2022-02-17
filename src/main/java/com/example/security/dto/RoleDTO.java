package com.example.security.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class RoleDTO {
    @JsonIgnore
    private Long id;
    private String name;

}
