package com.Mafiuz04.medical_proxy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class AppointmentDto {
    private Long id;
    private Long doctorId;
    private Long patientId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
