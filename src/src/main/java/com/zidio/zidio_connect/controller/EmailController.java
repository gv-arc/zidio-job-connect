package com.zidio.zidio_connect.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zidio.zidio_connect.DTO.EmailRequestDTO;
import com.zidio.zidio_connect.Service.EmailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequestDTO dto) {
        emailService.sendEmail(dto);
        return ResponseEntity.ok("Email sent successfully");
    }
}
