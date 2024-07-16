package com.Mafiuz04.medical_proxy.configuration;

import com.Mafiuz04.medical_proxy.client.MedicalProxyFeign;
import com.Mafiuz04.medical_proxy.model.AppointmentDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
public class Fallback implements MedicalProxyFeign {

    @Override
    public List<AppointmentDto> getPatientAppointments(Long patientId) {
        return List.of();
    }

    @Override
    public List<AppointmentDto> getDoctorAvailableAppointments(Long doctorId) {
        return List.of();
    }

    @Override
    public AppointmentDto assignPatient(Long appointmentId, Long patientId) {
        return null;
    }

    @Override
    public List<AppointmentDto> getAppointmentsBySpecialization(String specialization, LocalDate date) {
        return List.of();
    }
}
