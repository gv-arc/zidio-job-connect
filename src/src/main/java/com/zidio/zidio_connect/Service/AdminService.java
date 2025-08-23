package com.zidio.zidio_connect.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.zidio_connect.DTO.AdminDTO;
import com.zidio.zidio_connect.Entity.Admin;
import com.zidio.zidio_connect.Repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepo;

    public Admin performAction(AdminDTO dto) {
        Admin admin = Admin.builder()
                .adminId(dto.getAdminId())
                .userId(dto.getUserId())
                .action(dto.getAction())
                .timeStamp(LocalDateTime.now())
                .build();
        return adminRepo.save(admin);
    }

    public List<Admin> getActionsByAdmin(Long adminId) {
        return adminRepo.findByAdminId(adminId);
    }

    public List<Admin> getActionsByUser(Long userId) {
        return adminRepo.findByUserId(userId);
    }
}
