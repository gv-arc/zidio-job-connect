package com.zidio.zidio_connect.Entity;

import jakarta.persistence.*;
import com.zidio.zidio_connect.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private boolean isActive = true;

    @Enumerated(EnumType.STRING)
    private Role role;
}
