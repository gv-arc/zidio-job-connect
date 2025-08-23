package com.zidio.zidio_connect.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

import com.zidio.zidio_connect.Enum.Action;
import lombok.*;

@Entity
@Table(name = "adminUsers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long adminId;
    private Long userId;

    @Enumerated(EnumType.STRING)
    private Action action;

    private LocalDateTime timeStamp;
}
