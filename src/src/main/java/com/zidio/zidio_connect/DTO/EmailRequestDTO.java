package com.zidio.zidio_connect.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailRequestDTO {
    private String to;
    private String subject;
    private String body;
}
