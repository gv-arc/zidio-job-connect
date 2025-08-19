package com.zidio.zidio_connect.DTO;

import com.zidio.zidio_connect.Enum.Action;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminDTO {
    private Long adminId;
    private Long userId;
    private Action action;
}
