package com.Mafiuz04.medical_proxy.controller;

import com.Mafiuz04.medical_proxy.model.AppointmentDto;
import com.Mafiuz04.medical_proxy.service.AppointmentCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AppointmentCheckController {
    private final AppointmentCheckService appointmentCheckService;

    @GetMapping("/appointments/patient")
    public List<AppointmentDto> getAppointmentsById(@RequestParam("patientId") Long patientId){
        return appointmentCheckService.getAppointments(patientId);
    }

    @GetMapping("/appointments/doctor")
    public List<AppointmentDto> getAvailableAppointmentsByDoctorId(@RequestParam("doctorId") Long doctorId){
        return appointmentCheckService.getAppointmentsByDoctorId(doctorId);
    }

    @PatchMapping("/appointments/assignPatient")
    public AppointmentDto assignPatient(@RequestParam("appointmentId") Long appointmentId, @RequestParam("patientId") Long patientId ){
        return appointmentCheckService.assignPatient(appointmentId, patientId);
    }

    @GetMapping("appointments/doctor/specialization/{specialization}")
    public List<AppointmentDto> getAvailableAppointmentsByDayAndDoctorSpecialization(@PathVariable("specialization")String specialization,
                                                                                     @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return appointmentCheckService.getAvailableAppointmentsByDayAndDoctorSpecialization(specialization, date);
    }
}
