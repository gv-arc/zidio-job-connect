package com.zidio.zidio_connect.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.zidio.zidio_connect.DTO.EmailRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendEmail(EmailRequestDTO dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(dto.getTo());
        message.setSubject(dto.getSubject());
        message.setText(dto.getBody());

        mailSender.send(message);
        System.out.println("Email sent to " + dto.getTo());
    }
}
