package com.zidio.zidio_connect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zidio.zidio_connect.DTO.AdminDTO;
import com.zidio.zidio_connect.Entity.Admin;
import com.zidio.zidio_connect.Service.AdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/action")
    public ResponseEntity<Admin> performAction(@RequestBody AdminDTO dto) {
        return ResponseEntity.ok(adminService.performAction(dto));
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<Admin>> getLogByAdmin(@PathVariable Long adminId) {
        return ResponseEntity.ok(adminService.getActionsByAdmin(adminId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Admin>> getLogByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(adminService.getActionsByUser(userId));
    }
}
