package com.feiraFacil.controller;

import com.feiraFacil.dto.createEntity.AdminCreateDTO;
import com.feiraFacil.model.Admin;
import com.feiraFacil.services.AdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admins")
@Tag(name = "Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity create(@RequestBody AdminCreateDTO adminDTO) {
        Admin admin = adminService.toAdmin(adminDTO);
        adminService.save(admin);
        return ResponseEntity.ok().build();
    }
}
