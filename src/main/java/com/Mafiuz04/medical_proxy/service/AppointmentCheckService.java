package com.Mafiuz04.medical_proxy.service;

import com.Mafiuz04.medical_proxy.client.MedicalProxyFeign;
import com.Mafiuz04.medical_proxy.model.AppointmentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentCheckService {

    private final MedicalProxyFeign medicalProxyFeign;

    public List<AppointmentDto> getAppointments(Long patientId) {
        return medicalProxyFeign.getPatientAppointments(patientId);
    }

    public List<AppointmentDto> getAppointmentsByDoctorId(Long doctorId){
        return medicalProxyFeign.getDoctorAvailableAppointments(doctorId);
    }

    public AppointmentDto assignPatient(Long appointmentId, Long patientId){
       return medicalProxyFeign.assignPatient(appointmentId, patientId);
    }

    public List<AppointmentDto> getAvailableAppointmentsByDayAndDoctorSpecialization(String specialization, LocalDate date){
        return medicalProxyFeign.getAppointmentsBySpecialization(specialization, date);
    }
}
