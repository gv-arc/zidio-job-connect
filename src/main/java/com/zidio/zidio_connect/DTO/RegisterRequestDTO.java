package com.zidio.zidio_connect.DTO;

import com.zidio.zidio_connect.Enum.Role;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterRequestDTO {
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    private String password;

    @NotNull
    private Role role;
}
