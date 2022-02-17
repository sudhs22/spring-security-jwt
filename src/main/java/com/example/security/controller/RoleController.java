package com.example.security.controller;

import com.example.security.dto.RoleDTO;
import com.example.security.model.Role;
import com.example.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/role")
    @PreAuthorize("hasRole('ROLE_UPDATE')")
    public RoleDTO createRole(@RequestBody RoleDTO roleDTO) {
        Role role = new Role();
        role.setName(roleDTO.getName());
        Role createdRole = roleRepository.save(role);

        RoleDTO response = new RoleDTO();
        response.setName(createdRole.getName());

        return response;
    }

}
