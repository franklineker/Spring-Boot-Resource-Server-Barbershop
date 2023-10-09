package com.drnavalhabarbershop.resourceserver.service;

import br.com.drnavalha.web.dto.AppointmentRequest;
import com.drnavalhabarbershop.resourceserver.domain.Appointment;
import com.drnavalhabarbershop.resourceserver.mapper.AppointmentMapper;
import com.drnavalhabarbershop.resourceserver.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment save(AppointmentRequest request) {
        return appointmentRepository.save(AppointmentMapper.toAppointment(request));
    }

    public List<Appointment> findAll(){
        return appointmentRepository.findAll();
    }

    public Appointment findById(String id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apppointment Not Found."));
    }

    public Appointment update(AppointmentRequest request, String id) {
        checkAppointmentExist(id);

        Appointment appointment = AppointmentMapper.toAppointment(request);
        appointment.setId(id);

        return appointmentRepository.save(appointment);
    }

    public void delete(String id){

        checkAppointmentExist(id);

        appointmentRepository.deleteById(id);
    }

    private void checkAppointmentExist(String id) {
        if(appointmentRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Appointment not found.");
        }
    }
}
