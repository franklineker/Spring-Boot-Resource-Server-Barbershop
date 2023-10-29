package com.drnavalhabarbershop.resourceserver.mapper;


import com.drnavalhabarbershop.resourceserver.domain.Appointment;
import com.drnavalhabarbershop.resourceserver.web.dto.AppointmentRequest;
import com.drnavalhabarbershop.resourceserver.web.dto.AppointmentResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AppointmentMapper {

    public static Appointment toAppointment(AppointmentRequest request) {

        return request != null ? Appointment
                .builder()
                .clientID(request.getClientID())
                .clientName(request.getClientName())
                .barberID(request.getBarberID())
                .barberName(request.getBarberName())
                .orderID(request.getOrderID())
                .orderTitle(request.getOrderTitle())
                .date(request.getDate())
                .hour(request.getHour())
                .build() : null;
    }

    public static AppointmentResponse toAppointmentResponse(Appointment appointment) {

        return AppointmentResponse.builder()
                .clientName(appointment.getClientName())
                .barberName(appointment.getBarberName())
                .orderTitle(appointment.getOrderTitle())
                .date(appointment.getDate())
                .hour(appointment.getHour())
                .build();
    }
}
